import java.io.File

import org.apache.spark
import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.sql

object App {


  def getScoreFiles(dir: String):List[File] = {
    val d = new File(dir)
    if (d.exists && d.isDirectory) {
      d.listFiles.filter(f => f.isFile && f.getName.startsWith("mission_score")).toList
    } else {
      List[File]()
    }
  }

  def main(args: Array[String]) {
    val cf = new SparkConf().setAppName("SparkMe Application").setMaster("local[*]")
    val sc = new SparkContext(cf)

    val spark = org.apache.spark.sql.SparkSession.builder
        .config(cf)
      .getOrCreate()

    val fileName = args(0)

    val df = spark.read
      .format("csv")
      .option("header", "true") //reading the headers
      .option("mode", "DROPMALFORMED")
      .load(fileName)


    println(df.show())

  }

}
