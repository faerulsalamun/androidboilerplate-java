package id.web.faerul.boilerplate.data.local;

import android.support.annotation.VisibleForTesting;
import com.squareup.sqlbrite2.BriteDatabase;
import com.squareup.sqlbrite2.SqlBrite;
import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton public class DatabaseHelper {

  private final BriteDatabase mDb;

  @Inject public DatabaseHelper(DbOpenHelper dbOpenHelper) {
    this(dbOpenHelper, Schedulers.io());
  }

  @VisibleForTesting public DatabaseHelper(DbOpenHelper dbOpenHelper, Scheduler scheduler) {
    SqlBrite.Builder briteBuilder = new SqlBrite.Builder();
    mDb = briteBuilder.build().wrapDatabaseHelper(dbOpenHelper, scheduler);
  }

  public BriteDatabase getBriteDb() {
    return mDb;
  }
}
