package com.gengqiquan.githubhelper.modules.reposistories

import android.os.Bundle
import android.view.View
import com.gengqiquan.adapter.adapter.RBAdapter
import com.gengqiquan.adapter.interfaces.Holder
import com.gengqiquan.githubhelper.R
import com.gengqiquan.githubhelper.base.MVPFragment
import com.gengqiquan.githubhelper.data.Repositorie
import com.gengqiquan.githubhelper.expansions.applySchedulers
import com.gengqiquan.githubhelper.provides.GithubService
import kotlinx.android.synthetic.main.activity_user_repositories.*


class UserRepositoriesFragment : MVPFragment() {

    var page = 1
    lateinit var userID: String

    override fun getLayoutID() = R.layout.activity_user_repositories

    override fun inject() {

    }

    override fun initView(view: View, savedInstanceState: Bundle?) {
        userID = arguments.getString("userID")

        refresh_layout.adapter(RBAdapter<Repositorie>(mContext)
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

    fun load(refresh: Boolean) {
        if (refresh) page = 1
        retrofit.create(GithubService::class.java).getUserRepositories(userID, page)
                .applySchedulers()
                .subscribe({
                    if (refresh) {
                        refresh_layout.refreshComplete(it)
                    } else {
                        refresh_layout.loadMoreComplete(it)
                    }
                    page++

                }) { e -> e.printStackTrace()
                    refresh_layout.loadFailure()
                }
    }


}
