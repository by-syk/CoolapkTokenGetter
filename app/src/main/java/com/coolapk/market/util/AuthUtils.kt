package com.coolapk.market.util

/**
 * Created by By_syk on 2017-05-19.
 */

object AuthUtils {
    external fun getAS(str: String): String

    init {
        System.loadLibrary("a")
    }
}