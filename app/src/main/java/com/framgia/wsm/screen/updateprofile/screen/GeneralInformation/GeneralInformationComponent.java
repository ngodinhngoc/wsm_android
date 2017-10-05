package com.framgia.wsm.screen.updateprofile.screen.GeneralInformation;

import com.framgia.wsm.screen.updateprofile.UpdateProfileComponent;
import com.framgia.wsm.utils.dagger.FragmentScope;
import dagger.Component;

/**
 * This is a Dagger component. Refer to {@link com.framgia.wsm.MainApplication}
 * for the list of Dagger components
 * used in this application.
 */
@FragmentScope
@Component(dependencies = UpdateProfileComponent.class, modules = GeneralInformationModule.class)
public interface GeneralInformationComponent {
    void inject(GeneralInformationFragment generalinformationFragment);
}
