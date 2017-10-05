package com.framgia.wsm.screen.updateprofile.screen.GeneralInformation;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.framgia.wsm.R;
import com.framgia.wsm.databinding.FragmentGeneralInformationBinding;
import com.framgia.wsm.screen.BaseFragment;
import com.framgia.wsm.screen.updateprofile.UpdateProfileActivity;
import javax.inject.Inject;

/**
 * GeneralInformation Screen.
 */
public class GeneralInformationFragment extends BaseFragment {

    @Inject
    GeneralInformationContract.ViewModel mViewModel;

    public static GeneralInformationFragment newInstance() {
        return new GeneralInformationFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {

        DaggerGeneralInformationComponent.builder()
                .updateProfileComponent(
                        ((UpdateProfileActivity) getActivity()).getUpdateProfileComponent())
                .generalInformationModule(new GeneralInformationModule(this))
                .build()
                .inject(this);

        FragmentGeneralInformationBinding binding =
                DataBindingUtil.inflate(inflater, R.layout.fragment_general_information, container,
                        false);
        binding.setViewModel((GeneralInformationViewModel) mViewModel);
        return binding.getRoot();
    }

    @Override
    public void onStart() {
        super.onStart();
        mViewModel.onStart();
    }

    @Override
    public void onStop() {
        mViewModel.onStop();
        super.onStop();
    }
}
