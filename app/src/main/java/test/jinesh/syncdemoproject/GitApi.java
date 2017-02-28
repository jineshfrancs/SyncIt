package test.jinesh.syncdemoproject;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import test.jinesh.syncdemoproject.beans.WeatherOutput;

/**
 * Created by gangadhar.g on 3/14/2016.
 */
public interface GitApi {

    @GET("v1/public/yql")
    Call<WeatherOutput> getWeather(@Query(value = "q",encoded = true) String query, @Query("format") String format);

}
