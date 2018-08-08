package il.ac.colman.cs.musichubandroid.datatypes;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class Artist {
    private String artistId;
    private String artistUserName;
    private String artistGenre;
    private String artistEmail;
    private byte[] artistHashedPassword;

    public Artist(){

    }

    public Artist(String artistId, String artistUserName, String artistGenre, String artistEmail, String artistPassword) {
        this.artistId = artistId;
        this.artistUserName = artistUserName;
        this.artistGenre = artistGenre;
        this.artistEmail = artistEmail;
        try{
            MessageDigest hashAlgorithm = MessageDigest.getInstance("SHA-256");
            artistHashedPassword = hashAlgorithm.digest(artistPassword.getBytes(StandardCharsets.UTF_8));
        }catch (NoSuchAlgorithmException e){
            e.printStackTrace();
        }
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

    public byte[] getArtistHashedPassword() {
        return artistHashedPassword;
    }

    public void setArtistHashedPassword(String password) {
        try{
            MessageDigest hashAlgorithm = MessageDigest.getInstance("SHA-256");
            artistHashedPassword = hashAlgorithm.digest(password.getBytes(StandardCharsets.UTF_8));
        }catch (NoSuchAlgorithmException e){
            e.printStackTrace();
        }
    }

    public boolean validatePassword(String password){
        try{
            MessageDigest hashAlgorithm = MessageDigest.getInstance("SHA-256");
            return Arrays.equals(hashAlgorithm.digest(password.getBytes(StandardCharsets.UTF_8)), artistHashedPassword);
        }catch (NoSuchAlgorithmException e){
            e.printStackTrace();
            return false;
        }
    }
}
