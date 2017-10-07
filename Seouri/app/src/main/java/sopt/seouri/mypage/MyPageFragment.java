package sopt.seouri.mypage;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mikhaellopez.circularimageview.CircularImageView;

import java.util.ArrayList;

import sopt.seouri.R;

/**
 * Created by ash on 2017-09-20.
 */

public class MyPageFragment extends Fragment {

    CircularImageView circularImageView;
    RecyclerView recyclerView;
    MyPageListAdapter myPageListAdapter;
    ArrayList<String> datas;
    LinearLayoutManager linearLayoutManager;
    /*뭘 의미하는지는 모르겠음*/
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String  mParam1;
    private String  mParam2;

    public MyPageFragment() {
    }
    /*뭘 의미하는지는 모르겠음*/
    public static MyPageFragment newInstance(String param1, String param2){
        MyPageFragment fragment = new MyPageFragment();
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
        datas = new ArrayList<String>();
        datas.add("늘 배고픈 저년");
        datas.add("늘 배고픈 저년");
        datas.add("늘 졸린 윤떠");
        datas.add("늘 졸린 윤떠");
        recyclerView.setHasFixedSize(true);
        linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        myPageListAdapter = new MyPageListAdapter(datas,getContext());
        recyclerView.setAdapter(myPageListAdapter);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.mypage_fragment, container, false);
        circularImageView = (CircularImageView)rootView.findViewById(R.id.mypage_circularImageView);
        recyclerView = (RecyclerView)rootView.findViewById(R.id.mypage_recyclerView);

        return rootView;
    }
}
