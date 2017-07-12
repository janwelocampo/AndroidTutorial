package dstudio.com.rxkotlinandroid.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

import dstudio.com.rxkotlinandroid.R
import dstudio.com.rxkotlinandroid.util.RXKotlinAndroidUtils
import dstudio.com.rxkotlinandroid.util.RXKotlinAndroidUtils.Constant.Companion.MSN_LOGIN_ACCEPTANCE
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : BaseActivity(), View.OnClickListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        
        button_login!!.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.button_login -> if (isValidInput(edit_msn!!.text.toString())) {
                startActivity(Intent(this@LoginActivity, SplashActivity::class.java))
                finish()
            }
        }
    }

    private fun isValidInput(msnNumber: String): Boolean {
        if (msnNumber.trim { it <= ' ' }.length < 10) {
            Toast.makeText(this, "MSN Number is less than 10", Toast.LENGTH_SHORT).show()
            return false
        }
        if (msnNumber != MSN_LOGIN_ACCEPTANCE) {
            Toast.makeText(this, "MSN Number is invalid", Toast.LENGTH_SHORT).show()
            return false
        }

        return true
    }
}
