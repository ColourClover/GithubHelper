package com.gengqiquan.githubhelper.expansions

import com.gengqiquan.githubhelper.base.IBaseView
import rx.Observable
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

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

