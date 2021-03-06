package com.framgia.wsm.data.source.remote.api.request;

import com.framgia.wsm.data.model.LeaveRequest;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by tri on 07/06/2017.
 */

public class OverTimeRequest extends BaseRequest {

    @SerializedName("request_overtime")
    @Expose
    private LeaveRequest mRequest;

    public LeaveRequest getRequest() {
        return mRequest;
    }

    public void setRequest(LeaveRequest request) {
        mRequest = request;
    }
}
