package dstudio.com.retrofitrxandroid.util;

import dstudio.com.retrofitrxandroid.apiurl.APIInterface;
import dstudio.com.retrofitrxandroid.client.RetrofitClient;

/**
 * Created by janwelcris on 6/8/2017.
 */

public class ApiUtils {
    public static final String BASE_URL = "https://raw.githubusercontent.com";

    public static APIInterface getSOService() {
        return RetrofitClient.getClient(BASE_URL).create(APIInterface.class);
    }
}