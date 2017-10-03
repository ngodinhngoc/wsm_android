package com.framgia.wsm.data.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by framgia on 02/10/2017.
 */

public class BankInfo extends BaseModel implements Parcelable {
    public static final Creator<BankInfo> CREATOR = new Creator<BankInfo>() {
        @Override
        public BankInfo createFromParcel(Parcel in) {
            return new BankInfo(in);
        }

        @Override
        public BankInfo[] newArray(int size) {
            return new BankInfo[size];
        }
    };
    @Expose
    @SerializedName("id")
    private int mId;
    @Expose
    @SerializedName("account_type")
    private String mAccountType;
    @Expose
    @SerializedName("bank_name")
    private String mBankName;
    @Expose
    @SerializedName("account_id")
    private String mAccountId;
    @Expose
    @SerializedName("tax_code")
    private String mTaxCode;

    protected BankInfo(Parcel in) {
        mId = in.readInt();
        mAccountType = in.readString();
        mBankName = in.readString();
        mAccountId = in.readString();
        mTaxCode = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mId);
        dest.writeString(mAccountType);
        dest.writeString(mBankName);
        dest.writeString(mAccountId);
        dest.writeString(mTaxCode);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public BankInfo() {
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public String getAccountType() {
        return mAccountType;
    }

    public void setAccountType(String accountType) {
        mAccountType = accountType;
    }

    public String getBankName() {
        return mBankName;
    }

    public void setBankName(String bankName) {
        mBankName = bankName;
    }

    public String getAccountId() {
        return mAccountId;
    }

    public void setAccountId(String accountId) {
        mAccountId = accountId;
    }

    public String getTaxCode() {
        return mTaxCode;
    }

    public void setTaxCode(String taxCode) {
        mTaxCode = taxCode;
    }
}
