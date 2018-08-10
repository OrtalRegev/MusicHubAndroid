package il.ac.colman.cs.musichubandroid.view;

import android.content.Context;
import android.support.annotation.AnimatorRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
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
    private int nResource;
    private int lastPosition =-1;
    public PostListAdpter(@NonNull Context context, int resource, @NonNull ArrayList<Post> objects) {
        super(context, resource, objects);
        nContext=context;
        nResource=resource;

    }

    static class ViewHolder {
        TextView descripton;
        ImageView profile;
        TextView hypes;
        Button playButton;
        Button hype;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        String postId = getItem(position).getPostId();
        String artistId = getItem(position).getArtistId();
        String postDescription = getItem(position).getPostDescription();
        String songName = getItem(position).getPostSongName();
        int hypes = getItem(position).getPostHypes();
        final  View result;
        ViewHolder holder = new ViewHolder();

        Post post = new Post(postId, artistId, postDescription, songName, hypes);
        LayoutInflater inflater = LayoutInflater.from(nContext);
        convertView = inflater.inflate(nResource, parent, false);

        holder.profile = (ImageView) convertView.findViewById(R.id.profilePic);
        holder.descripton = (TextView) convertView.findViewById(R.id.description);
        holder.playButton = (Button) convertView.findViewById(R.id.playButton);
        holder.hype = (Button) convertView.findViewById(R.id.hypeButton);
        holder.profile.setImageResource(R.drawable.common_google_signin_btn_icon_dark);
        holder.hypes = (TextView)convertView.findViewById(R.id.hypeCount);
        holder.hypes.setText("7");

        convertView.setTag(holder);
        Animation animation = AnimationUtils.loadAnimation(nContext,
                position>lastPosition ? R.anim.load_down_anim: R.anim.load_up_anim);
        //result.startAnimation(animation);
        //lastPosition=position;




        return convertView;
    }









    }

