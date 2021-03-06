package com.broadcast.sedatec.broadcastbestpractice;

import android.app.Activity;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by SedateC on 2017/7/19.
 */

public class ActivityCollector {
    public static List<Activity> activityLists = new ArrayList<>() ;
    public static void addActivity(Activity activity){
        activityLists.add(activity);
    }
    public static void removeActivity(Activity activity){
        activityLists.remove(activity);
    }
    public static void finshAll(){
        for(Activity activity:activityLists){
            if (!activity.isFinishing()){
                activity.finish();
            }
        }
    }
}
