package com.mounica.moviestv.dataobjects;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Genre
 */

public class Genre {

  @SerializedName("id")
  @Expose
  private int id;
  @SerializedName("name")
  @Expose
  private String name;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public Genre withId(int id) {
    this.id = id;
    return this;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Genre withName(String name) {
    this.name = name;
    return this;
  }

}
