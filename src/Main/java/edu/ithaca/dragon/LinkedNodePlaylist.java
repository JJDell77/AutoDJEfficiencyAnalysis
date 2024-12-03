package edu.ithaca.dragon;


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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'duration'");
    }

    @Override
    public Song playNext() {
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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'remove'");
    }

    @Override
    public boolean contains(Song song) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'contains'");
    }
    
}
