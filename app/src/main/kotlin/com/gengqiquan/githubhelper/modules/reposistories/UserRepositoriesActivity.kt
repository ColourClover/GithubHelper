package com.gengqiquan.githubhelper.modules.reposistories

import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.view.MenuItem
import android.view.View
import com.alibaba.android.arouter.launcher.ARouter
import com.che300.kotlin.extand.load
import com.gengqiquan.adapter.adapter.RBAdapter
import com.gengqiquan.adapter.interfaces.Holder
import com.gengqiquan.githubhelper.R
import com.gengqiquan.githubhelper.base.MVPActivity
import com.gengqiquan.githubhelper.data.Repositorie
import com.gengqiquan.githubhelper.expansions.applySchedulers
import com.gengqiquan.githubhelper.provides.APIs
import com.gengqiquan.githubhelper.provides.GithubService
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.nav_header_main.*


class UserRepositoriesActivity : MVPActivity() {
    lateinit var reposUrl: String

    override fun getLayoutID(): Int = R.layout.activity_user_repositories

    override fun inject() {

    }

    override fun initViews(savedInstanceState: Bundle?) {
        reposUrl = intent.getStringExtra("reposUrl")
       val userName = intent.getStringExtra("userName")
        mTitleBar.setTitle(userName)

        refresh.adapter(RBAdapter<Repositorie>(mContext)
                .bindViewData(this::bindViewAndData)
                .layout(R.layout.item_user_repositorie_list))
                .loadMore { load(false) }
                .refresh { load(true) }
                .doRefresh()

    }

    override fun initData() {
    }

    fun bindViewAndData(holder: Holder, item: Repositorie) {
        holder.setText(R.id.name, item.name)
        holder.setText(R.id.desc, item.description)
        holder.setText(R.id.language, item.language)
        if (item.stargazersCount > 0) {
            holder.getView<View>(R.id.star).visibility = View.VISIBLE
        } else {
            holder.getView<View>(R.id.star).visibility = View.GONE
        }
        if (item.forksCount > 0) {
            holder.getView<View>(R.id.fork).visibility = View.VISIBLE
        } else {
            holder.getView<View>(R.id.fork).visibility = View.GONE
        }
        holder.setText(R.id.star, item.stargazersCount.toString())
        holder.setText(R.id.fork, item.forksCount.toString())
    }

    fun load(boolean: Boolean) {
        retrofit.create(GithubService::class.java).getUserRepositories(reposUrl)
                .applySchedulers()
                .subscribe({
                    refresh.refreshComplete(it)

                }) { e -> e.printStackTrace() }
    }


}
