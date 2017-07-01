package com.gengqiquan.githubhelper.modules.user

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.text.Html
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.gengqiquan.adapter.adapter.RBAdapter
import com.gengqiquan.adapter.interfaces.Holder
import com.gengqiquan.githubhelper.App
import com.gengqiquan.githubhelper.R
import com.gengqiquan.githubhelper.base.MVPActivity
import com.gengqiquan.githubhelper.base.MVPFragment
import com.gengqiquan.githubhelper.data.Event
import com.gengqiquan.githubhelper.data.User
import com.gengqiquan.githubhelper.expansions.BindViewLifeAndSchedulers
import com.gengqiquan.githubhelper.expansions.applySchedulers
import com.gengqiquan.githubhelper.expansions.applySchedulersAndLife
import com.gengqiquan.githubhelper.expansions.load
import com.gengqiquan.githubhelper.provides.GithubService
import com.gengqiquan.githubhelper.utils.setLinkJump
import kotlinx.android.synthetic.main.fragment_events.*
import org.jetbrains.anko.sdk25.coroutines.onClick
import javax.inject.Inject

@Route(path = "/user/userlist")
class UserListActivity : MVPActivity() {

    @Autowired
    lateinit var url: String

    @Autowired
    lateinit var type: String

    var page = 1
    override fun getLayoutID() = R.layout.activity_user_list

    override fun inject() {
        ARouter.getInstance().inject(this)

    }

    override fun initViews(savedInstanceState: Bundle?) {
        setTitle(type)
        refresh_layout.adapter(RBAdapter<User>(mContext)
                .bindViewData(this::bindViewAndData)
                .layout(R.layout.item_user_list))
                .loadMore { load(false) }
                .refresh { load(true) }
                .doRefresh()
    }

    override fun initData() {

    }


    fun bindViewAndData(holder: Holder, item: User) {
        holder.setText(R.id.name, item.login)
        holder.getView<ImageView>(R.id.user_photo).load(item.avatarUrl)
        holder.itemView.onClick { ARouter.getInstance().build("/user/userInfo").withString("userLogin", item.login).navigation() }
    }

    fun load(refresh: Boolean) {
        if (refresh) page = 1
        retrofit.create(GithubService::class.java).getUserList(url, page)
                .applySchedulersAndLife(this)
                .subscribe({
                    if (refresh) {
                        refresh_layout.refreshComplete(it)
                    } else {
                        refresh_layout.loadMoreComplete(it)
                    }
                    page++
                }) { e ->
                    e.printStackTrace()
                    refresh_layout.loadFailure()
                }
    }


}

