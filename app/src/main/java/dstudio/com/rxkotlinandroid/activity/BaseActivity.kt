package dstudio.com.rxkotlinandroid.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.google.gson.Gson

import dstudio.com.rxkotlinandroid.util.PreferenceWrapper

/**
 * Created by janwelcris on 7/12/2017.
 */
abstract class BaseActivity : AppCompatActivity() {


    protected var mPreferenceWrapper : PreferenceWrapper? = null
    protected var mGson: Gson? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mPreferenceWrapper = PreferenceWrapper.instanceOf(this)
        mGson = Gson()

    }


}
