package com.xiangyiran.bigdata.sparkmall.util

object StringUtil {

    def isNotEmpty( s : String ): Boolean = {
        s != null && !"".equals(s.trim)
    }
}
