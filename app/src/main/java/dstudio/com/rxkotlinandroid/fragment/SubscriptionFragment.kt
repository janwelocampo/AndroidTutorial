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
import kotlinx.android.synthetic.main.fragment_subscription.*


/**
 * Created by janwelcris on 6/23/2017.
 */

class SubscriptionFragment : Fragment() {

    private var savedInstanceState: Bundle? = null
    private var myFragmentView: View? = null

    private var mAccount: UserData? = null

    private var listener: OnUserDataPass? = null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        this.savedInstanceState = savedInstanceState
        myFragmentView = inflater!!.inflate(R.layout.fragment_subscription, container, false)
        return myFragmentView
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

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
        textview_remaining_balance!!.text = NumberFormat.getNumberInstance(Locale.US).format(mAccount!!.included!![0].attributes!!.credit)
        textview_msn!!.text = mAccount!!.included!![0].attributes!!.msn
        textview_credit_expiry!!.text = mAccount!!.included!![0].attributes!!.creditExpiry
        textview_auto_renewal!!.text = java.lang.Boolean.toString(mAccount!!.included!![1].attributes!!.autoRenewal!!)

        textview_product_name!!.text = mAccount!!.included!![2].attributes!!.name
        textview_price!!.text = NumberFormat.getNumberInstance(Locale.US).format(mAccount!!.included!![2].attributes!!.price)

        textview_unli_text!!.text = java.lang.Boolean.toString(mAccount!!.included!![2].attributes!!.unlimitedText!!)
        textview_unli_talk!!.text = java.lang.Boolean.toString(mAccount!!.included!![2].attributes!!.unlimitedTalk!!)
        textview_unli_inter_text!!.text = java.lang.Boolean.toString(mAccount!!.included!![2].attributes!!.unlimitedInternationalText!!)
        textview_unli_inter_talk!!.text = java.lang.Boolean.toString(mAccount!!.included!![2].attributes!!.unlimitedInternationalTalk!!)
    }
}
