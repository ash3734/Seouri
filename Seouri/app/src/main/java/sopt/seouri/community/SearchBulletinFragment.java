package sopt.seouri.community;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import sopt.seouri.R;
import sopt.seouri.application.ApplicationController;
import sopt.seouri.network.NetworkService;

/**
 * A simple {@link Fragment} subclass.
 */
public class SearchBulletinFragment extends Fragment {

    Context context;

    private NetworkService service;

    public SearchBulletinFragment() {
        // Required empty public constructor
    }

    public void setContext(Context context){
        this.context = context;
    }

    RecyclerView S_recyclerview;
    LinearLayoutManager layoutManager2;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup v = (ViewGroup) inflater.inflate(R.layout.fragment_search_bulletin, container, false);

        service = ApplicationController.getInstance().getNetworkService();

        S_recyclerview = (RecyclerView)v.findViewById(R.id.Search_recyler);

        layoutManager2 = new LinearLayoutManager(getContext());
        layoutManager2.setOrientation(LinearLayoutManager.VERTICAL);             //리니어레이아웃의 형태이면 방향은 수직
        S_recyclerview.setLayoutManager(layoutManager2);

        return v;
    }

}
