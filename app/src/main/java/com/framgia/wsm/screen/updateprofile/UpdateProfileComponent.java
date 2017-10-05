package com.framgia.wsm.screen.updateprofile;

import android.content.Context;
import com.framgia.wsm.AppComponent;
import com.framgia.wsm.data.source.local.sharedprf.SharedPrefsApi;
import com.framgia.wsm.data.source.remote.api.service.WSMApi;
import com.framgia.wsm.screen.main.MainActivity;
import com.framgia.wsm.utils.dagger.ActivityScope;
import com.framgia.wsm.utils.rx.BaseSchedulerProvider;
import com.framgia.wsm.widget.dialog.DialogManager;
import dagger.Component;

/**
 * This is a Dagger component. Refer to {@link com.framgia.wsm.MainApplication} for the list of
 * Dagger components
 * used in this application.
 */
@ActivityScope
@Component(dependencies = AppComponent.class, modules = UpdateProfileModule.class)
public interface UpdateProfileComponent {
    void inject(UpdateProfileActivity updateProfileActivity);

    WSMApi nameApi();

    SharedPrefsApi sharedPrefsApi();

    Context applicationContext();

    BaseSchedulerProvider baseSchedulerProvider();

    DialogManager dialogManager();
}
