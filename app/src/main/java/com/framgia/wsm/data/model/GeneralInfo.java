package com.framgia.wsm.data.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by framgia on 02/10/2017.
 */

public class GeneralInfo extends BaseModel implements Parcelable {
    public static final Creator<GeneralInfo> CREATOR = new Creator<GeneralInfo>() {
        @Override
        public GeneralInfo createFromParcel(Parcel in) {
            return new GeneralInfo(in);
        }

        @Override
        public GeneralInfo[] newArray(int size) {
            return new GeneralInfo[size];
        }
    };
    @Expose
    @SerializedName("id")
    private int mId;
    @Expose
    @SerializedName("gender")
    private String mGender;
    @Expose
    @SerializedName("birthday")
    private String mBirthday;
    @Expose
    @SerializedName("personal_mail")
    private String mPersonalMail;
    @Expose
    @SerializedName("home_phone_number")
    private String mHomePhoneNumber;
    @Expose
    @SerializedName("nationality")
    private String mNationality;
    @Expose
    @SerializedName("married_status")
    private String mMarriedStatus;
    @Expose
    @SerializedName("number_of_childrent")
    private int mNumberOfChildrent;

    protected GeneralInfo(Parcel in) {
        mId = in.readInt();
        mGender = in.readString();
        mBirthday = in.readString();
        mPersonalMail = in.readString();
        mHomePhoneNumber = in.readString();
        mNationality = in.readString();
        mMarriedStatus = in.readString();
        mNumberOfChildrent = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mId);
        dest.writeString(mGender);
        dest.writeString(mBirthday);
        dest.writeString(mPersonalMail);
        dest.writeString(mHomePhoneNumber);
        dest.writeString(mNationality);
        dest.writeString(mMarriedStatus);
        dest.writeInt(mNumberOfChildrent);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public GeneralInfo() {
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public String getGender() {
        return mGender;
    }

    public void setGender(String gender) {
        mGender = gender;
    }

    public String getBirthday() {
        return mBirthday;
    }

    public void setBirthday(String birthday) {
        mBirthday = birthday;
    }

    public String getPersonalMail() {
        return mPersonalMail;
    }

    public void setPersonalMail(String personalMail) {
        mPersonalMail = personalMail;
    }

    public String getHomePhoneNumber() {
        return mHomePhoneNumber;
    }

    public void setHomePhoneNumber(String homePhoneNumber) {
        mHomePhoneNumber = homePhoneNumber;
    }

    public String getNationality() {
        return mNationality;
    }

    public void setNationality(String nationality) {
        mNationality = nationality;
    }

    public String getMarriedStatus() {
        return mMarriedStatus;
    }

    public void setMarriedStatus(String marriedStatus) {
        mMarriedStatus = marriedStatus;
    }

    public int getNumberOfChildrent() {
        return mNumberOfChildrent;
    }

    public void setNumberOfChildrent(int numberOfChildrent) {
        mNumberOfChildrent = numberOfChildrent;
    }
}
