package com.framgia.wsm.screen.updateprofile.screen.GeneralInformation;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import com.framgia.wsm.utils.dagger.FragmentScope;
import dagger.Module;
import dagger.Provides;

/**
 * This is a Dagger module. We use this to pass in the View dependency to
 * the {@link GeneralInformationPresenter}.
 */
@Module
public class GeneralInformationModule {

    private Fragment mFragment;

    public GeneralInformationModule(@NonNull Fragment fragment) {
        this.mFragment = fragment;
    }

    @FragmentScope
    @Provides
    public GeneralInformationContract.ViewModel provideViewModel(
            GeneralInformationContract.Presenter presenter) {
        return new GeneralInformationViewModel(presenter);
    }

    @FragmentScope
    @Provides
    public GeneralInformationContract.Presenter providePresenter() {
        return new GeneralInformationPresenter();
    }
}
