package com.mounica.moviestv.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.mounica.moviestv.R;
import com.mounica.moviestv.dataobjects.NowShowingMovies;
import com.mounica.moviestv.helper.Constants;
import com.mounica.moviestv.helper.GenreMap;
import java.util.List;

public class NowShowingAdapter extends
    RecyclerView.Adapter<RecyclerView.ViewHolder> {

  List<NowShowingMovies> mNowShowingMoviesList;
  Context mContext;
  private static final int ITEM = 0;
  private static final int LOADING = 1;
  private boolean isLoadingAdded = false;

  public NowShowingAdapter(Context context, List<NowShowingMovies> nowShowingMoviesList) {
    mContext = context;
    mNowShowingMoviesList = nowShowingMoviesList;
  }

  @NonNull
  @Override
  public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    RecyclerView.ViewHolder viewHolder = null;
    switch(viewType) {
      case ITEM:
        View view = LayoutInflater.from(mContext).inflate(R.layout.now_playing_movies, null);
        viewHolder = new nowPlayingMoviesHolder(view);
      break;
      case LOADING:
        View progress = LayoutInflater.from(mContext).inflate(R.layout.item_progress,null);
        viewHolder = new loadingProgress(progress);
        break;
    }
  return viewHolder;
  }

  @Override
  public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
    NowShowingMovies movie = mNowShowingMoviesList.get(position);
    switch(getItemViewType(position)){
      case ITEM:
        nowPlayingMoviesHolder moviesHolder = (nowPlayingMoviesHolder) holder;
        Glide.with(mContext)
            .load(Constants.BASE_URL_MOVIEBACKDROP_780 + movie.getBackdropPath())
            .asBitmap()
            .into(moviesHolder.mBackDrop);
        moviesHolder.mTitle.setText(movie.getTitle());
        //get genres
        List<Integer> genreIds = movie.getGenreIds();
        String genreText = "";
        for (Integer genreId : genreIds) {
          genreText += GenreMap.getGenreName(genreId) + ",";
        }
        moviesHolder.mGenre.setText(genreText.substring(0, genreText.length() - 1));
        moviesHolder.mVoteAverage.setText(Double.toString(movie.getVoteAverage()));
        break;
      case LOADING:
      default:
        break;
    }
  }

  @Override
  public int getItemCount() {
    return mNowShowingMoviesList.size();
  }

  @Override
  public int getItemViewType(int position) {
    return (position == mNowShowingMoviesList.size() - 1 && isLoadingAdded) ? LOADING : ITEM;
  }

  protected class nowPlayingMoviesHolder extends RecyclerView.ViewHolder {

    private ImageView mBackDrop;
    private TextView mTitle;
    private TextView mGenre;
    private TextView mVoteAverage;

    public nowPlayingMoviesHolder(View itemView) {
      super(itemView);
      mBackDrop = itemView.findViewById(R.id.moviebackdrop);
      mGenre = itemView.findViewById(R.id.genre);
      mVoteAverage = itemView.findViewById(R.id.voteaverage);
      mTitle = itemView.findViewById(R.id.movietitle);
    }
  }

  protected class loadingProgress extends RecyclerView.ViewHolder{
    public loadingProgress(View progressView){
      super(progressView);
    }
  }
}
