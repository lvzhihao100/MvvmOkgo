package com.gamerole.commom.box.display;

import com.gamerole.commom.util.ToastUtil;
import com.github.yoojia.inputs.Input;
import com.github.yoojia.inputs.MessageDisplay;

public class ToastMessageDisplay implements MessageDisplay {
    public ToastMessageDisplay() {
    }

    public void show(Input input, String message) {
        ToastUtil.showShort(message);
    }
}
