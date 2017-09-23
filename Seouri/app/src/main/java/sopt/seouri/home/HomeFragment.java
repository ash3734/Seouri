package sopt.seouri.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dev.sacot41.scviewpager.DotsView;
import com.dev.sacot41.scviewpager.SCViewPager;

import java.util.ArrayList;

import sopt.seouri.R;

/**
 * Created by ash on 2017-09-20.
 */

public class HomeFragment extends Fragment {
    /*뭘 의미하는지는 모르겠음*/
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String  mParam1;
    private String  mParam2;
    private SCViewPager mViewPager;
    private MPagerAdapter mPageAdapter;
    private DotsView mDotsView;
    private ArrayList<MainPagerData> pageDatas;

    public HomeFragment() {
    }
    /*뭘 의미하는지는 모르겠음*/
    public static HomeFragment newInstance(String param1,String param2){
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1,param1);
        args.putString(ARG_PARAM2,param2);
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onStart() {
        super.onStart();
        pageDatas = new ArrayList<MainPagerData>();
        pageDatas.add(new MainPagerData("1"));
        pageDatas.add(new MainPagerData("2"));
        pageDatas.add(new MainPagerData("3"));

        Log.d("ash","??");
        mPageAdapter = new MPagerAdapter(getChildFragmentManager(),pageDatas);
        mPageAdapter.setNumberOfPage(pageDatas.size());
        mPageAdapter.setFragmentBackgroundColor(R.color.theme_100);
        mViewPager.setAdapter(mPageAdapter);

        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                mDotsView.selectDot(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.home_fragment, container, false);
        mViewPager = (SCViewPager)rootView.findViewById(R.id.viewpager_main_activity);
        mDotsView = (DotsView)rootView.findViewById(R.id.dotsview_main);
        mDotsView.setDotRessource(R.drawable.dot_selected, R.drawable.dot_unselected);
        mDotsView.setNumberOfPage(3);
        Log.d("ash","!!");
        return rootView;
    }
}
