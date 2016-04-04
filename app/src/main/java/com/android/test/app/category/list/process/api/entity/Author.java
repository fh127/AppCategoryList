
package com.android.test.app.category.list.process.api.entity;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 *  Author class - Gson Model class {@link retrofit2.converter.gson.GsonConverterFactory}
 * @autor Fabian Hoyos
 */
public class Author {

    @SerializedName("name")
    @Expose
    public Label name;
    @SerializedName("uri")
    @Expose
    public Label uri;

    public Label getName() {
        return name;
    }

    public void setName(Label name) {
        this.name = name;
    }

    public Label getUri() {
        return uri;
    }

    public void setUri(Label uri) {
        this.uri = uri;
    }
}
