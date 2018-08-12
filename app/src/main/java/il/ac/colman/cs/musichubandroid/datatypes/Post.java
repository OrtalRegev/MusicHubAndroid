package il.ac.colman.cs.musichubandroid.datatypes;

public class Post {
    String postId;
    String artistId;
    String postDescription;
    int postHypes;
    long time;

    public Post(){

    }

    public Post(String postId, String artistId, String postDescription, int postHypes) {
        this.postId = postId;
        this.artistId = artistId;
        this.postDescription = postDescription;
        this.postHypes = postHypes;
        time = 0;
    }

    public Post(String postId, String artistId, String postDescription, int postHypes, long time) {
        this.postId = postId;
        this.artistId = artistId;
        this.postDescription = postDescription;
        this.postHypes = postHypes;
        this.time = time;
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

    public int getPostHypes() {
        return postHypes;
    }

    public void setPostHypes(int postHypes) {
        this.postHypes = postHypes;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
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
