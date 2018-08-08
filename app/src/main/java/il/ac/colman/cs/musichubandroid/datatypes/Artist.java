package il.ac.colman.cs.musichubandroid.datatypes;

import java.io.Serializable;

import il.ac.colman.cs.musichubandroid.utils;

public class Artist implements Serializable{
    private String artistId;
    private String artistUserName;
    private String artistGenre;
    private String artistEmail;
    private String artistHashedPassword;

    public Artist(){

    }

    public Artist(String artistId, String artistUserName, String artistGenre, String artistEmail, String artistPassword) {
        this.artistId = artistId;
        this.artistUserName = artistUserName;
        this.artistGenre = artistGenre;
        this.artistEmail = artistEmail;
        artistHashedPassword = utils.sha256(artistPassword);
    }

    public String getArtistId() {
        return artistId;
    }

    public void setArtistId(String artistId) {
        this.artistId = artistId;
    }

    public String getArtistUserName() {
        return artistUserName;
    }

    public void setArtistUserName(String artistUserName) {
        this.artistUserName = artistUserName;
    }

    public String getArtistGenre() {
        return artistGenre;
    }

    public void setArtistGenre(String artistGenre) {
        this.artistGenre = artistGenre;
    }

    public String getArtistEmail() {
        return artistEmail;
    }

    public void setArtistEmail(String artistEmail) {
        this.artistEmail = artistEmail;
    }

    public String getArtistHashedPassword() {
        return artistHashedPassword;
    }

    public void setArtistHashedPassword(String password) {
        artistHashedPassword = utils.sha256(password);
    }

    public boolean validatePassword(String password){
        return  artistHashedPassword.equals(utils.sha256(password));
    }
}
