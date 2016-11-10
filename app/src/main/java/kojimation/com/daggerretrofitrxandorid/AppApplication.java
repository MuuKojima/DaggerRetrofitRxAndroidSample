package kojimation.com.daggerretrofitrxandorid;

import android.app.Application;

/**
 * Created by muukojima on 2016/11/10.
 */

public class AppApplication extends Application {

    private AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mAppComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .apiModule(new ApiModule())
                .build();
    }

    public AppComponent getAppComponent() {
        return mAppComponent;
    }
}
