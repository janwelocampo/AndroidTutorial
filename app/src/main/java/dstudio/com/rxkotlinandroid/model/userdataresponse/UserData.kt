package dstudio.com.rxkotlinandroid.model.userdataresponse

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class UserData {

    @SerializedName("data")
    @Expose
    var data: Data? = null
    @SerializedName("included")
    @Expose
    var included: List<Included>? = null

}
