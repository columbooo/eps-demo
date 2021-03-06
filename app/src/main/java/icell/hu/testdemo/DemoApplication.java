package icell.hu.testdemo;

import android.app.Application;

import icell.hu.testdemo.di.AppModule;
import icell.hu.testdemo.di.DaggerDemoComponent;
import icell.hu.testdemo.di.DemoComponent;
import icell.hu.testdemo.di.DemoModule;

/**
 * Created by ilaszlo on 13/09/16.
 */

public class DemoApplication extends Application {


    private DemoComponent demoComponent;
    private AppModule appModule;
    private DemoModule demoModule;

    // private RefWatcher refWatcher;

    @Override
    public void onCreate() {
        super.onCreate();

        appModule = new AppModule(this);
        demoModule = new DemoModule();

       /* if (!LeakCanary.isInAnalyzerProcess(this)) {                                                // heap analysis.
            refWatcher = LeakCanary.install(this);
        }*/
    }

    public DemoComponent getComponent() {
        if (demoComponent == null) {
            demoComponent = DaggerDemoComponent.builder()
                    .appModule(getAppModule())
                    .demoModule(getDemoModule())
                    .build();
        }
        return demoComponent;
    }

    public AppModule getAppModule() {
        if (appModule == null) {
            appModule = new AppModule(this);
        }
        return appModule;
    }

    public void setAppModule(AppModule appModule) {
        this.appModule = appModule;
    }

    public DemoModule getDemoModule() {
        if (demoModule == null) {
            demoModule = new DemoModule();
        }
        return demoModule;
    }

    public void setDemoModule(DemoModule demoModule) {
        this.demoModule = demoModule;
    }

/*
    public RefWatcher getRefWatcher() {

        return refWatcher;
    }
*/

    /**
     * Don't use! Just for Test!
     */
    public void reset() {
        demoComponent = null;
        appModule = null;
        demoModule = null;
    }
}
