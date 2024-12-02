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
    // QUINN
    @Override
    public String allSongs() {

        StringBuilder allSongsString = new StringBuilder();

        for (int songIndex = 0; songIndex < this.size; songIndex++) {
            Song currentSong = playlist.get(songIndex);
            allSongsString.append(currentSong.getTitle()).append("\n");
        }
        return allSongsString.toString();
        
    }
    // QUINN
    @Override
    public int duration() {
        int totalDuration = 0;
        for (Song song: playlist){
            int songLength = song.getDuration();
            totalDuration += songLength;
        }
        return totalDuration/6000;
    }
    // QUINN
    @Override
    public String playNext() {
        if (size == 0) {
            return "The playlist is empty.";
        }

        Song nextSong = playlist.remove(0);
        size--;
        
        return "Now playing: " + nextSong.getTitle();
    }
    //JJ
    @Override
    public boolean isEmpty() {
        if (size == 0){
            return true;
        }
        else{
            return false;
        }
    }
    //JJ
    @Override
    public void add(Song song) {
        playlist.add(this.size, song);
        size++;
    }
    //JJ
    @Override
    public void remove(Song song) {
        if (song == null) {
            throw new IllegalArgumentException("Song cannot be null");
        }
        boolean removed = playlist.remove(song); 

        if (removed) {
            size--; 
        } 
        else {
            throw new IllegalArgumentException("Song not found in the playlist");
        }
    }
    
}
