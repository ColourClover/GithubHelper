package com.gengqiquan.githubhelper.data;

import android.os.Parcel;
import android.os.Parcelable;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class User implements Parcelable {

	@SerializedName("gists_url")
	private String gistsUrl;

	@SerializedName("repos_url")
	private String reposUrl;

	@SerializedName("following_url")
	private String followingUrl;

	@SerializedName("bio")
	private String bio;

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("login")
	private String login;

	@SerializedName("type")
	private String type;

	@SerializedName("blog")
	private String blog;

	@SerializedName("subscriptions_url")
	private String subscriptionsUrl;

	@SerializedName("updated_at")
	private String updatedAt;

	@SerializedName("site_admin")
	private boolean siteAdmin;

	@SerializedName("company")
	private String company;

	@SerializedName("id")
	private int id;

	@SerializedName("public_repos")
	private int publicRepos;

	@SerializedName("gravatar_id")
	private String gravatarId;

	@SerializedName("email")
	private String email;

	@SerializedName("organizations_url")
	private String organizationsUrl;

	@SerializedName("hireable")
	private String hireable;

	@SerializedName("starred_url")
	private String starredUrl;

	@SerializedName("followers_url")
	private String followersUrl;

	@SerializedName("public_gists")
	private int publicGists;

	@SerializedName("url")
	private String url;

	@SerializedName("received_events_url")
	private String receivedEventsUrl;

	@SerializedName("followers")
	private int followers;

	@SerializedName("avatar_url")
	private String avatarUrl;

	@SerializedName("events_url")
	private String eventsUrl;

	@SerializedName("html_url")
	private String htmlUrl;

	@SerializedName("following")
	private int following;

	@SerializedName("name")
	private String name;

	@SerializedName("location")
	private String location;

	public void setGistsUrl(String gistsUrl){
		this.gistsUrl = gistsUrl;
	}

	public String getGistsUrl(){
		return gistsUrl;
	}

	public void setReposUrl(String reposUrl){
		this.reposUrl = reposUrl;
	}

	public String getReposUrl(){
		return reposUrl;
	}

	public void setFollowingUrl(String followingUrl){
		this.followingUrl = followingUrl;
	}

	public String getFollowingUrl(){
		return followingUrl;
	}

	public void setBio(String bio){
		this.bio = bio;
	}

	public String getBio(){
		return bio;
	}

	public void setCreatedAt(String createdAt){
		this.createdAt = createdAt;
	}

	public String getCreatedAt(){
		return createdAt;
	}

	public void setLogin(String login){
		this.login = login;
	}

	public String getLogin(){
		return login;
	}

	public void setType(String type){
		this.type = type;
	}

	public String getType(){
		return type;
	}

	public void setBlog(String blog){
		this.blog = blog;
	}

	public String getBlog(){
		return blog;
	}

	public void setSubscriptionsUrl(String subscriptionsUrl){
		this.subscriptionsUrl = subscriptionsUrl;
	}

	public String getSubscriptionsUrl(){
		return subscriptionsUrl;
	}

	public void setUpdatedAt(String updatedAt){
		this.updatedAt = updatedAt;
	}

	public String getUpdatedAt(){
		return updatedAt;
	}

	public void setSiteAdmin(boolean siteAdmin){
		this.siteAdmin = siteAdmin;
	}

	public boolean isSiteAdmin(){
		return siteAdmin;
	}

	public void setCompany(String company){
		this.company = company;
	}

	public String getCompany(){
		return company;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setPublicRepos(int publicRepos){
		this.publicRepos = publicRepos;
	}

	public int getPublicRepos(){
		return publicRepos;
	}

	public void setGravatarId(String gravatarId){
		this.gravatarId = gravatarId;
	}

	public String getGravatarId(){
		return gravatarId;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail(){
		return email;
	}

	public void setOrganizationsUrl(String organizationsUrl){
		this.organizationsUrl = organizationsUrl;
	}

	public String getOrganizationsUrl(){
		return organizationsUrl;
	}

	public void setHireable(String hireable){
		this.hireable = hireable;
	}

	public String getHireable(){
		return hireable;
	}

	public void setStarredUrl(String starredUrl){
		this.starredUrl = starredUrl;
	}

	public String getStarredUrl(){
		return starredUrl;
	}

	public void setFollowersUrl(String followersUrl){
		this.followersUrl = followersUrl;
	}

	public String getFollowersUrl(){
		return followersUrl;
	}

	public void setPublicGists(int publicGists){
		this.publicGists = publicGists;
	}

	public int getPublicGists(){
		return publicGists;
	}

	public void setUrl(String url){
		this.url = url;
	}

	public String getUrl(){
		return url;
	}

	public void setReceivedEventsUrl(String receivedEventsUrl){
		this.receivedEventsUrl = receivedEventsUrl;
	}

	public String getReceivedEventsUrl(){
		return receivedEventsUrl;
	}

	public void setFollowers(int followers){
		this.followers = followers;
	}

	public int getFollowers(){
		return followers;
	}

	public void setAvatarUrl(String avatarUrl){
		this.avatarUrl = avatarUrl;
	}

	public String getAvatarUrl(){
		return avatarUrl;
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

	public void setFollowing(int following){
		this.following = following;
	}

	public int getFollowing(){
		return following;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setLocation(String location){
		this.location = location;
	}

	public String getLocation(){
		return location;
	}

	@Override
 	public String toString(){
		return 
			"User{" + 
			"gists_url = '" + gistsUrl + '\'' + 
			",repos_url = '" + reposUrl + '\'' + 
			",following_url = '" + followingUrl + '\'' + 
			",bio = '" + bio + '\'' + 
			",created_at = '" + createdAt + '\'' + 
			",login = '" + login + '\'' + 
			",type = '" + type + '\'' + 
			",blog = '" + blog + '\'' + 
			",subscriptions_url = '" + subscriptionsUrl + '\'' + 
			",updated_at = '" + updatedAt + '\'' + 
			",site_admin = '" + siteAdmin + '\'' + 
			",company = '" + company + '\'' + 
			",id = '" + id + '\'' + 
			",public_repos = '" + publicRepos + '\'' + 
			",gravatar_id = '" + gravatarId + '\'' + 
			",email = '" + email + '\'' + 
			",organizations_url = '" + organizationsUrl + '\'' + 
			",hireable = '" + hireable + '\'' + 
			",starred_url = '" + starredUrl + '\'' + 
			",followers_url = '" + followersUrl + '\'' + 
			",public_gists = '" + publicGists + '\'' + 
			",url = '" + url + '\'' + 
			",received_events_url = '" + receivedEventsUrl + '\'' + 
			",followers = '" + followers + '\'' + 
			",avatar_url = '" + avatarUrl + '\'' + 
			",events_url = '" + eventsUrl + '\'' + 
			",html_url = '" + htmlUrl + '\'' + 
			",following = '" + following + '\'' + 
			",name = '" + name + '\'' + 
			",location = '" + location + '\'' + 
			"}";
		}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(this.gistsUrl);
		dest.writeString(this.reposUrl);
		dest.writeString(this.followingUrl);
		dest.writeString(this.bio);
		dest.writeString(this.createdAt);
		dest.writeString(this.login);
		dest.writeString(this.type);
		dest.writeString(this.blog);
		dest.writeString(this.subscriptionsUrl);
		dest.writeString(this.updatedAt);
		dest.writeByte(siteAdmin ? (byte) 1 : (byte) 0);
		dest.writeString(this.company);
		dest.writeInt(this.id);
		dest.writeInt(this.publicRepos);
		dest.writeString(this.gravatarId);
		dest.writeString(this.email);
		dest.writeString(this.organizationsUrl);
		dest.writeString(this.hireable);
		dest.writeString(this.starredUrl);
		dest.writeString(this.followersUrl);
		dest.writeInt(this.publicGists);
		dest.writeString(this.url);
		dest.writeString(this.receivedEventsUrl);
		dest.writeInt(this.followers);
		dest.writeString(this.avatarUrl);
		dest.writeString(this.eventsUrl);
		dest.writeString(this.htmlUrl);
		dest.writeInt(this.following);
		dest.writeString(this.name);
		dest.writeString(this.location);
	}

	public User() {
	}

	protected User(Parcel in) {
		this.gistsUrl = in.readString();
		this.reposUrl = in.readString();
		this.followingUrl = in.readString();
		this.bio = in.readString();
		this.createdAt = in.readString();
		this.login = in.readString();
		this.type = in.readString();
		this.blog = in.readString();
		this.subscriptionsUrl = in.readString();
		this.updatedAt = in.readString();
		this.siteAdmin = in.readByte() != 0;
		this.company = in.readString();
		this.id = in.readInt();
		this.publicRepos = in.readInt();
		this.gravatarId = in.readString();
		this.email = in.readString();
		this.organizationsUrl = in.readString();
		this.hireable = in.readString();
		this.starredUrl = in.readString();
		this.followersUrl = in.readString();
		this.publicGists = in.readInt();
		this.url = in.readString();
		this.receivedEventsUrl = in.readString();
		this.followers = in.readInt();
		this.avatarUrl = in.readString();
		this.eventsUrl = in.readString();
		this.htmlUrl = in.readString();
		this.following = in.readInt();
		this.name = in.readString();
		this.location = in.readString();
	}

	public static final Parcelable.Creator<User> CREATOR = new Parcelable.Creator<User>() {
		public User createFromParcel(Parcel source) {
			return new User(source);
		}

		public User[] newArray(int size) {
			return new User[size];
		}
	};
}