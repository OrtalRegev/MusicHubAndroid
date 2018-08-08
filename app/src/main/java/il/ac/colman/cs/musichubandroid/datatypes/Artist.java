package il.ac.colman.cs.musichubandroid.datatypes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import il.ac.colman.cs.musichubandroid.utils;

public class Artist implements Serializable{
    private String artistId;
    private String artistUserName;
    private String artistGenre;
    private String artistEmail;
    private String artistHashedPassword;
    private ArrayList<String> followingIds;
    private ArrayList<String> followersIds;

    public Artist(){
        followersIds = new ArrayList<>();
        followingIds = new ArrayList<>();
    }

    public Artist(String artistUserName, String artistGenre, String artistEmail, String artistPassword) {
        this.artistUserName = artistUserName;
        this.artistGenre = artistGenre;
        this.artistEmail = artistEmail;
        artistHashedPassword = utils.sha256(artistPassword);
        followersIds = new ArrayList<>();
        followingIds = new ArrayList<>();
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

    public ArrayList<String> getFollowingIds() {
        return followingIds;
    }

    public void setFollowingIds(ArrayList<String> followingIds) {
        this.followingIds = followingIds;
    }

    public ArrayList<String> getFollowersIds() {
        return followersIds;
    }

    public void setFollowersIds(ArrayList<String> followersIds) {
        this.followersIds = followersIds;
    }

    public boolean validatePassword(String password){
        return  artistHashedPassword.equals(utils.sha256(password));
    }
}
