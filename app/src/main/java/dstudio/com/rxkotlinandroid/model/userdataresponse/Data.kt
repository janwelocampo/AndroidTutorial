package dstudio.com.rxkotlinandroid.model.userdataresponse

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Data {

    @SerializedName("type")
    @Expose
    var type: String? = null
    @SerializedName("id")
    @Expose
    var id: String? = null
    @SerializedName("attributes")
    @Expose
    var attributes: Attributes? = null
    @SerializedName("links")
    @Expose
    var links: Links? = null
    @SerializedName("relationships")
    @Expose
    var relationships: Relationships? = null

}
