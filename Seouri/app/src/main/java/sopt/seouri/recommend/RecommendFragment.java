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
import static sopt.seouri.MainActivity.toolbarImage;
import static sopt.seouri.MainActivity.toolbarText;

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
    public void onDestroyView() {
        super.onDestroyView();
        toolbarText.setText("");
    }

    @Override
    public void onStart() {
        super.onStart();
        toolbarImage.setVisibility(View.INVISIBLE);
        toolbarText.setText("마을기업 추천코스");
      relativeLayout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                RecommendData recommendData = new RecommendData("북촌 고예마을 협동 조합","부가내용"
                        ,"통인 시장","부가내용","북초 한옥 체험","부가내용",R.drawable.bookchon_text,R.drawable.bookchon,R.drawable.book);
                RecommendDetailFragment recommendDetailFragment = new RecommendDetailFragment(recommendData);
                recommendDetailFragment.setContext(context);
                transaction.replace(R.id.container,recommendDetailFragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
        relativeLayout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                RecommendData recommendData = new RecommendData("꿈 더하기 베이커리","부가내용"
                        ,"사랑 뻥뻥 사랑","부가내용","협동 조합 노느 메기","부가내용",R.drawable.eat_text,R.drawable.muckbang,R.drawable.muk);
                RecommendDetailFragment recommendDetailFragment = new RecommendDetailFragment(recommendData);
                recommendDetailFragment.setContext(context);
                transaction.replace(R.id.container,recommendDetailFragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
        relativeLayout3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                RecommendData recommendData = new RecommendData("노나매기 단체급식","부가내용"
                        ,"에너지 슈퍼마켓","부가내용","참 손길 협동조합","부가내용",R.drawable.healing_text,R.drawable.heal,R.drawable.heal_bg);
                RecommendDetailFragment recommendDetailFragment = new RecommendDetailFragment(recommendData);
                recommendDetailFragment.setContext(context);
                transaction.replace(R.id.container,recommendDetailFragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
        relativeLayout4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                RecommendData recommendData = new RecommendData("나눔 카페 앤 가게","부가내용"
                        ,"문화 예술 협동조합","부가내용","","",R.drawable.coffee_text,R.drawable.cogge,R.drawable.cof);
                RecommendDetailFragment recommendDetailFragment = new RecommendDetailFragment(recommendData);
                recommendDetailFragment.setContext(context);
                transaction.replace(R.id.container,recommendDetailFragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
        relativeLayout5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                RecommendData recommendData = new RecommendData("국악 나루","부가내용"
                        ,"홍스 공방","부가내용","놀자 씨씨","부가내용",R.drawable.drink_text,R.drawable.drink,R.drawable.guk);
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
