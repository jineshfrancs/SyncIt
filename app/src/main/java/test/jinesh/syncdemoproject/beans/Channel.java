
package test.jinesh.syncdemoproject.beans;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Channel {

    @SerializedName("units")
    @Expose
    private Units units;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("link")
    @Expose
    private String link;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("language")
    @Expose
    private String language;
    @SerializedName("lastBuildDate")
    @Expose
    private String lastBuildDate;
    @SerializedName("ttl")
    @Expose
    private String ttl;
    @SerializedName("location")
    @Expose
    private Location location;
    @SerializedName("wind")
    @Expose
    private Wind wind;
    @SerializedName("atmosphere")
    @Expose
    private Atmosphere atmosphere;
    @SerializedName("astronomy")
    @Expose
    private Astronomy astronomy;
    @SerializedName("image")
    @Expose
    private Image image;
    @SerializedName("item")
    @Expose
    private Item item;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Channel() {
    }

    /**
     * 
     * @param wind
     * @param location
     * @param link
     * @param atmosphere
     * @param image
     * @param ttl
     * @param astronomy
     * @param units
     * @param title
     * @param description
     * @param item
     * @param lastBuildDate
     * @param language
     */
    public Channel(Units units, String title, String link, String description, String language, String lastBuildDate, String ttl, Location location, Wind wind, Atmosphere atmosphere, Astronomy astronomy, Image image, Item item) {
        super();
        this.units = units;
        this.title = title;
        this.link = link;
        this.description = description;
        this.language = language;
        this.lastBuildDate = lastBuildDate;
        this.ttl = ttl;
        this.location = location;
        this.wind = wind;
        this.atmosphere = atmosphere;
        this.astronomy = astronomy;
        this.image = image;
        this.item = item;
    }

    public Units getUnits() {
        return units;
    }

    public void setUnits(Units units) {
        this.units = units;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getLastBuildDate() {
        return lastBuildDate;
    }

    public void setLastBuildDate(String lastBuildDate) {
        this.lastBuildDate = lastBuildDate;
    }

    public String getTtl() {
        return ttl;
    }

    public void setTtl(String ttl) {
        this.ttl = ttl;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public Atmosphere getAtmosphere() {
        return atmosphere;
    }

    public void setAtmosphere(Atmosphere atmosphere) {
        this.atmosphere = atmosphere;
    }

    public Astronomy getAstronomy() {
        return astronomy;
    }

    public void setAstronomy(Astronomy astronomy) {
        this.astronomy = astronomy;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

}
