package com.parallel;

import java.util.Random;
import java.util.concurrent.Callable;

public class ScanRequest implements Callable {
    int scanID;
    int userID;
    long startTime;
    long durationInMillis;

    public ScanRequest() {

    }

    public ScanRequest(int scanID, int userID){
        this.scanID = scanID;
        this.userID = userID;
    }

    public void startNewScan(){
        startTime = System.currentTimeMillis();
    }

    public void finishScan(){
        durationInMillis = System.currentTimeMillis() - startTime;
        System.out.printf("Scan %s finished after %s milliseconds%n", scanID, durationInMillis);
    }

    public long getDurationInMillis() {
        return durationInMillis;
    }


    @Override
    public Long call() throws Exception {
        startNewScan();
        try {
            Random r = new Random();
            Thread.sleep(r.nextInt(9)+1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        finishScan();
        return durationInMillis;
    }
}
