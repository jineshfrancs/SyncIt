
package test.jinesh.syncdemoproject.beans;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WeatherOutput {

    @SerializedName("query")
    @Expose
    private Query query;

    /**
     * No args constructor for use in serialization
     * 
     */
    public WeatherOutput() {
    }

    /**
     * 
     * @param query
     */
    public WeatherOutput(Query query) {
        super();
        this.query = query;
    }

    public Query getQuery() {
        return query;
    }

    public void setQuery(Query query) {
        this.query = query;
    }

}
