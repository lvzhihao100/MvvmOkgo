package com.gamerole.commom.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Created by zq on 2017/7/19.
 */

public class GSonUtil {
    public static Gson gson;

    static {
        gson = new GsonBuilder()
                .setLenient()
                .create();
    }

    private GSonUtil() {
    }



}

