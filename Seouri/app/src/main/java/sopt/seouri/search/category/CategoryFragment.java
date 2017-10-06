package sopt.seouri.search.category;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TabHost;
import android.widget.Toast;

import java.util.ArrayList;

import sopt.seouri.R;
import sopt.seouri.adapters.RecyclerCategoryAdapter;

/**
 * Created by 김지원 on 2017-10-06.
 */

public class CategoryFragment extends Fragment {
    private Context context;
    private int category;
    private int tabNumber = 0;
    private RecyclerView recyclerView1, recyclerView2, recyclerView3, recyclerView4, recyclerView5;
    private ArrayList<CategoryDatas> itemData1, itemData2, itemData3, itemData4, itemData5;

    public CategoryFragment() {
    }

    public void setContext(Context context, int category){
        this.context = context;
        this.category = category;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        String getBundleText = getArguments().getString("select");
//        Toast.makeText(context, getBundleText, Toast.LENGTH_SHORT).show();
        Toast.makeText(context, ""+category, Toast.LENGTH_SHORT).show();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        RelativeLayout layout = (RelativeLayout)inflater.inflate(R.layout.category_fragment,container,false);
        TabHost tabHost = (TabHost)layout.findViewById(R.id.category_tabhost);
        tabHost.setup();

        // 첫번째 탭
        TabHost.TabSpec ts1 = tabHost.newTabSpec("Tab Spec1");
        ts1.setContent(R.id.tab1);
        ts1.setIndicator("전체");
        tabHost.addTab(ts1);

        recyclerView1 = (RecyclerView)layout.findViewById(R.id.recycler_category1);
        recyclerView1.setHasFixedSize(true);
        LinearLayoutManager manager1 = new LinearLayoutManager(context);
        manager1.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView1.setLayoutManager(manager1);

        itemData1 = new ArrayList<>();
        itemData1.add(new CategoryDatas("1","성북구 마을기업","사진1","1"));
        itemData1.add(new CategoryDatas("2","혜화 마을기업","사진2","1"));
        itemData1.add(new CategoryDatas("3","성신여대 마을기업","사진3","1"));

        RecyclerCategoryAdapter adapter1 = new RecyclerCategoryAdapter(itemData1,clickListener);
        recyclerView1.setAdapter(adapter1);

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

        return layout;
    }

    public View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            final int position = recyclerView1.getChildPosition(view);
            Toast.makeText(context,(position+1)+"번째 item클릭",Toast.LENGTH_SHORT).show();
        }
    };
}
