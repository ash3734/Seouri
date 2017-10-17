package sopt.seouri.mypage;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.mikhaellopez.circularimageview.CircularImageView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import sopt.seouri.R;
import sopt.seouri.application.ApplicationController;
import sopt.seouri.login.LoginActivity;
import sopt.seouri.mypage.networkData.MyPageData;
import sopt.seouri.mypage.networkData.MyPageResult;
import sopt.seouri.network.NetworkService;

/**
 * Created by ash on 2017-09-20.
 */

public class MyPageFragment extends Fragment {

    CircularImageView circularImageView;
    RecyclerView recyclerView;
    MyPageListAdapter myPageListAdapter;
    ArrayList<String> datas;
    LinearLayoutManager linearLayoutManager;
    TextView textViewName;
    RelativeLayout relativeLayoutLogout;
    NetworkService service;
    /*뭘 의미하는지는 모르겠음*/
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;

    Context context;


    public MyPageFragment() {
    }

    /*뭘 의미하는지는 모르겠음*/
    public static MyPageFragment newInstance(String param1, String param2) {
        MyPageFragment fragment = new MyPageFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
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
        service = ApplicationController.getInstance().getNetworkService();
        if (!ApplicationController.memberImg.equals(""))
            Glide.with(getActivity()).load(ApplicationController.memberImg).into(circularImageView);
        textViewName.setText(ApplicationController.memberName);
        relativeLayoutLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                        context);

                // 제목셋팅
                alertDialogBuilder.setTitle("로그아웃");

                // AlertDialog 셋팅
                alertDialogBuilder
                        .setMessage("\n정말 로그아웃 하실 것입니까?")
                        .setCancelable(false)
                        .setPositiveButton("취소",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(
                                            DialogInterface dialog, int id) {
                                        dialog.cancel();

                                    }
                                })
                        .setNegativeButton("확인",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(
                                            DialogInterface dialog, int id) {
                                        Intent intent = new Intent(getActivity(), LoginActivity.class);
                                        startActivity(intent);
                                        getActivity().finish();
                                    }
                                });

                // 다이얼로그 생성
                AlertDialog alertDialog = alertDialogBuilder.create();

                // 다이얼로그 보여주기
                alertDialog.show();

            }
        });
        Log.d("ash","userId in mypage"+ApplicationController.memberId);
        Call<MyPageResult> myPageResultCall = service.getMyPageResult(new MyPageData(ApplicationController.memberId));
        myPageResultCall.enqueue(new Callback<MyPageResult>() {
            @Override
            public void onResponse(Call<MyPageResult> call, Response<MyPageResult> response) {
                if (response.isSuccessful()) {
                    for (int i = 0; i < response.body().myPosts.size(); i++) {
                        datas.add(response.body().myPosts.get(i).title);
                    }
                    recyclerView.setHasFixedSize(true);
                    linearLayoutManager = new LinearLayoutManager(getActivity());
                    linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                    recyclerView.setLayoutManager(linearLayoutManager);
                    myPageListAdapter = new MyPageListAdapter(datas, getContext());
                    recyclerView.setAdapter(myPageListAdapter);
                } else {
                    Toast toast = Toast.makeText(getContext(), response.message(), Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                }
            }

            @Override
            public void onFailure(Call<MyPageResult> call, Throwable t) {
                Toast toast = Toast.makeText(getContext(), "네트워크 상태를 확인하세요", Toast.LENGTH_LONG);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
            }
        });

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.mypage_fragment, container, false);
        circularImageView = (CircularImageView) rootView.findViewById(R.id.mypage_circularImageView);
        recyclerView = (RecyclerView) rootView.findViewById(R.id.mypage_recyclerView);
        textViewName = (TextView) rootView.findViewById(R.id.mypage_name_text);
        relativeLayoutLogout = (RelativeLayout) rootView.findViewById(R.id.logout_btn);
        return rootView;
    }

    public void setContext(Context context) {
        this.context = context;
    }
}
