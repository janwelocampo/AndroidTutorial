package dstudio.com.rxkotlinandroid.model.userdataresponse

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Subscriptions {

    @SerializedName("links")
    @Expose
    var links: Links___? = null
    @SerializedName("data")
    @Expose
    var data: List<Datum>? = null

}
