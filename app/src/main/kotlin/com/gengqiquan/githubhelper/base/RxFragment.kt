package com.gengqiquan.githubhelper.base

import android.app.Activity
import com.trello.rxlifecycle2.android.FragmentEvent
import android.support.annotation.CallSuper
import android.os.Bundle
import com.trello.rxlifecycle2.android.RxLifecycleAndroid
import com.trello.rxlifecycle2.LifecycleTransformer
import android.support.annotation.CheckResult
import android.support.annotation.NonNull
import android.support.annotation.Nullable
import android.view.View
import com.trello.rxlifecycle2.RxLifecycle
import io.reactivex.Observable
import io.reactivex.subjects.BehaviorSubject


/**
 * Created by gengqiquan on 2017/6/27.
 */
abstract class RxFragment : DaggerFragment() {
    private val lifecycleSubject = BehaviorSubject.create<FragmentEvent>()

    @NonNull
    @CheckResult
    fun lifecycle(): Observable<FragmentEvent> {
        return lifecycleSubject.hide()
    }

    @NonNull
    @CheckResult
    fun <T> bindUntilEvent(@NonNull event: FragmentEvent): LifecycleTransformer<T> {
        return RxLifecycle.bindUntilEvent<T, FragmentEvent>(lifecycleSubject, event)
    }

    @NonNull
    @CheckResult
    fun <T> bindToLifecycle(): LifecycleTransformer<T> {
        return RxLifecycleAndroid.bindFragment<T>(lifecycleSubject)
    }

    @CallSuper
    override fun onAttach(activity: Activity) {
        super.onAttach(activity)
        lifecycleSubject.onNext(FragmentEvent.ATTACH)
    }

    @CallSuper
    override fun onCreate(@Nullable savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycleSubject.onNext(FragmentEvent.CREATE)
    }

    @CallSuper
    override fun onViewCreated(view: View, @Nullable savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lifecycleSubject.onNext(FragmentEvent.CREATE_VIEW)
    }

    @CallSuper
    override fun onStart() {
        super.onStart()
        lifecycleSubject.onNext(FragmentEvent.START)
    }

    @CallSuper
    override fun onResume() {
        super.onResume()
        lifecycleSubject.onNext(FragmentEvent.RESUME)
    }

    @CallSuper
    override fun onPause() {
        lifecycleSubject.onNext(FragmentEvent.PAUSE)
        super.onPause()
    }

    @CallSuper
    override fun onStop() {
        lifecycleSubject.onNext(FragmentEvent.STOP)
        super.onStop()
    }

    @CallSuper
    override fun onDestroyView() {
        lifecycleSubject.onNext(FragmentEvent.DESTROY_VIEW)
        super.onDestroyView()
    }

    @CallSuper
    override fun onDestroy() {
        lifecycleSubject.onNext(FragmentEvent.DESTROY)
        super.onDestroy()
    }

    @CallSuper
    override fun onDetach() {
        lifecycleSubject.onNext(FragmentEvent.DETACH)
        super.onDetach()
    }
}