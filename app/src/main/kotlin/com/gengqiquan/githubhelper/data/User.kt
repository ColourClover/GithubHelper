package com.gengqiquan.githubhelper.data

import android.os.Parcel
import android.os.Parcelable
import javax.annotation.Generated
import com.google.gson.annotations.SerializedName

@Generated("com.robohorse.robopojogenerator")
data class User(

        @field:SerializedName("gists_url")
        val gistsUrl: String? = null,

        @field:SerializedName("repos_url")
        val reposUrl: String,

        @field:SerializedName("two_factor_authentication")
        val twoFactorAuthentication: Boolean? = null,

        @field:SerializedName("following_url")
        val followingUrl: String? = null,

        @field:SerializedName("bio")
        val bio: String? = null,

        @field:SerializedName("created_at")
        val createdAt: String? = null,

        @field:SerializedName("login")
        val login: String? = null,

        @field:SerializedName("type")
        val type: String? = null,

        @field:SerializedName("blog")
        val blog: String? = null,

        @field:SerializedName("private_gists")
        val privateGists: Int? = null,

        @field:SerializedName("total_private_repos")
        val totalPrivateRepos: Int? = null,

        @field:SerializedName("subscriptions_url")
        val subscriptionsUrl: String? = null,

        @field:SerializedName("updated_at")
        val updatedAt: String? = null,

        @field:SerializedName("site_admin")
        val siteAdmin: Boolean? = null,

        @field:SerializedName("disk_usage")
        val diskUsage: Int? = null,

        @field:SerializedName("collaborators")
        val collaborators: Int? = null,

        @field:SerializedName("compString")
        val compString: String? = null,

        @field:SerializedName("owned_private_repos")
        val ownedPrivateRepos: Int? = null,

        @field:SerializedName("id")
        val id: Int? = null,

        @field:SerializedName("public_repos")
        val publicRepos: Int? = null,

        @field:SerializedName("gravatar_id")
        val gravatarId: String? = null,

        @field:SerializedName("plan")
        val plan: Plan? = null,

        @field:SerializedName("email")
        val email: String? = null,

        @field:SerializedName("organizations_url")
        val organizationsUrl: String? = null,

        @field:SerializedName("hireable")
        val hireable: String? = null,

        @field:SerializedName("starred_url")
        val starredUrl: String? = null,

        @field:SerializedName("followers_url")
        val followersUrl: String? = null,

        @field:SerializedName("public_gists")
        val publicGists: Int? = null,

        @field:SerializedName("url")
        val url: String? = null,

        @field:SerializedName("received_events_url")
        val receivedEventsUrl: String? = null,

        @field:SerializedName("followers")
        val followers: Int? = null,

        @field:SerializedName("avatar_url")
        val avatarUrl: String,

        @field:SerializedName("events_url")
        val eventsUrl: String? = null,

        @field:SerializedName("html_url")
        val htmlUrl: String? = null,

        @field:SerializedName("following")
        val following: Int? = null,

        @field:SerializedName("name")
        val name: String,

        @field:SerializedName("location")
        val location: String? = null
) : Parcelable {
        companion object {
                @JvmField val CREATOR: Parcelable.Creator<User> = object : Parcelable.Creator<User> {
                        override fun createFromParcel(source: Parcel): User = User(source)
                        override fun newArray(size: Int): Array<User?> = arrayOfNulls(size)
                }
        }

        constructor(source: Parcel) : this(
        source.readString(),
        source.readString(),
        source.readValue(Boolean::class.java.classLoader) as Boolean?,
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
        source.readValue(Boolean::class.java.classLoader) as Boolean?,
        source.readValue(Int::class.java.classLoader) as Int?,
        source.readValue(Int::class.java.classLoader) as Int?,
        source.readString(),
        source.readValue(Int::class.java.classLoader) as Int?,
        source.readValue(Int::class.java.classLoader) as Int?,
        source.readValue(Int::class.java.classLoader) as Int?,
        source.readString(),
        source.readParcelable<Plan>(Plan::class.java.classLoader),
        source.readString(),
        source.readString(),
        source.readString(),
        source.readString(),
        source.readString(),
        source.readValue(Int::class.java.classLoader) as Int?,
        source.readString(),
        source.readString(),
        source.readValue(Int::class.java.classLoader) as Int?,
        source.readString(),
        source.readString(),
        source.readString(),
        source.readValue(Int::class.java.classLoader) as Int?,
        source.readString(),
        source.readString()
        )

        override fun describeContents() = 0

        override fun writeToParcel(dest: Parcel, flags: Int) {
                dest.writeString(gistsUrl)
                dest.writeString(reposUrl)
                dest.writeValue(twoFactorAuthentication)
                dest.writeString(followingUrl)
                dest.writeString(bio)
                dest.writeString(createdAt)
                dest.writeString(login)
                dest.writeString(type)
                dest.writeString(blog)
                dest.writeValue(privateGists)
                dest.writeValue(totalPrivateRepos)
                dest.writeString(subscriptionsUrl)
                dest.writeString(updatedAt)
                dest.writeValue(siteAdmin)
                dest.writeValue(diskUsage)
                dest.writeValue(collaborators)
                dest.writeString(compString)
                dest.writeValue(ownedPrivateRepos)
                dest.writeValue(id)
                dest.writeValue(publicRepos)
                dest.writeString(gravatarId)
                dest.writeParcelable(plan, 0)
                dest.writeString(email)
                dest.writeString(organizationsUrl)
                dest.writeString(hireable)
                dest.writeString(starredUrl)
                dest.writeString(followersUrl)
                dest.writeValue(publicGists)
                dest.writeString(url)
                dest.writeString(receivedEventsUrl)
                dest.writeValue(followers)
                dest.writeString(avatarUrl)
                dest.writeString(eventsUrl)
                dest.writeString(htmlUrl)
                dest.writeValue(following)
                dest.writeString(name)
                dest.writeString(location)
        }
}