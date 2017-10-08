package sopt.seouri.search.category;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TabHost;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import sopt.seouri.R;
import sopt.seouri.application.ApplicationController;
import sopt.seouri.network.NetworkService;


public class CategoryFragment extends Fragment {
    private Context context;
    private String location;
    private NetworkService service;
    private RecyclerView recyclerView1, recyclerView2, recyclerView3, recyclerView4, recyclerView5;
    private ArrayList<SearchCategoryResultData> itemData1, itemData2, itemData3, itemData4, itemData5;

    public CategoryFragment() {
    }

    public void setContext(Context context, String location) {
        this.context = context;
        this.location = location;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        service = ApplicationController.getInstance().getNetworkService();
        RelativeLayout layout = (RelativeLayout) inflater.inflate(R.layout.category_fragment, container, false);
        TabHost tabHost = (TabHost) layout.findViewById(R.id.category_tabhost);
        tabHost.setup();

        itemData1 = new ArrayList<>();
        itemData2 = new ArrayList<>();
        itemData3 = new ArrayList<>();
        itemData4 = new ArrayList<>();
        itemData5 = new ArrayList<>();

        recyclerView1 = (RecyclerView) layout.findViewById(R.id.recycler_category1);
        recyclerView1.setHasFixedSize(true);
//        LinearLayoutManager manager1 = new LinearLayoutManager(context);
//        manager1.setOrientation(LinearLayoutManager.VERTICAL);
//        recyclerView1.setLayoutManager(manager1);
        recyclerView1.setLayoutManager(new LinearLayoutManager(context));

        recyclerView2 = (RecyclerView) layout.findViewById(R.id.recycler_category2);
        recyclerView2.setHasFixedSize(true);
        recyclerView2.setLayoutManager(new LinearLayoutManager(context));

        recyclerView3 = (RecyclerView) layout.findViewById(R.id.recycler_category3);
        recyclerView3.setHasFixedSize(true);
        recyclerView3.setLayoutManager(new LinearLayoutManager(context));

        recyclerView4 = (RecyclerView) layout.findViewById(R.id.recycler_category4);
        recyclerView4.setHasFixedSize(true);
        recyclerView4.setLayoutManager(new LinearLayoutManager(context));

        recyclerView5 = (RecyclerView) layout.findViewById(R.id.recycler_category5);
        recyclerView5.setHasFixedSize(true);
        recyclerView5.setLayoutManager(new LinearLayoutManager(context));

        // 첫번째 탭
        TabHost.TabSpec ts1 = tabHost.newTabSpec("Tab Spec1");
        ts1.setContent(R.id.tab1);
        ts1.setIndicator("전체");
        tabHost.addTab(ts1);

        // 두번째 탭
        TabHost.TabSpec ts2 = tabHost.newTabSpec("Tab Spec2");
        ts2.setContent(R.id.tab2);
        ts2.setIndicator("놀거리");
        tabHost.addTab(ts2);

        // 세번째 탭
        TabHost.TabSpec ts3 = tabHost.newTabSpec("Tab Spec3");
        ts3.setContent(R.id.tab3);
        ts3.setIndicator("먹거리");
        tabHost.addTab(ts3);

        // 네번째 탭
        TabHost.TabSpec ts4 = tabHost.newTabSpec("Tab Spec4");
        ts4.setContent(R.id.tab4);
        ts4.setIndicator("구경거리");
        tabHost.addTab(ts4);

        // 다섯번째 탭
        TabHost.TabSpec ts5 = tabHost.newTabSpec("Tab Spec5");
        ts5.setContent(R.id.tab5);
        ts5.setIndicator("체험거리");
        tabHost.addTab(ts5);

        Call<SearchCategoryResult> searchCategoryResultCall = service.getSearchCategoryResult(location);
        searchCategoryResultCall.enqueue(new Callback<SearchCategoryResult>() {
            @Override
            public void onResponse(Call<SearchCategoryResult> call, Response<SearchCategoryResult> response) {
                if (response.isSuccessful()) {
                    if (response.body().message.equals("Succeed in selecting location")) {
//                        Toast.makeText(context, ""+response.body().list.get(0).name, Toast.LENGTH_SHORT).show();

                        // 통신 완료 후 주석처리
                        itemData1.add(new SearchCategoryResultData("1", "성북구 마을기업", "사진1", "1"));
                        itemData1.add(new SearchCategoryResultData("2", "혜화 마을기업", "사진2", "2"));
                        itemData1.add(new SearchCategoryResultData("3", "성신여대 마을기업", "사진3", "3"));
                        itemData1.add(new SearchCategoryResultData("4", "동대문 마을기업", "사진4", "4"));
                        itemData1.add(new SearchCategoryResultData("5", "강남구 마을기업", "사진5", "4"));

                        // 서버에 데이터 추가 된 후 주석 풀 것
//                        itemData1 = response.body().list;

                        for(int i=0; i<itemData1.size(); i++) {
                            if (itemData1.get(i).category.equals("1")){
                                itemData2.add(itemData1.get(i));
                            } else if (itemData1.get(i).category.equals("2")) {
                                itemData3.add(itemData1.get(i));
                            } else if (itemData1.get(i).category.equals("3")) {
                                itemData4.add(itemData1.get(i));
                            } else if (itemData1.get(i).category.equals("4")) {
                                itemData5.add(itemData1.get(i));
                            }
                        }
                    /*    RecyclerCategoryAdapter adapter1 = new RecyclerCategoryAdapter(itemData1, clickListener);
                        recyclerView1.setAdapter(adapter1);
                        RecyclerCategoryAdapter adapter2 = new RecyclerCategoryAdapter(itemData2, clickListener);
                        recyclerView2.setAdapter(adapter2);
                        RecyclerCategoryAdapter adapter3 = new RecyclerCategoryAdapter(itemData3, clickListener);
                        recyclerView3.setAdapter(adapter3);
                        RecyclerCategoryAdapter adapter4 = new RecyclerCategoryAdapter(itemData4, clickListener);
                        recyclerView4.setAdapter(adapter4);
                        RecyclerCategoryAdapter adapter5 = new RecyclerCategoryAdapter(itemData5, clickListener);
                        recyclerView5.setAdapter(adapter5);*/
                    }
                } else {
                    Log.d("SearchCategory 통신 에러", response.body().message);
                }
            }

            @Override
            public void onFailure(Call<SearchCategoryResult> call, Throwable t) {
                Log.d("SearchCategory", "통신 실패");
            }
        });

//        itemData1.add(new SearchCategoryResultData("1","성북구 마을기업","사진1","1"));
//        itemData1.add(new SearchCategoryResultData("2","혜화 마을기업","사진2","1"));
//        itemData1.add(new SearchCategoryResultData("3","성신여대 마을기업","사진3","1"));

        return layout;
    }

