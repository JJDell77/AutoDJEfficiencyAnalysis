package edu.ithaca.dragon;

import java.util.ArrayList;
import java.util.NoSuchElementException;

import javax.management.RuntimeErrorException;

import edu.ithaca.dragon.autodj.Song;

public class ArrayListCollection implements Collection {
    
    private ArrayList<Playlist> collection;
    private int size;

    public ArrayListCollection(int capacity){
       this.collection = new ArrayList<>();
       this.size = 0;
    }

    @Override
    public void addPlaylist(Playlist playlist) {
        collection.add(playlist);
        this.size++;
    }

    @Override
    public String playlistNamesAndDurations() {
        if (size == 0){
            throw new NoSuchElementException("Collection is empty");
        }
        StringBuilder playlistNamesAndDurationString = new StringBuilder();
        int duration = 0;
        for (int i=0; i<size; i++){
            Playlist thisPlaylist = collection.get(i);
            String currentPlaylistName = thisPlaylist.getName();
            int currentPlaylistDuration = thisPlaylist.duration();
            playlistNamesAndDurationString.append(currentPlaylistName + " " + "Duration:" + " " + currentPlaylistDuration + " " + "minutes").append("\n");
            duration += thisPlaylist.duration();
        }
        return playlistNamesAndDurationString.toString() + "Total Duration:" + " " + duration + " " + "minutes.";
    }

    @Override
    public String playlistInfo(String playlistName) {
        if (size == 0){
            throw new NoSuchElementException("Collection is empty");
        }

        
        Playlist playlistToFind = null;
        boolean found = false;
        for (int i=0; i<size && found == false; i++){
            Playlist playlist = collection.get(i);
            if (playlist.getName() == playlistName){
                playlistToFind = playlist;
                found = true;
            }
        }
        if (playlistToFind == null){
            throw new NoSuchElementException("Playlist not found");
        }
        StringBuilder playlistInfo = new StringBuilder();
        int numOfSongs = playlistToFind.getSize();
        int playlistDuration = playlistToFind.duration();
        String mostPlayedArtist = playlistToFind.mostPopularArtist();
        playlistInfo.append("This playlist has " + numOfSongs + " songs with a duration of " + playlistDuration + " minutes. The most popular artist in this playlist is " + mostPlayedArtist);
        return playlistInfo.toString();
    }

    @Override
    public void removePlaylist() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removePlaylist'");
    }

    @Override
    public void addEmptyPlaylist() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addEmptyPlaylist'");
    }

    @Override
    public void newRandomPlaylist() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'newRandomPlaylist'");
    }

    @Override
    public void removeAllInstances() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removeAllInstances'");
    }
    
}
