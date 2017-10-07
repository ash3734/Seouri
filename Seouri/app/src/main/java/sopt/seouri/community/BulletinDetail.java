package sopt.seouri.community;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import sopt.seouri.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class BulletinDetail extends Fragment {

    Context context;
    String location;


    public void setContext(Context context, String location) {
        this.context = context;
        this.location = location;
    }


    public BulletinDetail() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.fragment_bulletin_detail, container, false);




        return rootView;
    }

}
