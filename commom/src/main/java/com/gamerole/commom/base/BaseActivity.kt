package com.gamerole.commom.base

import android.annotation.SuppressLint
import android.content.res.Configuration
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.gamerole.commom.R
import org.jetbrains.anko.sdk27.coroutines.onClick

abstract class BaseActivity : AppCompatActivity() {
    private lateinit var viewModel: BaseViewModel
    var immersion: Boolean = true

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (immersion) {
            setContentView(R.layout.common_activity)
        } else {
            setContentView(R.layout.common_immer_activity)
        }
        val viewRoot: ViewGroup = findViewById(R.id.flImmerRoot)
        viewRoot.addView(layoutInflater.inflate(layoutId, null, false))
        viewModel = getViewModel()
        initView()
        initData()
        initEvent()
        val back: View? = findViewById<View>(R.id.ivBack)
        back?.onClick { onBackPressed() }
        viewModel.progress.observe(this, Observer {
            if (it)
                showLoading()
            else
                hideLoading()
        })
    }


    abstract fun getViewModel(): BaseViewModel

    protected fun initEvent() {}


    protected override fun onDestroy() {
        super.onDestroy()
    }

    open fun initData() {}
    open fun initView() {}
    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        // 如果你的app可以横竖屏切换，并且适配4.4或者emui3手机请务必在onConfigurationChanged方法里添加这句话
    }

    override fun onContentChanged() {
        super.onContentChanged()
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
    }

    /**
     * 初始化布局ID
     *
     * @return
     */
    protected abstract val layoutId: Int
    fun showLoading() {
        println("loading...")
    }

    fun hideLoading() {
        println("hide loading")
    }
}