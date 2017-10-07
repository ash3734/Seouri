package sopt.seouri.community;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import sopt.seouri.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class WriteFragment extends Fragment {
    private Context context;

    Button complete;

    public WriteFragment() {
        // Required empty public constructor
    }

    public void setContext(Context context){
        this.context = context;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup v = (ViewGroup) inflater.inflate(R.layout.fragment_write, container, false);

        complete = (Button)v.findViewById(R.id.complete);
        complete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
            }
        });

        return  v;
    }

}
