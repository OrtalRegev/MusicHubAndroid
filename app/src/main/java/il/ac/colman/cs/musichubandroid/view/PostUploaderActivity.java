package il.ac.colman.cs.musichubandroid.view;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import il.ac.colman.cs.musichubandroid.R;
import il.ac.colman.cs.musichubandroid.datatypes.Post;

/**
 * Created by regevor on 11/08/2018.
 */

public class PostUploaderActivity extends AppCompatActivity{
    private static final  int PICK_SONG=100;
    TextView songName;
    EditText discription;
    Button songSelecterButton;
    Button uploadButton;
    Uri songUri=null;

    FirebaseAuth mAuth;
    DatabaseReference posts;
    StorageReference mStorage;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_uploader);
        mStorage = FirebaseStorage.getInstance().getReference();
        mAuth = FirebaseAuth.getInstance();
        posts = FirebaseDatabase.getInstance().getReference("artists");
        uploadButton=(Button)findViewById(R.id.uploadButton);
        discription=(EditText) findViewById(R.id.discriptionBox);
        songSelecterButton=(Button)findViewById(R.id.songPicker);
        songName=(TextView)findViewById(R.id.songName);
        songSelecterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSongGallery();
            }
        });
        uploadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uploadOnclick();
            }
        });

    }

    private void openSongGallery()
    {
        Intent intent= new Intent(Intent.ACTION_PICK,  android.provider.MediaStore.Audio.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent,PICK_SONG);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==PICK_SONG && resultCode==RESULT_OK)
        {
            songUri=data.getData();
            songName.setText("selected");
        }
    }

    private void uploadOnclick() {
        if (!discription.getText().toString().isEmpty() && !songUri.toString().isEmpty()) {

            if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                    != PackageManager.PERMISSION_GRANTED) {

                // Should we show an explanation?
                if (shouldShowRequestPermissionRationale(
                        Manifest.permission.READ_EXTERNAL_STORAGE)) {
                    // Explain to the user why we need to read the contacts
                }

                requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                        1);
            }
            StorageReference filepath = mStorage.child("songs").child(mAuth.getCurrentUser().getUid());
            filepath.putFile(songUri).addOnCompleteListener(new OnCompleteListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onComplete(@NonNull Task<UploadTask.TaskSnapshot> task) {
                    if (task.isSuccessful()) {
                        Post post = new Post(songUri.toString(), mAuth.getUid(), discription.getText().toString(), 0);
                        posts.child(mAuth.getCurrentUser().getUid()).child("post").setValue(post);
                        Toast.makeText(PostUploaderActivity.this, "Uploaded", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(PostUploaderActivity.this, "Failed to upload", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
        else {
            Toast.makeText(this, "please choose a song and make sure you wrote a discription", Toast.LENGTH_SHORT).show();
        }
    }
}
