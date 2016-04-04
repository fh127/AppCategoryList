
package com.android.test.app.category.list.process.api.entity;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Attributes class  - Gson Model class {@link retrofit2.converter.gson.GsonConverterFactory}
 * @autor Fabian Hoyos
 */
public class Attributes {


    @Expose
    public String height;


    @Expose
    public String amount;

    @Expose
    public String currency;



    @Expose
    public String rel;

    @Expose
    public String type;


    @SerializedName("im:bundleId")
    @Expose
    public String im_bundleId;


    @Expose
    public String href;


    @SerializedName("im:id")
    @Expose
    public String im_id;

    @Expose
    public String term;

    @Expose
    public String scheme;

    @Expose
    public String label;

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getRel() {
        return rel;
    }

    public void setRel(String rel) {
        this.rel = rel;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIm_bundleId() {
        return im_bundleId;
    }

    public void setIm_bundleId(String im_bundleId) {
        this.im_bundleId = im_bundleId;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getIm_id() {
        return im_id;
    }

    public void setIm_id(String im_id) {
        this.im_id = im_id;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getScheme() {
        return scheme;
    }

    public void setScheme(String scheme) {
        this.scheme = scheme;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
