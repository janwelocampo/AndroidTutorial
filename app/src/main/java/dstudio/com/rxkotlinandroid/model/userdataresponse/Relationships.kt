package dstudio.com.rxkotlinandroid.model.userdataresponse

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Relationships {

    @SerializedName("services")
    @Expose
    var services: Services? = null

}
