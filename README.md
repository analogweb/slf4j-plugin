Analog Web Framework SLF4J Plugn
===============================================

[![Build Status](https://travis-ci.org/analogweb/slf4j-plugin.svg)](https://travis-ci.org/analogweb/slf4j-plugin)

[SLF4J](http://www.slf4j.org) logger bridge for AnalogWeb framework.

This plugin enable logging effects of SLF4J through org.analogweb.util.logging package.

There is SBT's case.

You also needs to add logger implementation and configuration (like [Logback](http://logback.qos.ch/)).

```scala
val scalaplugin = "org.analogweb" % "analogweb-scala" % "0.11.0"
val slf4jplugin = "org.analogweb" % "analogweb-slf4j" % "0.11.0"
// logger implementation.(and logback.xml)
val logback = "ch.qos.logback" % "logback-classic" % "1.2.3" 
```
