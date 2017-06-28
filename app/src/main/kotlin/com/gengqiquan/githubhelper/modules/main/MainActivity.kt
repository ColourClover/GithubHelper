package com.gengqiquan.githubhelper.modules

import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import bindView
import com.gengqiquan.githubhelper.R
import com.gengqiquan.githubhelper.base.BaseFragment
import com.gengqiquan.githubhelper.provides.FragmentFactory
import com.gengqiquan.githubhelper.base.MVPActivity
import com.gengqiquan.githubhelper.expansions.*
import com.gengqiquan.githubhelper.modules.user.UserInfoActivity
import io.reactivex.rxkotlin.toObservable
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.nav_header_main.*
import org.jetbrains.anko.find
import org.jetbrains.anko.sdk25.coroutines.onClick
import org.jetbrains.anko.startActivity


class MainActivity : MVPActivity(), NavigationView.OnNavigationItemSelectedListener {
    override fun initViews(savedInstanceState: Bundle?) {
        setTitle("GithubHelper")
        mTitleBar.setLeftIcon(R.drawable.ic_menu_white_24dp)
        mTitleBar.setLeftClickListener(View.OnClickListener {
            if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
                drawer_layout.closeDrawer(GravityCompat.START)
            } else {
                drawer_layout.openDrawer(GravityCompat.START)
            }
        })

        nav_view.setNavigationItemSelectedListener(this)
        val header = nav_view.getHeaderView(0)
        header.find<ImageView>(R.id.user_photo).load(user.avatarUrl)
        header.find<TextView>(R.id.user_name).text = user.name
        header.find<TextView>(R.id.user_desc).text = user.bio
        header.find<ImageView>(R.id.user_photo).onClick { startActivity<UserInfoActivity>("user" to user) }
        toast("hello " + user.login!!)
        changeFragment("Events", "userID" to user.login)
    }

    override fun initData() {
    }

    override fun getLayoutID(): Int = R.layout.activity_main

    override fun inject() {

    }


    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }


    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
//        ARouter.getInstance().build("/tab/" + item.title.toString())
//                .navigation()
        changeFragment(item.title.toString())
        return true
    }

    fun changeFragment(tag: String, vararg params: Pair<String, Any>) {
        setTitle(tag)
        val fragment: BaseFragment = FragmentFactory.createFragment(tag)
        fragment.arguments = Bundle().pair(params)
        supportFragmentManager.beginTransaction().replace(R.id.content, fragment).commitAllowingStateLoss()

        drawer_layout.closeDrawer(GravityCompat.START)
    }

}
