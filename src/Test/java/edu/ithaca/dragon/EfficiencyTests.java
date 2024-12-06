package edu.ithaca.dragon;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import javax.management.RuntimeErrorException;

import org.jfree.data.category.DefaultCategoryDataset;

import edu.ithaca.dragon.ArrayPlaylist;
import edu.ithaca.dragon.LinkedNodePlaylist;
import edu.ithaca.dragon.autodj.Song;
import edu.ithaca.dragon.autodj.data.SongDataIO;
import edu.ithaca.efficiency.EfficiencyChart;

public class EfficiencyTests {
//Max amount of songs is 97349
    public static Playlist sampleArrayPlaylist(int amountOfData) throws IOException{
        List<Song> allSongs = SongDataIO.buildSongListFromCsv("src/test/resources/Localify_100k_Tracks.csv");
        Playlist arrayPlaylist = new ArrayPlaylist(50, "APlaylist");
        for (int i=0; i<amountOfData; i++){
            arrayPlaylist.add(allSongs.get(i));
        }
        return arrayPlaylist;
    }

    public static Playlist sampleLinkedNodePlaylist(int amountOfData) throws IOException{
        List<Song> allSongs = SongDataIO.buildSongListFromCsv("src/test/resources/Localify_100k_Tracks.csv");

        Playlist linkedNodePlaylist = new LinkedNodePlaylist("LNPlaylist");
        for (int i=0; i<amountOfData; i++){
            linkedNodePlaylist.add(allSongs.get(i));
        }
        return linkedNodePlaylist;
    }

    public static long timeAllSongs(Playlist playlist, int numToAverage) throws IOException{ //tests time it takes to get all songs
        long total = 0;
        for (int i=0; i<numToAverage; i++){
            long start = System.nanoTime();
            playlist.allSongs();
            long end = System.nanoTime();
            long runTime = (end - start);
            total+= runTime;
        }
        return total/numToAverage;
    }

    public static long timeDuration(Playlist playlist, int numToAverage) throws IOException{ //tests time it takes to get the duration of a playist
        long total = 0;
        for (int i=0; i<numToAverage; i++){
            long start = System.nanoTime();
            playlist.duration();
            long end = System.nanoTime();
            long runTime = (end - start);
            total+= runTime;
        }
        return total/numToAverage;
    }

    public static long timeAddSong(Playlist playlist, int numToAverage) throws IOException{ //tests time it takes to get add songs
        List<Song> allSongs = SongDataIO.buildSongListFromCsv("src/test/resources/Localify_100k_Tracks.csv");
        Song songToAdd = allSongs.get(97349);
        long total = 0;
        for (int i=0; i<numToAverage; i++){
            long start = System.nanoTime();
            playlist.add(songToAdd);
            long end = System.nanoTime();
            long runTime = (end - start);
            total+= runTime;
        }
        return total/numToAverage;
    }

    public static long timeRemoveSong(Playlist playlist, int numToAverage) throws IOException{ //tests time it takes to get add songs
        List<Song> allSongs = SongDataIO.buildSongListFromCsv("src/test/resources/Localify_100k_Tracks.csv");
        playlist.add(allSongs.get(0));
        Song songToRemove = allSongs.get(0);
        long total = 0;
        for (int i=0; i<numToAverage; i++){
            long start = System.nanoTime();
            playlist.remove(songToRemove);
            long end = System.nanoTime();
            long runTime = (end - start);
            total+= runTime;
            playlist.add(allSongs.get(0));
        }
        return total/numToAverage;
    }

    public static long timePlayNext(Playlist playlist, int numToAverage) throws IOException{ //tests time it takes to get add songs
        long total = 0;
        for (int i=0; i<numToAverage; i++){
            long start = System.nanoTime();
            playlist.playNext();
            long end = System.nanoTime();
            long runTime = (end - start);
            total+= runTime;
        }
        return total/numToAverage;
    }


    public static DefaultCategoryDataset collectAllSongsData(String playlistType) throws IOException{ //recieves a type of grab bag, tests its effieciency for a large amount of data and prints the times
        
        final int numSongsToAddFirst = 1000;
        final int numDataPointsToPrint = 50;
        final int numToAverageOver = 500;
        Playlist playlist = null;
        DefaultCategoryDataset dataset = new DefaultCategoryDataset( );
        System.out.println("Testing " + playlistType);
        for(int i=1; i<numDataPointsToPrint; i++){
            int numSongsToAdd = numSongsToAddFirst * i;
            if (playlistType == "ArrayPlaylist"){
                playlist = sampleArrayPlaylist(numSongsToAdd);
            }
            else if (playlistType == "LinkedNodePlaylist"){
                playlist = sampleLinkedNodePlaylist(numSongsToAdd);
            }
            else{throw new RuntimeErrorException(null, "Playlist Type Invalid");}
            double avgTime = timeAllSongs(playlist, numToAverageOver);
            System.out.println((i+1)*numSongsToAdd + " \t\t " + avgTime);
            dataset.addValue( avgTime, playlistType, Integer.toString(i+1));
        }
        return dataset;
    }

