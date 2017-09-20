package sopt.seouri.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.home_fragment, container, false);


        return rootView;
    }
}
