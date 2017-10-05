package com.framgia.wsm.screen.updateprofile.screen.GeneralInformation;

/**
 * Exposes the data to be used in the GeneralInformation screen.
 */

public class GeneralInformationViewModel implements GeneralInformationContract.ViewModel {

    private GeneralInformationContract.Presenter mPresenter;

    public GeneralInformationViewModel(GeneralInformationContract.Presenter presenter) {
        mPresenter = presenter;
        mPresenter.setViewModel(this);
    }

    @Override
    public void onStart() {
        mPresenter.onStart();
    }

    @Override
    public void onStop() {
        mPresenter.onStop();
    }
}
