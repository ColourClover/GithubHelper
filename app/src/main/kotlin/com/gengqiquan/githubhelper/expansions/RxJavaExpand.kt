package com.gengqiquan.githubhelper.expansions

import com.gengqiquan.githubhelper.base.IBaseView
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by gengqiquan on 2017/6/23.
 */
fun <T> Observable<T>.applySchedulersAndLife(view: IBaseView): Observable<T> =
        this.compose(view.bindToLife())
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())

fun <T> Observable<T>.applySchedulers(): Observable<T> =
        this.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())

