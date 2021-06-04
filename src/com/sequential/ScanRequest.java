package com.sequential;

public class ScanRequest {
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

}
