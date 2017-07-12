package dstudio.com.rxkotlinandroid.activity

import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.widget.Toolbar
import android.view.MenuItem

import dstudio.com.rxkotlinandroid.R
import dstudio.com.rxkotlinandroid.callback.OnUserDataPass
import dstudio.com.rxkotlinandroid.fragment.AccountFragment
import dstudio.com.rxkotlinandroid.fragment.SubscriptionFragment
import dstudio.com.rxkotlinandroid.model.userdataresponse.UserData
import dstudio.com.rxkotlinandroid.util.RXKotlinAndroidUtils


class DashboardActivity : BaseActivity(), NavigationView.OnNavigationItemSelectedListener, OnUserDataPass {



    private var fragmentManager: FragmentManager? = null
    private var fragmentTransaction: FragmentTransaction? = null

    private var mAccount: UserData? = null


    @Suppress("DEPRECATION")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
        val toolbar = findViewById(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)

        val drawer = findViewById(R.id.drawer_layout) as DrawerLayout
        val toggle = ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        val navigationView = findViewById(R.id.nav_view) as NavigationView

        drawer.setDrawerListener(toggle)
        toggle.syncState()
        navigationView.setNavigationItemSelectedListener(this)

        val response = mPreferenceWrapper!!.getPrefString(RXKotlinAndroidUtils.Constant.COLLECTION_RESPONSE)
        mAccount = mGson!!.fromJson(response, UserData::class.java)

        initializeViews()

    }

    private fun initializeViews() {
        fragmentManager = supportFragmentManager
        fragmentTransaction = fragmentManager!!.beginTransaction()
        fragmentTransaction!!.add(R.id.linear_content, AccountFragment()).commit()

    }

    override fun onBackPressed() {
        val drawer = findViewById(R.id.drawer_layout) as DrawerLayout
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onUserDataPass(): UserData {

       return mAccount!!
    }


    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.

        when (item.itemId) {
            R.id.nav_account -> changeFragment(AccountFragment())
            R.id.nav_subscription -> changeFragment(SubscriptionFragment())
            else -> {
            }
        }


        val drawer = findViewById(R.id.drawer_layout) as DrawerLayout
        drawer.closeDrawer(GravityCompat.START)
        return true
    }

    private fun changeFragment(fragment: Fragment) {
        fragmentTransaction = fragmentManager!!.beginTransaction()
        fragmentTransaction!!.replace(R.id.linear_content, fragment)
        fragmentTransaction!!.addToBackStack(null)
        fragmentTransaction!!.commit()

    }
}
