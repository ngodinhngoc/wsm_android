package com.framgia.wsm.data.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by framgia on 02/10/2017.
 */

public class Address extends BaseModel implements Parcelable {
    public static final Creator<Address> CREATOR = new Creator<Address>() {
        @Override
        public Address createFromParcel(Parcel in) {
            return new Address(in);
        }

        @Override
        public Address[] newArray(int size) {
            return new Address[size];
        }
    };
    @Expose
    @SerializedName("id")
    private int mId;
    @Expose
    @SerializedName("distance_from_office")
    private int mDistanceFromOffice;
    @Expose
    @SerializedName("place_of_birth")
    private String mPlaceOfBirth;
    @Expose
    @SerializedName("current_address")
    private String mCurrentAddress;
    @Expose
    @SerializedName("permanent_address")
    private String mPermanentAddress;

    protected Address(Parcel in) {
        mId = in.readInt();
        mDistanceFromOffice = in.readInt();
        mPlaceOfBirth = in.readString();
        mCurrentAddress = in.readString();
        mPermanentAddress = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mId);
        dest.writeInt(mDistanceFromOffice);
        dest.writeString(mPlaceOfBirth);
        dest.writeString(mCurrentAddress);
        dest.writeString(mPermanentAddress);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public int getDistanceFromOffice() {
        return mDistanceFromOffice;
    }

    public void setDistanceFromOffice(int distanceFromOffice) {
        mDistanceFromOffice = distanceFromOffice;
    }

    public String getPlaceOfBirth() {
        return mPlaceOfBirth;
    }

    public void setPlaceOfBirth(String placeOfBirth) {
        mPlaceOfBirth = placeOfBirth;
    }

    public String getCurrentAddress() {
        return mCurrentAddress;
    }

    public void setCurrentAddress(String currentAddress) {
        mCurrentAddress = currentAddress;
    }

    public String getPermanentAddress() {
        return mPermanentAddress;
    }

    public void setPermanentAddress(String permanentAddress) {
        mPermanentAddress = permanentAddress;
    }
}
