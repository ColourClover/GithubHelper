package com.gengqiquan.githubhelper

import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.view.MenuItem
import android.view.View
import com.alibaba.android.arouter.launcher.ARouter
import com.gengqiquan.githubhelper.base.MVPActivity
import com.gengqiquan.githubhelper.expansions.applySchedulers
import com.gengqiquan.githubhelper.provides.APIs
import com.gengqiquan.githubhelper.provides.GithubService
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : MVPActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun initViews(savedInstanceState: Bundle?) {
        mTitleBar.setTitle("GithubHelper")
        mTitleBar.setLeftIcon(R.drawable.ic_menu_white_24dp)
        mTitleBar.setLeftClickListener(View.OnClickListener {
            if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
                drawer_layout.closeDrawer(GravityCompat.START)
            } else {
                drawer_layout.openDrawer(GravityCompat.START)
            }
        })
        nav_view.setNavigationItemSelectedListener(this)
        val p = HashMap<String, String>()
        p.put("q", "gengqiquan/tangram")
        p.put("sort", "stars")
        p.put("order", "desc")
        //   showLoading()
        retrofit.create(GithubService::class.java).user(APIs.TEST_TOKEN)
                .applySchedulers()
                .subscribe({
                    text.text = it.toString()
                    toast(it.login!!)
                }) { e -> e.printStackTrace() }

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
        ARouter.getInstance().build("/tab/" + item.title.toString())
                .navigation()
        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }
}
