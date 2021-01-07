package com.gamerole.commom.util;


import com.gamerole.commom.base.App;

import es.dmoral.toasty.Toasty;
import io.reactivex.android.schedulers.AndroidSchedulers;

public class ToastUtil {
    public ToastUtil() {
    }

    public static void showShort(CharSequence message) {
        AndroidSchedulers.mainThread().scheduleDirect(() -> {
            Toasty.normal(App.INSTANCE, message).show();
        });
    }
}
