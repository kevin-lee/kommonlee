addSbtPlugin("com.github.sbt" % "sbt-ci-release" % "1.12.1")
addSbtPlugin("com.eed3si9n"   % "sbt-assembly"   % "2.5.0")

val sbtDevOopsVersion = "3.9.0"
addSbtPlugin("io.kevinlee" % "sbt-devoops-java"   % sbtDevOopsVersion)
addSbtPlugin("io.kevinlee" % "sbt-devoops-github" % sbtDevOopsVersion)
