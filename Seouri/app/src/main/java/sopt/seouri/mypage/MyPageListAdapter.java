package sopt.seouri.mypage;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import sopt.seouri.R;

/**
 * Created by yangseunghyuk on 2017-09-30.
 */

public class MyPageListAdapter extends RecyclerView.Adapter<MyPageViewHolder> {

    ArrayList<String> datas;
    Context context;

    @Override
    public MyPageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.mypage_list_recyler,parent,false);
        return new MyPageViewHolder(v);
    }

    public MyPageListAdapter(ArrayList<String> bulletinItems, Context context) {
        this.context = context;
        this.datas = bulletinItems;
    }


    @Override
    public void onBindViewHolder(MyPageViewHolder holder, int position) {
        holder.textView.setText(datas.get(position));
    }

    @Override
    public int getItemCount() {
        return (datas != null) ? datas.size() : 0;
    }
}
