package dstudio.com.retrofitrxandroid.apiconnection;


import dstudio.com.retrofitrxandroid.model.userdataresponse.UserData;
import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by janwelcris on 6/8/2017.
 */

public interface APIInterface {
    @GET("/janwelocampo/AndroidTutorial/master/collection.json")
    Observable<UserData> doGetUserData();



}
