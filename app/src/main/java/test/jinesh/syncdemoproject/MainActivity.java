package test.jinesh.syncdemoproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import test.jinesh.sync.OnSyncListner;
import test.jinesh.syncdemoproject.beans.WeatherOutput;

public class MainActivity extends AppCompatActivity implements OnSyncListner {
    RelativeLayout wheatherLayout, internetLayout;
    TextView dateText, syncText, statusText, city, state, country, wheather, unit, wind, admosphere, sunrise,zero;
    ImageView statusImage;
    ProgressBar syncProgress;
    private static OkHttpClient.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeViews();

    }

    private void initializeViews() {
        wheatherLayout = (RelativeLayout) findViewById(R.id.wheatherLayout);
        internetLayout = (RelativeLayout) findViewById(R.id.noInternetLayout);
        dateText = (TextView) findViewById(R.id.date);
        syncText = (TextView) findViewById(R.id.textView5);
        statusText = (TextView) findViewById(R.id.textView3);
        city = (TextView) findViewById(R.id.textView);
        state = (TextView) findViewById(R.id.textView9);
        country = (TextView) findViewById(R.id.country);
        wheather = (TextView) findViewById(R.id.textView2);
        unit = (TextView) findViewById(R.id.textView4);
        wind = (TextView) findViewById(R.id.textView6);
        admosphere = (TextView) findViewById(R.id.textView7);
        sunrise = (TextView) findViewById(R.id.textView8);
        syncProgress = (ProgressBar) findViewById(R.id.progressBar);
        zero= (TextView) findViewById(R.id.zero);
        statusImage = (ImageView) findViewById(R.id.statusImage);
        maakeVisibility();
        callService();
    }

    private void maakeVisibility() {
        dateText.setVisibility(View.INVISIBLE);
        statusText.setVisibility(View.INVISIBLE);
        city.setVisibility(View.INVISIBLE);
        state.setVisibility(View.INVISIBLE);
        country.setVisibility(View.INVISIBLE);
        wheather.setVisibility(View.INVISIBLE);
        unit.setVisibility(View.INVISIBLE);
        wind.setVisibility(View.INVISIBLE);
        admosphere.setVisibility(View.INVISIBLE);
        sunrise.setVisibility(View.INVISIBLE);
        syncProgress.setVisibility(View.VISIBLE);
        syncText.setVisibility(View.VISIBLE);
        zero.setVisibility(View.INVISIBLE);
        statusImage.setVisibility(View.INVISIBLE);
    }
    private void hide() {
        dateText.setVisibility(View.VISIBLE);
        statusText.setVisibility(View.VISIBLE);
        city.setVisibility(View.VISIBLE);
        state.setVisibility(View.VISIBLE);
        country.setVisibility(View.VISIBLE);
        wheather.setVisibility(View.VISIBLE);
        unit.setVisibility(View.VISIBLE);
        wind.setVisibility(View.VISIBLE);
        admosphere.setVisibility(View.VISIBLE);
        sunrise.setVisibility(View.VISIBLE);
        syncProgress.setVisibility(View.INVISIBLE);
        syncText.setVisibility(View.INVISIBLE);
        zero.setVisibility(View.VISIBLE);
        statusImage.setVisibility(View.VISIBLE);
    }

    private void callService() {
        String serviceName = "https://query.yahooapis.com/";
        builder = getHttpClient();
        Retrofit retrofit = new Retrofit.Builder().baseUrl(serviceName).addConverterFactory(GsonConverterFactory.create()).client(builder.build()).build();
        GitApi gi = retrofit.create(GitApi.class);
        String query=null;
        String citys="bangalore";
       query="select * from weather.forecast where woeid in (select woeid from geo.places(1) where text='"+citys+"')";

        Call<WeatherOutput> call = (Call<WeatherOutput>) gi.getWeather(query, "json");
        call.enqueue(new Callback<WeatherOutput>() {
            @Override
            public void onResponse(Call<WeatherOutput> call, Response<WeatherOutput> response) {
                WeatherOutput weatherOutput = response.body();
                if(weatherOutput!=null){
                    updateUI(weatherOutput);
                }else{
                    syncProgress.setVisibility(View.INVISIBLE);
                    syncText.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void onFailure(Call<WeatherOutput> call, Throwable t) {
                syncProgress.setVisibility(View.INVISIBLE);
                syncText.setVisibility(View.INVISIBLE);
            }

        });
    }

    private void updateUI(WeatherOutput weatherOutput) {
        hide();
        dateText.setText(weatherOutput.getQuery().getResults().getChannel().getLastBuildDate());
        statusText.setText(weatherOutput.getQuery().getResults().getChannel().getItem().getCondition().getText());
        city.setText(weatherOutput.getQuery().getResults().getChannel().getLocation().getCity());
        state.setText(weatherOutput.getQuery().getResults().getChannel().getLocation().getRegion());
        country.setText(weatherOutput.getQuery().getResults().getChannel().getLocation().getCountry());
        wheather.setText(weatherOutput.getQuery().getResults().getChannel().getItem().getCondition().getTemp());
        unit.setText(weatherOutput.getQuery().getResults().getChannel().getUnits().getTemperature());
        wind.setText("Wind "+weatherOutput.getQuery().getResults().getChannel().getWind().getSpeed()+" "+weatherOutput.getQuery().getResults().getChannel().getUnits().getSpeed());
        admosphere.setText("Atmo "+weatherOutput.getQuery().getResults().getChannel().getAtmosphere().getPressure()+" "+weatherOutput.getQuery().getResults().getChannel().getUnits().getPressure());
        sunrise.setText("R "+weatherOutput.getQuery().getResults().getChannel().getAstronomy().getSunrise()+" S "+weatherOutput.getQuery().getResults().getChannel().getAstronomy().getSunset());
        String des=weatherOutput.getQuery().getResults().getChannel().getItem().getDescription();
        int start=des.indexOf("<img");
        int end=des.indexOf("/>");
        String last=des.substring(start,end);
        last=last.replaceAll("\\\"","");
        last=last.replaceAll("<img src=","");
        Log.e("last",last);
        String imageurl=last;
        Picasso.with(MainActivity.this)
                .load(imageurl)
                .placeholder(R.mipmap.ic_launcher)
                .into(statusImage);



    }

    @Override
    public void onSync(boolean isDataAvailable) {
        if (isDataAvailable) {
            /*Call web service to update views here*/
            wheatherLayout.setVisibility(View.VISIBLE);
            internetLayout.setVisibility(View.GONE);
            maakeVisibility();
            callService();
        } else {
            /*No data connection*/
            wheatherLayout.setVisibility(View.GONE);
            internetLayout.setVisibility(View.VISIBLE);
        }
    }

    public OkHttpClient.Builder getHttpClient() {
        if (builder == null) {
            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient.Builder client = new OkHttpClient.Builder();
            client.addInterceptor(loggingInterceptor);
            client.writeTimeout(60000, TimeUnit.MILLISECONDS);
            client.readTimeout(60000, TimeUnit.MILLISECONDS);
            client.connectTimeout(60000, TimeUnit.MILLISECONDS);
            return client;
        }
        return builder;
    }
}
