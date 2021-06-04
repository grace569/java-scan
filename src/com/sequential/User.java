package com.sequential;

public class User {
    int userID;
    long totalDurationInMillis;

    public User() {

    }

    public User(int userID) {
        this.userID = userID;
    }

    public void printTotalDurationOfScans() {
        System.out.printf("User request for user %s took a total " +
                "time of %s milliseconds%n", userID, totalDurationInMillis);
    }

    public void triggerScanRequests(int numOfRequests) throws InterruptedException {
        for (int i = 0; i < numOfRequests; i++) {
            ScanRequest sr = new ScanRequest(i, userID);
            sr.startNewScan();
            Thread.sleep(i * 5);
            sr.finishScan();
            totalDurationInMillis += sr.getDurationInMillis();
        }
    }

    public long getTotalDurationInMillis() {
        return totalDurationInMillis;
    }
}
