package il.ac.colman.cs.musichubandroid.view;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import il.ac.colman.cs.musichubandroid.model.SingeltonLookedAt;

import static android.app.Activity.RESULT_OK;

/**
 * Created by regevor on 10/08/2018.
 */

public class FragmentOthersProfile extends Fragment {
    private static final  int PICK_IMAGE=100;
    Button addPerson;
    Uri imageUri;
    ImageView profilePic;
    StorageReference mStorage;
    FirebaseAuth auth;
    String userId;
    SingeltonLookedAt lookedAt;
    File picFile;

    public FragmentOthersProfile()
    {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_others_profile,container,false);
    }


    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        lookedAt= SingeltonLookedAt.getInstance();
        userId = lookedAt.getUserId();
        addPerson= (Button)view.findViewById(R.id.addPerson);
        profilePic=(ImageView)view.findViewById(R.id.OthersProfile);
        mStorage = FirebaseStorage.getInstance().getReference();

        StorageReference pic = mStorage.child("pictures").child(userId);
        try {
            picFile = File.createTempFile("images", null, view.getContext().getCacheDir());
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
        addPerson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (userId.equals(lookedAt.getUserId()))
                {

                }else{

                }
            }
        });


    }
}
