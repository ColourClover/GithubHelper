package com.gengqiquan.githubhelper.modules.events

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.text.Html
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.gengqiquan.adapter.adapter.RBAdapter
import com.gengqiquan.adapter.interfaces.Holder
import com.gengqiquan.githubhelper.R
import com.gengqiquan.githubhelper.base.MVPFragment
import com.gengqiquan.githubhelper.data.Event
import com.gengqiquan.githubhelper.expansions.applySchedulers
import com.gengqiquan.githubhelper.expansions.load
import com.gengqiquan.githubhelper.provides.GithubService
import kotlinx.android.synthetic.main.fragment_events.*


class EventsFragment : MVPFragment() {
    lateinit var persent: EventPersenter
    override fun getLayoutID() = R.layout.fragment_events
    var page = 1
    override fun initView(view: View, savedInstanceState: Bundle?) {
        userID = arguments.getString("userID")
        refresh_layout.adapter(RBAdapter<Event>(mContext)
                .bindViewData(this::bindViewAndData)
                .layout(R.layout.item_event_list))
                .loadMore { load(false) }
                .refresh { load(true) }
                .doRefresh()
    }


    lateinit var userID: String

    override fun inject() {
        persent = EventPersenter()
    }

    override fun initData() {
    }

    fun bindViewAndData(holder: Holder, item: Event) {
        holder.setText(R.id.created_time, item.createdAt)
        holder.getView<TextView>(R.id.desc).text = Html.fromHtml(persent.getDesc(item))
        holder.getView<TextView>(R.id.tags).text = Html.fromHtml(persent.getTags(item))
        holder.getView<ImageView>(R.id.user_photo).load(item.actor.avatarUrl)
    }

    fun load(refresh: Boolean) {
        if (refresh) page = 1
        retrofit.create(GithubService::class.java).getUserEvents(userID, "public", page)
                .applySchedulers()
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


    private var mListener: OnFragmentInteractionListener? = null


    fun onButtonPressed(uri: Uri) {
        mListener?.onFragmentInteraction(uri)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            mListener = context as OnFragmentInteractionListener?
        }
    }

    override fun onDetach() {
        super.onDetach()
        mListener = null
    }

    interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onFragmentInteraction(uri: Uri)
    }


}

