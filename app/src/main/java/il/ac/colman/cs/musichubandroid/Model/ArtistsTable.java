package il.ac.colman.cs.musichubandroid.Model;


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
        String username = artist.getArtistUserName();
        String genre = artist.getArtistGenre();

    }
}
