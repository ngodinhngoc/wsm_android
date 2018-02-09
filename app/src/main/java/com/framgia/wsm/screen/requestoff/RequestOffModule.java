package com.framgia.wsm.screen.requestoff;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import com.framgia.wsm.data.model.OffRequest;
import com.framgia.wsm.data.source.RequestRepository;
import com.framgia.wsm.data.source.UserRepository;
import com.framgia.wsm.data.source.local.UserLocalDataSource;
import com.framgia.wsm.data.source.remote.RequestRemoteDataSource;
import com.framgia.wsm.data.source.remote.UserRemoteDataSource;
import com.framgia.wsm.utils.Constant;
import com.framgia.wsm.utils.dagger.ActivityScope;
import com.framgia.wsm.utils.navigator.Navigator;
import com.framgia.wsm.utils.rx.BaseSchedulerProvider;
import com.framgia.wsm.utils.validator.Validator;
import com.framgia.wsm.widget.dialog.DialogManager;
import com.framgia.wsm.widget.dialog.DialogManagerImpl;
import dagger.Module;
import dagger.Provides;

/**
 * This is a Dagger module. We use this to pass in the View dependency to
 * the {@link RequestOffPresenter}.
 */
@Module
public class RequestOffModule {

    private Activity mActivity;

    public RequestOffModule(@NonNull Activity activity) {
        this.mActivity = activity;
    }

    @ActivityScope
    @Provides
    public RequestOffContract.ViewModel provideViewModel(Context context,
            RequestOffContract.Presenter presenter, DialogManager dialogManager,
            Navigator navigator) {
        OffRequest requestOff =
                mActivity.getIntent().getExtras().getParcelable(Constant.EXTRA_REQUEST_OFF);
        int actionType = mActivity.getIntent().getExtras().getInt(Constant.EXTRA_ACTION_TYPE);
        return new RequestOffViewModel(context, presenter, dialogManager, navigator, requestOff,
                actionType);
    }

    @ActivityScope
    @Provides
    public RequestOffContract.Presenter providePresenter(UserRepository userRepository,
            RequestRepository requestRepository, BaseSchedulerProvider baseSchedulerProvider,
            Validator validator) {
        return new RequestOffPresenter(userRepository, requestRepository, baseSchedulerProvider,
                validator);
    }

    @ActivityScope
    @Provides
    public DialogManager provideDialogManager() {
        return new DialogManagerImpl(mActivity);
    }

    @ActivityScope
    @Provides
    Navigator provideNavigator() {
        return new Navigator(mActivity);
    }

    @ActivityScope
    @Provides
    UserRepository provideUserRepository(UserLocalDataSource userLocalDataSource,
            UserRemoteDataSource remoteDataSource) {
        return new UserRepository(userLocalDataSource, remoteDataSource);
    }

    @ActivityScope
    @Provides
    RequestRepository provideRequestRepository(RequestRemoteDataSource remoteDataSource) {
        return new RequestRepository(remoteDataSource);
    }

    @ActivityScope
    @Provides
    Validator provideValidator() {
        return new Validator(mActivity.getApplicationContext(), OffRequest.class);
    }
}
