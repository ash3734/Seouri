package sopt.seouri.community;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import sopt.seouri.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class GuBulletinFragment extends Fragment {

    LinearLayout dobong;

    public GuBulletinFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup guView = (ViewGroup) inflater.inflate(R.layout.fragment_gu_bulletin, container, false);

        dobong = (LinearLayout)guView.findViewById(R.id.dobong);

        dobong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"게시판 글 목록 보여주기",Toast.LENGTH_SHORT).show();
            }
        });

        return guView;
    }

}
