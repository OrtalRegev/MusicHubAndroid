package il.ac.colman.cs.musichubandroid.view;

import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.File;

import il.ac.colman.cs.musichubandroid.R;

/**
 * Created by regevor on 10/08/2018.
 */

public class Profile extends AppCompatActivity {
    Button addPost;
    private static final  int PICK_IMAGE=100;
    Uri imageUri;
    ImageView profilePic;
    StorageReference mStorage;
    FirebaseAuth auth;
    String userId;
    File picFile;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);
        mStorage = FirebaseStorage.getInstance().getReference();
        addPost= (Button)findViewById(R.id.addPost);
        profilePic=(ImageView)findViewById(R.id.profilePic);
        profilePic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGallery();
            }
        });
        auth = FirebaseAuth.getInstance();
        userId = auth.getCurrentUser().getUid();
        StorageReference pic = mStorage.child("pictures").child(userId);
        try {
            picFile = File.createTempFile("images", null, this.getCacheDir());
        }catch (Exception e){

        }
        pic.getFile(picFile).addOnCompleteListener(new OnCompleteListener<FileDownloadTask.TaskSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<FileDownloadTask.TaskSnapshot> task) {
                if(task.isSuccessful()){
                    profilePic.setImageURI(Uri.fromFile(picFile));
                }
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
            StorageReference filepath = mStorage.child("pictures").child(userId);
            filepath.putFile(imageUri).addOnCompleteListener(new OnCompleteListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onComplete(@NonNull Task<UploadTask.TaskSnapshot> task) {
                    if(task.isSuccessful()){
                        profilePic.setImageURI(imageUri);
                    }else{
                        Toast.makeText(Profile.this, "Failed to upload please try again", Toast.LENGTH_SHORT).show();
                    }
                }
            });


        }
    }
}
