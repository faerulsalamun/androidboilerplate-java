package id.web.faerul.boilerplate.ui.main;

import id.web.faerul.boilerplate.data.DataManager;
import id.web.faerul.boilerplate.injection.ConfigPersistent;
import id.web.faerul.boilerplate.ui.base.BasePresenter;
import id.web.faerul.boilerplate.util.RetrofitError;
import id.web.faerul.boilerplate.util.RxScheduler;
import id.web.faerul.boilerplate.util.RxUtil;
import io.reactivex.disposables.Disposable;
import javax.inject.Inject;

@ConfigPersistent public class MainPresenter extends BasePresenter<MainMvpView> {

  private final DataManager mDataManager;
  private Disposable mDisposable;

  @Inject public MainPresenter(DataManager dataManager) {
    mDataManager = dataManager;
  }

  @Override public void attachView(MainMvpView mvpView) {
    super.attachView(mvpView);
  }

  @Override public void detachView() {
    super.detachView();
    if (mDisposable != null) mDisposable.dispose();
  }

  public void loadRibots() {
    checkViewAttached();
    RxUtil.dispose(mDisposable);
    mDisposable =
        mDataManager.getRibots().compose(RxScheduler.applySchedulersIo()).subscribe(ribotList -> {
          getMvpView().showRibots(ribotList);
        }, throwable -> {
          getMvpView().showError(RetrofitError.handleError(throwable));
        });
  }
}
