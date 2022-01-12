package com.example.sinopac_interview.base

import android.app.ActivityManager
import android.app.Application
import android.content.Context
import android.content.Intent
import kotlin.properties.Delegates

/****************************************************
 * Author: AlanLai
 * Create Date: 2020/4/30
 * Usage:
 *
 * Revision History
 * Date         Author           Description
 ****************************************************/

class BaseApplication : Application() {

    companion object {
        private var instance: BaseApplication by Delegates.notNull()
        fun instance() = instance
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    fun exitApp() {
        // Finish all activities.
        killProcess()
        finishAndRemoveAllTasks()
    }

    fun restartApp() {
        val intent: Intent =
                packageManager.getLaunchIntentForPackage(baseContext.packageName) ?: Intent()
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
        intent.putExtra("REBOOT", "reboot")
        startActivity(intent)
    }

    /**
     * Kill current process.
     */
    private fun killProcess() {
        val home = Intent(Intent.ACTION_MAIN)
        home.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
        home.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        home.addCategory(Intent.CATEGORY_HOME)
        startActivity(home)
    }

    private fun finishAndRemoveAllTasks() {
        val am =
                baseContext.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
                        ?: return
        try {
            val appTasks = am.appTasks
            for (appTask in appTasks) {
                //CqrLog.debug("will finish and remove task: id=" + appTask.getTaskInfo().id);
                appTask.finishAndRemoveTask()
            }
        } catch (e: SecurityException) {
            //CqrLog.debug(e);
        }
    }
}