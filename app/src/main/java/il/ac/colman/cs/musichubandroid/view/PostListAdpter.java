package il.ac.colman.cs.musichubandroid.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import il.ac.colman.cs.musichubandroid.R;
import il.ac.colman.cs.musichubandroid.datatypes.Post;

public class PostListAdpter extends ArrayAdapter<Post>{
    private  Context nContext;
    int nResource;
    public PostListAdpter(@NonNull Context context, int resource, @NonNull ArrayList<Post> objects) {
        super(context, resource, objects);
        nContext=context;
        nResource=resource;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        String postId = getItem(position).getPostId();
        String artistId = getItem(position).getArtistId();
        String postDescription = getItem(position).getPostDescription();
        String songName = getItem(position).getPostSongName();
        int hypes = getItem(position).getPostHypes();

        Post post = new Post(postId, artistId, postDescription, songName, hypes);
        LayoutInflater inflater = LayoutInflater.from(nContext);
        convertView = inflater.inflate(nResource, parent, false);
        ImageView profile = (ImageView) convertView.findViewById(R.id.profilePic);
        TextView sonngDicript = (TextView) convertView.findViewById(R.id.artistAndSongName);
        Button playButton = (Button) convertView.findViewById(R.id.playButton);
        Button hype = (Button) convertView.findViewById(R.id.hypeButton);
        profile.setImageResource(R.drawable.common_google_signin_btn_icon_dark);
        sonngDicript.setText(postDescription+"&"+artistId+"&"+postId);
        return convertView;
    }









    }

