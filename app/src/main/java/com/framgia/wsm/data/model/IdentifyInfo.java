package com.framgia.wsm.data.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by framgia on 02/10/2017.
 */

public class IdentifyInfo extends BaseModel implements Parcelable {
    public static final Creator<IdentifyInfo> CREATOR = new Creator<IdentifyInfo>() {
        @Override
        public IdentifyInfo createFromParcel(Parcel in) {
            return new IdentifyInfo(in);
        }

        @Override
        public IdentifyInfo[] newArray(int size) {
            return new IdentifyInfo[size];
        }
    };
    @Expose
    @SerializedName("id")
    private int mId;
    @Expose
    @SerializedName("identify_type")
    private String mIdentifyType;
    @Expose
    @SerializedName("date_issue")
    private String mDateIssue;
    @Expose
    @SerializedName("place_issue")
    private String mPlaceIssue;
    @Expose
    @SerializedName("code")
    private String mCode;
    @Expose
    @SerializedName("date_expiry")
    private String mDateExpiry;

    protected IdentifyInfo(Parcel in) {
        mId = in.readInt();
        mIdentifyType = in.readString();
        mDateIssue = in.readString();
        mDateExpiry = in.readString();
        mPlaceIssue = in.readString();
        mCode = in.readString();
    }

    IdentifyInfo() {
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public String getIdentifyType() {
        return mIdentifyType;
    }

    public void setIdentifyType(String identifyType) {
        mIdentifyType = identifyType;
    }

    public String getDateIssue() {
        return mDateIssue;
    }

    public void setDateIssue(String dateIssue) {
        mDateIssue = dateIssue;
    }

    public String getDateExpiry() {
        return mDateExpiry;
    }

    public void setDateExpiry(String dateExpiry) {
        mDateExpiry = dateExpiry;
    }

    public String getPlaceIssue() {
        return mPlaceIssue;
    }

    public void setPlaceIssue(String placeIssue) {
        mPlaceIssue = placeIssue;
    }

    public String getCode() {
        return mCode;
    }

    public void setCode(String code) {
        mCode = code;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(mId);
        parcel.writeString(mIdentifyType);
        parcel.writeString(mDateIssue);
        parcel.writeString(mDateExpiry);
        parcel.writeString(mPlaceIssue);
        parcel.writeString(mCode);
    }
}
