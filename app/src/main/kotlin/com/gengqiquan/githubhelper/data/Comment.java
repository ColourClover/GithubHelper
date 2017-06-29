package com.gengqiquan.githubhelper.data;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class Comment{

	@SerializedName("issue_url")
	private String issueUrl;

	@SerializedName("updated_at")
	private String updatedAt;

	@SerializedName("html_url")
	private String htmlUrl;

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("id")
	private int id;

	@SerializedName("body")
	private String body;

	@SerializedName("user")
	private User user;

	@SerializedName("url")
	private String url;

	public void setIssueUrl(String issueUrl){
		this.issueUrl = issueUrl;
	}

	public String getIssueUrl(){
		return issueUrl;
	}

	public void setUpdatedAt(String updatedAt){
		this.updatedAt = updatedAt;
	}

	public String getUpdatedAt(){
		return updatedAt;
	}

	public void setHtmlUrl(String htmlUrl){
		this.htmlUrl = htmlUrl;
	}

	public String getHtmlUrl(){
		return htmlUrl;
	}

	public void setCreatedAt(String createdAt){
		this.createdAt = createdAt;
	}

	public String getCreatedAt(){
		return createdAt;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setBody(String body){
		this.body = body;
	}

	public String getBody(){
		return body;
	}

	public void setUser(User user){
		this.user = user;
	}

	public User getUser(){
		return user;
	}

	public void setUrl(String url){
		this.url = url;
	}

	public String getUrl(){
		return url;
	}

	@Override
 	public String toString(){
		return 
			"Comment{" + 
			"issue_url = '" + issueUrl + '\'' + 
			",updated_at = '" + updatedAt + '\'' + 
			",html_url = '" + htmlUrl + '\'' + 
			",created_at = '" + createdAt + '\'' + 
			",id = '" + id + '\'' + 
			",body = '" + body + '\'' + 
			",user = '" + user + '\'' + 
			",url = '" + url + '\'' + 
			"}";
		}
}