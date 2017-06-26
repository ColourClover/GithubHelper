package com.gengqiquan.githubhelper.data

import android.os.Parcel
import android.os.Parcelable
import javax.annotation.Generated
import com.google.gson.annotations.SerializedName

@Generated("com.robohorse.robopojogenerator")
data class Repositorie(

        @field:SerializedName("stargazers_count")
        val stargazersCount: Int,

        @field:SerializedName("pushed_at")
        val pushedAt: String? = null,

        @field:SerializedName("subscription_url")
        val subscriptionUrl: String? = null,

        @field:SerializedName("language")
        val language: String? = null,

        @field:SerializedName("branches_url")
        val branchesUrl: String? = null,

        @field:SerializedName("issue_comment_url")
        val issueCommentUrl: String? = null,

        @field:SerializedName("labels_url")
        val labelsUrl: String? = null,

        @field:SerializedName("subscribers_url")
        val subscribersUrl: String? = null,

        @field:SerializedName("releases_url")
        val releasesUrl: String? = null,

        @field:SerializedName("svn_url")
        val svnUrl: String? = null,

        @field:SerializedName("id")
        val id: Int? = null,

        @field:SerializedName("forks")
        val forks: Int? = null,

        @field:SerializedName("archive_url")
        val archiveUrl: String? = null,

        @field:SerializedName("git_refs_url")
        val gitRefsUrl: String? = null,

        @field:SerializedName("forks_url")
        val forksUrl: String? = null,

        @field:SerializedName("statuses_url")
        val statusesUrl: String? = null,

        @field:SerializedName("ssh_url")
        val sshUrl: String? = null,

        @field:SerializedName("full_name")
        val fullName: String? = null,

        @field:SerializedName("size")
        val size: Int? = null,

        @field:SerializedName("languages_url")
        val languagesUrl: String? = null,

        @field:SerializedName("html_url")
        val htmlUrl: String? = null,

        @field:SerializedName("collaborators_url")
        val collaboratorsUrl: String? = null,

        @field:SerializedName("clone_url")
        val cloneUrl: String? = null,

        @field:SerializedName("name")
        val name: String? = null,

        @field:SerializedName("pulls_url")
        val pullsUrl: String? = null,

        @field:SerializedName("default_branch")
        val defaultBranch: String? = null,

        @field:SerializedName("hooks_url")
        val hooksUrl: String? = null,

        @field:SerializedName("trees_url")
        val treesUrl: String? = null,

        @field:SerializedName("tags_url")
        val tagsUrl: String? = null,

        @field:SerializedName("private")
        val jsonMemberPrivate: Boolean? = null,

        @field:SerializedName("contributors_url")
        val contributorsUrl: String? = null,

        @field:SerializedName("has_downloads")
        val hasDownloads: Boolean? = null,

        @field:SerializedName("notifications_url")
        val notificationsUrl: String? = null,

        @field:SerializedName("open_issues_count")
        val openIssuesCount: Int? = null,

        @field:SerializedName("description")
        val description: String? = null,

        @field:SerializedName("created_at")
        val createdAt: String? = null,

        @field:SerializedName("watchers")
        val watchers: Int? = null,

        @field:SerializedName("keys_url")
        val keysUrl: String? = null,

        @field:SerializedName("deployments_url")
        val deploymentsUrl: String? = null,

        @field:SerializedName("has_projects")
        val hasProjects: Boolean? = null,

        @field:SerializedName("has_wiki")
        val hasWiki: Boolean? = null,

        @field:SerializedName("updated_at")
        val updatedAt: String? = null,

        @field:SerializedName("comments_url")
        val commentsUrl: String? = null,

        @field:SerializedName("stargazers_url")
        val stargazersUrl: String? = null,

        @field:SerializedName("git_url")
        val gitUrl: String? = null,

        @field:SerializedName("has_pages")
        val hasPages: Boolean? = null,

        @field:SerializedName("owner")
        val owner: Owner? = null,

        @field:SerializedName("commits_url")
        val commitsUrl: String? = null,

        @field:SerializedName("compare_url")
        val compareUrl: String? = null,

        @field:SerializedName("git_commits_url")
        val gitCommitsUrl: String? = null,

        @field:SerializedName("blobs_url")
        val blobsUrl: String? = null,

        @field:SerializedName("git_tags_url")
        val gitTagsUrl: String? = null,

        @field:SerializedName("merges_url")
        val mergesUrl: String? = null,

        @field:SerializedName("downloads_url")
        val downloadsUrl: String? = null,

        @field:SerializedName("has_issues")
        val hasIssues: Boolean? = null,

        @field:SerializedName("url")
        val url: String? = null,

        @field:SerializedName("contents_url")
        val contentsUrl: String? = null,

        @field:SerializedName("mirror_url")
        val mirrorUrl: String? = null,

        @field:SerializedName("milestones_url")
        val milestonesUrl: String? = null,

        @field:SerializedName("teams_url")
        val teamsUrl: String? = null,

        @field:SerializedName("fork")
        val fork: Boolean? = null,

        @field:SerializedName("issues_url")
        val issuesUrl: String? = null,

        @field:SerializedName("events_url")
        val eventsUrl: String? = null,

        @field:SerializedName("issue_events_url")
        val issueEventsUrl: String? = null,

        @field:SerializedName("assignees_url")
        val assigneesUrl: String? = null,

        @field:SerializedName("open_issues")
        val openIssues: Int? = null,

        @field:SerializedName("watchers_count")
        val watchersCount: Int? = null,

        @field:SerializedName("homepage")
        val homepage: String? = null,

        @field:SerializedName("forks_count")
        val forksCount: Int
) : Parcelable {
        companion object {
                @JvmField val CREATOR: Parcelable.Creator<Repositorie> = object : Parcelable.Creator<Repositorie> {
                        override fun createFromParcel(source: Parcel): Repositorie = Repositorie(source)
                        override fun newArray(size: Int): Array<Repositorie?> = arrayOfNulls(size)
                }
        }

        constructor(source: Parcel) : this(
        source.readInt(),
        source.readString(),
        source.readString(),
        source.readString(),
        source.readString(),
        source.readString(),
        source.readString(),
        source.readString(),
        source.readString(),
        source.readString(),
        source.readValue(Int::class.java.classLoader) as Int?,
        source.readValue(Int::class.java.classLoader) as Int?,
        source.readString(),
        source.readString(),
        source.readString(),
        source.readString(),
        source.readString(),
        source.readString(),
        source.readValue(Int::class.java.classLoader) as Int?,
        source.readString(),
        source.readString(),
        source.readString(),
        source.readString(),
        source.readString(),
        source.readString(),
        source.readString(),
        source.readString(),
        source.readString(),
        source.readString(),
        source.readValue(Boolean::class.java.classLoader) as Boolean?,
        source.readString(),
        source.readValue(Boolean::class.java.classLoader) as Boolean?,
        source.readString(),
        source.readValue(Int::class.java.classLoader) as Int?,
        source.readString(),
        source.readString(),
        source.readValue(Int::class.java.classLoader) as Int?,
        source.readString(),
        source.readString(),
        source.readValue(Boolean::class.java.classLoader) as Boolean?,
        source.readValue(Boolean::class.java.classLoader) as Boolean?,
        source.readString(),
        source.readString(),
        source.readString(),
        source.readString(),
        source.readValue(Boolean::class.java.classLoader) as Boolean?,
        source.readParcelable<Owner>(Owner::class.java.classLoader),
        source.readString(),
        source.readString(),
        source.readString(),
        source.readString(),
        source.readString(),
        source.readString(),
        source.readString(),
        source.readValue(Boolean::class.java.classLoader) as Boolean?,
        source.readString(),
        source.readString(),
        source.readString(),
        source.readString(),
        source.readString(),
        source.readValue(Boolean::class.java.classLoader) as Boolean?,
        source.readString(),
        source.readString(),
        source.readString(),
        source.readString(),
        source.readValue(Int::class.java.classLoader) as Int?,
        source.readValue(Int::class.java.classLoader) as Int?,
        source.readString(),
        source.readInt()
        )

        override fun describeContents() = 0

        override fun writeToParcel(dest: Parcel, flags: Int) {
                dest.writeInt(stargazersCount)
                dest.writeString(pushedAt)
                dest.writeString(subscriptionUrl)
                dest.writeString(language)
                dest.writeString(branchesUrl)
                dest.writeString(issueCommentUrl)
                dest.writeString(labelsUrl)
                dest.writeString(subscribersUrl)
                dest.writeString(releasesUrl)
                dest.writeString(svnUrl)
                dest.writeValue(id)
                dest.writeValue(forks)
                dest.writeString(archiveUrl)
                dest.writeString(gitRefsUrl)
                dest.writeString(forksUrl)
                dest.writeString(statusesUrl)
                dest.writeString(sshUrl)
                dest.writeString(fullName)
                dest.writeValue(size)
                dest.writeString(languagesUrl)
                dest.writeString(htmlUrl)
                dest.writeString(collaboratorsUrl)
                dest.writeString(cloneUrl)
                dest.writeString(name)
                dest.writeString(pullsUrl)
                dest.writeString(defaultBranch)
                dest.writeString(hooksUrl)
                dest.writeString(treesUrl)
                dest.writeString(tagsUrl)
                dest.writeValue(jsonMemberPrivate)
                dest.writeString(contributorsUrl)
                dest.writeValue(hasDownloads)
                dest.writeString(notificationsUrl)
                dest.writeValue(openIssuesCount)
                dest.writeString(description)
                dest.writeString(createdAt)
                dest.writeValue(watchers)
                dest.writeString(keysUrl)
                dest.writeString(deploymentsUrl)
                dest.writeValue(hasProjects)
                dest.writeValue(hasWiki)
                dest.writeString(updatedAt)
                dest.writeString(commentsUrl)
                dest.writeString(stargazersUrl)
                dest.writeString(gitUrl)
                dest.writeValue(hasPages)
                dest.writeParcelable(owner, 0)
                dest.writeString(commitsUrl)
                dest.writeString(compareUrl)
                dest.writeString(gitCommitsUrl)
                dest.writeString(blobsUrl)
                dest.writeString(gitTagsUrl)
                dest.writeString(mergesUrl)
                dest.writeString(downloadsUrl)
                dest.writeValue(hasIssues)
                dest.writeString(url)
                dest.writeString(contentsUrl)
                dest.writeString(mirrorUrl)
                dest.writeString(milestonesUrl)
                dest.writeString(teamsUrl)
                dest.writeValue(fork)
                dest.writeString(issuesUrl)
                dest.writeString(eventsUrl)
                dest.writeString(issueEventsUrl)
                dest.writeString(assigneesUrl)
                dest.writeValue(openIssues)
                dest.writeValue(watchersCount)
                dest.writeString(homepage)
                dest.writeInt(forksCount)
        }
}