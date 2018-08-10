package il.ac.colman.cs.musichubandroid.view;

import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import il.ac.colman.cs.musichubandroid.R;

/**
 * Created by regevor on 10/08/2018.
 */

public class Profile extends AppCompatActivity {
    Button addPost;
    private static final  int PICK_IMAGE=100;
    Uri imageUri;
    ImageView profilePic;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);
        addPost= (Button)findViewById(R.id.addPost);
        profilePic=(ImageView)findViewById(R.id.profilePic);
        profilePic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGallery();
            }
        });
    }
    public void openGallery()
    {
        Intent gallery= new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(gallery,PICK_IMAGE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==PICK_IMAGE && resultCode==RESULT_OK)
        {
            imageUri=data.getData();
            profilePic.setImageURI(imageUri);

        }
    }
}
