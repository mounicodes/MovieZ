package com.mounica.moviestv.adapter;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

/**
 * Created by mounicachikkam on 5/14/18.
 */

public abstract class PaginationListener extends RecyclerView.OnScrollListener {

  LinearLayoutManager mLayoutManager;

  public PaginationListener(LinearLayoutManager linearLayoutManager) {
    mLayoutManager = linearLayoutManager;
  }

  @Override
  public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
    int childrenCount = mLayoutManager.getChildCount();
    int itemCount = mLayoutManager.getItemCount();
    int firstVisibleItemPosition = mLayoutManager.findFirstVisibleItemPosition();

    if (!isLoading() && !isLastPage()) {
      if ((childrenCount + firstVisibleItemPosition) >= itemCount
          && firstVisibleItemPosition >= 0) {
        loadMoreItems();
      }
    }
  }

  protected abstract void loadMoreItems();

  public abstract int getTotalPageCount();

  public abstract boolean isLastPage();

  public abstract boolean isLoading();


}
