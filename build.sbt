ThisBuild / organization := "io.kevinlee"
ThisBuild / homepage     := Some(url("https://github.com/kevin-lee/kommonlee"))
ThisBuild / scmInfo      := Some(
  ScmInfo(
    url("https://github.com/kevin-lee/kommonlee"),
    "scm:git:git@github.com:kevin-lee/kommonlee.git",
  )
)
ThisBuild / developers   := List(
  Developer("kevin-lee", "Kevin Lee", "kevin.code@kevinlee.io", url("https://github.com/kevin-lee"))
)
ThisBuild / licenses     := List(License.MIT)

lazy val libs = new {
  val junit          = "junit"         % "junit"           % "4.13.1"
  val assertj        = "org.assertj"   % "assertj-core"    % "1.5.0"
  val mockitoCore    = "org.mockito"   % "mockito-core"    % "1.9.5"
  val junitInterface = "com.github.sbt" % "junit-interface" % "0.13.1"

  val servletApi25       = "javax.servlet"     % "servlet-api"       % "2.5"
  val jspApi21           = "javax.servlet.jsp" % "jsp-api"           % "2.1"
  val javaxServletApi301 = "javax.servlet"     % "javax.servlet-api" % "3.0.1"
  val jspApi22           = "javax.servlet.jsp" % "jsp-api"           % "2.2"
  val jstl               = "javax.servlet"     % "jstl"              % "1.2"

  val asm5 = "org.ow2.asm" % "asm" % "5.0.3"
}

lazy val javaMajorVersion: Int = {
  val version = sys.props("java.specification.version")
  if (version.startsWith("1.")) version.drop(2).toInt else version.takeWhile(_.isDigit).toInt
}

lazy val kommonlee = (project in file("."))
  .enablePlugins(DevOopsGitHubReleasePlugin)
  .aggregate(
    kommonleeTest,
    kommonleeCore,
    kommonleeLib3rdAsm,
    kommonleeAsm,
    kommonleeWeb,
    kommonleeWeb3,
    kommonleeExamples,
  )
  .settings(
    name           := "kommonlee",
    publish / skip := true,
    devOopsPackagedArtifacts := List("test", "core", "asm", "web", "web3")
      .map(m => s"modules/kommonlee-$m/target/kommonlee-$m*.jar"),
  )

lazy val kommonleeTest = module("kommonlee-test")
  .settings(
    libraryDependencies ++= List(
      libs.junit,
      libs.assertj    % Test,
      libs.mockitoCore % Test,
    )
  )

lazy val kommonleeCore = module("kommonlee-core")
  .dependsOn(kommonleeTest % "test->compile")
  .settings(
    libraryDependencies ++= List(
      libs.junit      % Test,
      libs.assertj    % Test,
      libs.mockitoCore % Test,
    )
  )

/* Internal project (not published) to make the ASM 5.0.3 jar with the package renamed to
 * org.elixirian.kommonlee.lib3rd.asm5. kommonlee-asm compiles against it and has its classes in its own jar.
 */
lazy val kommonleeLib3rdAsm = Project("kommonleeLib3rdAsm", file("modules/kommonlee-3rd-asm"))
  .settings(
    name                         := "kommonlee-3rd-asm",
    crossPaths                   := false,
    autoScalaLibrary             := false,
    publish / skip               := true,
    libraryDependencies += libs.asm5,
    assembly / assemblyJarName   := "kommonlee-3rd-asm-5.0.3.jar",
    assembly / assemblyOption ~= (_.withIncludeScala(false)),
    assembly / assemblyShadeRules := Seq(
      ShadeRule.rename("org.objectweb.asm.**" -> "org.elixirian.kommonlee.lib3rd.asm5.@1").inAll
    ),
  )

lazy val kommonleeAsm = module("kommonlee-asm")
  .dependsOn(kommonleeCore, kommonleeTest % "test->compile")
  .settings(
    libraryDependencies ++= List(
      libs.junit      % Test,
      libs.assertj    % Test,
      libs.mockitoCore % Test,
    ),
    Compile / unmanagedJars += Attributed.blank((kommonleeLib3rdAsm / assembly).value),
    Compile / packageBin / mappings ++= {
      val shadedJar = (kommonleeLib3rdAsm / assembly).value
      val dir       = target.value / "lib3rd-asm-classes"
      IO.delete(dir)
      IO.unzip(shadedJar, dir, new SimpleFilter(name => !name.startsWith("META-INF/")))
      (dir ** -DirectoryFilter).get().map(file => file -> IO.relativize(dir, file).get)
    },
  )

lazy val kommonleeWeb = module("kommonlee-web")
  .dependsOn(kommonleeCore, kommonleeTest % "test->compile")
  .settings(
    libraryDependencies ++= List(
      libs.junit        % Test,
      libs.mockitoCore   % Test,
      libs.servletApi25 % Provided,
      libs.jspApi21     % Provided,
      libs.jstl         % Runtime,
    )
  )

lazy val kommonleeWeb3 = module("kommonlee-web3")
  .dependsOn(kommonleeCore, kommonleeTest % "test->compile")
  .settings(
    libraryDependencies ++= List(
      libs.junit              % Test,
      libs.mockitoCore         % Test,
      libs.javaxServletApi301 % Provided,
      libs.jspApi22           % Provided,
      libs.jstl               % Runtime,
    )
  )

lazy val kommonleeExamples = module("kommonlee-examples")
  .dependsOn(kommonleeCore, kommonleeAsm, kommonleeWeb3, kommonleeTest % "test->compile")
  .settings(
    publish / skip := true,
    libraryDependencies ++= List(
      libs.mockitoCore,
      libs.javaxServletApi301 % Provided,
      libs.jspApi22           % Provided,
      libs.jstl               % Runtime,
    ),
  )

def module(projectName: String): Project = {
  val id = projectName.split("-").toList match {
    case head :: tail => head + tail.map(_.capitalize).mkString
    case Nil => projectName
  }
  Project(id, file(s"modules/$projectName"))
    .enablePlugins(DevOopsJavaPlugin)
    .settings(
      name                         := projectName,
      javaVersion                  := "1.8",
      Compile / doc / javacOptions += "-Xdoclint:none",
      Test / fork                  := true,
      Test / javaOptions ++= (
        if (javaMajorVersion >= 17) List("--add-opens=java.base/java.lang=ALL-UNNAMED") else Nil
      ),
      testOptions += Tests.Argument(TestFrameworks.JUnit, "-a"),
      libraryDependencies += libs.junitInterface % Test,
    )
}
