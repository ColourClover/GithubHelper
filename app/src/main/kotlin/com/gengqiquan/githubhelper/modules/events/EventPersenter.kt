package com.gengqiquan.githubhelper.modules.events

import com.gengqiquan.githubhelper.data.Event

/**
 * Created by gengqiquan on 2017/6/27.
 */
class EventPersenter {
    val groupUser = "/user/userInfo?userLogin="
    val groupRepos = "/repos/"
    val groupRepoBranch = "/repos/branch/"
    fun getDesc(event: Event): String {
        var desc = ""
        when (event.type) {
            "PushEvent" -> desc = event.actor.displayLogin.href(groupUser) + " pushed to " +
                    event.payload.ref.replace("refs/heads/", "").href(groupRepoBranch) + " at " +
                    event.repo.name.href(groupRepos)


            "WatchEvent" -> desc = event.actor.displayLogin.href(groupUser).space() + event.payload.action?.space() +
                    event.repo.name.href(groupRepos)
            "CreateEvent" -> {
                when (event.payload.refType) {
                    "repository" -> desc = event.actor.displayLogin.href(groupUser).space() + "created " +
                            event.payload.refType.space() + event.repo.name.href(groupRepos)
                    "branch" -> desc = event.actor.displayLogin.href(groupUser).space() + "created " +
                            event.payload.refType.space() + event.payload.ref.href(groupRepoBranch).space() + "in " + event.repo.name.href(groupRepos)
                }
            }
            "IssuesEvent" -> desc = event.actor.displayLogin.href(groupUser).space() + event.payload.action + " issue " +
                    "#${event.payload.issue.number}".href(groupUser) + " in " + event.repo.name.href(groupRepos)
            "ForkEvent" -> desc = event.actor.displayLogin.href(groupUser).space() + "forked " +
                    event.repo.name.href(groupRepos).space() + "to " + event.payload.forkee.fullName.href(groupRepos)
            "IssueCommentEvent" -> desc = event.actor.displayLogin.href(groupUser).space() + "commented on issue " +
                    "#${event.payload.issue.number}".href(groupUser) + " in " + event.repo.name.href(groupRepos)
            else -> desc = event.type!!
        }
        return desc
    }

    fun getTags(event: Event): String {
        var desc = ""
        when (event.type) {
            "PushEvent" -> {
                event.payload.commits.forEach { desc += it.sha.substring(0, 6).href(groupUser).space() + "- " + it.message + "<br>" }
            }
            "WatchEvent" -> desc = ""
            "CreateEvent" -> desc = ""
            "ForkEvent" -> desc = ""
            "IssuesEvent" -> desc = event.payload.issue.title + "<br>"
            "IssueCommentEvent" -> desc = event.payload.issue.body + "<br>"
        }
        return desc
    }

    fun String.href(router: String): String = "<a href=\"" + router + this + "\">" + this + "</a>"
    fun String.space(): String = this + " "
}