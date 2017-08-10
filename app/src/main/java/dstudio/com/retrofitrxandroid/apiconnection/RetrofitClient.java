package dstudio.com.retrofitrxandroid.apiconnection;

import android.content.Context;

import java.util.concurrent.TimeUnit;

import dstudio.com.retrofitrxandroid.apiconnection.connectivity.LiveNetworkMonitor;
import dstudio.com.retrofitrxandroid.apiconnection.connectivity.NetworkInterceptor;
import dstudio.com.retrofitrxandroid.apiconnection.connectivity.NoNetworkException;
import dstudio.com.retrofitrxandroid.util.ApiUtils;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by janwelcris on 6/8/2017.
 */

public class RetrofitClient {
    private static int readTimeout = 60;
    private static  int connectTimeout = 60;
    private static Retrofit retrofit = null;

    private static Retrofit getClient(final Context context, String baseUrl) {
        if (retrofit==null) {

            retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .client(monitorInterceptor(context))
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

        }
        return retrofit;
    }

    private static OkHttpClient monitorInterceptor(Context context){

        OkHttpClient client = new OkHttpClient.Builder()

                // set time out comment out if doesn't need
                .readTimeout(readTimeout, TimeUnit.SECONDS)
                .connectTimeout(connectTimeout, TimeUnit.SECONDS)

                // add network monitor interceptor
                .addInterceptor(new NetworkInterceptor(context))
                .build();
        return client;
    }

    public static APIInterface getSOService(Context context) {
        return RetrofitClient.getClient(context,ApiUtils.Constants.BASE_URL).create(APIInterface.class);
    }
}