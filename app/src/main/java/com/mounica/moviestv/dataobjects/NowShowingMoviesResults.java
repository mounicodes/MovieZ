package com.mounica.moviestv.dataobjects;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * Results - same for Nowshowing,popular and upcoming
 */

public class NowShowingMoviesResults {

  @SerializedName("results")
  @Expose
  private List<NowShowingMovies> results = null;
  @SerializedName("page")
  @Expose
  private int page;
  @SerializedName("total_results")
  @Expose
  private int totalResults;
//  @SerializedName("dates")
//  @Expose
//  private Dates dates;
  @SerializedName("total_pages")
  @Expose
  private int totalPages;

  public List<NowShowingMovies> getResults() {
    return results;
  }

  public void setResults(List<NowShowingMovies> results) {
    this.results = results;
  }

  public NowShowingMoviesResults withResults(List<NowShowingMovies> results) {
    this.results = results;
    return this;
  }

  public int getPage() {
    return page;
  }

  public void setPage(int page) {
    this.page = page;
  }

  public NowShowingMoviesResults withPage(int page) {
    this.page = page;
    return this;
  }

  public int getTotalResults() {
    return totalResults;
  }

  public void setTotalResults(int totalResults) {
    this.totalResults = totalResults;
  }

  public NowShowingMoviesResults withTotalResults(int totalResults) {
    this.totalResults = totalResults;
    return this;
  }

//  public Dates getDates() {
//    return dates;
//  }
//
//  public void setDates(Dates dates) {
//    this.dates = dates;
//  }
//
//  public NowShowingMoviesResults withDates(Dates dates) {
//    this.dates = dates;
//    return this;
//  }

  public int getTotalPages() {
    return totalPages;
  }

  public void setTotalPages(int totalPages) {
    this.totalPages = totalPages;
  }

  public NowShowingMoviesResults withTotalPages(int totalPages) {
    this.totalPages = totalPages;
    return this;
  }


}
