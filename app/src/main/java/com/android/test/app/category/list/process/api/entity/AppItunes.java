
package com.android.test.app.category.list.process.api.entity;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


/**
 * AppItunes class  - Gson Model class {@link retrofit2.converter.gson.GsonConverterFactory}
 * @autor Fabian Hoyos
 */
public class AppItunes {

    @SerializedName("feed")
    @Expose
    public Feed feed;

    public Feed getFeed() {
        return feed;
    }

    public void setFeed(Feed feed) {
        this.feed = feed;
    }
}
