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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'duration'");
    }
    // QUINN
    @Override
    public String playNext() {
        Song currentSong = playlist.get(0);
        Song nextSong = playlist.nextIndex();

    }
    //JJ
    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isEmpty'");
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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'remove'");
    }
    
}
