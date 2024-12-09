package edu.ithaca.dragon;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.IOException;

public class HashMapLibraryTest {

    private HashMapLibrary library;

    @BeforeEach
    void setUp() throws IOException {
        library = new HashMapLibrary();

        // Use the sampleCollection method to add a collection to the library
        Collection sampleCollection = sampleCollection();
        library.importCollection(sampleCollection);
    }

    @Test
    void testAllSongsAndArtists() throws IOException {
        String result = library.allSongsAndArtists();
        assertNotNull(result);
        assertTrue(result.contains("Playlist1")); // Check if Playlist1's songs appear in the output
    }

    @Test
    void testSongInfoString() throws IOException {
        // Use the first song from the sample collection for testing
        Collection sampleCollection = sampleCollection();
        Song testSong = sampleCollection.getPlaylists().get(0).getSongs().get(0); // Get a song

        String songInfo = library.songInfoString(testSong);
        assertNotNull(songInfo);
        assertTrue(songInfo.contains(testSong.getTitle()));
    }

    @Test
    void testImportCollection() throws IOException {
        // Create a new collection using sampleCollection
        Collection newCollection = sampleCollection();
        library.importCollection(newCollection);

        String result = library.allSongsAndArtists();
        assertTrue(result.contains("Playlist2")); // Verify Playlist2's songs are added
    }

    @Test
    void testDiscontinueCollection() throws IOException {
        // Remove the sample collection
        Collection sampleCollection = sampleCollection();
        library.discontinueCollection(sampleCollection);

        String result = library.allSongsAndArtists();
        assertEquals("No Songs Available", result); // Confirm collection is removed
    }

    // Helper method to create sampleCollection (copied from your code)
    private Collection sampleCollection() throws IOException {
        List<Song> allSongs = SongDataIO.buildSongListFromCsv("src/test/resources/Localify_100k_Tracks.csv");
        Playlist playlist1 = new LinkedNodePlaylist("Playlist1");
        for (int i = 0; i < 5; i++) {
            playlist1.add(allSongs.get(i));
        }
        Playlist playlist2 = new LinkedNodePlaylist("Playlist2");
        for (int i = 5; i < 10; i++) {
            playlist2.add(allSongs.get(i));
        }
        Playlist playlist3 = new LinkedNodePlaylist("Playlist3");
        for (int i = 10; i < 15; i++) {
            playlist3.add(allSongs.get(i));
        }
        Collection myCollection = new ArrayListCollection(5, "myCollection");
        myCollection.addPlaylist(playlist1);
        myCollection.addPlaylist(playlist2);
        myCollection.addPlaylist(playlist3);
        return myCollection;
    }
}
