package id.web.faerul.boilerplate.ui.main;

import android.app.Activity;
import android.view.ViewGroup;
import id.web.faerul.boilerplate.R;
import id.web.faerul.boilerplate.data.model.Ribot;
import id.web.faerul.boilerplate.ui.base.BaseAdapterItemReyclerView;
import id.web.faerul.boilerplate.ui.base.BaseItemRecyclerViewHolder;
import javax.inject.Inject;

public class MainAdapter
    extends BaseAdapterItemReyclerView<Ribot, BaseItemRecyclerViewHolder<?>> {

  @Inject public MainAdapter(Activity activity) {
    super(activity);
  }

  @Override protected int getItemResourceLayout(int viewType) {
    return viewType == VIEW_TYPE_ITEM ? R.layout.item_ribot : R.layout.item_ribot;
  }

  @Override
  public BaseItemRecyclerViewHolder<?> onCreateViewHolder(ViewGroup parent, int viewType) {

    if (viewType == VIEW_TYPE_ITEM) {
      return new MainHolder(context, getView(parent, viewType), itemClickListener,
          longItemClickListener);
    } else if (viewType == VIEW_TYPE_LOADING) {
      return new MainHolder(context, getView(parent, viewType), itemClickListener,
          longItemClickListener);
    }
    return null;
  }

  @Override public int getItemViewType(int position) {
    return data.get(position) == null ? VIEW_TYPE_LOADING : VIEW_TYPE_ITEM;
  }
}
