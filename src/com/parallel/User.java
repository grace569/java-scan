package com.parallel;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class User {
    int userID;
    long totalDurationInMillis = 0;

    public User() {

    }

    public User(int userID) {
        this.userID = userID;
    }

    public void triggerScans(int numOfRequests){

        List<Callable<Long>> listOfScans = new ArrayList<>();
        ExecutorService pool = Executors.newFixedThreadPool(3);
        for (int i = 0; i < numOfRequests; i++) {
            ScanRequest sr = new ScanRequest(i, userID);
            listOfScans.add(sr);
        }
        try {
            List<Future<Long>> futures = pool.invokeAll(listOfScans);
            for (Future<Long> future : futures) {
                long temp = future.get();
                if (temp > totalDurationInMillis) {
                    totalDurationInMillis = temp;
                }
            }
        } catch (InterruptedException | ExecutionException e) {
            System.out.println(e);
        }
    }


    public long getTotalDurationInMillis() {
        return totalDurationInMillis;
    }

    public void printTotalDurationOfScans() {
        System.out.printf("User request for user %s took a total " +
                "time of %s milliseconds%n", userID, totalDurationInMillis);
    }
}
