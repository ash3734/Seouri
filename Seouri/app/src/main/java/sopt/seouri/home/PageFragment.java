package sopt.seouri.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import sopt.seouri.R;

/**
 * Created by ash on 2017-09-23.
 */

public class PageFragment extends Fragment{
    ArrayList<MainPagerData> mDatas;
    int position;
    public static PageFragment create(ArrayList<MainPagerData> datas, int position) {

        PageFragment fragment = new PageFragment();
        Bundle args = new Bundle();
        args.putSerializable("pageDatas", datas);
        args.putInt("position",position);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onStart() {
        super.onStart();
        mDatas = (ArrayList<MainPagerData>) getArguments().getSerializable("pageDatas");
        position = getArguments().getInt("position");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.page_fragment, container, false);
        return rootView;
    }
}
