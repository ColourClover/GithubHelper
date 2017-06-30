package com.gengqiquan.githubhelper.modules.events

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
import com.gengqiquan.githubhelper.expansions.applySchedulers
import com.gengqiquan.githubhelper.expansions.load
import com.gengqiquan.githubhelper.provides.GithubService
import com.gengqiquan.githubhelper.utils.setLinkJump
import kotlinx.android.synthetic.main.fragment_events.*
import javax.inject.Inject

@Route(path = "/repos/repo/events")
class EventListActivity : MVPActivity() {

    @Autowired(name = "url")
    lateinit var url: String
    @Inject
    lateinit var persent: EventPersenter
    var page = 1
    override fun getLayoutID() = R.layout.fragment_events

    override fun inject() {
        ARouter.getInstance().inject(this)
        DaggerEventPersenter_EventListComponent.builder()
                .appComponent(App.component)
                .activityModule(activityModule)
                .build()
                .inject(this)

    }

    override fun initViews(savedInstanceState: Bundle?) {
        setTitle("Events")
        refresh_layout.adapter(RBAdapter<Event>(mContext)
                .bindViewData(this::bindViewAndData)
                .layout(R.layout.item_event_list))
                .loadMore { load(false) }
                .refresh { load(true) }
                .doRefresh()
    }

    override fun initData() {

    }


    fun bindViewAndData(holder: Holder, item: Event) {
        holder.setText(R.id.created_time, item.createdAt)
        val desc = holder.getView<TextView>(R.id.desc)
        setLinkJump(desc, persent.getDesc(item), resources.getColor(R.color.blue009eff))
        holder.getView<TextView>(R.id.tags).text = Html.fromHtml(persent.getTags(item))
        holder.getView<ImageView>(R.id.user_photo).load(item.actor.avatarUrl)
    }

    fun load(refresh: Boolean) {
        if (refresh) page = 1
        persent.getRepoEvents(url, page)
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

