package com.gamerole.login

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel

class HiltViewModel @ViewModelInject constructor():ViewModel() {
    /**
     * 在 LifeCycle 2.2.0 之后，可以用更精简的方法来完成，使用 LiveData 协程构造方法 (coroutine builder)。
     * liveData 协程构造方法提供了一个协程代码块，产生的是一个不可变的 LiveData，emit() 方法则用来更新 LiveData 的数据。
     * 具体可以查看之前写的这篇文章 [https://juejin.im/post/6844904193468137486#heading-10] 有详细介绍
     */
}