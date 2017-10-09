package sopt.seouri.search.detail;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import sopt.seouri.R;
import sopt.seouri.application.ApplicationController;
import sopt.seouri.network.NetworkService;

/**
 * Created by 김지원 on 2017-10-06.
 */

public class SearchDetailFragment extends Fragment {
    private Context context;
    private String villageEnterpriseId;
    private NetworkService service;
    private TextView name, intro, newsName, news, homepage, phone, address;
    private ImageView image, coupon;
    private RecyclerView recyclerView;
    private SearchDetailResultData itemDatas;

    public SearchDetailFragment() {
    }

    public void setContext(Context context, String villageEnterpriseId){
        this.context = context;
        this.villageEnterpriseId = villageEnterpriseId;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        service = ApplicationController.getInstance().getNetworkService();
        LinearLayout layout = (LinearLayout)inflater.inflate(R.layout.search_detail,container,false);

        name = (TextView)layout.findViewById(R.id.search_detail_name);
        intro = (TextView)layout.findViewById(R.id.search_detail_intro);
        newsName = (TextView)layout.findViewById(R.id.search_detail_news_name);
        news = (TextView)layout.findViewById(R.id.search_detail_news);
        homepage = (TextView)layout.findViewById(R.id.search_detail_homepage);
        phone = (TextView)layout.findViewById(R.id.search_detail_phone);
        address = (TextView)layout.findViewById(R.id.search_detail_address);

        image = (ImageView)layout.findViewById(R.id.search_detail_image);
        coupon = (ImageView)layout.findViewById(R.id.search_detail_coupon);

        recyclerView = (RecyclerView)layout.findViewById(R.id.search_detail_recycler_picture);
        itemDatas = new SearchDetailResultData();

        Call<SearchDetailResult> searchDetailResultCall = service.getSearchDetailResult(villageEnterpriseId);
        searchDetailResultCall.enqueue(new Callback<SearchDetailResult>() {
            @Override
            public void onResponse(Call<SearchDetailResult> call, Response<SearchDetailResult> response) {
                if(response.isSuccessful()){
                    if(response.body().message.equals("Succeed in selecting Specific VillageEnterprise"))
                    itemDatas = response.body().specificVe;
                    name.setText(itemDatas.name);
                    intro.setText(itemDatas.detail);
                    newsName.setText(itemDatas.name +" 소식");
                    news.setText(itemDatas.article);
                    homepage.setText(itemDatas.url);
                    phone.setText(itemDatas.phone);
                    address.setText(itemDatas.address);
                }else {
                    Log.d("DetailFragment 통신에러",""+response.body().message);
                }
            }

            @Override
            public void onFailure(Call<SearchDetailResult> call, Throwable t) {
                Log.d("SearchDetailFragment","통신 실패");
            }
        });

        return layout;
    }
}
