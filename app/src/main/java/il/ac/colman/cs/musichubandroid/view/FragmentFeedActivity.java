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

public class FragmentFeedActivity extends Fragment {
    ListView theFeed;

     public FragmentFeedActivity()
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
        Post post1 = new Post("post1", "1", "new song", "song number1", 0);
        Post post2 = new Post("post2", "1", "new song2", "song number2", 0);
        Post post3 = new Post("post3", "1", "new song3", "song number3", 0);
        Post post4 = new Post("post4", "1", "new song4", "song number4", 0);
        Post post5 = new Post("post5", "1", "new song5", "song number5", 0);
        Post post6 = new Post("post6", "1", "new song6", "song number6", 0);
        Post post7 = new Post("post7", "1", "new song7", "song number7", 0);
        Post post8 = new Post("post8", "1", "new song8", "song number8", 0);
        Post post9 = new Post("post9", "1", "new song9", "song number9", 0);
        Post post10 = new Post("post10", "1", "new song10", "song number10", 0);
        Post post11 = new Post("post11", "1", "new song11", "song number11", 0);
        Post post12 = new Post("post12", "1", "new song12", "song number12", 0);
        Post post13 = new Post("post13", "1", "new song13", "song number13", 0);
        Post post14 = new Post("post14", "1", "new song14", "song number14", 0);

        ArrayList<Post> postList = new ArrayList<>();
        postList.add(post1);
        postList.add(post2);
        postList.add(post3);
        postList.add(post4);
        postList.add(post5);
        postList.add(post6);
        postList.add(post7);
        postList.add(post8);
        postList.add(post9);
        postList.add(post10);
        postList.add(post11);
        postList.add(post12);
        postList.add(post13);
        postList.add(post14);

        PostListAdpter adapter= new PostListAdpter(view.getContext(),R.layout.post_adapter,postList);
        theFeed.setAdapter(adapter);
    }
}




