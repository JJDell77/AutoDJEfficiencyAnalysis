package edu.ithaca.dragon;

import java.util.ArrayList;

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

        StringBuilder playlistNamesAndDurationString = new StringBuilder();
        int duration = 0;
        for (int i=0; i<size; i++){
            Playlist thisPlaylist = collection.get(i);
            String currentPlaylistName = thisPlaylist.getName();
            playlistNamesAndDurationString.append(currentPlaylistName).append("\n");
            duration += thisPlaylist.duration();
        }
        return playlistNamesAndDurationString.toString() + "Total Duration:" + " " + duration + " " + "Minutes.";
    }

    @Override
    public String playlistInfo() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'playlistInfo'");
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
