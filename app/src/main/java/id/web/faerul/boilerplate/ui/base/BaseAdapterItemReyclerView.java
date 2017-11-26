package id.web.faerul.boilerplate.ui.base;

import android.content.Context;
import android.os.Handler;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by faerulsalamun(faerulsalamun@gmail.com) on 11/11/16.
 */

public abstract class BaseAdapterItemReyclerView<Data, Holder extends BaseItemRecyclerViewHolder>
    extends RecyclerView.Adapter<Holder> {

  protected Context context;
  protected List<Data> data;
  protected OnItemClickListener itemClickListener;
  protected OnLongItemClickListener longItemClickListener;
  private OnLoadMoreListener onLoadMoreListener;
  private LinearLayoutManager mLinearLayoutManager;
  private GridLayoutManager mGridLayoutManager;

  protected final int VIEW_TYPE_ITEM = 0;
  protected final int VIEW_TYPE_LOADING = 1;
  protected final int VIEW_TYPE_LOADING_NULL = 2;

  // For Load More
  private boolean isMoreLoading;
  private boolean isLastPage;
  private boolean isRefreshPage;
  private int visibleItemCount;
  private int lastVisibleItem;
  private int totalItemCount;

  public BaseAdapterItemReyclerView(Context context) {
    this.context = context;
    data = new ArrayList<>();
  }

  public BaseAdapterItemReyclerView(Context context, List<Data> data) {
    this.context = context;
    this.data = data;
  }

  protected View getView(ViewGroup parent, int viewType) {
    return LayoutInflater.from(context).inflate(getItemResourceLayout(viewType), parent, false);
  }

  protected abstract int getItemResourceLayout(int viewType);

  @Override public abstract Holder onCreateViewHolder(ViewGroup parent, int viewType);

  @Override public void onBindViewHolder(Holder holder, int position) {
    holder.bind(data.get(position));
  }

  @Override public int getItemCount() {
    try {
      return data.size();
    } catch (Exception e) {
      return 0;
    }
  }

  @Override public long getItemId(int position) {
    return position;
  }

  public void setOnItemClickListener(OnItemClickListener itemClickListener) {
    this.itemClickListener = itemClickListener;
  }

  public void setOnLongItemClickListener(OnLongItemClickListener longItemClickListener) {
    this.longItemClickListener = longItemClickListener;
  }

  public void setOnLoadMoreListener(OnLoadMoreListener onLoadMoreListener) {
    this.onLoadMoreListener = onLoadMoreListener;
  }

  public List<Data> getData() {
    return data;
  }

  public void add(Data item) {
    data.add(item);
    notifyItemInserted(data.size() - 1);
  }

  public void add(Data item, int position) {
    data.add(position, item);
    notifyItemInserted(position);
  }

  public void addAll(final List<Data> items) {
    //final int size = items.size();

    //RxWorker.doInComputation(() -> {
    //for (int i = 0; i < size; i++) {
    data.addAll(items);
    //}

    //}).subscribe(o -> {
    notifyDataSetChanged();
    //}, throwable -> {
    //});
  }

  public void addOrUpdate(Data item) {
    int i = data.indexOf(item);
    if (i >= 0) {
      data.set(i, item);
      notifyItemChanged(i);
    } else {
      add(item);
    }
  }

  public void addOrUpdate(final List<Data> items) {
    final int size = items.size();

    for (int i = 0; i < size; i++) {
      Data item = items.get(i);
      int x = data.indexOf(item);
      if (x >= 0) {
        data.set(x, item);
      } else {
        add(item);
      }
    }
  }

  public void remove(int position) {
    if (position >= 0 && position < data.size()) {
      data.remove(position);
      notifyItemRemoved(position);
    }
  }

  public void remove(Data item) {
    int position = data.indexOf(item);
    remove(position);
  }

  public void clear() {
    data.clear();
    notifyDataSetChanged();
  }

  public void setLinearLayoutManager(LinearLayoutManager linearLayoutManager) {
    this.mLinearLayoutManager = linearLayoutManager;
  }

  public void setGridLayoutManager(GridLayoutManager gridLayoutManager) {
    this.mGridLayoutManager = gridLayoutManager;
  }

  public void setRecyclerView(RecyclerView mView) {
    mView.addOnScrollListener(new RecyclerView.OnScrollListener() {
      @Override public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);

        if (mLinearLayoutManager != null) {
          totalItemCount = mLinearLayoutManager.getItemCount();
          lastVisibleItem = mLinearLayoutManager.findLastVisibleItemPosition();
        }

        if (mGridLayoutManager != null) {
          totalItemCount = mGridLayoutManager.getItemCount();
          lastVisibleItem = mGridLayoutManager.findLastVisibleItemPosition();
        }

        if (!isRefreshPage && !isMoreLoading && !isLastPage) {
          if (!recyclerView.canScrollVertically(1) && onLoadMoreListener != null) {
            onLoadMoreListener.onLoadMore();

            isMoreLoading = true;
          }
        }
      }
    });
  }

  public void setNestedRecyclerView(NestedScrollView mNestedScrollView) {
    mNestedScrollView.setOnScrollChangeListener(
        (NestedScrollView.OnScrollChangeListener) (v, scrollX, scrollY, oldScrollX, oldScrollY) -> {
          if (v.getChildAt(v.getChildCount() - 1) != null) {
            if ((scrollY >= (v.getChildAt(v.getChildCount() - 1).getMeasuredHeight()
                - v.getMeasuredHeight())) && scrollY > oldScrollY) {

              if (!isRefreshPage && !isMoreLoading && !isLastPage) {

                if (onLoadMoreListener != null) {

                  onLoadMoreListener.onLoadMore();
                  isMoreLoading = true;
                }
              }
            }
          }
        });
  }

  public void setProgressMore(final boolean isProgress) {
    if (isProgress) {
      new Handler().post(() -> {
        add(null);
      });
    } else {
      remove(data.size() - 1);
    }
  }

  public void setProgressMore(final boolean isProgress, final boolean isNotify) {
    if (isProgress) {
      data.add(null);
      notifyDataSetChanged();
    } else {
      remove(data.size() - 1);
    }
  }

  public void setProgressMore(final boolean isProgress, final int count) {
    if (isProgress) {
      for (int i = 0; i < count; i++) {
        add(null);
      }
    } else {
      for (int i = 0; i < count; i++) {
        remove(data.size() - 1);
      }
    }
  }

  public void setMoreLoading(boolean isMoreLoading) {
    this.isMoreLoading = isMoreLoading;
  }

  public void setLastPage(boolean isLastPage) {
    this.isLastPage = isLastPage;
  }

  public void setRefreshPage(boolean isRefreshPage) {
    this.isRefreshPage = isRefreshPage;
  }

  public interface OnItemClickListener {
    void onItemClick(View view, int position);
  }

  public interface OnLongItemClickListener {
    void onLongItemClick(View view, int position);
  }

  public interface OnLoadMoreListener {
    void onLoadMore();
  }
}
