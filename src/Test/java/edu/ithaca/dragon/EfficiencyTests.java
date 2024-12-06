package edu.ithaca.dragon;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import org.jfree.data.category.DefaultCategoryDataset;

import edu.ithaca.dragon.ArrayPlaylist;
import edu.ithaca.dragon.LinkedNodePlaylist;
import edu.ithaca.dragon.autodj.Song;
import edu.ithaca.dragon.autodj.data.SongDataIO;
import edu.ithaca.efficiency.EfficiencyChart;

public class EfficiencyTests {
//Max amount of songs is 100000
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

    public static long timeArrayPlaylistAllSongs() throws IOException{ //tests time it takes to get all songs
        Playlist playlist = sampleArrayPlaylist(10000);
        long start = System.nanoTime();
        playlist.allSongs();
        long end = System.nanoTime();
        long runTime = (end - start);
        return runTime;
    }

    public static long timeLNPlaylistAllSongs() throws IOException{ //tests time it takes to get all songs
        Playlist playlist = sampleLinkedNodePlaylist(10000);
        long start = System.nanoTime();
        playlist.allSongs();
        long end = System.nanoTime();
        long runTime = (end - start);
        return runTime;
    }

    public static long timeArrayPlaylistDuration() throws IOException{ //tests time it takes to get duration of the playlist
        Playlist playlist = sampleArrayPlaylist(10000);
        long start = System.nanoTime();
        playlist.duration();
        long end = System.nanoTime();
        long runTime = (end - start);
        return runTime;
    }

    public static long timeLNPlaylistDuration() throws IOException{ //tests time it takes to get duration of the playlist
        Playlist playlist = sampleLinkedNodePlaylist(10000);
        long start = System.nanoTime();
        playlist.duration();
        long end = System.nanoTime();
        long runTime = (end - start);
        return runTime;
    }

    public static DefaultCategoryDataset collectGrabBagPutData(GrabBag<String> testBag, String typeOfGrabBag){ //recieves a type of grab bag, tests its effieciency for a large amount of data and prints the times
        if (!testBag.isEmpty()){
            throw new RuntimeException("Test output is not acurate starting on bag with items");
        }
        final int numItemsToPutEachTime = 10000;
        final int numDataPointsToPrint = 50;
        final int numToAverageOver = 500;

        DefaultCategoryDataset dataset = new DefaultCategoryDataset( );
        System.out.println("Testing " + testBag.getClass().getSimpleName());
        System.out.println("Items in bag \t time to add a new item");
        for(int i=0; i<numDataPointsToPrint; i++){
            putManyItems(numItemsToPutEachTime, testBag);
            double avgTime = averageTimeForAPut(testBag, numToAverageOver);
            System.out.println((i+1)*numItemsToPutEachTime + " \t\t " + avgTime);
            dataset.addValue( avgTime, testBag.getClass().getSimpleName(), Integer.toString(i+1));
        }
        return dataset;
    }

    public static DefaultCategoryDataset collectGrabBagTakeData(GrabBag<String> testBag, String typeOfGrabBag){ //recieves a type of grab bag, tests its effieciency for a large amount of data and prints the times
        if (!testBag.isEmpty()){
            throw new RuntimeException("Test output is not acurate starting on bag with items");
        }
        final int numItemsToPutEachTime = 10000;
        final int numDataPointsToPrint = 50;
        final int numToAverageOver = 500;
        final int numItemsToTakeEachTime = 5000;

        
        DefaultCategoryDataset dataset = new DefaultCategoryDataset( );
        System.out.println("Testing " + testBag.getClass().getSimpleName());
        System.out.println("Items in bag \t time to add a new item");
        for(int i=0; i<numDataPointsToPrint; i++){
            putManyItems(numItemsToPutEachTime, testBag);
            takeManyItems(numItemsToTakeEachTime, testBag);
            double avgTime = averageTimeForATake(testBag, numToAverageOver);
            System.out.println((i+1)*numItemsToTakeEachTime + " \t\t " + avgTime);
            dataset.addValue( avgTime, testBag.getClass().getSimpleName(), Integer.toString(i+1));
        }
        return dataset;
    }

    public static DefaultCategoryDataset collectStackPushData(Stack<String> testStack, String typeOfStack){ //recieves a type of grab bag, tests its effieciency for a large amount of data and prints the times
        if (!testStack.isEmpty()){
            throw new RuntimeException("Test output is not acurate starting on bag with items");
        }
        final int numItemsToPushEachTime = 10000;
        final int numDataPointsToPrint = 50;
        final int numToAverageOver = 500;

        DefaultCategoryDataset dataset = new DefaultCategoryDataset( );
        System.out.println("Testing " + testStack.getClass().getSimpleName());
        System.out.println("Items in bag \t time to add a new item");
        for(int i=0; i<numDataPointsToPrint; i++){
            pushManyItems(numItemsToPushEachTime, testStack);
            double avgTime = averageTimeForAPush(testStack, numToAverageOver);
            System.out.println((i+1)*numItemsToPushEachTime + " \t\t " + avgTime);
            dataset.addValue( avgTime, testStack.getClass().getSimpleName(), Integer.toString(i+1));
        }
        return dataset;
    }

