import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;

import edu.ithaca.dragon.ArrayPlaylist;
import edu.ithaca.dragon.Playlist;
import edu.ithaca.dragon.autodj.Song;
import edu.ithaca.dragon.autodj.data.SongDataIO;

public class TestPlaylist {

    public Playlist sampleSongs() throws IOException{
        List<Song> allSongs = SongDataIO.buildSongListFromCsv("src/test/resources/Localify_100k_Tracks.csv");
        Playlist myPlaylist = new ArrayPlaylist(50);
        for (int i=0; i<50; i++){
            myPlaylist.add(allSongs.get(i));
        }
        return myPlaylist;
    }

    /**
     * @return return a string representing all songs in the playlist
    * @throws IOException 
    */
    @Test
    public void testAllSongs() throws IOException{
        Playlist myPlaylist = sampleSongs();

        assertEquals(50, myPlaylist.allSongs());
    }

    /**
     * @return calculate the duration of the playlist in minutes
     * @throws NoSuchElementException if the Queue is empty
     */
    @Test
    public void testDuration(){
        throw new NoSuchElementException("Not implemented");
    }

    /**
     * @post play next song and removes it from the playlist
     * @return song info
     */
    @Test
    public void testPlayNext(){
        throw new NoSuchElementException("Not implemented");
    }

    /**
     * @return true if there are no songs in the playlist
     * 
     */
    @Test
    public void testIsEmpty(){
        throw new NoSuchElementException("Not implemented");
    }

    /**
     * @post adds a song to the playlist
     * 
     */
    @Test
    public void TestAdd(){
        throw new NoSuchElementException("Not implemented");
    }

    /**
     * @post remove a song to the playlist
     * 
     */
    @Test
    public void TestRemove(){
        throw new NoSuchElementException("Not implemented");
    }
    
    
}
