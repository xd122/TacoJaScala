package com.tacoxiang.pojo

import com.fasterxml.jackson.annotation.JsonProperty

/**
 * ****************************************************************************************
 * Programs are meant to be read by humans and only incidentally for computers to execute
 * ****************************************************************************************
 * Author : tacoxiang
 * Time : 2020/3/30
 * Package : com.tacoxiang.pojo
 * ProjectName: TacoJaScala
 * Describe : 通用元数据应用
 * ============================================================
 **/

/**
 *
 * @param uName     执行人
 * @param passWd    授权密码
 * @param groupName 授权组
 */
case class AuthUser(
                     @JsonProperty("uName") uName: String,
                     @JsonProperty("passWd") passWd: String,
                     @JsonProperty("gName") groupName: String
                   )

/**
 *
 * @param sourceDataBase       数据库
 * @param sourceTable          数据表
 * @param sourcePartition      分区字段
 * @param sourcePartitionValue 最新分区
 * @param sourcePath           源数据hdfs路径
 */
case class SourceTable(
                        @JsonProperty("sourceDataBase") sourceDataBase: String,
                        @JsonProperty("sourceTable") sourceTable: String,
                        @JsonProperty("sourcePartition") sourcePartition: String,
                        @JsonProperty("sourcePartitionValue") sourcePartitionValue: String,
                        @JsonProperty("sourcePath") sourcePath: String
                      )

/**
 *
 * @param sinkDataBase       数据库
 * @param sinkTable          数据表
 * @param sinkPartition      分区字段
 * @param sinkPartitionValue 最新分区值
 * @param sinkPath           hdfs输出路径
 */
case class SinkTable(
                      @JsonProperty("sinkDataBase") sinkDataBase: String,
                      @JsonProperty("sinkTable") sinkTable: String,
                      @JsonProperty("sinkPartition") sinkPartition: String,
                      @JsonProperty("sinkPartitionValue") sinkPartitionValue: String,
                      @JsonProperty("sinkPath") sinkPath: String
                    )


case class Metadata(
                     @JsonProperty("appName") appName: String,
                     @JsonProperty("authUser") operatorUser: AuthUser,
                     @JsonProperty("source") source: List[SourceTable],
                     @JsonProperty("sink") sink: SinkTable
                   )
