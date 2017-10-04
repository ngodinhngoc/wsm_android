package com.framgia.wsm.data.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by framgia on 03/10/2017.
 */

public class VehicleInfo extends BaseModel implements Parcelable {
    public static final Creator<VehicleInfo> CREATOR = new Creator<VehicleInfo>() {
        @Override
        public VehicleInfo createFromParcel(Parcel in) {
            return new VehicleInfo(in);
        }

        @Override
        public VehicleInfo[] newArray(int size) {
            return new VehicleInfo[size];
        }
    };
    @Expose
    @SerializedName("id")
    private int mId;
    @Expose
    @SerializedName("vehicle_type")
    private String mVehicleType;
    @Expose
    @SerializedName("license_plate")
    private String mLicensePlate;

    public VehicleInfo() {
    }

    protected VehicleInfo(Parcel in) {
        mId = in.readInt();
        mVehicleType = in.readString();
        mLicensePlate = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mId);
        dest.writeString(mVehicleType);
        dest.writeString(mLicensePlate);
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

    public String getVehicleType() {
        return mVehicleType;
    }

    public void setVehicleType(String vehicleType) {
        mVehicleType = vehicleType;
    }

    public String getLicensePlate() {
        return mLicensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        mLicensePlate = licensePlate;
    }
}
