package com.gengqiquan.githubhelper.modules.reposistories

import android.graphics.Rect
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.gengqiquan.adapter.adapter.RBAdapter
import com.gengqiquan.adapter.interfaces.Holder
import com.gengqiquan.githubhelper.R
import com.gengqiquan.githubhelper.base.MVPActivity
import com.gengqiquan.githubhelper.data.MenuItem
import com.gengqiquan.githubhelper.data.Repo
import com.gengqiquan.githubhelper.expansions.load
import com.gengqiquan.githubhelper.expansions.notNull
import com.yqritc.recyclerviewflexibledivider.HorizontalDividerItemDecoration
import com.yqritc.recyclerviewflexibledivider.VerticalDividerItemDecoration
import kotlinx.android.synthetic.main.activity_repositories.*
import org.jetbrains.anko.dip
import org.jetbrains.anko.sdk25.coroutines.onClick

/**
 * Created by gengqiquan on 2017/6/29.
 */
@Route(path = "/repos/repo")
class RepositoriesActivity : MVPActivity(), IRepositoriesView {


    @Autowired
    lateinit var repoPath: String
    lateinit var persenter: RepositoriesPersenter
    lateinit var adapter: RBAdapter<MenuItem>
    override fun inject() {
        ARouter.getInstance().inject(this)
        persenter = RepositoriesPersenter(this, retrofit)
    }


    override fun getLayoutID() = R.layout.activity_repositories

    override fun initViews(savedInstanceState: Bundle?) {
        recyclerView.layoutManager = GridLayoutManager(mContext, 2)
        recyclerView.addItemDecoration(HorizontalDividerItemDecoration.Builder(this)
                .colorResId(R.color.line)
                .size(dip(1))
                .build())
        recyclerView.addItemDecoration(VerticalDividerItemDecoration.Builder(this)
                .colorResId(R.color.line)
                .size(dip(1))
                .build())

        adapter = RBAdapter<MenuItem>(mContext)
                .layout(R.layout.item_repo_menu_list)
                .bindViewData(this::bindView)
        recyclerView.adapter = adapter
    }

    fun bindView(holder: Holder, item: MenuItem) {
        holder.setText(R.id.title, item.title)
        holder.getView<TextView>(R.id.title).setCompoundDrawablesWithIntrinsicBounds(item.resID, 0, 0, 0)
        if (item.number.notNull()) {
            holder.setText(R.id.number, item.number.toString())
        }
        if (item.router.notNull()) {
            holder.itemView.onClick {
                ARouter.getInstance().build(item.router).with(item.bundle).navigation()
            }
        }

    }

    override fun initData() {
        persenter.getRepo(repoPath)

    }

    override fun setRepoBaseInfo(repo: Repo) {
        userPhoto.load(repo.owner.avatarUrl)
        repoName.text = repo.name
        repoDesc.text = repo.description
        star_number.text = repo.stargazersCount.toString()
        watcher_number.text = repo.watchersCount.toString()
        fork_number.text = repo.forksCount.toString()
        star.onClick { ARouter.getInstance().build("/user/userlist").withString("type", "Stars").withString("url", "repos/${repo.fullName}/stargazers").navigation() }
        watcher.onClick { ARouter.getInstance().build("/user/userlist").withString("type", "Watchers").withString("url", "repos/${repo.fullName}/subscribers").navigation() }
        fork.onClick { ARouter.getInstance().build("/repos/fork").withString("type", "Stars").withString("url", "repos/${repo.fullName}/forks").navigation() }

    }

    override fun setMenuItems(menus: List<MenuItem>) {
        adapter.appendList(menus)
    }
}