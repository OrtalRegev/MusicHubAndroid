package il.ac.colman.cs.musichubandroid.view;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.MediaStore;
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
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import il.ac.colman.cs.musichubandroid.R;

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

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_uploader);
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

    private void uploadOnclick()
    {
        if (!discription.getText().toString().isEmpty()&&!songUri.toString().isEmpty())
        {


        }else {
            Toast.makeText(this, "please choose a song and make sure you wrote a discription", Toast.LENGTH_SHORT).show();
        }
    }
}
