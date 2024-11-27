package edu.ithaca.dragon;

import java.util.ArrayList;
import edu.ithaca.dragon.autodj.Song;

public class ArrayPlaylist implements Playlist {

    private ArrayList<Song> playlist;
    private int size;

    public ArrayPlaylist(int capacity){
        this.playlist = new ArrayList<>();
        this.size = 0;
    }

    @Override
    public String allSongs() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'allplaylist'");
        /*
         * int songCount = 0;
        for (int i=0; i<sampleSongs.size(); i++){
            songCount++;
        }
         */
    }

    @Override
    public int duration() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'duration'");
    }

    @Override
    public String playNext() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'playNext'");
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isEmpty'");
    }

    @Override
    public void add(Song song) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'add'");
    }

    @Override
    public void remove(Song song) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'remove'");
    }
    
}
