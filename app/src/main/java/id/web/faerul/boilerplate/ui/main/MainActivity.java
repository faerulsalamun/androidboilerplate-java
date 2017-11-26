package id.web.faerul.boilerplate.ui.main;

import android.os.Bundle;
import butterknife.BindView;
import butterknife.ButterKnife;
import id.web.faerul.boilerplate.R;
import id.web.faerul.boilerplate.data.model.Ribot;
import id.web.faerul.boilerplate.ui.base.BaseActivity;
import id.web.faerul.boilerplate.util.DialogFactory;
import id.web.faerul.boilerplate.util.customview.CustomRecyclerView;
import java.util.List;
import javax.inject.Inject;

public class MainActivity extends BaseActivity implements MainMvpView {

  @Inject MainPresenter mMainPresenter;
  @Inject MainAdapter mRibotsAdapter;

  @BindView(R.id.recycler_view) CustomRecyclerView mRecyclerView;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    activityComponent().inject(this);
    setContentView(R.layout.activity_main);
    ButterKnife.bind(this);

    mRecyclerView.setAdapter(mRibotsAdapter);
    mRecyclerView.setUpAsList();
    mMainPresenter.attachView(this);
    mMainPresenter.loadRibots();
  }

  @Override protected void onDestroy() {
    super.onDestroy();

    mMainPresenter.detachView();
  }

  /***** MVP View methods implementation *****/

  @Override public void showRibots(List<Ribot> ribots) {
    mRibotsAdapter.addAll(ribots);
    mRibotsAdapter.notifyDataSetChanged();
  }

  @Override public void showError(String message) {
    DialogFactory.createGenericErrorDialog(this, message).show();
  }

  @Override public void showRibotsEmpty() {
  }
}
