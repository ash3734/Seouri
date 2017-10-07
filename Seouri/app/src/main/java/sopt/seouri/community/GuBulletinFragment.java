package sopt.seouri.community;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import sopt.seouri.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class GuBulletinFragment extends Fragment {


    GuBulletinFirstFragmnet guBulletinFirstFragmnet;
    GuBulletinListFragment guBulletinListFragment;

    public GuBulletinFragment() {
        // Required empty public constructor
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public void onStart() {
        super.onStart();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View guView = (View)inflater.inflate(R.layout.fragment_gu_bulletin, container, false);

        guBulletinFirstFragmnet = (GuBulletinFirstFragmnet)getChildFragmentManager().findFragmentById(R.id.gubulletinmain);

        return guView;
    }
}
