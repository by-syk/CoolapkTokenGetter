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

package com.by_syk.coolapktokengetter

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.by_syk.coolapktokengetter.util.ExtraUtil
import com.coolapk.market.util.AuthUtils
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

/**
 * Created by By_syk on 2016-07-16.
 */

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tv.text = AuthUtils.getAS(UUID.randomUUID().toString())
    }

    fun onTvClick(view: View) {
        ExtraUtil.copy2Clipboard(this, tv.text as String)

        Toast.makeText(this, R.string.toast_copied, Toast.LENGTH_SHORT).show();
    }
}
