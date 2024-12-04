package edu.ithaca.dragon;

import java.util.ArrayList;

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
        ArrayList<String> names = new ArrayList<>(size);
        int duration = 0;
        for (int i=0; i<size; i++){
            for (int )
        }
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
