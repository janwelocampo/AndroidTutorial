package dstudio.com.rxkotlinandroid.model.userdataresponse

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Included {

    @SerializedName("type")
    @Expose
    var type: String? = null
    @SerializedName("id")
    @Expose
    var id: String? = null
    @SerializedName("attributes")
    @Expose
    var attributes: Attributes_? = null
    @SerializedName("links")
    @Expose
    var links: Links__? = null
    @SerializedName("relationships")
    @Expose
    var relationships: Relationships_? = null

}
