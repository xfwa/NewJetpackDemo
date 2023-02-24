package com.android.ljm.gate.lifecycle

import android.app.Application
import androidx.lifecycle.ProcessLifecycleOwner

class TestApplication :Application(){

    /**
     * 为什么要学习lifecycle,使用jetpack有什么好处
     * 作为一名Android开发工程师，jetpack是必学技能，为什么呢？因为这是谷歌推荐的，也就是下面要说的，遵循最佳做法
     * https://developer.android.google.cn/jetpack?hl=zh-cn
     *
     * Lifecycle是什么？
     * 生命周期感知型组件可执行操作来响应另一个组件（如 activity 和 fragment）的生命周期状态的变化。
     * 这些组件有助于您写出更有条理且往往更精简的代码，这样的代码更易于维护。
     *
     * 未使用Lifecycle时我们是怎么管理生命周期的？
     */

    override fun onCreate() {
        super.onCreate()
        ProcessLifecycleOwner.get().lifecycle.addObserver(ApplicationLifecycleObserver())
    }

}