package com.framgia.wsm.data.source;

import com.framgia.wsm.data.model.LeaveType;
import com.framgia.wsm.data.model.OffType;
import com.framgia.wsm.data.model.OffTypeDay;
import com.framgia.wsm.data.model.Setting;
import com.framgia.wsm.data.model.User;
import com.framgia.wsm.data.source.remote.api.request.ChangePasswordRequest;
import com.framgia.wsm.data.source.remote.api.request.UpdateProfileRequest;
import com.framgia.wsm.data.source.remote.api.response.BaseResponse;
import com.framgia.wsm.data.source.remote.api.response.SignInDataResponse;
import io.reactivex.Observable;
import io.reactivex.Single;
import java.util.List;

/**
 * Created by le.quang.dao on 10/03/2017.
 */

public interface UserDataSource {
    /**
     * LocalData For User
     */
    interface LocalDataSource extends BaseLocalDataSource {
        void saveUser(User user);

        Observable<User> getUser();

        void clearData();

        User getUserCheckLogin();
    }

    /**
     * RemoteData For User
     */
    interface RemoteDataSource {
        Observable<BaseResponse<SignInDataResponse>> login(String userName, String password,
                String deviceId);

        Observable<Object> logout();

        Observable<BaseResponse<User>> getUserProfile(int userId);

        Observable<List<LeaveType>> getListLeaveType();

        Observable<List<OffType>> getListOffType();

        Observable<BaseResponse<OffTypeDay>> getRemainingDayOff();

        Observable<BaseResponse<User>> updateProfile(UpdateProfileRequest updateProfileRequest);

        Observable<Object> changePassword(ChangePasswordRequest changePasswordRequest);

        Single<BaseResponse<Setting>> getSetting();

        Single<Object> changeSetting(Setting setting);
    }
}
