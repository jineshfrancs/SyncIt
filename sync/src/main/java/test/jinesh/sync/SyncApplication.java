package test.jinesh.sync;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by Jinesh on 28-02-2017.
 */

public class SyncApplication extends android.app.Application implements android.app.Application.ActivityLifecycleCallbacks {
    Activity visibleActivity;
    BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            // internet lost alert dialog method call from here...
            boolean isDataAvailable=intent.getBooleanExtra(Sync.DATA_AVAILABLE,false);
            if(visibleActivity!=null){
                try {
                    String className=visibleActivity.getComponentName().getClassName();
                    Class<?> clazz = Class.forName(className);
                    Method method=clazz.getMethod(Sync.ON_SYNC,boolean.class);
                    try {
                        method.invoke(visibleActivity,isDataAvailable);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
    };
    @Override
    public void onCreate() {
        super.onCreate();
        registerActivityLifecycleCallbacks(this);
        registerReceiver(broadcastReceiver,new IntentFilter(Sync.NETWORK_DETECTOR));
    }
    @Override
    public void onActivityCreated(Activity activity, Bundle bundle) {

    }

    @Override
    public void onActivityStarted(Activity activity) {

    }

    @Override
    public void onActivityResumed(Activity activity) {
        visibleActivity=activity;
    }

    @Override
    public void onActivityPaused(Activity activity) {

    }

    @Override
    public void onActivityStopped(Activity activity) {

    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {

    }

    @Override
    public void onActivityDestroyed(Activity activity) {

    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        unregisterReceiver(broadcastReceiver);
    }
}
