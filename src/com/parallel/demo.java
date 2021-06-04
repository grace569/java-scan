package com.parallel;

public class demo {

    public static void main(String[] args) throws InterruptedException {

        triggerUserRequest(123, 5);
        triggerUserRequest(234, 5);

    }


    private static void triggerUserRequest(int userID, int numOfRequests) throws InterruptedException {
        User user = new User(userID);
        user.triggerScans(numOfRequests);
        user.printTotalDurationOfScans();
    }

}
