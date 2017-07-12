package dstudio.com.rxkotlinandroid.util

import dstudio.com.rxkotlinandroid.retrofitclient.RetrofitClient
import dstudio.com.rxkotlinandroid.retrofiturl.APIInterface

/**
 * Created by janwelcris on 7/12/2017.
 */

object RXKotlinAndroidUtils {
    interface Constant {
        companion object{
            val COLLECTION_RESPONSE = "collection_response"
            val MSN_LOGIN_ACCEPTANCE = "0468874507";
        }
    }

    interface URLString {
        companion object {
            val BASE_URL = "https://raw.githubusercontent.com/"
        }
    }

    val soService: APIInterface
        get() = RetrofitClient.getClient(URLString.BASE_URL).create(APIInterface::class.java)
}
