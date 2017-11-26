package id.web.faerul.boilerplate.injection.component;

import dagger.Subcomponent;
import id.web.faerul.boilerplate.injection.PerFragment;
import id.web.faerul.boilerplate.injection.module.FragmentModule;

/**
 * This component inject dependencies to all Activities across the application
 */
@PerFragment @Subcomponent(modules = FragmentModule.class) public interface FragmentComponent {

}
