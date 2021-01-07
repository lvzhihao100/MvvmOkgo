package com.gamerole.plugin

/**
 * <pre>
 *     desc  : 配置和 Build 相关的
 * </pre>
 */
object BuildConfig {
    val isBeta = true

    val compileSdkVersion = 30
    val buildToolsVersion = "30.0.2"
    val minSdkVersion = 21
    val targetSdkVersion = 30


    var versionCode = 140
    var versionName = "1.4.1"
    var appName="AI智慧门店"
    var beta=0

    var baseUrl=""

    init {
        if (isBeta){
            versionCode=38
            versionName="1.4.0.1"
            appName="AI智慧门店-beta"
            beta=1
            baseUrl=""
        }
    }

}