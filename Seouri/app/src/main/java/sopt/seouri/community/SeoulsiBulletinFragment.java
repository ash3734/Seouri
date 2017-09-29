package sopt.seouri.community;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import sopt.seouri.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SeoulsiBulletinFragment extends Fragment {


    public SeoulsiBulletinFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup viewGroup = (ViewGroup) inflater.inflate(R.layout.fragment_seoulsi_bulletin, container, false);



        return viewGroup;
    }

}
