package com.gengqiquan.githubhelper.modules.user


import android.os.Bundle
import android.support.v4.app.Fragment
import com.gengqiquan.githubhelper.R
import com.gengqiquan.githubhelper.base.MVPActivity
import com.gengqiquan.githubhelper.expansions.load
import kotlinx.android.synthetic.main.activity_user_info.*


/**
 * A simple [Fragment] subclass.
 * Use the [UserInfoActivity.newInstance] factory method to
 * create an instance of this fragment.
 */
class UserInfoActivity : MVPActivity() {
    override fun initViews(savedInstanceState: Bundle?) {
    }

    override fun inject() {
    }

    override fun getLayoutID() = R.layout.activity_user_info

    override fun initData() {
        user_photo.load(user.avatarUrl)
        login.text = user.login
        display_name.text = user.name
        followers_number.text = user.followers.toString()
        following_number.text = user.following.toString()
        followers.setOnClickListener { }
        following.setOnClickListener { }
        events.setOnClickListener { }
        org.setOnClickListener { }
        repo.setOnClickListener { }
        gists.setOnClickListener { }
    }

}
