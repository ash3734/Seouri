package sopt.seouri.community;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import sopt.seouri.R;
import sopt.seouri.application.ApplicationController;
import sopt.seouri.network.NetworkService;

import static sopt.seouri.MainActivity.fragmentManager;

/**
 * A simple {@link Fragment} subclass.
 */
public class GuBulletinListFragment extends Fragment {


    private Context context;
    private String location;

    BulletinItem bulletinItem, bulletinItem1, bulletinItem2;
    ArrayList<BulletinItem> bulletinItemArrayList;
    LinearLayoutManager layoutManager;
    RecyclerView recyclerView2;
    B_list_Adapter b_list_adapter;

    ArrayList<BulletinPostData> Data;

    private NetworkService service;
    LinearLayout Write_img;

    public GuBulletinListFragment() {
        // Required empty public constructor
    }

    private View.OnClickListener mClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int position = recyclerView2.getChildAdapterPosition(v);
//            Toast.makeText(getActivity(),bulletinItemArrayList.get(position).getB_title().toString(),Toast.LENGTH_SHORT).show();
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            BulletinDetail bulletinDetail = new BulletinDetail();
            bulletinDetail.setContext(context,Data.get(position));
            transaction.replace(R.id.container, bulletinDetail);
            transaction.commit();

        }
    };

    public void setContext(Context context, String location) {
        this.context = context;
        this.location = location;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup v = (ViewGroup) inflater.inflate(R.layout.fragment_gu_bulletin_list, container, false);

        service = ApplicationController.getInstance().getNetworkService();

        recyclerView2 = (RecyclerView) v.findViewById(R.id.guBulletin);
        Write_img = (LinearLayout) v.findViewById(R.id.write_img);
//        bulletinItemArrayList = new ArrayList<>();
        layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);             //리니어레이아웃의 형태이면 방향은 수직
        recyclerView2.setLayoutManager(layoutManager);

//        bulletinItem = new BulletinItem("작성자","제목1","2015-05-01",50);
//        bulletinItem1 = new BulletinItem("작성자","제목2","2015-05-01",50);
//        bulletinItem2 = new BulletinItem("작성자","제목3","2015-05-01",50);
//
//        bulletinItemArrayList.add(bulletinItem);
//        bulletinItemArrayList.add(bulletinItem1);
//        bulletinItemArrayList.add(bulletinItem2);

        Data = new ArrayList<BulletinPostData>();
        String a = "1";
        Call<FindBulletinResult> findbulletinresult = service.getFindBulletinResult("1");
        findbulletinresult.enqueue(new Callback<FindBulletinResult>() {
            @Override
            public void onResponse(Call<FindBulletinResult> call, Response<FindBulletinResult> response) {
                if (response.isSuccessful()) {
                    if (response.body().message.equals("Succeed in selecting posts"))
                    {
                            Data = response.body().posts;
                            b_list_adapter = new B_list_Adapter(Data, getContext(), mClickListener);
                            recyclerView2.setAdapter(b_list_adapter);
                            b_list_adapter.notifyDataSetChanged();
//                            //                        replyRecyclerViewAdapter = new ReplyRecyclerViewAdapter(itemdata,getApplicationContext(),postData,commentDatas);
//                            //                        recyclerView.setAdapter(replyRecyclerViewAdapter);
//                            //                        replyRecyclerViewAdapter.notifyDataSetChanged();
                    } else {
                        Toast.makeText(getContext(), "조회 실패", Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<FindBulletinResult> call, Throwable t) {
                Toast.makeText(getContext(), "통신 연결 실패", Toast.LENGTH_SHORT).show();
            }
        });

        Write_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                WriteFragment writeFragment = new WriteFragment();
                writeFragment.setContext(context);
                transaction.replace(R.id.container, writeFragment);
                transaction.commit();
            }
        });


        return v;
    }

}
