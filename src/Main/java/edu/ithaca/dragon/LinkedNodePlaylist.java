package edu.ithaca.dragon;


import java.util.NoSuchElementException;

import edu.ithaca.dragon.autodj.Song;
import edu.ithaca.dragon.io.LinkedNode;

public class LinkedNodePlaylist implements Playlist {

    private LinkedNode<Song> front;

    public LinkedNodePlaylist(){
        this.front = null;
    }

    @Override
    public String allSongs() {

        StringBuilder allSongsString = new StringBuilder();

        LinkedNode<Song> current = front;

        while (current != null) {
            Song currentSong = current.getItem();
            allSongsString.append(currentSong.getTitle()).append("\n");
            current = current.getNext();
        }
        return allSongsString.toString();
    }

    @Override
    public int duration() {
        int totalDuration = 0;

        LinkedNode<Song> current = front;
        while (current != null){
            int songLength = current.getItem().getDuration();
            totalDuration += songLength;
            current = current.getNext();
        }
        return totalDuration/60000;
    }

    @Override
    public Song playNext() {
        LinkedNode<Song> current = front;
        if (current == null){
            throw new NoSuchElementException("No Songs available");
        }
        front = front.getNext();
        return current.getItem();
    }

    @Override
    public boolean isEmpty() {
        if (front == null){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public void add(Song song) {
        
        if (front == null){
            front = new LinkedNode<Song>(song);
        }
        
        else{
            LinkedNode<Song> current = front;

            while (current.getNext() != null){
                current = current.getNext();
            }
            current.setNext(new LinkedNode<Song>(song));
        }
    }

    @Override
    public void remove(Song song) {
        if (front == null) {
            throw new IllegalArgumentException("Song not found in the playlist.");
        }
    
        if (front.getItem() == song) {
            front = front.getNext();
            return;
        }
        
        LinkedNode<Song> current = front;
        boolean found = false;
        while (current.getNext() != null){
            LinkedNode<Song> nextNode = current.getNext();
            if (nextNode.getItem().equals(song) && found == false) {
                current.setNext(nextNode.getNext()); 
                found = true;
            }

            
            current = nextNode;
        }
        if (found == false){
            throw new IllegalArgumentException("Song not found in the playlist.");
        }
    }
    

    @Override
    public boolean contains(Song song) {
        LinkedNode<Song> current = front;

        while (current != null){
            if (current.getItem() == song){
                return true;
            }
            current = current.getNext();
        }
        return false;
    }
    
}
