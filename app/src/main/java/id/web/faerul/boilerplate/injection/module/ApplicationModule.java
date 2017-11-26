package id.web.faerul.boilerplate.injection.module;

import android.app.Application;
import android.content.Context;
import dagger.Module;
import dagger.Provides;
import id.web.faerul.boilerplate.data.remote.RestService;
import id.web.faerul.boilerplate.injection.ApplicationContext;
import javax.inject.Singleton;

/**
 * Provide application-level dependencies.
 */
@Module public class ApplicationModule {
  protected final Application mApplication;

  public ApplicationModule(Application application) {
    mApplication = application;
  }

  @Provides Application provideApplication() {
    return mApplication;
  }

  @Provides @ApplicationContext Context provideContext() {
    return mApplication;
  }

  @Provides @Singleton RestService provideRibotsService() {
    return RestService.Creator.newRibotsService();
  }
}
