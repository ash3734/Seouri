package sopt.seouri.ask;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import sopt.seouri.R;
import sopt.seouri.application.ApplicationController;
import sopt.seouri.network.NetworkService;

import static sopt.seouri.MainActivity.fragmentManager;
import static sopt.seouri.MainActivity.toolbarImage;
import static sopt.seouri.MainActivity.toolbarText;

/**
 * Created by ash on 2017-09-20.
 */

public class AskPostFragment extends Fragment {
    Context context;
    private EditText editTextTitle;
    private EditText editTextContent;
    private RelativeLayout relativeLayoutConfirm;
    NetworkService service;

    public AskPostFragment() {
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
        toolbarText.setText("문의하기");

        service = ApplicationController.getInstance().getNetworkService();
        relativeLayoutConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Call<String> stringCall = service.getAskPostResult(new AskData(ApplicationController.memberId,editTextTitle.getText().toString(),editTextContent.getText().toString()));
                stringCall.enqueue(new Callback<String>() {
                    @Override
                    public void onResponse(Call<String> call, Response<String> response) {
                        if(response.isSuccessful()){
                            Toast toast = Toast.makeText(getContext(), "성공적으로 완료하였습니다.", Toast.LENGTH_LONG);
                            toast.show();
                            fragmentManager.popBackStack();
                        }else{
                            Toast toast = Toast.makeText(getContext(), response.message(), Toast.LENGTH_LONG);
                            toast.show();
                        }
                    }

                    @Override
                    public void onFailure(Call<String> call, Throwable t) {
                        Toast toast = Toast.makeText(getActivity(), "네트워크 상태를 확인하세요", Toast.LENGTH_LONG);
                        toast.setGravity(Gravity.CENTER, 0, 0);
                        toast.show();
                    }
                });
            }
        });

      }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.ask_post_fragment, container, false);
        editTextTitle = (EditText)rootView.findViewById(R.id.ask_post_title);
        editTextContent = (EditText)rootView.findViewById(R.id.ask_post_content);
        relativeLayoutConfirm = (RelativeLayout)rootView.findViewById(R.id.ask_post_confirm);
        return rootView;
    }

    public void setContext(Context context) {
        this.context = context;
    }
}
