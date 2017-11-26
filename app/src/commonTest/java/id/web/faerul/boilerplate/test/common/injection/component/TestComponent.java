package id.web.faerul.boilerplate.test.common.injection.component;

import javax.inject.Singleton;

import dagger.Component;
import id.web.faerul.boilerplate.injection.component.ApplicationComponent;
import id.web.faerul.boilerplate.test.common.injection.module.ApplicationTestModule;

@Singleton
@Component(modules = ApplicationTestModule.class)
public interface TestComponent extends ApplicationComponent {

}
