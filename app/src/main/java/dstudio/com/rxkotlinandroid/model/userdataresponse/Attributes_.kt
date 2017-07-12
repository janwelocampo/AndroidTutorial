package dstudio.com.rxkotlinandroid.model.userdataresponse

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Attributes_ {

    @SerializedName("msn")
    @Expose
    var msn: String? = null
    @SerializedName("credit")
    @Expose
    var credit: Int? = null
    @SerializedName("credit-expiry")
    @Expose
    var creditExpiry: String? = null
    @SerializedName("data-usage-threshold")
    @Expose
    var dataUsageThreshold: Boolean? = null
    @SerializedName("included-data-balance")
    @Expose
    var includedDataBalance: Int? = null
    @SerializedName("included-credit-balance")
    @Expose
    var includedCreditBalance: Any? = null
    @SerializedName("included-rollover-credit-balance")
    @Expose
    var includedRolloverCreditBalance: Any? = null
    @SerializedName("included-rollover-data-balance")
    @Expose
    var includedRolloverDataBalance: Any? = null
    @SerializedName("included-international-talk-balance")
    @Expose
    var includedInternationalTalkBalance: Any? = null
    @SerializedName("expiry-date")
    @Expose
    var expiryDate: String? = null
    @SerializedName("auto-renewal")
    @Expose
    var autoRenewal: Boolean? = null
    @SerializedName("primary-subscription")
    @Expose
    var primarySubscription: Boolean? = null
    @SerializedName("name")
    @Expose
    var name: String? = null
    @SerializedName("included-data")
    @Expose
    var includedData: Any? = null
    @SerializedName("included-credit")
    @Expose
    var includedCredit: Any? = null
    @SerializedName("included-international-talk")
    @Expose
    var includedInternationalTalk: Any? = null
    @SerializedName("unlimited-text")
    @Expose
    var unlimitedText: Boolean? = null
    @SerializedName("unlimited-talk")
    @Expose
    var unlimitedTalk: Boolean? = null
    @SerializedName("unlimited-international-text")
    @Expose
    var unlimitedInternationalText: Boolean? = null
    @SerializedName("unlimited-international-talk")
    @Expose
    var unlimitedInternationalTalk: Boolean? = null
    @SerializedName("price")
    @Expose
    var price: Int? = null

}
