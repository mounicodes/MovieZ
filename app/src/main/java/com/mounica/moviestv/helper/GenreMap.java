package com.mounica.moviestv.helper;

import com.mounica.moviestv.dataobjects.Genre;
import java.util.HashMap;
import java.util.List;

/**
 * Created by mounicachikkam on 5/9/18.
 */

public class GenreMap {

  private static HashMap<Integer, String> genresMap;

  public static boolean isGenreListLoaded(){
    return (genresMap!=null);
  }

  public static void loadGenresList(List<Genre> genres) {
    if (genres == null) {
      return;
    }
    genresMap = new HashMap<>();
    for (Genre genre : genres) {
      genresMap.put(genre.getId(), genre.getName());
    }
  }

  public static String getGenreName(Integer genreId) {
    if (genreId == null) {
      return null;
    }
    return genresMap.get(genreId);
  }
}
