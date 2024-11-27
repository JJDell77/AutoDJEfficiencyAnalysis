package edu.ithaca.dragon;

import java.util.NoSuchElementException;

import edu.ithaca.dragon.autodj.Song;

public interface Playlist {
    
    /**
     * @return return a string representing all songs in the playlist
     */
    String allSongs(Song[] playlist);

    /**
     * @return calculate the duration of the playlist in minutes
     * @throws NoSuchElementException if the Queue is empty
     */
    int  duration(Song[] playlist);

    /**
     * @post play next song and removes it from the playlist
     * @return song info
     */
    String playNext(Song[] playlist);

    /**
     * @return true if there are no songs in the playlist
     * 
     */
    boolean isEmpty(Song[] playlist);

    /**
     * @post adds a song to the playlist
     * 
     */
    void add(Song[] playlist, Song song);

    /**
     * @post remove a song to the playlist
     * 
     */
    void remove(Song[] playlist, Song song);
    
}
