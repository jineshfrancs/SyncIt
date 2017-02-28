package test.jinesh.syncdemoproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import test.jinesh.sync.OnSyncListner;

public class MainActivity extends AppCompatActivity implements OnSyncListner {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    @Override
    public void onSync(boolean isDataAvailable) {
        if(isDataAvailable){
            /*Call web service to update views here*/
        }else{
            /*No data connection*/
        }
    }
}
