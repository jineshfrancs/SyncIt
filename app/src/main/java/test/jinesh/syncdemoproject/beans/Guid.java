
package test.jinesh.syncdemoproject.beans;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Guid {

    @SerializedName("isPermaLink")
    @Expose
    private String isPermaLink;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Guid() {
    }

    /**
     * 
     * @param isPermaLink
     */
    public Guid(String isPermaLink) {
        super();
        this.isPermaLink = isPermaLink;
    }

    public String getIsPermaLink() {
        return isPermaLink;
    }

    public void setIsPermaLink(String isPermaLink) {
        this.isPermaLink = isPermaLink;
    }

}
