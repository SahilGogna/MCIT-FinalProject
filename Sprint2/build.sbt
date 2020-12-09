name := "Sprint2"

version := "0.1"

scalaVersion := "2.12.10"

val hadoopVersion = "2.7.3"

libraryDependencies ++= Seq(
  "org.apache.hadoop" % "hadoop-common",
  "org.apache.hadoop" % "hadoop-hdfs",
).map( _ % hadoopVersion)

libraryDependencies += "org.apache.hive" % "hive-jdbc" % "1.1.0-cdh5.16.2"

// Cloudera artifacts are published in their own remote repository
resolvers += "Cloudera" at "https://repository.cloudera.com/artifactory/cloudera-repos/"

// https://mvnrepository.com/artifact/com.google.code.gson/gson
libraryDependencies += "com.google.code.gson" % "gson" % "1.7.1"

// https://mvnrepository.com/artifact/com.opencsv/opencsv
libraryDependencies += "com.opencsv" % "opencsv" % "3.7"