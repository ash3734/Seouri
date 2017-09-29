package sopt.seouri.community;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import sopt.seouri.R;

/**
 * Created by ash on 2017-09-20.
 */

public class CommunityFragment extends Fragment {
    /*뭘 의미하는지는 모르겠음*/
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String  mParam1;
    private String  mParam2;

    public TabLayout tabLayout;
    public ViewPager viewPager;
    public CommunityMainAdapter communityMainAdapter;


    public CommunityFragment() {
    }
    /*뭘 의미하는지는 모르겠음*/
    public static CommunityFragment newInstance(String param1, String param2){
        CommunityFragment fragment = new CommunityFragment();
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
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.community_fragment, container, false);


        tabLayout = (TabLayout)rootView.findViewById(R.id.tab_layout);
        viewPager = (ViewPager)rootView.findViewById(R.id.view_pager);


        tabLayout.addTab(tabLayout.newTab().setText("구별 게시판"));
        tabLayout.addTab(tabLayout.newTab().setText("서울시 게시판"));
        //set equal tab interval
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        //creating Home_PageAdapter adapter
        communityMainAdapter = new CommunityMainAdapter(getChildFragmentManager());
        viewPager.setAdapter(communityMainAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener(){

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }
            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });

            return rootView;
    }
}
