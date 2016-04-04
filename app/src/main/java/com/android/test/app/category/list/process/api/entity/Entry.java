
package com.android.test.app.category.list.process.api.entity;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * DataEntry class  - Gson Model class {@link retrofit2.converter.gson.GsonConverterFactory}
 *
 * @autor Fabian Hoyos
 */
public class Entry {

    @SerializedName("im:name")
    @Expose
    private Label name;
    @SerializedName("im:image")
    @Expose
    private List<DataEntry> images = new ArrayList();
    @Expose
    private Label summary;
    @SerializedName("im:price")
    @Expose
    private DataEntry price;
    @SerializedName("im:contentType")
    @Expose
    private DataEntry contentType;
    @SerializedName("rights")
    @Expose
    private Label rights;
    @SerializedName("title")
    @Expose
    private Label title;
    @SerializedName("id")
    @Expose
    private DataEntry id;

    @SerializedName("im:artist")
    @Expose
    private DataEntry artist;
    @Expose
    private DataEntry category;
    @SerializedName("im:releaseDate")
    @Expose
    private DataEntry releaseDate;

    public Label getName() {
        return name;
    }

    public void setName(Label name) {
        this.name = name;
    }

    public List<DataEntry> getImages() {
        return images;
    }

    public void setImages(List<DataEntry> images) {
        this.images = images;
    }

    public DataEntry getContentType() {
        return contentType;
    }

    public void setContentType(DataEntry contentType) {
        this.contentType = contentType;
    }

    public DataEntry getPrice() {
        return price;
    }

    public void setPrice(DataEntry price) {
        this.price = price;
    }

    public Label getSummary() {
        return summary;
    }

    public void setSummary(Label summary) {
        this.summary = summary;
    }

    public DataEntry getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(DataEntry releaseDate) {
        this.releaseDate = releaseDate;
    }

    public DataEntry getCategory() {
        return category;
    }

    public void setCategory(DataEntry category) {
        this.category = category;
    }

    public DataEntry getArtist() {
        return artist;
    }

    public void setArtist(DataEntry artist) {
        this.artist = artist;
    }

    public DataEntry getId() {
        return id;
    }

    public void setId(DataEntry id) {
        this.id = id;
    }

    public Label getTitle() {
        return title;
    }

    public void setTitle(Label title) {
        this.title = title;
    }

    public Label getRights() {
        return rights;
    }

    public void setRights(Label rights) {
        this.rights = rights;
    }
}
