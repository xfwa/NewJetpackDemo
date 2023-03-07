package com.android.ljm.gate.workmanager

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.WorkRequest
import androidx.work.impl.WorkRequestHolder

/**
 * 参考文档：
 * https://developer.android.google.cn/topic/libraries/architecture/workmanager/basics?hl=zh-cn
 *
 * 什么是WorkManager?
 * WorkManager 是适合用于持久性工作的推荐解决方案。（在Google推出这套方案之前，我们通常会使用一些例如JobScheduler,后台Service等方式去做一些持久性的工作。）
 * 如果工作始终要通过应用重启和系统重新启动来调度，便是持久性的工作。由于大多数后台处理操作都是通过持久性工作完成的，因此 WorkManager 是适用于后台处理操作的主要推荐 API。
 *
 * 持久性的工作类型
 * WorkManager可以处理三种类型的持久性工作
 * 立即执行：必须立即开始且很快就完成的任务，可以加急
 * 长时间运行：运行时间可能较长（有可能超过10分钟）的任务
 * 可延期执行：延期开始并且可以定期运行的预定任务
 *
 * 在WorkManager中，支持以下三种工作类型
 *
 * 详细的我们会在后面的使用中讲到
 *
 *
 * 使用WorkManager保证工作可靠性
 * WorkManager 适用于需要可靠运行的工作，即使用户导航离开屏幕、退出应用或重启设备也不影响工作的执行。例如：
 * 向后端服务发送日志或分析数据。
 * 定期将应用数据与服务器同步。
 *
 * 导入依赖
 * 如我我们现在是是使用kotlin开发，我们只需要导入最基本的kotlin+coroutines库就可以了
 * def work_version = "2.8.0"
 * // Kotlin + coroutines
 * implementation "androidx.work:work-runtime-ktx:$work_version"
 * 如果您有其它需求，可以参照以下文档：
 * https://developer.android.google.cn/jetpack/androidx/releases/work?hl=zh-cn
 *
 * 怎么使用WorkManager
 *
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //定义一个一次性的请求
        val build = OneTimeWorkRequestBuilder<UploadWork>().build()
        WorkManager.getInstance(this).enqueue(build)

    }
}