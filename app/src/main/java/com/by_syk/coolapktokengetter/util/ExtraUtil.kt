/*
 * Copyright 2017 By_syk
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.by_syk.coolapktokengetter.util

import android.annotation.SuppressLint
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import java.util.*

/**
 * Created by By_syk on 2017-05-19.
 */

object ExtraUtil {
    @SuppressLint("NewApi")
    fun copy2Clipboard(context: Context?, text: String?) {
        if (context == null || text == null) {
            return
        }

        if (C.SDK >= 11) {
            val clipboardManager = context.getSystemService(Context.CLIPBOARD_SERVICE)
                    as ClipboardManager
            val clipData = ClipData.newPlainText(null, text)
            clipboardManager.primaryClip = clipData
        } else {
            val clipboardManager = context.getSystemService(Context.CLIPBOARD_SERVICE)
                    as android.text.ClipboardManager
            clipboardManager.text = text
        }
    }

    @SuppressLint("NewApi")
    fun getFromClipboard(context: Context?): String? {
        if (context == null) {
            return null
        }

        if (C.SDK >= 11) {
            val clipboardManager = context.getSystemService(Context.CLIPBOARD_SERVICE)
                    as ClipboardManager
            val clipData = clipboardManager.primaryClip
            if (clipData.itemCount > 0) {
                return clipData.getItemAt(0).text.toString()
            }
            return null
        } else {
            val clipboardManager = context.getSystemService(Context.CLIPBOARD_SERVICE)
                    as android.text.ClipboardManager
            return clipboardManager.text.toString()
        }
    }

    fun formatTime(timeMillis: Long?): String {
        val calendar = Calendar.getInstance()
        if (timeMillis != null) {
            calendar.timeInMillis = timeMillis
        }

        return String.format("%1$02d:%2$02d:%3$02d",
                calendar.get(Calendar.HOUR_OF_DAY),
                calendar.get(Calendar.MINUTE),
                calendar.get(Calendar.SECOND))
    }
}