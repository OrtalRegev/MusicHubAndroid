package il.ac.colman.cs.musichubandroid.view;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import il.ac.colman.cs.musichubandroid.R;

/**
 * Created by regevor on 11/08/2018.
 */

public class FragmentSearch extends Fragment {
    Button searchButton;
    EditText searchText;

    public FragmentSearch()
    {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_search,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        searchButton=(Button) view.findViewById(R.id.searchButton);
        searchText=(EditText)view.findViewById(R.id.searchEditText);
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*
                *******************************************************
                ortal put you shit here
                *******************************************************
                 */
            }
        });

    }
}
