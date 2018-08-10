package il.ac.colman.cs.musichubandroid.model;


import android.support.annotation.NonNull;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import il.ac.colman.cs.musichubandroid.datatypes.Artist;

public class ArtistsTable {

    DatabaseReference databaseArtists;

    FirebaseAuth mAuth;

    Artist currentArtist;

    private boolean success = false;

    public ArtistsTable(){
        mAuth = FirebaseAuth.getInstance();
        databaseArtists = FirebaseDatabase.getInstance().getReference("artists");
    }

    public boolean register(Artist artist, String email, String password){
        this.currentArtist = artist;
        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    String id = mAuth.getCurrentUser().getUid();
                    currentArtist.setArtistId(id);
                    databaseArtists.child(id).setValue(currentArtist);
                    success = true;
                }else{
                    success = false;
                }
            }
        });
        return success;
    }
    public void login(String email, String password){
        mAuth.signInWithEmailAndPassword(email, password);
    }
    public void getArtistData(){
        databaseArtists.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                parseData(dataSnapshot);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
    public void signOut(){
        mAuth.signOut();
    }
    private void parseData(DataSnapshot dataSnapshot){
        currentArtist.setArtistId(dataSnapshot.child(mAuth.getCurrentUser().getUid()).getValue(Artist.class).getArtistId());
        currentArtist.setArtistGenre(dataSnapshot.child(mAuth.getCurrentUser().getUid()).getValue(Artist.class).getArtistGenre());
        currentArtist.setArtistUserName(dataSnapshot.child(mAuth.getCurrentUser().getUid()).getValue(Artist.class).getArtistUserName());
        currentArtist.setFollowersIds(dataSnapshot.child(mAuth.getCurrentUser().getUid()).getValue(Artist.class).getFollowersIds());
        currentArtist.setFollowingIds(dataSnapshot.child(mAuth.getCurrentUser().getUid()).getValue(Artist.class).getFollowingIds());
        currentArtist.setPostsIds(dataSnapshot.child(mAuth.getCurrentUser().getUid()).getValue(Artist.class).getPostsIds());
        currentArtist.setProfileImageName(dataSnapshot.child(mAuth.getCurrentUser().getUid()).getValue(Artist.class).getProfileImageName());
    }
}
