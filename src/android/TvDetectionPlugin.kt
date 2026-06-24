package com.example.plugin.tvdetection

import android.content.pm.PackageManager
import android.util.Log
import org.apache.cordova.CallbackContext
import org.apache.cordova.CordovaPlugin
import org.json.JSONArray
import org.json.JSONException

class TvDetectionPlugin : CordovaPlugin() {

    companion object {
        const val TAG = "DeviceTypeRuntimeCheck"
    }

    override fun execute(action: String, args: JSONArray, callbackContext: CallbackContext): Boolean {
        if (action == "isTelevision") {
            this.checkIfTelevision(callbackContext)
            return true
        }
        return false
    }

    private fun checkIfTelevision(callbackContext: CallbackContext) {
        try {
            // Получаем packageManager через cordova.activity
            val packageManager = cordova.activity.packageManager
            val isTelevision = packageManager.hasSystemFeature(PackageManager.FEATURE_LEANBACK)

            if (isTelevision) {
                Log.d(TAG, "Running on a TV Device")
            } else {
                Log.d(TAG, "Running on a non-TV Device")
            }

            // Возвращаем результат в JavaScript
            callbackContext.success(if (isTelevision) 1 else 0) // Использование Boolean (isTelevision) тоже допустимо
        } catch (e: Exception) {
            Log.e(TAG, "Error checking device type", e)
            callbackContext.error("Error: ${e.message}")
        }
    }
}
