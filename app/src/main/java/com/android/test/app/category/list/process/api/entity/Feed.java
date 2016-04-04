
package com.android.test.app.category.list.process.api.entity;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;




/**
 * Feed class - Gson Model class {@link retrofit2.converter.gson.GsonConverterFactory}
 *
 * @autor Fabian Hoyos
 */
public class Feed {

    @SerializedName("author")
    @Expose
    public Author author;
    @SerializedName("entry")
    @Expose
    public List<Entry> entry = new ArrayList<Entry>();

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public List<Entry> getEntry() {
        return entry;
    }

    public void setEntry(List<Entry> entry) {
        this.entry = entry;
    }
}
