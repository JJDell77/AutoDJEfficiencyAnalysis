package edu.ithaca.dragon;

import org.jfree.data.category.DefaultCategoryDataset;

import edu.ithaca.dragon.LeftEndListQueue;
import edu.ithaca.dragon.datastructures.stack.LeftTopListStack;
import edu.ithaca.dragon.datastructures.stack.RightTopListStack;
import edu.ithaca.dragon.datastructures.queue.Queue;
import edu.ithaca.dragon.datastructures.stack.Stack;
import edu.ithaca.efficiency.EfficiencyChart;
import edu.ithaca.dragon.datastructures.queue.RightEndListQueue;

public class EfficiencyTests {

    public static long timeAPut(GrabBag<String> grabBag){ //tests time it takes to add something to a grab bag
        long start = System.nanoTime();
        grabBag.putSomethingIn("an example string");
        long end = System.nanoTime();
        long runTime = (end - start);
        return runTime;
    }

    public static long timeATake(GrabBag<String> grabBag){ //tests time it takes to take something out of a grab bag
        long start = System.nanoTime();
        grabBag.takeSomethingOut();
        long end = System.nanoTime();
        long runTime = (end - start);
        return runTime;
    }

    public static long timeAPush(Stack<String> stack){ //tests time it takes to add something to a grab bag
        long start = System.nanoTime();
        stack.push("an example string");
        long end = System.nanoTime();
        long runTime = (end - start);
        return runTime;
    }

    public static long timeAPop(Stack<String> stack){ //tests time it takes to pop something from a grab bag
        long start = System.nanoTime();
        stack.pop();
        long end = System.nanoTime();
        long runTime = (end - start);
        return runTime;
    }

    public static long timeEnqueue(Queue<String> queue){ //tests time it takes to add something to a Queue
        long start = System.nanoTime();
        queue.enqueue("an example string");
        long end = System.nanoTime();
        long runTime = (end - start);
        return runTime;
    }

    public static long timeDequeue(Queue<String> queue){ //tests time it takes to dequeue something from a Queue
        long start = System.nanoTime();
        queue.dequeue();
        long end = System.nanoTime();
        long runTime = (end - start);
        return runTime;
    }

    public static long averageTimeForAPut(GrabBag<String> grabBag, int numPutsToAverage){ //tests average time it takes to put a lot of stuff into a grab bag
        long total = 0;
        for (int i=0; i<numPutsToAverage; i++){
            total += timeAPut(grabBag);
        }
        return total/numPutsToAverage;
    }

    public static long averageTimeForATake(GrabBag<String> grabBag, int numPutsToAverage){ //tests average time it takes to take a lot of stuff out of a grab bag
        long total = 0;
        for (int i=0; i<numPutsToAverage; i++){
            total += timeATake(grabBag);
        }
        return total/numPutsToAverage;
    }

    public static long averageTimeForAPush(Stack<String> stack, int numPutsToAverage){ //tests average time it takes to put a lot of stuff into a grab bag
        long total = 0;
        for (int i=0; i<numPutsToAverage; i++){
            total += timeAPush(stack);
        }
        return total/numPutsToAverage;
    }

    public static long averageTimeForAPop(Stack<String> stack, int numPutsToAverage){ //tests average time it takes to pop a lot of stuff out of a grab bag
        long total = 0;
        for (int i=0; i<numPutsToAverage; i++){
            total += timeAPop(stack);
        }
        return total/numPutsToAverage;
    }

    public static long averageTimeForEnqueue(Queue<String> queue, int numPutsToAverage){ //tests average time it takes to put a lot of stuff into a Queue
        long total = 0;
        for (int i=0; i<numPutsToAverage; i++){
            total += timeEnqueue(queue);
        }
        return total/numPutsToAverage;
    }

    public static long averageTimeForDequeue(Queue<String> queue, int numPutsToAverage){ //tests average time it takes to dequeue a lot of stuff out of a Queue
        long total = 0;
        for (int i=0; i<numPutsToAverage; i++){
            total += timeDequeue(queue);
        }
        return total/numPutsToAverage;
    }

    public static void putManyItems(int putCount, GrabBag<String> grabBag) { //puts a bunch of stuff in a grab bag
        for (int i=0; i<putCount; i++){
            grabBag.putSomethingIn("an example string");
        }
    }

    public static void takeManyItems(int takeCount, GrabBag<String> grabBag) { 
        for (int i=0; i<takeCount; i++){
            grabBag.takeSomethingOut();
        }
    }

    public static void pushManyItems(int putCount, Stack<String> stack) { //puts a bunch of stuff in a grab bag
        for (int i=0; i<putCount; i++){
            stack.push("an example string");
        }
    }

    public static void popManyItems(int popCount, Stack<String> stack) { 
        for (int i=0; i<popCount; i++){
            stack.pop();
        }
    }

    public static void queueManyItems(int putCount, Queue<String> queue) { //puts a bunch of stuff in a grab bag
        for (int i=0; i<putCount; i++){
            queue.enqueue("an example string");
        }
    }

    public static void dequeueManyItems(int dequeueCount, Queue<String> queue) { //puts a bunch of stuff in a grab bag
        for (int i=0; i<dequeueCount; i++){
            queue.dequeue();
        }
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