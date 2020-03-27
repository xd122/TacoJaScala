package com.tacoxiang.template.json

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.ObjectMapper

import com.fasterxml.jackson.module.scala.DefaultScalaModule
import com.fasterxml.jackson.module.scala.experimental.ScalaObjectMapper

import scala.io.Source

/**
 * ****************************************************************************************                                                 
 * Programs are meant to be read by humans and only incidentally for computers to execute
 * ****************************************************************************************
 * Author : tacoxiang                          
 * Time : 2020/3/27                            
 * Package : com.tacoxiang.template.json      
 * ProjectName: TacoJaScala
 * Describe :                                
 * ============================================================
 **/

case class Table(@JsonProperty("tName") tName: String)

case class Field(@JsonProperty("name") name: String, @JsonProperty("type") output: String)

case class Config(@JsonProperty("appName") appName: String,
                  @JsonProperty("table") table: Table,
                  @JsonProperty("fields") fields: List[Field])

object GetJsonValueTemplate {
  /**
   *
   * @param jsonConfFile json格式得配置文件
   * @return 模板类Config的对象
   */
  def getJsonConf(jsonConfFile: String): Config = {
    val mapper = new ObjectMapper() with ScalaObjectMapper
    mapper.registerModule(DefaultScalaModule)
    val conf = mapper.readValue[Config](Source.fromFile(jsonConfFile).reader())
    conf
  }

  def main(args: Array[String]): Unit = {
    val jsonInstance = getJsonConf(GetJsonValueTemplate.getClass.getClassLoader
      .getResource("conf/json/template.json").getPath)
    println(jsonInstance.table.tName)
    println(jsonInstance.fields.head.name)
  }
}
