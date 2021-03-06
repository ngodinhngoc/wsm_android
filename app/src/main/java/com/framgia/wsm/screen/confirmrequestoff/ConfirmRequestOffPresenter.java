package com.framgia.wsm.screen.confirmrequestoff;

import com.framgia.wsm.data.model.User;
import com.framgia.wsm.data.source.RequestRepository;
import com.framgia.wsm.data.source.UserRepository;
import com.framgia.wsm.data.source.remote.api.error.BaseException;
import com.framgia.wsm.data.source.remote.api.error.RequestError;
import com.framgia.wsm.data.source.remote.api.request.RequestOffRequest;
import com.framgia.wsm.utils.rx.BaseSchedulerProvider;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;

/**
 * Listens to user actions from the UI ({@link ConfirmRequestOffActivity}), retrieves the data and
 * updates
 * the UI as required.
 */
final class ConfirmRequestOffPresenter implements ConfirmRequestOffContract.Presenter {
    private static final String TAG = ConfirmRequestOffPresenter.class.getName();

    private ConfirmRequestOffContract.ViewModel mViewModel;
    private RequestRepository mRequestRepository;
    private UserRepository mUserRepository;
    private BaseSchedulerProvider mSchedulerProvider;
    private CompositeDisposable mCompositeDisposable;

    ConfirmRequestOffPresenter(UserRepository userRepository, RequestRepository requestRepository,
            BaseSchedulerProvider schedulerProvider) {
        mUserRepository = userRepository;
        mRequestRepository = requestRepository;
        mSchedulerProvider = schedulerProvider;
        mCompositeDisposable = new CompositeDisposable();
    }

    @Override
    public void onStart() {
    }

    @Override
    public void onStop() {
        mCompositeDisposable.clear();
    }

    @Override
    public void setViewModel(ConfirmRequestOffContract.ViewModel viewModel) {
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
    public void createFormRequestOff(RequestOffRequest requestOffRequest) {
        Disposable disposable = mRequestRepository.createFormRequestOff(requestOffRequest)
                .subscribeOn(mSchedulerProvider.io())
                .observeOn(mSchedulerProvider.ui())
                .doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(@NonNull Disposable disposable) throws Exception {
                        mViewModel.onShowIndeterminateProgressDialog();
                    }
                })
                .doAfterTerminate(new Action() {
                    @Override
                    public void run() throws Exception {
                        mViewModel.onDismissProgressDialog();
                    }
                })
                .subscribe(new Consumer<Object>() {
                    @Override
                    public void accept(@NonNull Object o) throws Exception {
                        mViewModel.onCreateFormRequestOffSuccess();
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(@NonNull Throwable throwable) throws Exception {
                        mViewModel.onCreateFormFormRequestOffError((BaseException) throwable);
                    }
                });
        mCompositeDisposable.add(disposable);
    }

    @Override
    public void deleteFormRequestOff(int requestOffId) {
        Disposable disposable = mRequestRepository.deleteFormRequestOff(requestOffId)
                .subscribeOn(mSchedulerProvider.io())
                .observeOn(mSchedulerProvider.ui())
                .doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(@NonNull Disposable disposable) throws Exception {
                        mViewModel.onShowIndeterminateProgressDialog();
                    }
                })
                .doAfterTerminate(new Action() {
                    @Override
                    public void run() throws Exception {
                        mViewModel.onDismissProgressDialog();
                    }
                })
                .subscribe(new Consumer<Object>() {
                    @Override
                    public void accept(@NonNull Object o) throws Exception {
                        mViewModel.onDeleteFormRequestOffSuccess();
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(@NonNull Throwable throwable) throws Exception {
                        mViewModel.onDeleteFormRequestOffError((BaseException) throwable);
                    }
                });
        mCompositeDisposable.add(disposable);
    }

    @Override
    public void editFormRequestOff(RequestOffRequest requestOffRequest) {
        Disposable disposable = mRequestRepository.editFormRequestOff(requestOffRequest)
                .subscribeOn(mSchedulerProvider.io())
                .observeOn(mSchedulerProvider.ui())
                .doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(@NonNull Disposable disposable) throws Exception {
                        mViewModel.onShowIndeterminateProgressDialog();
                    }
                })
                .doAfterTerminate(new Action() {
                    @Override
                    public void run() throws Exception {
                        mViewModel.onDismissProgressDialog();
                    }
                })
                .subscribe(new Consumer<Object>() {
                    @Override
                    public void accept(@NonNull Object o) throws Exception {
                        mViewModel.onEditFormRequestOffSuccess();
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(@NonNull Throwable throwable) throws Exception {
                        mViewModel.onEditFormRequestOffError((BaseException) throwable);
                    }
                });
        mCompositeDisposable.add(disposable);
    }
}
