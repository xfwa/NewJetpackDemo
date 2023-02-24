package com.android.ljm.gate.lifecycle

object TestUtil {

    fun diSomething(callback: () -> Unit) {
        Thread {
            Thread.sleep(1000 * 10)
            callback.invoke()
        }.start()
    }

}