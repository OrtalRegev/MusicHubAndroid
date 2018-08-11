package il.ac.colman.cs.musichubandroid.model;

import android.media.MediaPlayer;

/**
 * Created by regevor on 12/08/2018.
 */

public class SingeltonSongPlaying {
    SingeltonSongPlaying singeltonSongPlaying=null;
    MediaPlayer songPlayer;

    private SingeltonSongPlaying()
    {

    }

    public void setSongPlayer(MediaPlayer songPlayer) {
        songPlayer.stop();
        this.songPlayer = songPlayer;
        songPlayer.start();
    }

    public SingeltonSongPlaying getInstence() {
        if (singeltonSongPlaying == null)
        {
            singeltonSongPlaying = new SingeltonSongPlaying();
        }
        return singeltonSongPlaying;
    }

    public MediaPlayer getSongPlayer() {
        return songPlayer;
    }



}
