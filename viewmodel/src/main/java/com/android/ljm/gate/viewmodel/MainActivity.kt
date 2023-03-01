package com.android.ljm.gate.viewmodel

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity

/**
 * 什么是ViewModel？
 * ViewModel 类是一种业务逻辑或屏幕级状态容器。它用于将状态公开给界面，以及封装相关的业务逻辑。
 * 它的主要优点是，它可以缓存状态，并可在配置更改后持久保留相应状态。这意味着在 activity 之间导航时或进行配置更改后（例如旋转屏幕时），界面将无需重新提取数据。
 * 简单的说它就是为界面（Activity,Fragment）数据准备的模型
 *
 * ViewModel的优势？
 * 持久性
 * ViewModel 允许数据在 ViewModel 持有的状态和 ViewModel 触发的操作结束后继续存在。这种缓存意味着在常见的配置更改（例如屏幕旋转）完成后，您无需重新提取数据。
 * 作用域
 * ViewModel的作用域是指ViewModel实例的生命周期，即在何时创建和销毁ViewModel对象。 在Android中，ViewModel的生命周期范围可以是：
 * Activity级别的作用域：在此范围内创建的ViewModel对象将在与其相关联的Activity被销毁时销毁。
 * Fragment级别的作用域：在此范围内创建的ViewModel对象将在与其相关联的Fragment被销毁时销毁。
 * Application级别的作用域：在此范围内创建的ViewModel对象将在应用程序进程被销毁时销毁。
 *
 * ViewModel的生命周期
 *
 * 使用ViewModel
 *
 * 注意：ViewModel 通常不应引用视图、Lifecycle 或可能存储对 activity 上下文的引用的任何类。由于 ViewModel 的生命周期大于界面的生命周期，因此在 ViewModel 中保留与生命周期相关的 API 可能会导致内存泄漏。
 *
 * 数据的持久性-屏幕旋转问题
 * 在ViewModel出现之前，我们一般是在onSaveInstanceState()函数保存数据，在onCreate()恢复数据
 *
 * 在有ViewModel之后，我们可以使用ViewModel很好的解决这个问题
 *
 * ViewModel数据共享
 *
 * 想在ViewModel使用到生命周期怎么办
 */
private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {

    private val viewModel: MyViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel.userNameLiveData.observe(this) {
            Log.d(TAG, "onCreate: $it")
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.d(TAG, "onSaveInstanceState: ")
    }

    fun sendData(view: View) {
        viewModel.getUserInfo()
    }
}