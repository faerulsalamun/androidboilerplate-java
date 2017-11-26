package id.web.faerul.boilerplate.util.customview;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

/**
 * Created by faerulsalamun(faerulsalamun@gmail.com) on 11/11/16.
 */

public class CustomRecyclerView extends RecyclerView {

  private LinearLayoutManager mLinearLayoutManager;
  private GridLayoutManager mGridLayoutManager;

  public CustomRecyclerView(Context context) {
    super(context);
  }

  public CustomRecyclerView(Context context, AttributeSet attrs) {
    super(context, attrs);
  }

  public CustomRecyclerView(Context context, AttributeSet attrs, int defStyle) {
    super(context, attrs, defStyle);
  }

  public void setUpAsList() {
    setHasFixedSize(true);
    mLinearLayoutManager = new LinearLayoutManager(getContext());
    setLayoutManager(mLinearLayoutManager);
  }

  public void setUpAsGrid(int spanCount) {
    setHasFixedSize(true);
    mGridLayoutManager = new GridLayoutManager(getContext(), spanCount);
    setLayoutManager(mGridLayoutManager);
  }

  public LinearLayoutManager getLinearLayoutManager() {
    return mLinearLayoutManager;
  }

  public GridLayoutManager getGridLayoutManager() {
    return mGridLayoutManager;
  }
}
