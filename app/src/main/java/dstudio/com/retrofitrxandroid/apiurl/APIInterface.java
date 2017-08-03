package dstudio.com.retrofitrxandroid.apiurl;


import dstudio.com.retrofitrxandroid.model.colorresponse.Colors;
import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by janwelcris on 6/8/2017.
 */

public interface APIInterface {
    @GET("/janwelocampo/AndroidTutorial/master/colors.json")
    Observable<Colors> doGetColors();


}
