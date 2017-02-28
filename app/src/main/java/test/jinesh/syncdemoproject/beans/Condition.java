
package test.jinesh.syncdemoproject.beans;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Condition {

    @SerializedName("code")
    @Expose
    private String code;
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("temp")
    @Expose
    private String temp;
    @SerializedName("text")
    @Expose
    private String text;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Condition() {
    }

    /**
     * 
     * @param text
     * @param temp
     * @param code
     * @param date
     */
    public Condition(String code, String date, String temp, String text) {
        super();
        this.code = code;
        this.date = date;
        this.temp = temp;
        this.text = text;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
