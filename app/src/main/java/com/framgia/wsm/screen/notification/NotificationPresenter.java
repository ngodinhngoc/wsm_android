package com.framgia.wsm.screen.notification;

import com.framgia.wsm.data.source.NotificationRepository;
import com.framgia.wsm.data.source.remote.api.error.BaseException;
import com.framgia.wsm.data.source.remote.api.error.RequestError;
import com.framgia.wsm.data.source.remote.api.request.NotificationRequest;
import com.framgia.wsm.data.source.remote.api.response.BaseResponse;
import com.framgia.wsm.data.source.remote.api.response.NotificationResponse;
import com.framgia.wsm.utils.rx.BaseSchedulerProvider;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/**
 * Listens to user actions from the UI ({@link NotificationDialogFragment}), retrieves the data and
 * updates
 * the UI as required.
 */
final class NotificationPresenter implements NotificationContract.Presenter {
    private static final String TAG = NotificationPresenter.class.getName();

    private NotificationContract.ViewModel mViewModel;
    private NotificationRepository mNotificationRepository;
    private CompositeDisposable mCompositeDisposable;
    private BaseSchedulerProvider mSchedulerProvider;

    NotificationPresenter(NotificationRepository notificationRepository,
            BaseSchedulerProvider baseSchedulerProvider) {
        mNotificationRepository = notificationRepository;
        mCompositeDisposable = new CompositeDisposable();
        mSchedulerProvider = baseSchedulerProvider;
    }

    @Override
    public void onStart() {
    }

    @Override
    public void onStop() {
    }

    @Override
    public void setViewModel(NotificationContract.ViewModel viewModel) {
        mViewModel = viewModel;
    }

    @Override
    public void getNotification(int page) {
        Disposable subscription = mNotificationRepository.getNotification(page)
                .subscribeOn(mSchedulerProvider.io())
                .observeOn(mSchedulerProvider.ui())
                .subscribe(new Consumer<BaseResponse<NotificationResponse>>() {
                    @Override
                    public void accept(@NonNull BaseResponse<NotificationResponse> baseResponse)
                            throws Exception {
                        if (baseResponse != null && baseResponse.getData() != null) {
                            mViewModel.onGetNotificationSuccess(
                                    baseResponse.getData().getNotifications());
                        }
                    }
                }, new RequestError() {
                    @Override
                    public void onRequestError(BaseException error) {
                        mViewModel.onGetNotificationError(error);
                    }
                });
        mCompositeDisposable.add(subscription);
    }

    @Override
    public void setRead(NotificationRequest notificationRequest) {
        Disposable subscription = mNotificationRepository.setReadNotification(notificationRequest)
                .subscribeOn(mSchedulerProvider.io())
                .observeOn(mSchedulerProvider.ui())
                .subscribe(new Consumer<BaseResponse>() {
                    @Override
                    public void accept(@NonNull BaseResponse baseResponse) throws Exception {
                        mViewModel.onSetReadSuccess();
                    }
                }, new RequestError() {
                    @Override
                    public void onRequestError(BaseException error) {
                        mViewModel.onSetReadError(error);
                    }
                });
        mCompositeDisposable.add(subscription);
    }
}
