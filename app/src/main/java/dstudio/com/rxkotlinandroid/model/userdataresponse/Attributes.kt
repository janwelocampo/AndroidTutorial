package dstudio.com.rxkotlinandroid.model.userdataresponse

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Attributes {

    @SerializedName("payment-type")
    @Expose
    var paymentType: String? = null
    @SerializedName("unbilled-charges")
    @Expose
    var unbilledCharges: Any? = null
    @SerializedName("next-billing-date")
    @Expose
    var nextBillingDate: Any? = null
    @SerializedName("title")
    @Expose
    var title: String? = null
    @SerializedName("first-name")
    @Expose
    var firstName: String? = null
    @SerializedName("last-name")
    @Expose
    var lastName: String? = null
    @SerializedName("date-of-birth")
    @Expose
    var dateOfBirth: String? = null
    @SerializedName("contact-number")
    @Expose
    var contactNumber: String? = null
    @SerializedName("email-address")
    @Expose
    var emailAddress: String? = null
    @SerializedName("email-address-verified")
    @Expose
    var emailAddressVerified: Boolean? = null
    @SerializedName("email-subscription-status")
    @Expose
    var emailSubscriptionStatus: Boolean? = null

}
