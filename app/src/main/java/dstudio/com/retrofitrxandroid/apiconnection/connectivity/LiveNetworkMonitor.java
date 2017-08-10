package dstudio.com.retrofitrxandroid.apiconnection.connectivity;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by janwelcris on 8/10/2017.
 */

public class LiveNetworkMonitor {


    public static boolean isNetworkAvailable(Context context) {
            ConnectivityManager connectivityManager
                    = (ConnectivityManager) (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();

            return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();

    }
}