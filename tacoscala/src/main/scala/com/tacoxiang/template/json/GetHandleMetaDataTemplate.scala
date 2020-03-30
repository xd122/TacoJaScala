package com.tacoxiang.template.json

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.scala.DefaultScalaModule
import com.fasterxml.jackson.module.scala.experimental.ScalaObjectMapper
import com.tacoxiang.pojo.Metadata

import scala.io.Source

/**
 * ****************************************************************************************                                                 
 * Programs are meant to be read by humans and only incidentally for computers to execute
 * ****************************************************************************************
 * Author : tacoxiang                          
 * Time : 2020/3/30                            
 * Package : com.tacoxiang.template.json      
 * ProjectName: TacoJaScala
 * Describe :                                
 * ============================================================
 **/
object GetHandleMetaDataTemplate {

  def getMetaDataInfo(metaDataFile: String): Metadata = {
    val mapper = new ObjectMapper() with ScalaObjectMapper
    mapper.registerModule(DefaultScalaModule)
    val metadata = mapper.readValue[Metadata](Source.fromFile(metaDataFile).reader())
    metadata
  }

  def main(args: Array[String]): Unit = {
    val data = getMetaDataInfo(GetHandleMetaDataTemplate.getClass.getClassLoader
      .getResource("conf/json/metadata.json").getPath)

    /**
     * AuthUser(tacoxaing,tacoxiang123,data-warehouse)
     * SinkTable(datawarehouse,offlineSinkTable1,dt,20200330,hdfs://xxx-sink-1)
     * List(SourceTable(datawarehouse,offlineTable1,dt,20200330,hdfs://xxx-2), SourceTable(datawarehouse,offlineTable2,dt,20200330,hdfs://xxx-2))
     * spark-data-warehouse-etl
     */

    println(data.operatorUser)
    println(data.sink)
    println(data.source)
    println(data.appName)

  }
}
