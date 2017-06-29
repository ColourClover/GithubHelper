package com.gengqiquan.githubhelper.utils;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 耿 on 2016/8/30.
 */
public class ExitUtil {

    public static List<Activity> activity_ = new ArrayList<Activity>();

    public static void addActivity(Activity activity) {
        activity_.add(activity);
    }

    public static void removeActivity(Activity activity) {
        activity_.remove(activity);
    }

    public static void exit() {
        List<Activity> copy = new ArrayList<Activity>(activity_);
        for (Activity activity : copy) {
            activity.finish();
        }
        System.exit(0);
    }

    public static void finish() {
        List<Activity> copy = new ArrayList<Activity>(activity_);
        for (Activity activity : copy) {
            activity.finish();
        }
    }
    public static void finish(Class activity) {
        Activity act_=null;
        for (Activity act : activity_) {
            if(act.getClass().getName().equals(activity.getName())){
                act_=act;
            }
        }
        if (act_!=null){
            activity_.remove(act_);
            act_.finish();
        }
    }

}
