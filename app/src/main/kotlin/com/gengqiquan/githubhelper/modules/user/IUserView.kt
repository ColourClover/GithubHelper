package com.gengqiquan.githubhelper.modules.user

import com.gengqiquan.githubhelper.base.IBaseView
import com.gengqiquan.githubhelper.data.User

/**
 * Created by gengqiquan on 2017/6/29.
 */
interface IUserView : IBaseView {
    fun setUserInfo(user: User)
}