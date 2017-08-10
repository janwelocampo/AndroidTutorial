package dstudio.com.retrofitrxandroid.apiconnection.connectivity;

import android.content.Context;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by janwelcris on 8/10/2017.
 */

public class NetworkInterceptor implements Interceptor {
    private Context mContext;

    public NetworkInterceptor(Context context) {
        mContext = context;
    }
    @Override
    public Response intercept(Chain chain) throws IOException {
        if (!LiveNetworkMonitor.isNetworkAvailable(mContext)) {
            throw new NoNetworkException();
        }

        return chain.proceed(chain.request());
    }
}
