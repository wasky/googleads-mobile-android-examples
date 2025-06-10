package com.google.android.gms.example.interstitialexample

import android.app.Activity
import android.app.Application
import android.os.Build
import android.os.Bundle
import android.view.WindowInsets
import com.google.android.gms.ads.AdActivity

class AdMobExampleApplication : Application() {

    private val activityLifecycleCallbacks = object : ActivityLifecycleCallbacks {

        override fun onActivityPreCreated(activity: Activity, savedInstanceState: Bundle?) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.VANILLA_ICE_CREAM) {
                if (activity::class.java == AdActivity::class.java) {
                    val rootView = activity.window.decorView
                    rootView.windowInsetsController?.hide(WindowInsets.Type.navigationBars())
                }
            }
        }

        override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {}
        override fun onActivityStarted(activity: Activity) {}
        override fun onActivityResumed(activity: Activity) {}
        override fun onActivityPaused(activity: Activity) {}
        override fun onActivityStopped(activity: Activity) {}
        override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {}
        override fun onActivityDestroyed(activity: Activity) {}
    }

    override fun onCreate() {
        super.onCreate()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.VANILLA_ICE_CREAM) {
            registerActivityLifecycleCallbacks(activityLifecycleCallbacks)
        }
    }

}