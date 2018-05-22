package com.mounica.moviestv.dataobjects;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Date
 */

public class Dates {

  @SerializedName("maximum")
  @Expose
  private String maximum;
  @SerializedName("minimum")
  @Expose
  private String minimum;

  public String getMaximum() {
    return maximum;
  }

  public void setMaximum(String maximum) {
    this.maximum = maximum;
  }

  public Dates withMaximum(String maximum) {
    this.maximum = maximum;
    return this;
  }

  public String getMinimum() {
    return minimum;
  }

  public void setMinimum(String minimum) {
    this.minimum = minimum;
  }

  public Dates withMinimum(String minimum) {
    this.minimum = minimum;
    return this;
  }


}
