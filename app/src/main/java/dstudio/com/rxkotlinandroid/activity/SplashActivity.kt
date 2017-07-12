package dstudio.com.rxkotlinandroid.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import dstudio.com.rxkotlinandroid.R
import dstudio.com.rxkotlinandroid.model.userdataresponse.UserData
import dstudio.com.rxkotlinandroid.retrofiturl.APIInterface
import dstudio.com.rxkotlinandroid.util.RXKotlinAndroidUtils
import dstudio.com.rxkotlinandroid.util.RXKotlinAndroidUtils.Constant.Companion.COLLECTION_RESPONSE
import rx.Subscriber
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

class SplashActivity : BaseActivity()  {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        loadUserData()
    }

    private fun loadUserData() {
        RXKotlinAndroidUtils.soService.doGetUserData().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : Subscriber<UserData>() {
                    override fun onCompleted() {
                        Log.i("Completed","Completed")}

                    override fun onError(e: Throwable) {
                        Log.i("Error",e.localizedMessage)
                    }

                    override fun onNext(soAnswersResponse: UserData) {

                        mPreferenceWrapper!!.setPrefString(COLLECTION_RESPONSE, mGson!!.toJson(soAnswersResponse))
                        startActivity(Intent(this@SplashActivity, DashboardActivity::class.java))
                        finish()

                    }
                })
    }
}
