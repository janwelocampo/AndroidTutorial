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

import dstudio.com.rxkotlinandroid.R
import dstudio.com.rxkotlinandroid.callback.OnUserDataPass
import dstudio.com.rxkotlinandroid.model.userdataresponse.UserData
import dstudio.com.rxkotlinandroid.util.PreferenceWrapper
import dstudio.com.rxkotlinandroid.util.RXKotlinAndroidUtils.Constant.Companion.COLLECTION_RESPONSE
import kotlinx.android.synthetic.main.fragment_account.*


/**
 * Created by janwelcris on 6/23/2017.
 */

class AccountFragment : Fragment() {

    private var savedInstanceState: Bundle? = null
    private var myFragmentView: View? = null

    private var mAccount: UserData? = null


    private var listener: OnUserDataPass? = null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        this.savedInstanceState = savedInstanceState
        myFragmentView = inflater!!.inflate(R.layout.fragment_account, container, false)

        return myFragmentView
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mAccount = listener?.onUserDataPass()

        initializeViews()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnUserDataPass) {
            listener = context
        }
    }


    private fun initializeViews() {
        textview_name!!.text = mAccount!!.data!!.attributes!!.title +
                " " + mAccount!!.data!!.attributes!!.firstName +
                " " + mAccount!!.data!!.attributes!!.lastName
        textview_birthday!!.text = mAccount!!.data!!.attributes!!.dateOfBirth
        textview_contact!!.text = mAccount!!.data!!.attributes!!.contactNumber
        textview_email!!.text = mAccount!!.data!!.attributes!!.emailAddress
        textview_email_verified!!.text = java.lang.Boolean.toString(mAccount!!.data!!.attributes!!.emailAddressVerified!!)
    }
}
