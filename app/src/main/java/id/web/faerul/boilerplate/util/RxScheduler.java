package id.web.faerul.boilerplate.util;

import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by faerulsalamun(faerulsalamun@gmail.com) on 10/13/16.
 */

public class RxScheduler {

  public static <T> ObservableTransformer<T, T> applySchedulersComputation() {
    return observable -> observable.subscribeOn(Schedulers.computation())
        .observeOn(AndroidSchedulers.mainThread());
  }

  public static <T> ObservableTransformer<T, T> applySchedulersIo() {
    return observable -> observable.subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread());
  }

  public static <T> ObservableTransformer<T, T> applySchedulersNewThread() {
    return observable -> observable.subscribeOn(Schedulers.newThread())
        .observeOn(AndroidSchedulers.mainThread());
  }
}