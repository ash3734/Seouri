package sopt.seouri.community;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import sopt.seouri.R;
import sopt.seouri.adapters.GridAdapter;
import sopt.seouri.application.ApplicationController;
import sopt.seouri.network.NetworkService;

import static sopt.seouri.MainActivity.fragmentManager;

/**
 * Created by ash on 2017-09-20.
 */

public class CommunityFragment extends Fragment {
    /*뭘 의미하는지는 모르겠음*/
//    private static final String ARG_PARAM1 = "param1";
//    private static final String ARG_PARAM2 = "param2";
//    private String  mParam1;
//    private String  mParam2;

    public TabLayout tabLayout;
    public ViewPager viewPager;
    public CommunityMainAdapter communityMainAdapter;

    GridView gridView;
    GuBulletinListFragment guBulletinListFragment;

    NetworkService service;

    public CommunityFragment() {
    }
    /*뭘 의미하는지는 모르겠음*/
//    public static CommunityFragment newInstance(String param1, String param2){
//        CommunityFragment fragment = new CommunityFragment();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1,param1);
//        args.putString(ARG_PARAM2,param2);
//        fragment.setArguments(args);
//        return fragment;
//    }


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
            ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.community_fragment, container, false);

        service = ApplicationController.getInstance().getNetworkService();

        String[] countryList = getResources().getStringArray(R.array.seoul);
        gridView = (GridView)rootView.findViewById(R.id.search_location_gridview2);
        gridView.setAdapter(new GridAdapter(getContext(), countryList));

        guBulletinListFragment = new GuBulletinListFragment();

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                guBulletinListFragment.setContext(getContext(), String.valueOf(position));
                transaction.replace(R.id.container,guBulletinListFragment);
                transaction.commit();
            }
        });

        return rootView;
    }


}
