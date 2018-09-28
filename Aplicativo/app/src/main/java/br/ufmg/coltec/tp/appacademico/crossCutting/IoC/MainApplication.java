package br.ufmg.coltec.tp.appacademico.crossCutting.IoC;

import android.app.Application;

public class MainApplication extends Application {
    private static AppComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        initDagger();
    }

    private void initDagger() {
        component = DaggerAppComponent
                .builder()
                .build();
    }

    public static AppComponent getComponent() {
        return component;
    }
}
