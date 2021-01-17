package mergesort;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Mergesort {
    private static final int INIT_NUMofINT = 128;
    private static final int POOLSIZE = 10;
    private static ExecutorService executor = null;
    private static volatile ArrayList<Future> results = null;
    public static LinkedList<LinkedList<Integer>> partialResults = new LinkedList<>();

    public static void init(){
        executor = Executors.newFixedThreadPool(POOLSIZE);
        results = new ArrayList<>(); // futures
        for(int i = 0; i<POOLSIZE; i++) {
            results.add(null);
        }

        Random random = new Random();


        for(int i = 0; i<INIT_NUMofINT; i++){
            int randInt = random.nextInt(1000);
            LinkedList<Integer> tempList = new LinkedList<>();
            tempList.add(randInt);
            partialResults.add(tempList);
        }
    }

    public static void printPartialResults(){
        for(int i = 0; i < partialResults.size(); i++) {
            for (int j = 0; j < partialResults.get(i).size(); j++) {
                System.out.print(" " + partialResults.get(i).get(j));
            }
            System.out.print(" ;  ");
        }
        System.out.println();
    }


    //------------------------------------------------ m a i n -----------------------------------------------------------------
    public static void main(String[] args) {
        init();
        System.out.println("----------------------------------- Initial --------------------------------------------------");
        printPartialResults();

        while(partialResults.size()!=1) {
            try {
                checkTasks();
                Thread.sleep(10);
                System.out.println(partialResults.size());
            } catch (Exception e) {
                System.err.println("Caught exception: " + e.getMessage());
            }
        }
        System.out.println("----------------------------------- Sorted --------------------------------------------------");
        printPartialResults(); // here not partial. it is the result.

    }

    public static void checkTasks(){
        for(int i = 0; i < results.size(); i++) {
            if(( results.get(i) == null || results.get(i).isDone() || results.get(i).isCancelled()) && partialResults.size() >= 2)
            {
                results.set(i, executor.submit(new Merger(partialResults.pollFirst(), partialResults.pollFirst())));
            }
        }
    }
}
