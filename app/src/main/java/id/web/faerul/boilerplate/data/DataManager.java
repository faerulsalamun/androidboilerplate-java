package id.web.faerul.boilerplate.data;

import id.web.faerul.boilerplate.data.local.DatabaseHelper;
import id.web.faerul.boilerplate.data.local.PreferencesHelper;
import id.web.faerul.boilerplate.data.model.Ribot;
import id.web.faerul.boilerplate.data.remote.RestService;
import io.reactivex.Observable;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton public class DataManager {

  private final RestService mRibotsService;
  private final DatabaseHelper mDatabaseHelper;
  private final PreferencesHelper mPreferencesHelper;

  @Inject public DataManager(RestService ribotsService, PreferencesHelper preferencesHelper,
      DatabaseHelper databaseHelper) {
    mRibotsService = ribotsService;
    mPreferencesHelper = preferencesHelper;
    mDatabaseHelper = databaseHelper;
  }

  public PreferencesHelper getPreferencesHelper() {
    return mPreferencesHelper;
  }

  public Observable<List<Ribot>> getRibots() {
    return mRibotsService.getRibots();
  }
}
