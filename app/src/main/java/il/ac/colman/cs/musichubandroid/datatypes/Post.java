package il.ac.colman.cs.musichubandroid.datatypes;

public class Post {
    String postId;
    String artistId;
    String postDescription;
    String postSongName;
    int postHypes;

    public Post(String postId, String artistId, String postDescription, String postSongName, int postHypes) {
        this.postId = postId;
        this.artistId = artistId;
        this.postDescription = postDescription;
        this.postSongName = postSongName;
        this.postHypes = postHypes;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public String getArtistId() {
        return artistId;
    }

    public void setArtistId(String artistId) {
        this.artistId = artistId;
    }

    public String getPostDescription() {
        return postDescription;
    }

    public void setPostDescription(String postDescription) {
        this.postDescription = postDescription;
    }

    public String getPostSongName() {
        return postSongName;
    }

    public void setPostSongName(String postSongName) {
        this.postSongName = postSongName;
    }

    public int getPostHypes() {
        return postHypes;
    }

    public void setPostHypes(int postHypes) {
        this.postHypes = postHypes;
    }

    public int addHype(){
        return ++postHypes;
    }

    public int removeHype(){
        if (postHypes == 0){
            return postHypes;
        }
        return --postHypes;
    }
}
