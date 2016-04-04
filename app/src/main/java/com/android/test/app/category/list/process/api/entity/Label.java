package com.android.test.app.category.list.process.api.entity;

import com.google.gson.annotations.Expose;


/**
 * Label class - Gson Model class {@link retrofit2.converter.gson.GsonConverterFactory}
 *
 * @autor Fabian Hoyos
 */
public class Label {


    @Expose
    public String label;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}