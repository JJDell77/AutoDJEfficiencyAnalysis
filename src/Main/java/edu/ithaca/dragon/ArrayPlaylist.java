package edu.ithaca.dragon;

import edu.ithaca.dragon.autodj.Song;

public class ArrayPlaylist implements Playlist {

    private Song[] playlist;
    private int size;

    public ArrayPlaylist(int capacity){
        this.playlist = new Song[capacity];
        this.size = 0;
    }

    @Override
    public String allSongs(Song[] playlist) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'allplaylist'");
    }

    @Override
    public int duration(Song[] playlist) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'duration'");
    }

    @Override
    public String playNext(Song[] playlist) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'playNext'");
    }

    @Override
    public boolean isEmpty(Song[] playlist) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isEmpty'");
    }

    @Override
    public void add(Song[] playlist, Song song) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'add'");
    }

    @Override
    public void remove(Song[] playlist, Song song) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'remove'");
    }
    
}
