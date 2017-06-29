package com.gengqiquan.githubhelper.data;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class Actor{

	@SerializedName("display_login")
	private String displayLogin;

	@SerializedName("avatar_url")
	private String avatarUrl;

	@SerializedName("id")
	private int id;

	@SerializedName("login")
	private String login;

	@SerializedName("gravatar_id")
	private String gravatarId;

	@SerializedName("url")
	private String url;

	public void setDisplayLogin(String displayLogin){
		this.displayLogin = displayLogin;
	}

	public String getDisplayLogin(){
		return displayLogin;
	}

	public void setAvatarUrl(String avatarUrl){
		this.avatarUrl = avatarUrl;
	}

	public String getAvatarUrl(){
		return avatarUrl;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setLogin(String login){
		this.login = login;
	}

	public String getLogin(){
		return login;
	}

	public void setGravatarId(String gravatarId){
		this.gravatarId = gravatarId;
	}

	public String getGravatarId(){
		return gravatarId;
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
			"Actor{" + 
			"display_login = '" + displayLogin + '\'' + 
			",avatar_url = '" + avatarUrl + '\'' + 
			",id = '" + id + '\'' + 
			",login = '" + login + '\'' + 
			",gravatar_id = '" + gravatarId + '\'' + 
			",url = '" + url + '\'' + 
			"}";
		}
}