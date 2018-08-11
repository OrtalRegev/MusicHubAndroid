package il.ac.colman.cs.musichubandroid.view;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

import il.ac.colman.cs.musichubandroid.R;
import il.ac.colman.cs.musichubandroid.datatypes.Post;

public class FragmentFeed extends Fragment {
    ListView theFeed;
    DatabaseReference artists;
    ArrayList<Post> postList = new ArrayList<>();
     public FragmentFeed()
     {

     }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main_feed_page,container,false);
    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        theFeed=(ListView) view.findViewById(R.id.feed);
        artists = FirebaseDatabase.getInstance().getReference("artists");
        artists.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    postList.add(snapshot.child("post").getValue(Post.class));
                }
                Collections.sort(postList,(new Comparator<Post>() {
                    @Override
                    public int compare(Post post, Post t1) {
                        return (int)(post.getTime() - t1.getTime());
                    }
                }));
                PostListAdpter adapter = new PostListAdpter(view.getContext(),R.layout.post_adapter,postList);
                theFeed.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });



    }
}




