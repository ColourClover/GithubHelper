package com.gengqiquan.githubhelper.data

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
)