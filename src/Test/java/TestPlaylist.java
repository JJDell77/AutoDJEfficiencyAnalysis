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

    public ArrayList<Song> otherSongs() throws IOException{
        List<Song> allSongs = SongDataIO.buildSongListFromCsv("src/test/resources/Localify_100k_Tracks.csv");
        ArrayList<Song> mylist = new ArrayList<>();
        for (int i=50; i<5; i++){
            mylist.add(allSongs.get(i));
        }
        return mylist;
    }
    
    /**
     * @return return a string representing all songs in the playlist
    * @throws IOException 
    */
    @Test
    public void testAllSongs() throws IOException{
        Playlist myPlaylist = sampleSongs();

        assertEquals("Resonate, Traveling Man, Plantation, Who Paid Them Off?, New Fashion, The Gold (Dubmatix Runnin' Remix)," + //
                        "Give Yourself Over, Garden Tree, High Grade, Pure Fire (Disco Mix), Make You Happy, Goodbye - Sim Redmond Band Remix," + //
                        "8 Track Mind, In the Dark, Beautiful People, Biggie K - Donna The Buffalo Remix, Open My Eyes," + //
                        "Come With Us, Life Is Water, Hurricane, Holes In The Ground, Good Thoughts, Pink Guitar, All Is Not Lost," + //
                        "Save Me, All I Ever Want, Breakdown, Nothing I Can Do, Trampoline, Bliss Seeker, Yin Yang Boomerang," + //
                        "Hey Boy, Where Are the Monsters, Big Red Button, New Persona, Runnin' Round, Talk, Velvet Rope," + //
                        "Positive Friction, No Place Like The Right Time, Heaven & the Earth, Motor, Dance in the Street," + //
                        "Seminole Wind, Locket And Key, I Believe, Across the Way, Holding on to Nothing, Unsteady, Renegades", myPlaylist.allSongs());
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
    public void testIsEmpty() throws IOException{
        Playlist myPlaylist = new ArrayPlaylist(10);
        ArrayList<Song> testSongs = otherSongs();

        myPlaylist.add(testSongs.get(0));
        myPlaylist.add(testSongs.get(1));
        myPlaylist.add(testSongs.get(2));
        myPlaylist.add(testSongs.get(3));
        myPlaylist.add(testSongs.get(4));
        
        assertEquals(myPlaylist.isEmpty(), false);

        myPlaylist.add(testSongs.get(0));
        myPlaylist.add(testSongs.get(1));
        myPlaylist.add(testSongs.get(2));
        myPlaylist.add(testSongs.get(3));
        myPlaylist.add(testSongs.get(4));

        assertEquals(myPlaylist.isEmpty(), true);
    }

    /**
     * @post adds a song to the playlist
     * 
     */
    @Test
    public void TestAdd() throws IOException{
        Playlist myPlaylist = new ArrayPlaylist(10);
        ArrayList<Song> testSongs = otherSongs();

        myPlaylist.add(testSongs.get(0));
        myPlaylist.add(testSongs.get(1));
        myPlaylist.add(testSongs.get(2));
        myPlaylist.add(testSongs.get(3));
        myPlaylist.add(testSongs.get(4));
        
        assertEquals(myPlaylist, testSongs);

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

/* 
        
Resonate, Traveling Man, Plantation, Who Paid Them Off?, New Fashion, The Gold (Dubmatix Runnin' Remix),
Give Yourself Over, Garden Tree, High Grade, Pure Fire (Disco Mix), Make You Happy, Goodbye - Sim Redmond Band Remix,
8 Track Mind, In the Dark, Beautiful People, Biggie K - Donna The Buffalo Remix, Open My Eyes,
Come With Us, Life Is Water, Hurricane, Holes In The Ground, Good Thoughts, Pink Guitar, All Is Not Lost,
Save Me, All I Ever Want, Breakdown, Nothing I Can Do, Trampoline, Bliss Seeker, Yin Yang Boomerang,
Hey Boy, Where Are the Monsters, Big Red Button, New Persona, Runnin' Round, Talk, Velvet Rope,
Positive Friction, No Place Like The Right Time, Heaven & the Earth, Motor, Dance in the Street,
Seminole Wind, Locket And Key, I Believe, Across the Way, Holding on to Nothing, Unsteady, Renegades,
*/
        