    public View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            int position;
            switch (((View)view.getParent()).getId()){
                case R.id.recycler_category1 :
                    position = recyclerView1.getChildPosition(view);
                    Toast.makeText(context,"첫번째 recycler의 " +(position+1)+"번째 item클릭,"+itemData1.get(position).villageEnterpriseId,Toast.LENGTH_SHORT).show();
                    break;

                case R.id.recycler_category2 :
                    position = recyclerView2.getChildPosition(view);
                    Toast.makeText(context,"두번째 recycler의 " +(position+1)+"번째 item클릭,"+itemData2.get(position).villageEnterpriseId,Toast.LENGTH_SHORT).show();
                    break;

                case R.id.recycler_category3 :
                    position = recyclerView3.getChildPosition(view);
                    Toast.makeText(context,"세번째 recycler의 " +(position+1)+"번째 item클릭,"+itemData3.get(position).villageEnterpriseId,Toast.LENGTH_SHORT).show();
                    break;

                case R.id.recycler_category4 :
                    position = recyclerView4.getChildPosition(view);
                    Toast.makeText(context,"네번째 recycler의 " +(position+1)+"번째 item클릭,"+itemData4.get(position).villageEnterpriseId,Toast.LENGTH_SHORT).show();
                    break;

                case R.id.recycler_category5 :
                    position = recyclerView5.getChildPosition(view);
                    Toast.makeText(context,"다섯번째 recycler의 " +(position+1)+"번째 item클릭,"+itemData5.get(position).villageEnterpriseId,Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    };
}
