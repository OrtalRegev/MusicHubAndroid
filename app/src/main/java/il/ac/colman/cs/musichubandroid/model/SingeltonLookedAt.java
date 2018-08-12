package il.ac.colman.cs.musichubandroid.model;

/**
 * Created by regevor on 11/08/2018.
 */

public class SingeltonLookedAt {

    private static SingeltonLookedAt instance=new SingeltonLookedAt();
    private  String userId;

    private SingeltonLookedAt() {}

    public static SingeltonLookedAt getInstance(){
        return instance;
    }


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }



}
