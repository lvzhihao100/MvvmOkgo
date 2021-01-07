package com.gamerole.commom.http;

import com.gamerole.commom.BaseHttpConfig;
import com.gamerole.commom.box.exception.JsonParseException;
import com.gamerole.commom.box.exception.LogoutException;
import com.gamerole.commom.box.exception.ToastException;
import com.gamerole.commom.entity.HttpData;
import com.gamerole.commom.util.GSonUtil;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import okhttp3.ResponseBody;


public abstract class JsonConverter<T> extends AbsConverter<T> {

    @Override
    public T convertResponse(okhttp3.Response response) throws Throwable {
        ResponseBody body = response.body();
        if (body == null) return null;
        T data;
        String jsonBody = body.string();
        HttpData httpData = new Gson().fromJson(jsonBody, HttpData.class);

        int code = httpData.getStatus();
        String msg = httpData.getMsg();

        if (code == 401 || code == 505) {
            throw new LogoutException(msg);
        } else if (code != BaseHttpConfig.OK) {
            throw new ToastException(msg);
        }
        try {
            Gson gson = GSonUtil.gson;
            Type genericSuperclass = getClass().getGenericSuperclass();
            Type type = ((ParameterizedType) genericSuperclass).getActualTypeArguments()[0];
            data = gson.fromJson(jsonBody, type);
        } catch (JsonSyntaxException e) {
            throw new JsonParseException(response.request().url().url().toString());
        }
        return data;
    }

}
