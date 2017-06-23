package com.gengqiquan.githubhelper.provides;

import java.util.Map;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * Created by gengqiquan on 2017/6/21.
 */

public interface GithubService {
    @GET("search/repositories")
    Observable<String> searchRepositories(@QueryMap Map<String, String> params);

    @FormUrlEncoded
    @POST("login/oauth/access_token")
    Observable<String> accessToken(@Field("client_id") String client_id, @Field("client_secret") String client_secret, @Field("code") String code);

    //scope
    @GET("login/oauth/authorize?client_id={client_id}&state={state}&redirect_uri={redirect_uri}")
    Observable<String> authorize(@Path("client_id") String client_id, @Path("state") String state, @Path("redirect_uri") String redirect_uri);
}
