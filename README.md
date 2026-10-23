# KommonLee

[![Build](https://github.com/kevin-lee/kommonlee/actions/workflows/build.yml/badge.svg)](https://github.com/kevin-lee/kommonlee/actions/workflows/build.yml)

[KommonLee](https://github.com/Kevin-Lee/kommonlee-core) (pronounced the same as 'commonly') is a set of commonly used Java libraries written by [Kevin Lee](http://lckymn.com) and is currently used in the [software projects](http://lckymn.com/kevin-projects.html) owned by Kevin Lee and Agin3 Pty Ltd. It is an open source project. The main goal of this project is to create better APIs for Java to make Java programming fun and enjoyable with fewer chances to introduce bugs.

## Modules

| Module | Description |
|---|---|
| [kommonlee-test](modules/kommonlee-test) | Helpers for JUnit tests |
| [kommonlee-core](modules/kommonlee-core) | Collections, functional types, IO and utilities |
| [kommonlee-asm](modules/kommonlee-asm) | Method and constructor analysis with ASM (ASM 5.0.3 is shaded in) |
| [kommonlee-web](modules/kommonlee-web) | Servlet 2.5 utilities |
| [kommonlee-web3](modules/kommonlee-web3) | Servlet 3 utilities |

## Get KommonLee

Requirement: Java 8 or later.

sbt

```scala
libraryDependencies += "io.kevinlee" % "kommonlee-core" % "0.1.2"
```

Maven

```xml
<dependency>
  <groupId>io.kevinlee</groupId>
  <artifactId>kommonlee-core</artifactId>
  <version>0.1.2</version>
</dependency>
```

## Build

```sh
sbt test
```

## History

The modules came from the separate `kevin-lee/kommonlee-*` repositories. The old groupId was `org.elixirian`. The full Git history of each repository is kept in this repository.

## License

MIT. See [LICENSE](LICENSE).
