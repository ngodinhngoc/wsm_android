package com.framgia.wsm.screen.updateprofile.screen.GeneralInformation;

/**
 * Listens to user actions from the UI ({@link GeneralInformationFragment}), retrieves the data and
 * updates
 * the UI as required.
 */
final class GeneralInformationPresenter implements GeneralInformationContract.Presenter {
    private static final String TAG = GeneralInformationPresenter.class.getName();

    private GeneralInformationContract.ViewModel mViewModel;

    public GeneralInformationPresenter() {
    }

    @Override
    public void onStart() {
    }

    @Override
    public void onStop() {
    }

    @Override
    public void setViewModel(GeneralInformationContract.ViewModel viewModel) {
        mViewModel = viewModel;
    }
}
