package id.web.faerul.boilerplate.util;

import io.reactivex.Observable;

/**
 * Created by faerulsalamun(faerulsalamun@gmail.com) on 11/11/16.
 */

public class RxWorker {

  public static Observable<Object> doInComputation(final Runnable runnable) {
    return Observable.create(subscriber -> {
      runnable.run();
      if (!subscriber.isDisposed()) {
        subscriber.onNext("We are done bro!");
      }
    }).compose(RxScheduler.applySchedulersComputation());
  }

  public static Observable<Object> doInIO(final Runnable runnable) {
    return Observable.create(subscriber -> {
      runnable.run();
      if (!subscriber.isDisposed()) {
        subscriber.onNext("We are done bro!");
      }
    }).compose(RxScheduler.applySchedulersIo());
  }

  public static Observable<Object> doInNewThread(final Runnable runnable) {
    return Observable.create(subscriber -> {
      runnable.run();
      if (!subscriber.isDisposed()) {
        subscriber.onNext("We are done bro!");
      }
    }).compose(RxScheduler.applySchedulersNewThread());
  }
}
