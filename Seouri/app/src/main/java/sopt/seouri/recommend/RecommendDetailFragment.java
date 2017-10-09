package sopt.seouri.recommend;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import sopt.seouri.R;

/**
 * Created by ash on 2017-09-20.
 */

public class RecommendDetailFragment extends Fragment {
    /*뭘 의미하는지는 모르겠음*/
    /*private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String  mParam1;
    private String  mParam2;*/
    Context context;
    RecommendData recommendData;
    ImageView imageView;
    TextView textViewRecommendCommend;
    TextView textViewRecommendCompany1;
    TextView textViewRecommendCompany2;
    TextView textViewRecommendCompany3;
    TextView textViewRecommendCompanyComment1;
    TextView textViewRecommendCompanyComment2;
    TextView textViewRecommendCompanyComment3;


    public RecommendDetailFragment(RecommendData recommendData) {
        this.recommendData =recommendData;
    }
    /*뭘 의미하는지는 모르겠음*/
    /*public static RecommendDetailFragment newInstance(String param1, String param2){
        RecommendDetailFragment fragment = new RecommendDetailFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1,param1);
        args.putString(ARG_PARAM2,param2);
        fragment.setArguments(args);
        return fragment;
    }*/
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
        imageView.setImageResource(recommendData.recommendImg);
        textViewRecommendCommend.setText(recommendData.recommendComment);
        textViewRecommendCompany1.setText(recommendData.commpanyName1);
        textViewRecommendCompany2.setText(recommendData.commpanyName2);
        textViewRecommendCompany3.setText(recommendData.commpanyName3);
        textViewRecommendCompanyComment1.setText(recommendData.commpanyComment1);
        textViewRecommendCompanyComment2.setText(recommendData.commpanyComment2);
        textViewRecommendCompanyComment3.setText(recommendData.commpanyComment3);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.recommend_detail_fragment, container, false);
        imageView = (ImageView)rootView.findViewById(R.id.recommend_img);
        textViewRecommendCommend = (TextView)rootView.findViewById(R.id.recommend_commend);
        textViewRecommendCompany1 = (TextView)rootView.findViewById(R.id.reco_compa1);
        textViewRecommendCompany2 = (TextView)rootView.findViewById(R.id.reco_compa2);
        textViewRecommendCompany3 = (TextView)rootView.findViewById(R.id.reco_compa3);
        textViewRecommendCompanyComment1 = (TextView)rootView.findViewById(R.id.reco_coma_comment1);
        textViewRecommendCompanyComment2 = (TextView)rootView.findViewById(R.id.reco_coma_comment2);
        textViewRecommendCompanyComment3 = (TextView)rootView.findViewById(R.id.reco_coma_comment3);
        return rootView;
    }

    public void setContext(Context context) {
        this.context = context;
    }
}
