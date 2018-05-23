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
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Adapter for Upcoming Movies
 */

public class UpcomingMoviesAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

  private Context mContext;
  private List<NowShowingMovies> mUpcomingMovies;

  public UpcomingMoviesAdapter(Context context,List<NowShowingMovies> upcomingMovies){
    mContext = context;
    mUpcomingMovies = upcomingMovies;
  }

  @NonNull
  @Override
  public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(mContext).inflate(R.layout.upcoming,null);
    return new UpcomingViewHolder(view);
  }

  @Override
  public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    NowShowingMovies movie = mUpcomingMovies.get(position);
    UpcomingViewHolder upcomingViewHolder = (UpcomingViewHolder) holder;
    //format date MMM D YYYY
    Calendar cal = Calendar.getInstance();
    cal.set(Calendar.YEAR,Integer.parseInt(movie.getReleaseDate().substring(0,4)));
    cal.set(Calendar.MONTH,Integer.parseInt(movie.getReleaseDate().substring(5,7)));
    cal.set(Calendar.DATE,Integer.parseInt(movie.getReleaseDate().substring(8)));
    String formatDate = new SimpleDateFormat("MMM d, yyyy").format(cal.getTime());
    upcomingViewHolder.mReleaseDate.setText(formatDate);
    Glide.with(mContext)
        .load(Constants.BASE_URL_MOVIEBACKDROP_780+movie.getPosterPath())
        .asBitmap()
        .centerCrop()
        .into(upcomingViewHolder.mUpcomingImage);
  }

  @Override
  public int getItemCount() {
    return mUpcomingMovies.size();
  }


  public class UpcomingViewHolder extends RecyclerView.ViewHolder{
    private ImageView mUpcomingImage;
    private TextView mReleaseDate;

    public UpcomingViewHolder(View itemView) {
      super(itemView);
      mUpcomingImage = itemView.findViewById(R.id.upcomingimage);
      mReleaseDate = itemView.findViewById(R.id.release);

      mUpcomingImage.getLayoutParams().width = (int) (mContext.getResources().getDisplayMetrics().widthPixels * 0.45);
      mUpcomingImage.getLayoutParams().height = (int) ((mContext.getResources().getDisplayMetrics().widthPixels * 0.45) / 0.70);
    }
  }
}
