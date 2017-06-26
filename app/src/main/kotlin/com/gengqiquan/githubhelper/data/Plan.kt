package com.gengqiquan.githubhelper.data

import android.os.Parcel
import android.os.Parcelable
import javax.annotation.Generated
import com.google.gson.annotations.SerializedName

@Generated("com.robohorse.robopojogenerator")
data class Plan(

	@field:SerializedName("private_repos")
	val privateRepos: Int? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("collaborators")
	val collaborators: Int? = null,

	@field:SerializedName("space")
	val space: Int? = null
) : Parcelable {
	companion object {
		@JvmField val CREATOR: Parcelable.Creator<Plan> = object : Parcelable.Creator<Plan> {
			override fun createFromParcel(source: Parcel): Plan = Plan(source)
			override fun newArray(size: Int): Array<Plan?> = arrayOfNulls(size)
		}
	}

	constructor(source: Parcel) : this(
	source.readValue(Int::class.java.classLoader) as Int?,
	source.readString(),
	source.readValue(Int::class.java.classLoader) as Int?,
	source.readValue(Int::class.java.classLoader) as Int?
	)

	override fun describeContents() = 0

	override fun writeToParcel(dest: Parcel, flags: Int) {
		dest.writeValue(privateRepos)
		dest.writeString(name)
		dest.writeValue(collaborators)
		dest.writeValue(space)
	}
}