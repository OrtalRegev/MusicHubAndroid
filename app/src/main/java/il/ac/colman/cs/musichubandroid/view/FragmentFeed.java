package il.ac.colman.cs.musichubandroid.view;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

import il.ac.colman.cs.musichubandroid.R;
import il.ac.colman.cs.musichubandroid.datatypes.Post;

public class FragmentFeed extends Fragment {
    ListView theFeed;

     public FragmentFeed()
     {

     }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main_feed_page,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        theFeed=(ListView) view.findViewById(R.id.feed);

        ArrayList<Post> postList = new ArrayList<>();

        PostListAdpter adapter= new PostListAdpter(view.getContext(),R.layout.post_adapter,postList);
        theFeed.setAdapter(adapter);
    }
}




