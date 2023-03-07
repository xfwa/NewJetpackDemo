package com.android.ljm.gate.workmanager

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters

class UploadWork(context: Context, workerParams: WorkerParameters) :
    Worker(context, workerParams) {
    override fun doWork(): Result {
        /**
         * Result.success()：工作成功完成。
         * Result.failure()：工作失败。
         * Result.retry()：工作失败，应根据其重试政策在其他时间尝试。
         */
        // TODO: 这里做一些后台操纵
        Log.d("xfwa", "doWork: ")
        return Result.success()
    }
}