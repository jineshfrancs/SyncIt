
package test.jinesh.syncdemoproject.beans;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Units {

    @SerializedName("distance")
    @Expose
    private String distance;
    @SerializedName("pressure")
    @Expose
    private String pressure;
    @SerializedName("speed")
    @Expose
    private String speed;
    @SerializedName("temperature")
    @Expose
    private String temperature;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Units() {
    }

    /**
     * 
     * @param distance
     * @param pressure
     * @param speed
     * @param temperature
     */
    public Units(String distance, String pressure, String speed, String temperature) {
        super();
        this.distance = distance;
        this.pressure = pressure;
        this.speed = speed;
        this.temperature = temperature;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getPressure() {
        return pressure;
    }

    public void setPressure(String pressure) {
        this.pressure = pressure;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

}
