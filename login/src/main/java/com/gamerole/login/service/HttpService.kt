package com.gamerole.login.service

import com.gamerole.commom.entity.HttpData
import com.gamerole.commom.http.JsonConverter
import com.lzy.okgo.OkGo
import com.lzy.okrx2.adapter.SingleBody
import io.reactivex.Single

class HttpService {
    fun login(account: String?, pwd: String?): Single<HttpData<*>> {
        return OkGo.get<HttpData<*>>("login")
            .params("account", account)
            .params("pwd", pwd)
            .converter(object : JsonConverter<HttpData<*>?>() {})
            .adapt(SingleBody())
    }
}