package sopt.seouri.recommend;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import sopt.seouri.R;

import static sopt.seouri.MainActivity.fragmentManager;

/**
 * Created by ash on 2017-09-20.
 */

public class RecommendFragment extends Fragment {
    /*뭘 의미하는지는 모르겠음*/
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String  mParam1;
    private String  mParam2;
    Context context;
    private RelativeLayout relativeLayout1;
    private RelativeLayout relativeLayout2;
    private RelativeLayout relativeLayout3;
    private RelativeLayout relativeLayout4;
    private RelativeLayout relativeLayout5;

    public RecommendFragment() {
    }
    /*뭘 의미하는지는 모르겠음*/
    public static RecommendFragment newInstance(String param1, String param2){
        RecommendFragment fragment = new RecommendFragment();
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
      relativeLayout1.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              FragmentTransaction transaction = fragmentManager.beginTransaction();
              RecommendData recommendData = new RecommendData("북촌 고예마을 협동 조합","부가내용"
              ,"통인 시장","부가내용","북초 한옥 체험","부가내용","북촌 데이트","",R.drawable.bookchon_bg);
              RecommendDetailFragment recommendDetailFragment = new RecommendDetailFragment(recommendData);
              recommendDetailFragment.setContext(context);
              transaction.replace(R.id.container,recommendDetailFragment);
              transaction.addToBackStack(null);
              transaction.commit();
          }
      });
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.recommend_fragment, container, false);
        relativeLayout1 = (RelativeLayout)rootView.findViewById(R.id.reco_1);
        relativeLayout2 = (RelativeLayout)rootView.findViewById(R.id.reco_2);
        relativeLayout3 = (RelativeLayout)rootView.findViewById(R.id.reco_3);
        relativeLayout4 = (RelativeLayout)rootView.findViewById(R.id.reco_4);
        relativeLayout5 = (RelativeLayout)rootView.findViewById(R.id.reco_5);
        return rootView;
    }

    public void setContext(Context context) {
        this.context = context;
    }
}
