package com.gengqiquan.githubhelper.modules.reposistories

import android.os.Bundle
import com.gengqiquan.githubhelper.R
import com.gengqiquan.githubhelper.data.MenuItem
import com.gengqiquan.githubhelper.data.Repo
import com.gengqiquan.githubhelper.expansions.BindViewLifeAndSchedulers
import com.gengqiquan.githubhelper.expansions.pair
import com.gengqiquan.githubhelper.expansions.pairs
import com.gengqiquan.githubhelper.provides.GithubService
import retrofit2.Retrofit

/**
 * Created by gengqiquan on 2017/6/23.
 */
class RepositoriesPersenter {
    val mView: IRepositoriesView
    val retrofit: Retrofit

    constructor(mView: IRepositoriesView, retrofit: Retrofit) {
        this.mView = mView
        this.retrofit = retrofit

    }

    fun getRepo(repoPath: String) {
        retrofit.create(GithubService::class.java).getRepositories(repoPath)
                .BindViewLifeAndSchedulers(mView)
                .subscribe({
                    mView.setRepoBaseInfo(it)
                    getMenuList(it)
                }) {}
    }

    //"repos/${repo.fullName}/readme"
    private fun getMenuList(repo: Repo) {
        val menus = arrayListOf<MenuItem>()
        menus.add(MenuItem(R.drawable.ic_menu_send, repo.language, null, null, null))
        menus.add(MenuItem(R.drawable.ic_menu_send, repo.createdAt, null, null, null))
        menus.add(MenuItem(R.drawable.ic_menu_send, "Branches", null, "/repos/repo/branches", Bundle().pairs("url" to "repos/${repo.fullName}/branches")))
        menus.add(MenuItem(R.drawable.ic_menu_send, "Issues", repo.openIssuesCount, "/repos/repo/issues", Bundle().pairs("url" to "repos/${repo.fullName}/issues")))
        menus.add(MenuItem(R.drawable.ic_menu_send, "Events", null, "/repos/repo/events", Bundle().pairs("url" to "repos/${repo.fullName}/events")))
        menus.add(MenuItem(R.drawable.ic_menu_send, "Commits", null, "/repos/repo/commits", Bundle().pairs("url" to "repos/${repo.fullName}/commits")))
        menus.add(MenuItem(R.drawable.ic_menu_send, "Pull Requests", null, "/repos/repo/pulls", Bundle().pairs("url" to "repos/${repo.fullName}/pulls")))
        menus.add(MenuItem(R.drawable.ic_menu_send, "Source", null, "/repos/repo/contents", Bundle().pairs("url" to "repos/${repo.fullName}/contents")))
        mView.setMenuItems(menus)
    }
}