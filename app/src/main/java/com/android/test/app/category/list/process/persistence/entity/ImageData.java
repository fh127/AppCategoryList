package com.android.test.app.category.list.process.persistence.entity;
import io.realm.RealmObject;

/**
 * ImageData class {@link RealmObject}
 * @autor Fabian Hoyos
 */
public class ImageData extends RealmObject {


  private String url;
  private String height;

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getHeight() {
    return height;
  }

  public void setHeight(String height) {
    this.height = height;
  }
}
