package com.by_syk.coolapktokengetter.receiver

import android.app.Activity
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

import com.coolapk.market.util.AuthUtils
import java.util.*

/**
 * Created by By_syk on 2017-03-20.
 */

class CoolapkTokenGetReceiver : BroadcastReceiver() {
    val ACTION_GET_CLIP = "adbCoolapkTokenGet"

    override fun onReceive(context: Context, intent: Intent) {
        if (ACTION_GET_CLIP != intent.action) {
            resultCode = Activity.RESULT_CANCELED
            resultData = null
            return
        }

        resultCode = Activity.RESULT_OK
        resultData = AuthUtils.getAS(UUID.randomUUID().toString())
    }
}
