package com.android.test.app.category.list.process.persistence.entity;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Category class {@link RealmObject}
 * @autor Fabian Hoyos
 */
public class Category extends RealmObject {
  @PrimaryKey
  private String id;
  private String name;
  private String scheme;
  private String term;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getScheme() {
    return scheme;
  }

  public void setScheme(String scheme) {
    this.scheme = scheme;
  }

  public String getTerm() {
    return term;
  }

  public void setTerm(String term) {
    this.term = term;
  }
}
