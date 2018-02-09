package com.framgia.wsm.screen.requestoff;

import android.util.Log;
import com.framgia.wsm.data.model.OffRequest;
import com.framgia.wsm.data.model.User;
import com.framgia.wsm.data.source.RequestRepository;
import com.framgia.wsm.data.source.UserRepository;
import com.framgia.wsm.data.source.remote.api.error.BaseException;
import com.framgia.wsm.data.source.remote.api.error.RequestError;
import com.framgia.wsm.data.source.remote.api.response.BaseResponse;
import com.framgia.wsm.utils.common.StringUtils;
import com.framgia.wsm.utils.rx.BaseSchedulerProvider;
import com.framgia.wsm.utils.validator.Validator;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.List;

/**
 * Listens to user actions from the UI ({@link RequestOffActivity}), retrieves the data and updates
 * the UI as required.
 */
final class RequestOffPresenter implements RequestOffContract.Presenter {
    private static final String TAG = RequestOffPresenter.class.getName();

    private RequestOffContract.ViewModel mViewModel;
    private UserRepository mUserRepository;
    private RequestRepository mRequestRepository;
    private BaseSchedulerProvider mSchedulerProvider;
    private CompositeDisposable mCompositeDisposable;
    private Validator mValidator;

    RequestOffPresenter(UserRepository userRepository, RequestRepository requestRepository,
            BaseSchedulerProvider baseSchedulerProvider, Validator validator) {
        mUserRepository = userRepository;
        mRequestRepository = requestRepository;
        mSchedulerProvider = baseSchedulerProvider;
        mCompositeDisposable = new CompositeDisposable();
        mValidator = validator;
    }

    @Override
    public void onStart() {
    }

    @Override
    public void onStop() {
        mCompositeDisposable.clear();
    }

    @Override
    public void setViewModel(RequestOffContract.ViewModel viewModel) {
        mViewModel = viewModel;
    }

    @Override
    public void getUser() {
        Disposable disposable = mUserRepository.getUser()
                .subscribeOn(mSchedulerProvider.io())
                .observeOn(mSchedulerProvider.ui())
                .subscribe(new Consumer<User>() {
                    @Override
                    public void accept(@NonNull User user) throws Exception {
                        mViewModel.onGetUserSuccess(user);
                    }
                }, new RequestError() {
                    @Override
                    public void onRequestError(BaseException error) {
                        mViewModel.onGetUserError(error);
                    }
                });
        mCompositeDisposable.add(disposable);
    }

    @Override
    public boolean validateData(OffRequest requestOff) {
        String errorMessage = mValidator.validateValueNonEmpty(requestOff.getReason());
        if (StringUtils.isNotBlank(errorMessage)) {
            mViewModel.onInputReasonError(errorMessage);
        }
        try {
            return mValidator.validateAll(requestOff);
        } catch (IllegalAccessException e) {
            Log.e(TAG, "validateDataInput: ", e);
            return false;
        }
    }

    @Override
    public void getListReplacement(int groupId) {
        Disposable disposable = mRequestRepository.getListReplacement(groupId)
                .subscribeOn(mSchedulerProvider.io())
                .observeOn(mSchedulerProvider.ui())
                .subscribe(new Consumer<BaseResponse<List<User>>>() {
                    @Override
                    public void accept(BaseResponse<List<User>> listBaseResponse) throws Exception {
                        mViewModel.onGetUserReplacementSuccess(listBaseResponse.getData());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        mViewModel.onGetUserError((BaseException) throwable);
                    }
                });
        mCompositeDisposable.add(disposable);
    }
}
