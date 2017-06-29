package com.gengqiquan.githubhelper.provides

import com.gengqiquan.githubhelper.base.BaseFragment
import com.gengqiquan.githubhelper.modules.events.EventsFragment
import com.gengqiquan.githubhelper.modules.reposistories.RepositoriesListFragment

import java.util.HashMap

object FragmentFactory {

    private val mFragmentCache = HashMap<String, BaseFragment>()

    fun createFragment(tag: String): BaseFragment {

        var fragment: BaseFragment? = mFragmentCache[tag]
        if (fragment != null) {
            return fragment
        }
        when (tag) {
            "Events" -> fragment = EventsFragment()
            "Repositories" -> fragment = RepositoriesListFragment()
            "Starred" -> fragment = RepositoriesListFragment()
            else -> fragment = EventsFragment()
        }
        mFragmentCache.put(tag, fragment)
        return fragment
    }
}  