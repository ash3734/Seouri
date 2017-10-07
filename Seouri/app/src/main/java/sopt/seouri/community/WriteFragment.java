package sopt.seouri.community;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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
public class WriteFragment extends Fragment {
    private Context context;

    Button complete;
    EditText W_title;
    EditText W_content;

    GuBulletinListFragment guBulletinListFragment;

    String w_title;
    String w_content;

    NetworkService service;

    public WriteFragment() {
        // Required empty public constructor
    }

    public void setContext(Context context){
        this.context = context;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup v = (ViewGroup) inflater.inflate(R.layout.fragment_write, container, false);

        service = ApplicationController.getInstance().getNetworkService();

        W_title = (EditText)v.findViewById(R.id.W_title);
        W_content = (EditText)v.findViewById(R.id.W_content);


        guBulletinListFragment = new GuBulletinListFragment();

        complete = (Button)v.findViewById(R.id.W_complete);
        complete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                w_content = W_content.getText().toString();
                w_title = W_title.getText().toString();

                BulletinAddPostData bulletinAddPostData = new BulletinAddPostData();
                bulletinAddPostData.userId = "1";
                bulletinAddPostData.title = "게시글 제목";
                bulletinAddPostData.setContent("게시글 내용");
                bulletinAddPostData.location = "1";

                Call<BulletinAddPostResult> bulletinAddPostResultCall  = service.getBulletinAddPostResult(bulletinAddPostData);
                bulletinAddPostResultCall.enqueue(new Callback<BulletinAddPostResult>() {
                    @Override
                    public void onResponse(Call<BulletinAddPostResult> call, Response<BulletinAddPostResult> response) {
                        if(response.isSuccessful())
                        {
                            if(response.body().message.equals("Succeed in inserting post.")) {
                                Toast.makeText(getContext(), "게시글 등록 성공", Toast.LENGTH_SHORT).show();

                                FragmentTransaction transaction = fragmentManager.beginTransaction();
                                guBulletinListFragment.setContext(getContext(), "1");
                                transaction.replace(R.id.container, guBulletinListFragment);
                                transaction.commit();
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<BulletinAddPostResult> call, Throwable t) {
                        Toast.makeText(getContext(), "통신 실패", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        return  v;
    }

}
