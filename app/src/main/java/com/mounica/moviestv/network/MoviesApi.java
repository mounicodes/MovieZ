package com.mounica.moviestv.network;

import com.mounica.moviestv.dataobjects.GenreList;
import com.mounica.moviestv.dataobjects.NowShowingMoviesResults;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by mounicachikkam on 5/8/18.
 */

public interface MoviesApi {
  //Now playing movies
  @GET("movie/now_playing")
  Call<NowShowingMoviesResults> getNowShowingMovies(@Query("api_key") String apiKey, @Query("page") Integer page, @Query("region") String region);
  //get all genres
  @GET("genre/movie/list")
  Call<GenreList> getGenreList(@Query("api_key") String apiKey);
  //Popular movies
  @GET("movie/popular")
  Call<NowShowingMoviesResults> getPopularMovies(@Query("api_key") String apiKey, @Query("page") Integer page);
}
