package sopt.seouri.community;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import sopt.seouri.R;
import sopt.seouri.application.ApplicationController;
import sopt.seouri.network.NetworkService;

/**
 * A simple {@link Fragment} subclass.
 */
public class BulletinDetailMoreReplyFragment extends Fragment {

    Context context;
    ArrayList<CommentsData> commentsDataArrayList;
    String profile;

    ListView listView;
    ImageView addreply;
    EditText addreply_edit;

    ListViewAdapter mMyAdapter;

    NetworkService service;

    BulletinAddCommentData bulletinAddCommentData;

    ImageView R_proimg;

    public BulletinDetailMoreReplyFragment() {
        // Required empty public constructor
    }

    public void setContext(Context context, ArrayList<CommentsData> cData, String postId) {
        this.context = context;
        this.commentsDataArrayList = cData;
        this.profile = postId;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup v = (ViewGroup) inflater.inflate(R.layout.fragment_bulletin_detail_more_reply, container, false);

        listView = (ListView)v.findViewById(R.id.reply_list);
        addreply = (ImageView)v.findViewById(R.id.R_add_reply_img);
        addreply_edit = (EditText)v.findViewById(R.id.R_add_reply_edit);


        R_proimg = (ImageView)v.findViewById(R.id.DR_proimg);
        Glide.with(getContext()).load(profile).into(R_proimg);


        service = ApplicationController.getInstance().getNetworkService();

        mMyAdapter = new ListViewAdapter(commentsDataArrayList);
        listView.setAdapter(mMyAdapter);

        addreply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                String str3 = addreply_edit.getText().toString();
                bulletinAddCommentData = new BulletinAddCommentData();

                bulletinAddCommentData.userId = "1";
                bulletinAddCommentData.postId = commentsDataArrayList.get(0).postId;
                bulletinAddCommentData.setContent(str3);

                Call<BulletinAddCommentResult> bulletinAddCommentResultCall = service.getBulletinAddCommentResult(bulletinAddCommentData);
                bulletinAddCommentResultCall.enqueue(new Callback<BulletinAddCommentResult>() {
                    @Override
                    public void onResponse(Call<BulletinAddCommentResult> call, Response<BulletinAddCommentResult> response) {
                        if(response.isSuccessful())
                        {
                            mMyAdapter.notifyDataSetChanged();
                            listView.setAdapter(mMyAdapter);
                            Toast.makeText(getContext()," 댓글 등록 성공",Toast.LENGTH_SHORT).show();
                            addreply_edit.setText("");

                        }
                        else
                        {
                            Toast.makeText(getContext(),response.body().message.toString(),Toast.LENGTH_SHORT).show();

                        }
                    }

                    @Override
                    public void onFailure(Call<BulletinAddCommentResult> call, Throwable t) {
                        Toast.makeText(getContext()," 통신 실패",Toast.LENGTH_SHORT).show();

                    }
                });
            }
        });


        return v;
    }
}