    public static DefaultCategoryDataset collectDurationData(String playlistType) throws IOException{ //recieves a type of grab bag, tests its effieciency for a large amount of data and prints the times
        
        final int numSongsToAddFirst = 1000;
        final int numDataPointsToPrint = 50;
        final int numToAverageOver = 500;
        Playlist playlist = null;
        DefaultCategoryDataset dataset = new DefaultCategoryDataset( );
        System.out.println("Testing " + playlistType);
        for(int i=1; i<numDataPointsToPrint; i++){
            int numSongsToAdd = numSongsToAddFirst * i;
            if (playlistType == "ArrayPlaylist"){
                playlist = sampleArrayPlaylist(numSongsToAdd);
            }
            else if (playlistType == "LinkedNodePlaylist"){
                playlist = sampleLinkedNodePlaylist(numSongsToAdd);
            }
            else{throw new RuntimeErrorException(null, "Playlist Type Invalid");}
            double avgTime = timeDuration(playlist, numToAverageOver);
            System.out.println((i+1)*numSongsToAdd + " \t\t " + avgTime);
            dataset.addValue( avgTime, playlistType, Integer.toString(i+1));
        }
        return dataset;
    }

    public static DefaultCategoryDataset collectAddSongData(String playlistType) throws IOException{ //recieves a type of grab bag, tests its effieciency for a large amount of data and prints the times
        
        final int numSongsToAddFirst = 1000;
        final int numDataPointsToPrint = 50;
        final int numToAverageOver = 500;
        Playlist playlist = null;
        DefaultCategoryDataset dataset = new DefaultCategoryDataset( );
        System.out.println("Testing " + playlistType);
        for(int i=1; i<numDataPointsToPrint; i++){
            int numSongsToAdd = numSongsToAddFirst * i;
            if (playlistType == "ArrayPlaylist"){
                playlist = sampleArrayPlaylist(numSongsToAdd);
            }
            else if (playlistType == "LinkedNodePlaylist"){
                playlist = sampleLinkedNodePlaylist(numSongsToAdd);
            }
            else{throw new RuntimeErrorException(null, "Playlist Type Invalid");}
            double avgTime = timeAddSong(playlist, numToAverageOver);
            System.out.println((i+1)*numSongsToAdd + " \t\t " + avgTime);
            dataset.addValue( avgTime, playlistType, Integer.toString(i+1));
        }
        return dataset;
    }

    public static DefaultCategoryDataset collectRemoveSongData(String playlistType) throws IOException{ //recieves a type of grab bag, tests its effieciency for a large amount of data and prints the times
        
        final int numSongsToAddFirst = 1000;
        final int numDataPointsToPrint = 50;
        final int numToAverageOver = 500;
        Playlist playlist = null;
        DefaultCategoryDataset dataset = new DefaultCategoryDataset( );
        System.out.println("Testing " + playlistType);
        for(int i=1; i<numDataPointsToPrint; i++){
            int numSongsToAdd = numSongsToAddFirst * i;
            if (playlistType == "ArrayPlaylist"){
                playlist = sampleArrayPlaylist(numSongsToAdd);
            }
            else if (playlistType == "LinkedNodePlaylist"){
                playlist = sampleLinkedNodePlaylist(numSongsToAdd);
            }
            else{throw new RuntimeErrorException(null, "Playlist Type Invalid");}
            double avgTime = timeRemoveSong(playlist, numToAverageOver);
            System.out.println((i+1)*numSongsToAdd + " \t\t " + avgTime);
            dataset.addValue( avgTime, playlistType, Integer.toString(i+1));
        }
        return dataset;
    }

    public static DefaultCategoryDataset collectPlayNextData(String playlistType) throws IOException{ //recieves a type of grab bag, tests its effieciency for a large amount of data and prints the times
        
        final int numSongsToAddFirst = 1000;
        final int numDataPointsToPrint = 50;
        final int numToAverageOver = 500;
        Playlist playlist = null;
        DefaultCategoryDataset dataset = new DefaultCategoryDataset( );
        System.out.println("Testing " + playlistType);
        for(int i=1; i<numDataPointsToPrint; i++){
            int numSongsToAdd = numSongsToAddFirst * i;
            if (playlistType == "ArrayPlaylist"){
                playlist = sampleArrayPlaylist(numSongsToAdd);
            }
            else if (playlistType == "LinkedNodePlaylist"){
                playlist = sampleLinkedNodePlaylist(numSongsToAdd);
            }
            else{throw new RuntimeErrorException(null, "Playlist Type Invalid");}
            double avgTime = timePlayNext(playlist, numToAverageOver);
            System.out.println((i+1)*numSongsToAdd + " \t\t " + avgTime);
            dataset.addValue( avgTime, playlistType, Integer.toString(i+1));
        }
        return dataset;
    }


    public static void main(String[] args) throws IOException{
        new EfficiencyChart(collectAllSongsData("ArrayPlaylist"));
        new EfficiencyChart(collectAllSongsData("LinkedNodePlaylist"));
        new EfficiencyChart(collectDurationData("ArrayPlaylist"));
        new EfficiencyChart(collectDurationData("LinkedNodePlaylist"));
        new EfficiencyChart(collectAddSongData("ArrayPlaylist"));
        new EfficiencyChart(collectAddSongData("LinkedNodePlaylist"));
        new EfficiencyChart(collectRemoveSongData("ArrayPlaylist"));
        new EfficiencyChart(collectRemoveSongData("LinkedNodePlaylist"));
        new EfficiencyChart(collectPlayNextData("ArrayPlaylist"));
        new EfficiencyChart(collectPlayNextData("LinkedNodePlaylist"));
    }
    
}