package com.gengqiquan.githubhelper.data;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class Event{

	@SerializedName("actor")
	private Actor actor;

	@SerializedName("public")
	private boolean jsonMemberPublic;

	@SerializedName("payload")
	private Payload payload;

	@SerializedName("repo")
	private Repo repo;

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("id")
	private String id;

	@SerializedName("type")
	private String type;

	public void setActor(Actor actor){
		this.actor = actor;
	}

	public Actor getActor(){
		return actor;
	}

	public void setJsonMemberPublic(boolean jsonMemberPublic){
		this.jsonMemberPublic = jsonMemberPublic;
	}

	public boolean isJsonMemberPublic(){
		return jsonMemberPublic;
	}

	public void setPayload(Payload payload){
		this.payload = payload;
	}

	public Payload getPayload(){
		return payload;
	}

	public void setRepo(Repo repo){
		this.repo = repo;
	}

	public Repo getRepo(){
		return repo;
	}

	public void setCreatedAt(String createdAt){
		this.createdAt = createdAt;
	}

	public String getCreatedAt(){
		return createdAt;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setType(String type){
		this.type = type;
	}

	public String getType(){
		return type;
	}

	@Override
 	public String toString(){
		return 
			"Event{" + 
			"actor = '" + actor + '\'' + 
			",public = '" + jsonMemberPublic + '\'' + 
			",payload = '" + payload + '\'' + 
			",repo = '" + repo + '\'' + 
			",created_at = '" + createdAt + '\'' + 
			",id = '" + id + '\'' + 
			",type = '" + type + '\'' + 
			"}";
		}
}