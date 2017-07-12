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


/**
 * Created by janwelcris on 6/23/2017.
 */

class AccountFragment : Fragment() {

    private var savedInstanceState: Bundle? = null
    private var myFragmentView: View? = null

    private var mAccount: UserData? = null

    private var textViewName: TextView? = null
    private var textViewBirthday: TextView? = null
    private var textViewContact: TextView? = null
    private var textViewEmail: TextView? = null
    private var textViewEmailVerified: TextView? = null
    private var listener: OnUserDataPass? = null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        this.savedInstanceState = savedInstanceState
        myFragmentView = inflater!!.inflate(R.layout.fragment_account, container, false)

        return myFragmentView
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        textViewName = view!!.findViewById(R.id.textview_name) as TextView
        textViewBirthday = view.findViewById(R.id.textview_birthday) as TextView
        textViewContact = view.findViewById(R.id.textview_contact) as TextView
        textViewEmail = view.findViewById(R.id.textview_email) as TextView
        textViewEmailVerified = view.findViewById(R.id.textview_email_verified) as TextView

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
        textViewName!!.text = mAccount!!.data!!.attributes!!.title +
                " " + mAccount!!.data!!.attributes!!.firstName +
                " " + mAccount!!.data!!.attributes!!.lastName
        textViewBirthday!!.text = mAccount!!.data!!.attributes!!.dateOfBirth
        textViewContact!!.text = mAccount!!.data!!.attributes!!.contactNumber
        textViewEmail!!.text = mAccount!!.data!!.attributes!!.emailAddress
        textViewEmailVerified!!.text = java.lang.Boolean.toString(mAccount!!.data!!.attributes!!.emailAddressVerified!!)
    }
}
