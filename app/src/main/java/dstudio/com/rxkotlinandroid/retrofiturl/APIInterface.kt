package dstudio.com.rxkotlinandroid.retrofiturl

import dstudio.com.rxkotlinandroid.model.userdataresponse.UserData
import retrofit2.http.GET
import rx.Observable

/**
 * Created by janwelcris on 7/12/2017.
 */

interface APIInterface {

    @GET("/amaysim-au/engineering-test-resources/master/collection.json")
    fun doGetUserData(): Observable<UserData>
}
