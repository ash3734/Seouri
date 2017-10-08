package sopt.seouri.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.text.util.Linkify;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.dev.sacot41.scviewpager.DotsView;
import com.dev.sacot41.scviewpager.SCViewPager;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import sopt.seouri.R;
import sopt.seouri.application.ApplicationController;
import sopt.seouri.home.networkData.PosterData;
import sopt.seouri.network.NetworkService;

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
    private ArrayList<PosterData> pageDatas;
    private ImageView imageViewWeek1;
    private ImageView imageViewWeek2;
    private TextView textViewWeek1;
    private TextView textViewWeek2;
    private TextView textViewNotice1;
    private TextView textViewNotice2;
    private TextView textViewNotice3;
    private TextView textViewNotice4;
    private TextView textViewNotice5;
    private TextView textViewJob1;
    private TextView textViewJob2;
    NetworkService service;

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
        pageDatas = new ArrayList<PosterData>();

        service = ApplicationController.getInstance().getNetworkService();
        Call<MainResult> mainResultCall = service.getMainResult();
        mainResultCall.enqueue(new Callback<MainResult>() {
            @Override
            public void onResponse(Call<MainResult> call, final Response<MainResult> response) {
                if(response.isSuccessful()){
                    if(response.body().message.equals("Succeed in home")){
                        pageDatas=response.body().poster;

                        mPageAdapter = new MPagerAdapter(getChildFragmentManager(),pageDatas);
                        mPageAdapter.setNumberOfPage(pageDatas.size());
                        mPageAdapter.setFragmentBackgroundColor(R.color.theme_100);
                        mDotsView.setNumberOfPage(pageDatas.size());
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
                        Glide.with(getActivity()).load(response.body().weekvillageEnterprise.get(0).photo).into(imageViewWeek1);
                        textViewWeek1.setText(response.body().weekvillageEnterprise.get(0).name);
                        Glide.with(getActivity()).load(response.body().weekvillageEnterprise.get(1).photo).into(imageViewWeek2);
                        textViewWeek2.setText(response.body().weekvillageEnterprise.get(1).name);

                        Linkify.TransformFilter transform = new Linkify.TransformFilter() {
                            @Override
                            public String transformUrl(Matcher match, String url) {
                                return "";
                            }
                        };

                        int flags = Pattern.CASE_INSENSITIVE;

                        textViewNotice1.setText(response.body().villageinformation.get(0).comment);
                        Pattern p = Pattern.compile(response.body().villageinformation.get(0).comment, flags);
                        Linkify.addLinks(textViewNotice1, p,response.body().villageinformation.get(0).inforUrl,null,transform);

                        textViewNotice2.setText(response.body().villageinformation.get(1).comment);
                        Pattern p2 = Pattern.compile(response.body().villageinformation.get(1).comment, flags);
                        Linkify.addLinks(textViewNotice2, p,response.body().villageinformation.get(1).inforUrl,null,transform);

                        textViewNotice3.setText(response.body().villageinformation.get(2).comment);
                        Pattern p3 = Pattern.compile(response.body().villageinformation.get(2).comment, flags);
                        Linkify.addLinks(textViewNotice3, p,response.body().villageinformation.get(2).inforUrl,null,transform);

                        textViewNotice4.setText(response.body().villageinformation.get(3).comment);
                        Pattern p4 = Pattern.compile(response.body().villageinformation.get(3).comment, flags);
                        Linkify.addLinks(textViewNotice4, p,response.body().villageinformation.get(3).inforUrl,null,transform);

                        textViewNotice5.setText(response.body().villageinformation.get(4).comment);
                        Pattern p5 = Pattern.compile(response.body().villageinformation.get(4).comment, flags);
                        Linkify.addLinks(textViewNotice5, p,response.body().villageinformation.get(4).inforUrl,null,transform);

                        textViewJob1.setText(response.body().jobinformation.get(0).jobcomment);
                        textViewJob2.setText(response.body().jobinformation.get(1).jobcomment);
                    }else{
                        Toast toast = Toast.makeText(getContext(), "서버 오류 입니다.", Toast.LENGTH_LONG);
                        toast.show();
                    }
                }else{
                    Toast toast = Toast.makeText(getContext(), response.message(), Toast.LENGTH_LONG);
                    toast.show();
                }
            }

            @Override
            public void onFailure(Call<MainResult> call, Throwable t) {
                Toast toast = Toast.makeText(getContext(), "네트워크 상태를 확인하세요", Toast.LENGTH_LONG);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
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

        imageViewWeek1 = (ImageView)rootView.findViewById(R.id.main_week_seouri_imge_1);
        imageViewWeek2 = (ImageView)rootView.findViewById(R.id.main_week_seouri_imge_2);
        textViewWeek1= (TextView) rootView.findViewById(R.id.main_week_seouri_text_1);
        textViewWeek2= (TextView) rootView.findViewById(R.id.main_week_seouri_text_2);
        textViewNotice1= (TextView) rootView.findViewById(R.id.main_notice_1);
        textViewNotice2= (TextView) rootView.findViewById(R.id.main_notice_2);
        textViewNotice3= (TextView) rootView.findViewById(R.id.main_notice_3);
        textViewNotice4= (TextView) rootView.findViewById(R.id.main_notice_4);
        textViewNotice5= (TextView) rootView.findViewById(R.id.main_notice_5);
        textViewJob1= (TextView) rootView.findViewById(R.id.main_job_1);
        textViewJob2= (TextView) rootView.findViewById(R.id.main_job_2);
        return rootView;
    }
}
