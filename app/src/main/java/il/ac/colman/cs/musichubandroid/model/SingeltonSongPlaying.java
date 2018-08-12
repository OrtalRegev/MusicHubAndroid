package il.ac.colman.cs.musichubandroid.model;

import android.media.MediaPlayer;

/**
 * Created by regevor on 12/08/2018.
 */

public class SingeltonSongPlaying {
    static SingeltonSongPlaying singeltonSongPlaying = new SingeltonSongPlaying();
    MediaPlayer songPlayer;

    private SingeltonSongPlaying() {}

    public void setSongPlayer(MediaPlayer songPlayer) {
        if (this.songPlayer != null && this.songPlayer.isPlaying()) {this.songPlayer.stop();}
        this.songPlayer= songPlayer;
    }
    public void playSong()
    {
        songPlayer.start();
    }

    public static SingeltonSongPlaying getInstence() {
        return singeltonSongPlaying;
    }

    public MediaPlayer getSongPlayer() {
        return songPlayer;
    }



}
