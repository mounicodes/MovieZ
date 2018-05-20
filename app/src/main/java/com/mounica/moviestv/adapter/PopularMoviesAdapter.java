package com.mounica.moviestv.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.mounica.moviestv.R;
import com.mounica.moviestv.dataobjects.NowShowingMovies;
import com.mounica.moviestv.helper.Constants;
import java.util.List;

/**
 * TODO: Write class purpose
 */
public class PopularMoviesAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

  private List<NowShowingMovies> mPopularMovieList;
  private Context mContext;

  public PopularMoviesAdapter(Context context, List<NowShowingMovies> popularMovieList) {
    mContext = context;
    mPopularMovieList = popularMovieList;
  }

  @NonNull
  @Override
  public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(mContext).inflate(R.layout.popular_movies, null);
    return new PopularViewHolder(view);
  }

  @Override
  public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    NowShowingMovies popularMovie = mPopularMovieList.get(position);
    PopularViewHolder popularViewHolder = (PopularViewHolder) holder;
    popularViewHolder.mPopularTitle.setText(popularMovie.getTitle());
    Glide.with(mContext)
        .load(Constants.BASE_URL_MOVIEBACKDROP_780 + popularMovie.getBackdropPath())
        .asBitmap()
        .into(popularViewHolder.mPopularImage);
  }

  @Override
  public int getItemCount() {
    return mPopularMovieList.size();
  }

  private class PopularViewHolder extends RecyclerView.ViewHolder {

    ImageView mPopularImage;
    TextView mPopularTitle;

    public PopularViewHolder(View itemView) {
      super(itemView);
      mPopularImage = itemView.findViewById(R.id.popularimage);
      mPopularTitle = itemView.findViewById(R.id.populartitle);
    }
  }
}
