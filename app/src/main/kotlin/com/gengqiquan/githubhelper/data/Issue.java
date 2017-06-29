package com.gengqiquan.githubhelper.data;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class Issue{

	@SerializedName("comments")
	private int comments;

	@SerializedName("closed_at")
	private Object closedAt;

	@SerializedName("assignees")
	private List<Object> assignees;

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("title")
	private String title;

	@SerializedName("body")
	private String body;

	@SerializedName("url")
	private String url;

	@SerializedName("labels")
	private List<Object> labels;

	@SerializedName("labels_url")
	private String labelsUrl;

	@SerializedName("number")
	private int number;

	@SerializedName("milestone")
	private Object milestone;

	@SerializedName("updated_at")
	private String updatedAt;

	@SerializedName("events_url")
	private String eventsUrl;

	@SerializedName("html_url")
	private String htmlUrl;

	@SerializedName("comments_url")
	private String commentsUrl;

	@SerializedName("repository_url")
	private String repositoryUrl;

	@SerializedName("id")
	private int id;

	@SerializedName("state")
	private String state;

	@SerializedName("assignee")
	private Object assignee;

	@SerializedName("locked")
	private boolean locked;

	@SerializedName("user")
	private User user;

	public void setComments(int comments){
		this.comments = comments;
	}

	public int getComments(){
		return comments;
	}

	public void setClosedAt(Object closedAt){
		this.closedAt = closedAt;
	}

	public Object getClosedAt(){
		return closedAt;
	}

	public void setAssignees(List<Object> assignees){
		this.assignees = assignees;
	}

	public List<Object> getAssignees(){
		return assignees;
	}

	public void setCreatedAt(String createdAt){
		this.createdAt = createdAt;
	}

	public String getCreatedAt(){
		return createdAt;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return title;
	}

	public void setBody(String body){
		this.body = body;
	}

	public String getBody(){
		return body;
	}

	public void setUrl(String url){
		this.url = url;
	}

	public String getUrl(){
		return url;
	}

	public void setLabels(List<Object> labels){
		this.labels = labels;
	}

	public List<Object> getLabels(){
		return labels;
	}

	public void setLabelsUrl(String labelsUrl){
		this.labelsUrl = labelsUrl;
	}

	public String getLabelsUrl(){
		return labelsUrl;
	}

	public void setNumber(int number){
		this.number = number;
	}

	public int getNumber(){
		return number;
	}

	public void setMilestone(Object milestone){
		this.milestone = milestone;
	}

	public Object getMilestone(){
		return milestone;
	}

	public void setUpdatedAt(String updatedAt){
		this.updatedAt = updatedAt;
	}

	public String getUpdatedAt(){
		return updatedAt;
	}

	public void setEventsUrl(String eventsUrl){
		this.eventsUrl = eventsUrl;
	}

	public String getEventsUrl(){
		return eventsUrl;
	}

	public void setHtmlUrl(String htmlUrl){
		this.htmlUrl = htmlUrl;
	}

	public String getHtmlUrl(){
		return htmlUrl;
	}

	public void setCommentsUrl(String commentsUrl){
		this.commentsUrl = commentsUrl;
	}

	public String getCommentsUrl(){
		return commentsUrl;
	}

	public void setRepositoryUrl(String repositoryUrl){
		this.repositoryUrl = repositoryUrl;
	}

	public String getRepositoryUrl(){
		return repositoryUrl;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setState(String state){
		this.state = state;
	}

	public String getState(){
		return state;
	}

	public void setAssignee(Object assignee){
		this.assignee = assignee;
	}

	public Object getAssignee(){
		return assignee;
	}

	public void setLocked(boolean locked){
		this.locked = locked;
	}

	public boolean isLocked(){
		return locked;
	}

	public void setUser(User user){
		this.user = user;
	}

	public User getUser(){
		return user;
	}

	@Override
 	public String toString(){
		return 
			"Issue{" + 
			"comments = '" + comments + '\'' + 
			",closed_at = '" + closedAt + '\'' + 
			",assignees = '" + assignees + '\'' + 
			",created_at = '" + createdAt + '\'' + 
			",title = '" + title + '\'' + 
			",body = '" + body + '\'' + 
			",url = '" + url + '\'' + 
			",labels = '" + labels + '\'' + 
			",labels_url = '" + labelsUrl + '\'' + 
			",number = '" + number + '\'' + 
			",milestone = '" + milestone + '\'' + 
			",updated_at = '" + updatedAt + '\'' + 
			",events_url = '" + eventsUrl + '\'' + 
			",html_url = '" + htmlUrl + '\'' + 
			",comments_url = '" + commentsUrl + '\'' + 
			",repository_url = '" + repositoryUrl + '\'' + 
			",id = '" + id + '\'' + 
			",state = '" + state + '\'' + 
			",assignee = '" + assignee + '\'' + 
			",locked = '" + locked + '\'' + 
			",user = '" + user + '\'' + 
			"}";
		}
}