    public static DefaultCategoryDataset collectStackPopData(Stack<String> testStack, String typeOfStack){ //recieves a type of grab bag, tests its effieciency for a large amount of data and prints the times
        if (!testStack.isEmpty()){
            throw new RuntimeException("Test output is not acurate starting on bag with items");
        }
        final int numItemsToPutEachTime = 10000;
        final int numDataPointsToPrint = 50;
        final int numToAverageOver = 500;
        final int numItemsToTakeEachTime = 5000;

        
        DefaultCategoryDataset dataset = new DefaultCategoryDataset( );
        System.out.println("Testing " + testStack.getClass().getSimpleName());
        System.out.println("Items in bag \t time to add a new item");
        for(int i=0; i<numDataPointsToPrint; i++){
            pushManyItems(numItemsToPutEachTime, testStack);
            popManyItems(numItemsToTakeEachTime, testStack);
            double avgTime = averageTimeForAPop(testStack, numToAverageOver);
            System.out.println((i+1)*numItemsToTakeEachTime + " \t\t " + avgTime);
            dataset.addValue( avgTime, testStack.getClass().getSimpleName(), Integer.toString(i+1));
        }
        return dataset;
    }

    public static DefaultCategoryDataset collectQueueEnqueueData(Queue<String> testQueue, String typeOfQueue){ //recieves a type of grab bag, tests its effieciency for a large amount of data and prints the times
        if (!testQueue.isEmpty()){
            throw new RuntimeException("Test output is not acurate starting on bag with items");
        }
        final int numItemsToEnqueueEachTime = 10000;
        final int numDataPointsToPrint = 50;
        final int numToAverageOver = 500;

        DefaultCategoryDataset dataset = new DefaultCategoryDataset( );
        System.out.println("Testing " + testQueue.getClass().getSimpleName());
        System.out.println("Items in bag \t time to add a new item");
        for(int i=0; i<numDataPointsToPrint; i++){
            queueManyItems(numItemsToEnqueueEachTime, testQueue);
            double avgTime = averageTimeForEnqueue(testQueue, numToAverageOver);
            System.out.println((i+1)*numItemsToEnqueueEachTime + " \t\t " + avgTime);
            dataset.addValue( avgTime, testQueue.getClass().getSimpleName(), Integer.toString(i+1));
        }
        return dataset;
    }

    public static DefaultCategoryDataset collectQueueDequeueData(Queue<String> testQueue, String typeOfQueue){ //recieves a type of grab bag, tests its effieciency for a large amount of data and prints the times
        if (!testQueue.isEmpty()){
            throw new RuntimeException("Test output is not acurate starting on bag with items");
        }
        final int numItemsToEnqueueEachTime = 10000;
        final int numDataPointsToPrint = 50;
        final int numToAverageOver = 500;
        final int numItemsToTakeEachTime = 5000;

        DefaultCategoryDataset dataset = new DefaultCategoryDataset( );
        System.out.println("Testing " + testQueue.getClass().getSimpleName());
        System.out.println("Items in bag \t time to add a new item");
        for(int i=0; i<numDataPointsToPrint; i++){
            queueManyItems(numItemsToEnqueueEachTime, testQueue);
            dequeueManyItems(numItemsToTakeEachTime, testQueue);
            double avgTime = averageTimeForDequeue(testQueue, numToAverageOver);
            System.out.println((i+1)*numItemsToTakeEachTime + " \t\t " + avgTime);
            dataset.addValue( avgTime, testQueue.getClass().getSimpleName(), Integer.toString(i+1));
        }
        return dataset;
    }

    public static void main(String[] args){
        new EfficiencyChart(collectGrabBagPutData(new RandomListGrabBag<>(), "RandomListGrabBag"));
        new EfficiencyChart(collectGrabBagTakeData(new RandomListGrabBag<>(), "RandomListGrabBag TakeData"));
        new EfficiencyChart(collectStackPushData(new RightTopListStack<>(), "RightTopListStack"));
        new EfficiencyChart(collectStackPopData(new RightTopListStack<>(), "RightTopListStack PopData"));
        new EfficiencyChart(collectStackPushData(new LeftTopListStack<>(), "LeftTopListStack"));
        new EfficiencyChart(collectStackPopData(new LeftTopListStack<>(), "LeftTopListStack PopData"));
        new EfficiencyChart(collectQueueEnqueueData(new LeftEndListQueue<>(), "LeftEndListQueue"));
        new EfficiencyChart(collectQueueDequeueData(new LeftEndListQueue<>(), "LeftEndListQueue DequeueData"));
        new EfficiencyChart(collectQueueEnqueueData(new RightEndListQueue<>(), "RightEndListQueue"));
        new EfficiencyChart(collectQueueDequeueData(new RightEndListQueue<>(), "RightEndListQueue DequeueData"));
        
                

    }
    
}