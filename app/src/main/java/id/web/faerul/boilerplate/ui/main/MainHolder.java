package id.web.faerul.boilerplate.ui.main;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import butterknife.BindView;
import id.web.faerul.boilerplate.R;
import id.web.faerul.boilerplate.data.model.Ribot;
import id.web.faerul.boilerplate.ui.base.BaseAdapterItemReyclerView;
import id.web.faerul.boilerplate.ui.base.BaseItemRecyclerViewHolder;

/**
 * Created by faerulsalamun on 26/11/17.
 */

public class MainHolder extends BaseItemRecyclerViewHolder<Ribot> {

  @BindView(R.id.text_name) TextView mTextName;

  public MainHolder(Context mContext, View itemView,
      BaseAdapterItemReyclerView.OnItemClickListener itemClickListener,
      BaseAdapterItemReyclerView.OnLongItemClickListener longItemClickListener) {
    super(mContext, itemView, itemClickListener, longItemClickListener);
  }

  @Override public void bind(Ribot ribot) {
    mTextName.setText(ribot.getProfile().getName().getFirst());
  }
}
