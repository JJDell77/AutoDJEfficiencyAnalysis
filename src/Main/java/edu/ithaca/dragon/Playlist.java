package edu.ithaca.dragon;

import java.util.NoSuchElementException;

public interface Playlist {
    
    /**
     * @return return a string representing all songs in the playlist
     */
    String allSongs(playlist myPlaylist);

    /**
     * @return calculate the duration of the playlist in minutes
     * @throws NoSuchElementException if the Queue is empty
     */
    int  duration(playlist myPlaylist);

    /**
     * @post play next song and removes it from the playlist
     * @return song info
     */
    String playNext(playlist myPlaylist);

    /**
     * @return true if there are no songs in the playlist
     * 
     */
    boolean isEmpty(playlist myPlaylist);

    /**
     * @post adds a song to the playlist
     * 
     */
    void add(playlist myPlaylist, String song);

    /**
     * @post remove a song to the playlist
     * 
     */
    void remove(playlist myPlaylist, String song);
    
}
