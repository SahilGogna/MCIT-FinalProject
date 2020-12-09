package ca.bigdata.hadoop

import org.apache.hadoop.conf.Configuration
import org.apache.hadoop.fs.{FileSystem, Path}

trait HadoopConfiguration {

  // configuration constants
  val CONFIG_PATH_1: String = "/Users/sahilgogna/opt/hadoop-2.7.3/etc/cloudera/core-site.xml"
  val CONFIG_PATH_2: String = "/Users/sahilgogna/opt/hadoop-2.7.3/etc/cloudera/hdfs-site.xml"

  // making a configuration object
  val config = new Configuration()

  // adding configuration files of the cluster to the config object
  config.addResource(new Path(CONFIG_PATH_1))
  config.addResource(new Path(CONFIG_PATH_2))

  val fileSystem: FileSystem = FileSystem.get(config)
}
