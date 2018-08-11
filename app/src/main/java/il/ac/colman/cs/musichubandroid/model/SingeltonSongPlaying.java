package il.ac.colman.cs.musichubandroid.model;

import android.media.MediaPlayer;

/**
 * Created by regevor on 12/08/2018.
 */

public class SingeltonSongPlaying {
    static SingeltonSongPlaying singeltonSongPlaying=null;
    MediaPlayer songPlayer;

    private SingeltonSongPlaying()
    {


    }

    public void setSongPlayer(MediaPlayer songPlayer) {
        if (songPlayer.isPlaying()) {songPlayer.stop();}
        this.songPlayer = songPlayer;
    }
    public void playSong()
    {
        songPlayer.start();
    }

    static public SingeltonSongPlaying getInstence() {
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
