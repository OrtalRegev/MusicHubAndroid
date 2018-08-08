package il.ac.colman.cs.musichubandroid.model;


import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import il.ac.colman.cs.musichubandroid.datatypes.Artist;

public class ArtistsTable {

    DatabaseReference databaseArtists;

    public ArtistsTable(){
        databaseArtists = FirebaseDatabase.getInstance().getReference("artists");
    }

    public void addArtist(Artist artist){
        String id = databaseArtists.push().getKey();
        artist.setArtistId(id);
        databaseArtists.child(id).setValue(artist);
    }
    public Artist getArtist(){
        return null;
    }
}
