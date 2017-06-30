package com.gengqiquan.githubhelper.modules.reposistories

import com.gengqiquan.githubhelper.base.IBaseView
import com.gengqiquan.githubhelper.data.MenuItem
import com.gengqiquan.githubhelper.data.Repo

/**
 * Created by gengqiquan on 2017/6/30.
 */
interface IRepositoriesView :IBaseView{
    fun setRepoBaseInfo(repo: Repo)
    fun setMenuItems(repo: List<MenuItem>)
}