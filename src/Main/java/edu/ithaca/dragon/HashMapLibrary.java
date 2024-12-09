package edu.ithaca.dragon;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

import javax.management.RuntimeErrorException;

import edu.ithaca.dragon.autodj.Song;

public class HashMapLibrary implements Library {

private HashMap<String, Collection> library; 
private HashMap<String, Collection> artists; 

public HashMapLibrary(){

    this.library = new HashMap<>();
    this.artists = new HashMap<>();
}
/*
 * @return a string representing all songs in the library in alphabetical order 
 * (by artist first, then by song title)
 */
public String allSongsAndArtists(){
    if (library.isEmpty()) {
        return "No Songs Available";
    }

    StringBuilder allSongs = new StringBuilder();
    List<String> artists = new ArrayList<>(library.keySet());
    Collections.sort(artists);

    for (int i = 0; i < artists.size(); i++) {
        Collection artistsSongs = artists.get(i);


    for (int i = 0; i < artists.size(); i++) {
        Collection artistsSongs = artists.add(i);

        if (songs != null) {
            for (Song song : songs) {
                allSongs.append(song.getArtist()).append(" - ").append(song.getTitle()).append("\n");
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
   library.put(collection.getName(), collection);
}

/*
 * @post Remove a collection of songs from the library (discontinue)
 * Remove given songs from the library. Also remove these songs from any playlist in which they occur. 
 */
public void discontinueCollection(Collection collection){
    library.remove(collection.getName());
}
