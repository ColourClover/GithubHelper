package com.gengqiquan.githubhelper.modules.user


import android.os.Bundle
import android.support.v4.app.Fragment
import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.gengqiquan.githubhelper.App
import com.gengqiquan.githubhelper.R
import com.gengqiquan.githubhelper.base.MVPActivity
import com.gengqiquan.githubhelper.data.User
import com.gengqiquan.githubhelper.expansions.applySchedulers
import com.gengqiquan.githubhelper.expansions.load
import com.gengqiquan.githubhelper.expansions.putSharedString
import com.gengqiquan.githubhelper.expansions.toJson
import com.gengqiquan.githubhelper.provides.APIs
import com.gengqiquan.githubhelper.provides.GithubService
import kotlinx.android.synthetic.main.activity_user_info.*
import javax.inject.Inject


@Route(path = "/user/userInfo")
class UserInfoActivity : MVPActivity(), IUserView {
    @Inject
    lateinit var persenter: UserPersenter
    @Autowired(name = "userLogin")
    lateinit var userLogin: String

    override fun inject() {
        DaggerUserPersenter_UserComponent.builder()
                .appComponent(App.component)
                .userPersenterModule(UserPersenter.UserPersenterModule(this))
                .activityModule(activityModule)
                .build().inject(this)
        ARouter.getInstance().inject(this)
    }

    override fun initViews(savedInstanceState: Bundle?) {
        followers.setOnClickListener { }
        following.setOnClickListener { }
        events.setOnClickListener { }
        org.setOnClickListener { }
        repo.setOnClickListener { }
        gists.setOnClickListener { }
    }

    override fun getLayoutID() = R.layout.activity_user_info

    override fun initData() {
        persenter.getUser(userLogin)

    }

    override fun setUserInfo(user: User) {
        user_photo.load(user.avatarUrl)
        login.text = user.login
        display_name.text = user.name
        followers_number.text = user.followers.toString()
        following_number.text = user.following.toString()

    }
}
