package kojimation.com.daggerretrofitrxandorid;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by muukojima on 2016/11/10.
 */

@Singleton
@Component(modules = {AppModule.class, ApiModule.class})
public interface AppComponent {
    void inject(MainActivity activity);
}
