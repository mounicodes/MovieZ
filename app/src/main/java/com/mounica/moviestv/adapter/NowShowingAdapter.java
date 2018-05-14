package com.mounica.moviestv.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.mounica.moviestv.R;
import com.mounica.moviestv.dataobjects.NowShowingMovies;
import com.mounica.moviestv.helper.Constants;
import com.mounica.moviestv.helper.GenreMap;
import java.util.List;

/**
 * Created by mounicachikkam on 5/9/18.
 */

public class NowShowingAdapter extends RecyclerView.Adapter<NowShowingAdapter.nowPlayingMoviesHolder> {

  List<NowShowingMovies> mNowShowingMoviesList;
  Context mContext;

  public NowShowingAdapter(Context context, List<NowShowingMovies> nowShowingMoviesList) {
    mContext = context;
    mNowShowingMoviesList = nowShowingMoviesList;
  }

  @NonNull
  @Override
  public nowPlayingMoviesHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(mContext).inflate(R.layout.now_playing_movies,null);
    return new nowPlayingMoviesHolder(view);
  }

  @Override
  public void onBindViewHolder(@NonNull nowPlayingMoviesHolder holder, int position) {
    NowShowingMovies movie = mNowShowingMoviesList.get(position);
    Glide.with(mContext)
        .load(Constants.BASE_URL_MOVIEBACKDROP_780+movie.getBackdropPath())
        .asBitmap()
        .into(holder.mBackDrop);
    holder.mTitle.setText(movie.getTitle());
    //get genres
    List<Integer> genreIds = movie.getGenreIds();
    String genreText = "";
    for(Integer genreId:genreIds){
      genreText += GenreMap.getGenreName(genreId) + ",";
    }
    holder.mGenre.setText(genreText.substring(0,genreText.length()-1));
    holder.mVoteAverage.setText(Double.toString(movie.getVoteAverage()));
  }

  @Override
  public int getItemCount() {
    return mNowShowingMoviesList.size();
  }

  public class nowPlayingMoviesHolder extends RecyclerView.ViewHolder {

    public ImageView mBackDrop;
    public TextView mTitle;
    public TextView mGenre;
    public TextView mVoteAverage;

    public nowPlayingMoviesHolder(View itemView) {
      super(itemView);
      mBackDrop = itemView.findViewById(R.id.moviebackdrop);
      mGenre = itemView.findViewById(R.id.genre);
      mVoteAverage = itemView.findViewById(R.id.voteaverage);
      mTitle = itemView.findViewById(R.id.movietitle);
    }
  }
}
