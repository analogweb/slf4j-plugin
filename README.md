Analog Web Framework
===============================================

[SLF4J](http://www.slf4j.org) logger bridge for AnalogWeb framework.

This plugin enables logging to use org.analogweb.util.logging package through SLF4J API.

There is SBT's case.

```scala
val scalaplugin = "org.analogweb" % "analogweb-scala" % "0.9.2-SNAPSHOT"
val slf4jplugin = "org.analogweb" % "analogweb-slf4j" % "0.9.2-SNAPSHOT"
// You also needs to add logger implementation(like [Logback](http://logback.qos.ch/)).
val logback = "ch.qos.logback" % "logback-classic" % "1.1.2" 
```

