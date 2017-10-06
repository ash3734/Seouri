package sopt.seouri.community;

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

public class B_list_Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    ArrayList<BulletinItem> bulletinItems;
    Context context;

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.b_list_recyler,parent,false);
        return new B_list_Viewholder(v);
    }

    public B_list_Adapter(ArrayList<BulletinItem> bulletinItems, Context context)
    {
        this.context = context;
        this.bulletinItems = bulletinItems;
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        B_list_Viewholder ViewHolder = (B_list_Viewholder) holder;
        ViewHolder.B_title.setText(bulletinItems.get(position).getB_title().toString());
        ViewHolder.B_writer.setText(bulletinItems.get(position).getB_writer().toString());
        ViewHolder.B_date.setText(bulletinItems.get(position).getB_date().toString());
        ViewHolder.B_views.setText(bulletinItems.get(position).getB_views() + " ");
    }

    @Override
    public int getItemCount() {
        return bulletinItems.size();
    }
}
