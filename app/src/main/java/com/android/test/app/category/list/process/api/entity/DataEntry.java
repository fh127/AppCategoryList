package com.android.test.app.category.list.process.api.entity;

import com.google.gson.annotations.Expose;


/**
 * DataEntry class  - Gson Model class {@link retrofit2.converter.gson.GsonConverterFactory}
 *
 * @autor Fabian Hoyos
 */
public class DataEntry {

    @Expose
    private String label;
    @Expose
    private Attributes attributes;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Attributes getAttributes() {
        return attributes;
    }

    public void setAttributes(Attributes attributes) {
        this.attributes = attributes;
    }
}