package com.gamerole.commom.entity;


import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class HttpData<T> implements Serializable {
    @SerializedName(
            value = "status",
            alternate = {"code"}
    )
    private int status;
    @SerializedName(
            value = "msg",
            alternate = {"message"}
    )
    private String msg;
    private T data;

    public HttpData() {
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
