package dstudio.com.rxkotlinandroid.model.userdataresponse

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Relationships_ {

    @SerializedName("subscriptions")
    @Expose
    var subscriptions: Subscriptions? = null
    @SerializedName("service")
    @Expose
    var service: Service? = null
    @SerializedName("product")
    @Expose
    var product: Product? = null
    @SerializedName("downgrade")
    @Expose
    var downgrade: Downgrade? = null

}
