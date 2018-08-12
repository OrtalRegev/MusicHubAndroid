package il.ac.colman.cs.musichubandroid.view;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
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

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import il.ac.colman.cs.musichubandroid.R;
import il.ac.colman.cs.musichubandroid.datatypes.Post;
import il.ac.colman.cs.musichubandroid.model.SingeltonSongPlaying;

public class PostListAdpter extends ArrayAdapter<Post>{
    private  Context nContext;
    private int nResource;
    private int lastPosition =-1;
    private File picFile;
    private File songFile;
    ViewHolder holder;
    SingeltonSongPlaying singeltonSongPlaying;
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
        final String artistId = getItem(position).getArtistId();
        String postDescription = getItem(position).getPostDescription();
        int hypes = getItem(position).getPostHypes();
        singeltonSongPlaying= SingeltonSongPlaying.getInstence();
        Post post = new Post(artistId,postId,postDescription,hypes);

        final  View result;
        holder = new ViewHolder();

        if(convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(nContext);
            convertView = inflater.inflate(nResource, parent, false);

            holder.profile = (ImageView) convertView.findViewById(R.id.profilePic);
            holder.descripton = (TextView) convertView.findViewById(R.id.description);
            holder.playButton = (Button) convertView.findViewById(R.id.playButton);
            holder.hype = (Button) convertView.findViewById(R.id.hypeButton);
            holder.hypes = (TextView) convertView.findViewById(R.id.hypeCount);

            result = convertView;

            convertView.setTag(holder);
        }else
        {
            holder = (ViewHolder) convertView.getTag();
            result = convertView;
        }
        Animation animation = AnimationUtils.loadAnimation(nContext,
                (position > lastPosition) ? R.anim.load_down_anim : R.anim.load_up_anim);
        result.startAnimation(animation);
        lastPosition = position;

        holder.descripton.setText(post.getPostDescription());
        holder.hypes.setText(Integer.toString(post.getPostHypes()));

        StorageReference pic = FirebaseStorage.getInstance().getReference().child("pictures").child(artistId);
        try {
            picFile = File.createTempFile("images", null, convertView.getContext().getCacheDir());
        }catch (Exception e){

        }
        pic.getFile(picFile).addOnCompleteListener(new OnCompleteListener<FileDownloadTask.TaskSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<FileDownloadTask.TaskSnapshot> task) {
                if(task.isSuccessful()){
                    holder.profile.setImageURI(Uri.fromFile(picFile));
                }
            }
        });
        holder.playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view){
                final StorageReference song = FirebaseStorage.getInstance().getReference().child("songs").child(artistId);
                try {
                    songFile = File.createTempFile("songs", null, view.getContext().getCacheDir());
                }catch (Exception e){

                }
                song.getFile(songFile).addOnCompleteListener(new OnCompleteListener<FileDownloadTask.TaskSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<FileDownloadTask.TaskSnapshot> task) {
                        if(task.isSuccessful()){
                            singeltonSongPlaying.setSongPlayer(MediaPlayer.create(view.getContext(), Uri.fromFile(songFile)));
                            singeltonSongPlaying.playSong();
                        }
                    }
                });

            }
        });

        return convertView;
    }

    }

