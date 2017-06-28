package com.gengqiquan.githubhelper.modules.events

import com.gengqiquan.githubhelper.data.Event

/**
 * Created by gengqiquan on 2017/6/27.
 */
class EventPersenter {
    fun getDesc(event: Event): String {
        var desc = ""
        when (event.type) {
            "PushEvent" -> desc = event.actor.displayLogin.color() + " pushed to " +
                    event.payload.ref.replace("refs/heads/", "").color() + " at " +
                    event.repo.name.color()


            "WatchEvent" -> desc = event.actor.displayLogin.color().space() + event.payload.action?.space() +
                    event.repo.name.color()
            "CreateEvent" -> {
                when (event.payload.refType) {
                    "repository" -> desc = event.actor.displayLogin.color().space() + "created " +
                            event.payload.refType.space() + event.repo.name.color()
                    "branch" -> desc = event.actor.displayLogin.color().space() + "created " +
                            event.payload.refType.space() + event.payload.ref.color().space() + "in " + event.repo.name
                }
            }
            "IssuesEvent" -> desc = event.actor.displayLogin.color().space() + event.payload.action + " issue " +
                    "#${event.payload.issue.number}".color() + " in " + event.repo.name.color()
            "ForkEvent" -> desc = event.actor.displayLogin.color().space() + "forked " +
                    event.repo.name.color().space() + "to " + event.payload.forkee.fullName.color()
            "IssueCommentEvent" -> desc = event.actor.displayLogin.color().space() + "commented on issue " +
                    "#${event.payload.issue.number}".color() + " in " + event.repo.name.color()
            else -> desc = event.type!!
        }
        return desc
    }

    fun getTags(event: Event): String {
        var desc = ""
        when (event.type) {
            "PushEvent" -> {
                event.payload.commits.forEach { desc += it.sha.substring(0, 6).color().space() + "- " + it.message + "<br>" }
//                if (desc.startsWith("<br>")) {
//                    desc.replaceFirst("<br>", "")
//                }
            }
            "WatchEvent" -> desc = ""
            "CreateEvent" -> desc = ""
            "ForkEvent" -> desc = ""
            "IssuesEvent" -> desc = event.payload.issue.title + "<br>"
            "IssueCommentEvent" -> desc = event.payload.issue.body + "<br>"
        }
        return desc
    }

    fun String.color(): String = "<font color='#009eff'>" + this + "</font>"
    fun String.space(): String = this + " "
}