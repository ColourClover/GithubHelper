package com.gengqiquan.githubhelper.provides;

import com.gengqiquan.githubhelper.data.Event;
import com.gengqiquan.githubhelper.data.Repo;
import com.gengqiquan.githubhelper.data.User;

import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

/**
 * Created by gengqiquan on 2017/6/21.
 */

public interface GithubService {
    @Headers("Cache-Control: max-age=640000")
    @GET("search/repositories")
    Observable<String> searchRepositories(@QueryMap Map<String, String> params);

    @FormUrlEncoded
    @POST("login/oauth/access_token")
    Observable<String> accessToken(@Field("client_id") String client_id, @Field("client_secret") String client_secret, @Field("code") String code);

    @Headers("Cache-Control: max-age=640000")
    @GET("login/oauth/authorize")
    Observable<String> authorize(@Query("client_id") String client_id, @Query("state") String state, @Query("redirect_uri") String redirect_uri);

    @Headers("Cache-Control: max-age=640000")
    @GET("user")
    Observable<User> user(@Query("access_token") String access_token);

    @Headers("Cache-Control: max-age=640000")
    @GET("users/{user}")
    Observable<User> getUser(@Path("user") String user);

    @Headers("Cache-Control: max-age=640000")
    @GET("users/{user}/{type}?per_page=20")
    Observable<List<Repo>> getRepositoriesList(@Path("user") String user, @Path("type") String type, @Query("page") int page);

    @Headers("Cache-Control: max-age=640000")
    @GET("users/{user}/events/{privacy}?per_page=20")
    Observable<List<Event>> getUserEvents(@Path("user") String user, @Path("privacy") String privacy, @Query("page") int page);

    @Headers("Cache-Control: max-age=640000")
    @GET("{url}?per_page=20")
    Observable<List<Event>> getRepoEvents(@Path(value = "url", encoded = true) String url, @Query("page") int page);

    @Headers("Cache-Control: max-age=640000")
    @GET("/repos/{repoPath}")
    Observable<Repo> getRepositories(@Path(value = "repoPath", encoded = true) String repoPath);
}
