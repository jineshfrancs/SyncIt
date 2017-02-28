package test.jinesh.sync;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by Jinesh on 28-02-2017.
 */

public class NetworkChangeReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if(isNetworkAvailable(context)){
            Intent networkChange=new Intent(Sync.NETWORK_DETECTOR);
            networkChange.putExtra(Sync.DATA_AVAILABLE,true);
            context.sendBroadcast(networkChange);
        }else{
            Intent networkChange=new Intent(Sync.NETWORK_DETECTOR);
            networkChange.putExtra(Sync.DATA_AVAILABLE,false);
            context.sendBroadcast(networkChange);
        }
    }
    public boolean isNetworkAvailable(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = cm.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {
            return true;
        }
        return false;
    }

}
