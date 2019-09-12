package gst.trainingcourse.final_mock.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import gst.trainingcourse.final_mock.R;
import gst.trainingcourse.final_mock.fragment.AppFragment;
import gst.trainingcourse.final_mock.fragment.MusicFragment;
import gst.trainingcourse.final_mock.fragment.PhotoFragment;
import gst.trainingcourse.final_mock.fragment.VideoFragment;


public class PageAdapter extends FragmentPagerAdapter {
    private Context mContext;

    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.category_app, R.string.category_music, R.string.category_photo, R.string.category_video};

    private int numOfTabs;

    public PageAdapter(FragmentManager fm, int numOfTabs) {
        super(fm);
        this.numOfTabs = numOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new AppFragment();
            case 1:

                return MusicFragment.newMusicInstance();

            case 2:
                return  PhotoFragment.newPhotoInstance();

            case 3:
                return new VideoFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numOfTabs;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(TAB_TITLES[position]);
    }
}