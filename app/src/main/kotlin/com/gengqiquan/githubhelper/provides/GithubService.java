package com.gengqiquan.githubhelper.provides;

import java.util.Map;

import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * Created by gengqiquan on 2017/6/21.
 */

public interface GithubService {
    @GET("search/repositories")
    Observable<String> searchRepositories(@QueryMap Map<String, String> params);
}
