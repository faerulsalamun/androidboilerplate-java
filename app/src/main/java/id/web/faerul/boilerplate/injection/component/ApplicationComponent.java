package id.web.faerul.boilerplate.injection.component;

import android.app.Application;
import android.content.Context;
import dagger.Component;
import id.web.faerul.boilerplate.data.DataManager;
import id.web.faerul.boilerplate.data.local.DatabaseHelper;
import id.web.faerul.boilerplate.data.local.PreferencesHelper;
import id.web.faerul.boilerplate.data.remote.RestService;
import id.web.faerul.boilerplate.injection.ApplicationContext;
import id.web.faerul.boilerplate.injection.module.ApplicationModule;
import id.web.faerul.boilerplate.util.RxEventBus;
import javax.inject.Singleton;

@Singleton @Component(modules = ApplicationModule.class) public interface ApplicationComponent {

  @ApplicationContext Context context();

  Application application();

  RestService ribotsService();

  PreferencesHelper preferencesHelper();

  DatabaseHelper databaseHelper();

  DataManager dataManager();

  RxEventBus eventBus();
}
