package dstudio.com.rxkotlinandroid.fragment

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import com.google.gson.Gson

import org.json.JSONException

import java.text.NumberFormat
import java.util.Locale

import dstudio.com.rxkotlinandroid.R
import dstudio.com.rxkotlinandroid.callback.OnUserDataPass
import dstudio.com.rxkotlinandroid.model.userdataresponse.UserData
import dstudio.com.rxkotlinandroid.util.PreferenceWrapper
import dstudio.com.rxkotlinandroid.util.RXKotlinAndroidUtils.Constant.Companion.COLLECTION_RESPONSE


/**
 * Created by janwelcris on 6/23/2017.
 */

class SubscriptionFragment : Fragment() {

    private var savedInstanceState: Bundle? = null
    private var myFragmentView: View? = null

    private var textViewRemainingBalance: TextView? = null
    private var textViewMSN: TextView? = null
    private var textViewCCExpiry: TextView? = null
    private var textViewAutoRenewal: TextView? = null

    private var textViewProductName: TextView? = null
    private var textViewPrice: TextView? = null

    private var textViewUnliText: TextView? = null
    private var textViewUnliTalk: TextView? = null
    private var textViewInterUnliText: TextView? = null
    private var textViewInterUnliTalk: TextView? = null

    private var mAccount: UserData? = null

    private var listener: OnUserDataPass? = null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        this.savedInstanceState = savedInstanceState
        myFragmentView = inflater!!.inflate(R.layout.fragment_subscription, container, false)
        return myFragmentView
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        textViewRemainingBalance = view!!.findViewById(R.id.textview_remaining_balance) as TextView
        textViewMSN = view.findViewById(R.id.textview_msn) as TextView
        textViewCCExpiry = view.findViewById(R.id.textview_credit_expiry) as TextView
        textViewAutoRenewal = view.findViewById(R.id.textview_auto_renewal) as TextView

        textViewProductName = view.findViewById(R.id.textview_product_name) as TextView
        textViewPrice = view.findViewById(R.id.textview_price) as TextView

        textViewUnliText = view.findViewById(R.id.textview_unli_text) as TextView
        textViewUnliTalk = view.findViewById(R.id.textview_unli_talk) as TextView
        textViewInterUnliText = view.findViewById(R.id.textview_unli_inter_text) as TextView
        textViewInterUnliTalk = view.findViewById(R.id.textview_unli_inter_talk) as TextView

        mAccount =  listener?.onUserDataPass()

        initializeViews()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnUserDataPass) {
            listener = context
        }
    }

    private fun initializeViews() {
        textViewRemainingBalance!!.text = NumberFormat.getNumberInstance(Locale.US).format(mAccount!!.included!![0].attributes!!.credit)
        textViewMSN!!.text = mAccount!!.included!![0].attributes!!.msn
        textViewCCExpiry!!.text = mAccount!!.included!![0].attributes!!.creditExpiry
        textViewAutoRenewal!!.text = java.lang.Boolean.toString(mAccount!!.included!![1].attributes!!.autoRenewal!!)

        textViewProductName!!.text = mAccount!!.included!![2].attributes!!.name
        textViewPrice!!.text = NumberFormat.getNumberInstance(Locale.US).format(mAccount!!.included!![2].attributes!!.price)

        textViewUnliText!!.text = java.lang.Boolean.toString(mAccount!!.included!![2].attributes!!.unlimitedText!!)
        textViewUnliTalk!!.text = java.lang.Boolean.toString(mAccount!!.included!![2].attributes!!.unlimitedTalk!!)
        textViewInterUnliText!!.text = java.lang.Boolean.toString(mAccount!!.included!![2].attributes!!.unlimitedInternationalText!!)
        textViewInterUnliTalk!!.text = java.lang.Boolean.toString(mAccount!!.included!![2].attributes!!.unlimitedInternationalTalk!!)
    }
}
