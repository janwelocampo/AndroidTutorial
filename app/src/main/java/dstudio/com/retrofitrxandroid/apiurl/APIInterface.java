package dstudio.com.retrofitrxandroid.apiurl;


import dstudio.com.retrofitrxandroid.model.userdataresponse.UserData;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by janwelcris on 6/8/2017.
 */

public interface APIInterface {
    @GET("/janwelocampo/AndroidTutorial/master/collection.json")
    Observable<UserData> doGetUserData();


}
