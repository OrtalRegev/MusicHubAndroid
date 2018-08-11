package il.ac.colman.cs.musichubandroid.datatypes;

import java.io.Serializable;
import java.util.ArrayList;

public class Artist implements Serializable{
    private String artistId;
    private String artistUserName;
    private String artistGenre;
    private String email;
    private ArrayList<String> followingIds;
    private ArrayList<String> followersIds;
    private String profileImageName;
    private ArrayList<String> postsIds;

    public Artist(){
        followersIds = new ArrayList<>();
        followingIds = new ArrayList<>();
        postsIds = new ArrayList<>();
    }

    public Artist(String artistUserName, String artistGenre, String email){
        this.artistUserName = artistUserName;
        this.artistGenre = artistGenre;
        this.email = email;
        followersIds = new ArrayList<>();
        followingIds = new ArrayList<>();
        postsIds = new ArrayList<>();
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getProfileImageName() {
        return profileImageName;
    }

    public void setProfileImageName(String profileImageName) {
        this.profileImageName = profileImageName;
    }

    public ArrayList<String> getPostsIds() {
        return postsIds;
    }

    public void setPostsIds(ArrayList<String> postsIds) {
        this.postsIds = postsIds;
    }
}
