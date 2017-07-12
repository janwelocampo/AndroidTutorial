package dstudio.com.rxkotlinandroid.util

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager

/**
 * Created by janwelcris on 7/12/2017.
 */

class PreferenceWrapper private constructor(context: Context) {
    private val sharedPref: SharedPreferences

    init {
        sharedPref = PreferenceManager.getDefaultSharedPreferences(context)
    }

    fun setPrefString(key: String, value: String) {
        sharedPref.edit().putString(key, value).commit()
    }

    fun getPrefString(key: String): String {
        return sharedPref.getString(key, "Empty")
    }

    companion object {

        fun instanceOf(context: Context): PreferenceWrapper {
            return PreferenceWrapper(context)
        }
    }
}
