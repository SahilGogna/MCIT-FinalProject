package ca.bigdata.kafka

import java.util.Properties

import ca.bigdata.hadoop.HadoopConfiguration
import org.apache.hadoop.fs.{FSDataInputStream, Path}
import org.apache.kafka.clients.producer.{KafkaProducer, ProducerConfig, ProducerRecord}
import org.apache.kafka.common.serialization.{IntegerSerializer, StringSerializer}

object Producer extends HadoopConfiguration {
  def main(args: Array[String]): Unit = {
    val topicName = "bdsf1901_sahil_trip"

    val producerProperties = new Properties()
    producerProperties.setProperty(
      ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092"
    )
    producerProperties.setProperty(
      ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, classOf[IntegerSerializer].getName
    )
    producerProperties.setProperty(
      ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, classOf[StringSerializer].getName
    )

    val producer = new KafkaProducer[Int, String](producerProperties)

    val inputStream: FSDataInputStream = fileSystem
      .open(new Path("/user/fall2019/sahilgogna/sprint3/OD_2019-10.csv"))

    var i = 1
    val data = scala.io.Source.fromInputStream(inputStream).getLines()
      .drop(1)
      .take(100).mkString("\n")
      .split("\n")
      .foreach(line => {
        println(line)
        producer.send(new ProducerRecord[Int, String](topicName, i, line))
        i = i + 1
      })
    producer.flush()
  }
}
