package com.framgia.wsm.screen.managelistrequests;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.framgia.wsm.R;
import com.framgia.wsm.databinding.FragmentManageListRequestsBinding;
import com.framgia.wsm.screen.BaseFragment;
import com.framgia.wsm.screen.main.MainActivity;
import com.framgia.wsm.utils.Constant;
import com.framgia.wsm.utils.RequestType;
import javax.inject.Inject;

/**
 * Managelistrequests Screen.
 */
public class ManageListRequestsFragment extends BaseFragment {

    public static final String TAG = "ManageListRequestsFragment";

    @Inject
    ManageListRequestsContract.ViewModel mViewModel;

    public static ManageListRequestsFragment newInstance(@RequestType int requestType) {
        ManageListRequestsFragment listRequestFragment = new ManageListRequestsFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(Constant.EXTRA_REQUEST_TYPE, requestType);
        listRequestFragment.setArguments(bundle);
        return listRequestFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {

        DaggerManageListRequestsComponent.builder()
                .mainComponent(((MainActivity) getActivity()).getMainComponent())
                .manageListRequestsModule(new ManageListRequestsModule(this))
                .build()
                .inject(this);

        FragmentManageListRequestsBinding binding =
                DataBindingUtil.inflate(inflater, R.layout.fragment_manage_list_requests, container,
                        false);
        binding.setViewModel((ManageListRequestsViewModel) mViewModel);
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

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (!isVisibleToUser) {
            return;
        }
        mViewModel.onReloadData();
    }
}
