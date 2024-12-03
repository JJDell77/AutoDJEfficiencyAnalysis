package edu.ithaca.dragon;

import java.util.NoSuchElementException;

import javax.management.RuntimeErrorException;

import edu.ithaca.dragon.autodj.Song;

public class HashMapLibrary implements Library{
    
/*
 * @return a string representing all songs in the library in alphabetical order 
 * (by artist first, then by song title)
 */
public String allSongsAndArtists(){
    throw new RuntimeErrorException(null, "Not Implemented.");
}

/*
 * @return information of a song
 * Retrieve information about a song within the library
 */
public String songInfoString(Song song){
    throw new RuntimeErrorException(null, "Not Implemented.");
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
