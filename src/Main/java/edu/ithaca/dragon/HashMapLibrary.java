package edu.ithaca.dragon;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

import javax.management.RuntimeErrorException;

import edu.ithaca.dragon.autodj.Song;

public class HashMapLibrary implements Library {

private HashMap<String, HashMap<String,Integer>> library; 

public HashMapLibrary(){

    this.library = new HashMap<>();
   
}
/*
 * @return a string representing all songs in the library in alphabetical order 
 * (by artist first, then by song title)
 */
public String allSongsAndArtists(){
    StringBuilder allSongs = new StringBuilder();

        List<String> artists = new ArrayList<>(library.keySet());
        Collections.sort(artists);

        for (String artist : artists) {
            HashMap<String, Integer> songs = library.get(artist);

            if (songs != null) {
                List<String> songTitles = new ArrayList<>(songs.keySet());
                Collections.sort(songTitles);

                for (String song : songTitles) {
                    allSongs.append(artist).append(" - ").append(song).append("\n");
                }
            }
        }
        return allSongs.toString().trim(); 
}

/*
 * @return information of a song
 * Retrieve information about a song within the library
 */
public String songInfoString(Song song){
    StringBuilder songInfo = new StringBuilder();
    songInfo.append(song.toString()).append("-\n");
    songInfo.append(song.getDuration()).append("\n");
    songInfo.append(song.getPlayCount()).append("\n");
    songInfo.append(song.getSpotifyDanceability()).append("\n");
    return songInfo.toString();
}

/*
 * @post Add a collection of songs to the library (import)
 */
public void importCollection(Collection collection){
    throw new RuntimeErrorException(null, "Not Implemented.");
}

/*
 * @post Remove a collection of songs from the library (discontinue)
 * Remove given songs from the library. Also remove these songs from any playlist in which they occur. 
 */
public void discontinueCollection(Collection collection){
    throw new RuntimeErrorException(null, "Not Implemented.");
}
}
