package com.xiangyiran.bigdata.sparkmall.util

import java.io.InputStream
import java.util.{Properties, ResourceBundle}

import com.alibaba.fastjson.{JSON, JSONObject}


object ConfigUtil {
    
    val bundle: ResourceBundle = ResourceBundle.getBundle("config")
    
    val condRb =  ResourceBundle.getBundle("condition")
    
    /**
      * 从config中获取信息
      * @param key
      * @return
      */
    def getValueFromConfig(key: String): String = {
        bundle.getString(key)
    }
    
    /**
      * 根据条件获取数据
      * @param cond
      * @return
      */
    def getValueFromCondition(cond:String): String = {
        val conds = condRb.getString("condition.params.json")
        // 转换JSON格式
        val json: JSONObject = JSON.parseObject(conds)
        json.getString(cond)
    }
    
    /**
      * 从config中获取信息
      * @param key
      * @return
      */
    def getValue(key: String): String = {
        
        val stream: InputStream = Thread.currentThread().getContextClassLoader.getResourceAsStream("config.properties")
        val properties = new Properties()
        properties.load(stream)
        
        properties.getProperty(key)
    }
}
