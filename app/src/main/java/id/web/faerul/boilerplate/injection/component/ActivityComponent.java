package id.web.faerul.boilerplate.injection.component;

import dagger.Subcomponent;
import id.web.faerul.boilerplate.injection.PerActivity;
import id.web.faerul.boilerplate.injection.module.ActivityModule;
import id.web.faerul.boilerplate.ui.main.MainActivity;

/**
 * This component inject dependencies to all Activities across the application
 */
@PerActivity @Subcomponent(modules = ActivityModule.class) public interface ActivityComponent {

  void inject(MainActivity mainActivity);
}
