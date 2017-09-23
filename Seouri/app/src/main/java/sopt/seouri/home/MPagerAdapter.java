package sopt.seouri.home;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.dev.sacot41.scviewpager.SCViewPagerAdapter;

import java.util.ArrayList;

/**
 * Created by ash on 2017-07-15.
 */


public class MPagerAdapter extends SCViewPagerAdapter {
    ArrayList<MainPagerData> datas;

    public MPagerAdapter(FragmentManager fragmentManager, ArrayList<MainPagerData> datas) {
        super(fragmentManager);
        this.datas=datas;
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public Fragment getItem(int position) {
        return PageFragment.create(datas,position);
    }
}
