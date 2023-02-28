package com.android.ljm.gate.livedata

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.Locale.filter

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {

    /**
     * 官方文档：
     * https://developer.android.google.cn/topic/libraries/architecture/livedata?hl=zh_cn
     * 1、什么是LiveData?
     * LiveData 是一种可观察的数据存储器类。与常规的可观察类不同，LiveData 具有生命周期感知能力，意指它遵循其他应用组件（如 activity、fragment 或 service）的生命周期。
     * 这种感知能力可确保 LiveData 仅更新处于活跃生命周期状态的应用组件观察者。当观察者（Activity,Fragment）生命周期处于STARTED状态(通常表示 Activity 正在启动或者正在后台运行，但尚未进入前台并与用户交互。)
     * 或者RESUMED状态(代表 Activity 正在前台运行并与用户交互。)则 LiveData 会认为该观察者处于活跃状态。LiveData 只会将更新通知给活跃的观察者。为观察 LiveData 对象而注册的非活跃观察者不会收到更改通知。
     *
     * 2、引入依赖
     * 同样的，如果你是AndroidX项目并且有引入appcompat，那么可以直接使用LiveData,如果您想但如引入，可以参考以下文档：
     * https://developer.android.google.cn/topic/libraries/architecture/adding-components?hl=zh-cn#lifecycle
     *
     * 3、使用LiveData的优势
     * 确保界面符合数据状态
     * 不会发生内存泄漏
     * 不会因 Activity 停止而导致崩溃
     * 不再需要手动处理生命周期
     * 数据始终保持最新状态
     * 适当的配置更改
     * 共享资源
     *
     * 4、怎么使用LiveData
     * 通常LiveData配合ViewModel一起使用，因为我们还没了解ViewModel，我们先了解LiveData,等了解完ViewModel之后，我们再一起结合使用，在实际开发过程中我们并不推荐将LiveData放在Activity或者Fragment,
     * 具体原因如下：
     *
     * Map操作符
     *
     *
     * switchMap操作符
     *
     *
     * MediatorLiveData
     */

    private val testLiveData = MutableLiveData<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        testLiveData.observe(this) {
            Log.d(TAG, "liveData收到数据: $it")
        }
    }

    fun sendData(view: View) {
        testLiveData.value = "主线程发送数据"
    }

    fun postSendData(view: View) {
        lifecycleScope.launch(Dispatchers.IO) {
            testLiveData.postValue("子线程发送数据")
        }
    }

    fun mapOperator(view: View) {
        val mapLiveData = Transformations.map(testLiveData) {
            "$it+map操作符"
        }

        mapLiveData.observe(this) {
            Log.d(TAG, "LiveData经过map转换后的数据: $it")
        }
    }

    private val test = Transformations.switchMap(testLiveData) { test ->
        getUserInfo(test)
    }


    fun switchOperator(view: View) {
        testLiveData.value = "111"
        test.observe(this) {
            Log.d(TAG, "switchOperator: $it")
        }
    }

    private fun getUserInfo(test: String): MutableLiveData<String> {
        val mutableLiveData = MutableLiveData<String>()
        mutableLiveData.value = "switch Map"
        return mutableLiveData
    }

    private val liveDataMerger = MediatorLiveData<List<String>>()

    private fun search(key: String) {
        liveDataMerger.observe(this) {
            it.forEach {
                Log.d(TAG, "search: $it")
            }
        }
        val searchQueryLiveData = MutableLiveData<String>()
        searchQueryLiveData.value = key
        val searchResultLiveData = MutableLiveData<List<String>>()
        liveDataMerger.apply {
            addSource(searchQueryLiveData) {
                getSearchResult().observe(this@MainActivity) {
                    searchResultLiveData.value = it
                }
            }

            addSource(searchResultLiveData) {
                value = it
            }
        }

    }

    private fun getSearchResult(): MutableLiveData<List<String>> {
        val resultLiveData = MutableLiveData<List<String>>()
        resultLiveData.value = arrayListOf("1", "2", "3")
        return resultLiveData
    }

    fun mediatorLiveData(view: View) {
        search("1")
    }

}