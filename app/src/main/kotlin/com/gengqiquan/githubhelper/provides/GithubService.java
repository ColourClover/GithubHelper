package com.gengqiquan.githubhelper.provides;

import com.gengqiquan.githubhelper.data.Event;
import com.gengqiquan.githubhelper.data.Repositorie;
import com.gengqiquan.githubhelper.data.User;

import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

/**
 * Created by gengqiquan on 2017/6/21.
 */

public interface GithubService {
    @GET("search/repositories")
    Observable<String> searchRepositories(@QueryMap Map<String, String> params);

    @FormUrlEncoded
    @POST("login/oauth/access_token")
    Observable<String> accessToken(@Field("client_id") String client_id, @Field("client_secret") String client_secret, @Field("code") String code);

    @GET("login/oauth/authorize")
    Observable<String> authorize(@Query("client_id") String client_id, @Query("state") String state, @Query("redirect_uri") String redirect_uri);

    @GET("user")
    Observable<User> user(@Query("access_token") String access_token);

    @GET("users/{user}")
    Observable<User> getUser(@Path("user") String user);

    @GET("users/{user}/{type}?per_page=20")
    Observable<List<Repositorie>> getRepositoriesList(@Path("user") String user, @Path("type") String type, @Query("page") int page);

    @GET("users/{user}/events/{privacy}?per_page=20")
    Observable<List<Event>> getUserEvents(@Path("user") String user, @Path("privacy") String privacy, @Query("page") int page);

    @GET("/repos/{owner}/{repo}")
    Observable<List<Event>> getRepositories(@Path("owner") String owner, @Path("repo") String repo);
}
