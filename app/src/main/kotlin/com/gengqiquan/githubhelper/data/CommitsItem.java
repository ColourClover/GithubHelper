package com.gengqiquan.githubhelper.data;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class CommitsItem{

	@SerializedName("author")
	private Author author;

	@SerializedName("distinct")
	private boolean distinct;

	@SerializedName("message")
	private String message;

	@SerializedName("sha")
	private String sha;

	@SerializedName("url")
	private String url;

	public void setAuthor(Author author){
		this.author = author;
	}

	public Author getAuthor(){
		return author;
	}

	public void setDistinct(boolean distinct){
		this.distinct = distinct;
	}

	public boolean isDistinct(){
		return distinct;
	}

	public void setMessage(String message){
		this.message = message;
	}

	public String getMessage(){
		return message;
	}

	public void setSha(String sha){
		this.sha = sha;
	}

	public String getSha(){
		return sha;
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
			"CommitsItem{" + 
			"author = '" + author + '\'' + 
			",distinct = '" + distinct + '\'' + 
			",message = '" + message + '\'' + 
			",sha = '" + sha + '\'' + 
			",url = '" + url + '\'' + 
			"}";
		}
}