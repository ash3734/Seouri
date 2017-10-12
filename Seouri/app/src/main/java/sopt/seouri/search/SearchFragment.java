package sopt.seouri.search;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;

import sopt.seouri.R;
import sopt.seouri.adapters.GridAdapter;
import sopt.seouri.search.category.CategoryFragment;

import static sopt.seouri.MainActivity.fragmentManager;

/**
 * Created by ash on 2017-09-20.
 */

public class SearchFragment extends Fragment {
    private Context context;
    private GridView gridView;
    private TextView search_all_btn;
    private String[] countryList;


    /*뭘 의미하는지는 모르겠음*/
//    private static final String ARG_PARAM1 = "param1";
//    private static final String ARG_PARAM2 = "param2";
//    private String  mParam1;
//    private String  mParam2;

    public SearchFragment() {
    }

    public void setContext(Context context){
        this.context = context;
    }
//    /*뭘 의미하는지는 모르겠음*/
//    public static SearchFragment newInstance(String param1, String param2){
//        SearchFragment fragment = new SearchFragment();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1,param1);
//        args.putString(ARG_PARAM2,param2);
//        fragment.setArguments(args);
//        return fragment;
//    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        countryList = getResources().getStringArray(R.array.seoul);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        LinearLayout layout = (LinearLayout) inflater.inflate(R.layout.search_fragment, container, false);
        gridView = (GridView)layout.findViewById(R.id.search_location_gridview);
        gridView.setAdapter(new GridAdapter(context, countryList));
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                FragmentTransaction transaction = fragmentManager.beginTransaction();
//                CategoryFragment categoryFragment = new CategoryFragment();
//
//                categoryFragment.setContext(context, String.valueOf(position));
//                transaction.replace(R.id.container,categoryFragment);
//                transaction.addToBackStack(null);
//                transaction.commit();
                toDetailFragment(String.valueOf(position));

            }
        });

        search_all_btn = (TextView)layout.findViewById(R.id.search_all_btn);
        search_all_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toDetailFragment("25");
            }
        });

        return layout;
    }

    private void toDetailFragment(String position){
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        CategoryFragment categoryFragment = new CategoryFragment();
        categoryFragment.setContext(context, position);
        transaction.replace(R.id.container,categoryFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
