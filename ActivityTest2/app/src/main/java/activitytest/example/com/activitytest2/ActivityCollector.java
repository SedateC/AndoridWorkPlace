package activitytest.example.com.activitytest2;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/6/19.
 */

public class ActivityCollector {
    public static List<Activity> activities = new ArrayList<>();
    public static void addActivity(Activity activity){
        activities.add(activity);
    }

    public static void removeActivity (Activity activity){
        activities.remove(activity);
    }

    public static void removeAllActivity ( ){
        for (Activity a:activities) {
            if(!a.isFinishing())
            a.finish();
        }
        activities.clear();
    }
}
