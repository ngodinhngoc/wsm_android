package com.framgia.wsm.screen.updateprofile;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import com.framgia.wsm.R;
import com.framgia.wsm.screen.updateprofile.screen.GeneralInformation.GeneralInformationFragment;

/**
 * Created by framgia on 04/10/2017.
 */

public class UpdateProfileAdapter extends FragmentStatePagerAdapter {
    private Context mContext;
    private static final int TAB_NUMBER = 6;

    UpdateProfileAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        //TODO edit later
        switch (position) {
            case UpdateProfileViewModel.Tab.GENERAL:
                return GeneralInformationFragment.newInstance();
            case UpdateProfileViewModel.Tab.WORKING:
                return GeneralInformationFragment.newInstance();
            case UpdateProfileViewModel.Tab.CONTACT:
                return GeneralInformationFragment.newInstance();
            case UpdateProfileViewModel.Tab.RELATIVE:
                return GeneralInformationFragment.newInstance();
            case UpdateProfileViewModel.Tab.EDUCATION:
                return GeneralInformationFragment.newInstance();
            case UpdateProfileViewModel.Tab.OTHER:
                return GeneralInformationFragment.newInstance();
            default:
                return new Fragment();
        }
    }

    @Override
    public int getCount() {
        return TAB_NUMBER;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case UpdateProfileViewModel.Tab.GENERAL:
                return mContext.getString(R.string.general);
            case UpdateProfileViewModel.Tab.WORKING:
                return mContext.getString(R.string.working);
            case UpdateProfileViewModel.Tab.CONTACT:
                return mContext.getString(R.string.contact);
            case UpdateProfileViewModel.Tab.RELATIVE:
                return mContext.getString(R.string.relative);
            case UpdateProfileViewModel.Tab.EDUCATION:
                return mContext.getString(R.string.education);
            case UpdateProfileViewModel.Tab.OTHER:
                return mContext.getString(R.string.other);
            default:
                return null;
        }
    }
}
