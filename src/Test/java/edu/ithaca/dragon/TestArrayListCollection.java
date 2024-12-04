package edu.ithaca.dragon;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.util.List;

import org.junit.jupiter.api.Test;

import edu.ithaca.dragon.autodj.Song;
import edu.ithaca.dragon.autodj.data.SongDataIO;

public class TestArrayListCollection {

    public Collection sampleCollection() throws IOException{
        List<Song> allSongs = SongDataIO.buildSongListFromCsv("src/test/resources/Localify_100k_Tracks.csv");
        Playlist playlist1 = new LinkedNodePlaylist("Playlist1");
        for (int i=0; i<5; i++){
            playlist1.add(allSongs.get(i));
        }
        Playlist playlist2 = new LinkedNodePlaylist("Playlist2");
        for (int i=5; i<10; i++){
            playlist2.add(allSongs.get(i));
        }
        Playlist playlist3 = new LinkedNodePlaylist("Playlist3");
        for (int i=10; i<15; i++){
            playlist3.add(allSongs.get(i));
        }
        Collection myCollection = new ArrayListCollection(5);
        myCollection.addPlaylist(playlist1);
        myCollection.addPlaylist(playlist2);
        myCollection.addPlaylist(playlist3);
        return myCollection;
    }
    
    @Test
    public void testPlaylistNamesAndDurations() throws IOException {
        Collection myCollection = sampleCollection();

        assertEquals(myCollection.playlistNamesAndDurations(), "Playlist1\n"+
        "Playlist2\n"+
        "Playlist3\n"+
        "Total Duration: 68 Minutes.");
    }

    @Test
    public void testPlaylistInfo() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'playlistInfo'");
    }

    @Test
    public void testRemovePlaylist() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removePlaylist'");
    }

    @Test
    public void testAddEmptyPlaylist() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addEmptyPlaylist'");
    }

    @Test
    public void testNewRandomPlaylist() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'newRandomPlaylist'");
    }

    @Test
    public void testRemoveAllInstances() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removeAllInstances'");
    }
}
