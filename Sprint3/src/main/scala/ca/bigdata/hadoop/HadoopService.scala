package ca.bigdata.hadoop

import java.net.{HttpURLConnection, URL}
import java.util.zip.ZipEntry
import java.util.zip.ZipInputStream
import org.apache.hadoop.fs.Path

object HadoopService extends HadoopConfiguration{

  val DOWNLOADING_MESSAGE: String = "Downloading to HDFS"
  val DOWNLOADED_MESSAGE : String = "Files Downloaded successfully to HDFS"

  def main(args: Array[String]): Unit = {
    unzipUrl("https://sitewebbixi.s3.amazonaws.com/uploads/docs/biximontrealrentals2019-33ea73.zip",
      "/user/fall2019/sahilgogna/sprint3")
  }

  def unzipUrl(sourceUrl:String, dirPath : String) : Unit = {
    assureExistance(dirPath)
    println(DOWNLOADING_MESSAGE)
    val url = new URL(sourceUrl)
    val connection = url.openConnection.asInstanceOf[HttpURLConnection]
    connection.setRequestMethod("GET")
    val in = connection.getInputStream
    val zipIn = new ZipInputStream(in)
    val buffer = new Array[Byte](1024)
    var zipEntry: ZipEntry = zipIn.getNextEntry

    while (zipEntry != null) {
      val filePath = new Path(dirPath + "/" + zipEntry.getName)
      val outputStream = fileSystem.create(filePath)
      var len: Integer = zipIn.read(buffer)
      while (len > 0) {
        outputStream.write(buffer, 0, len)
        len = zipIn.read(buffer)
      }
      outputStream.close()
      zipEntry = zipIn.getNextEntry

    }
    println(DOWNLOADED_MESSAGE)
    zipIn.closeEntry()
    zipIn.close()
  }

  def assureExistance(folderPath:String):Boolean = {
    val path : Path = new Path(folderPath)
    if (fileSystem.exists(path)){
      fileSystem.delete(path,true)
    }
    fileSystem.mkdirs(path)
  }

}
