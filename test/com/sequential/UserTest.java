package com.sequential;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    private User user;

    @BeforeEach
    public void createUser() throws InterruptedException {
        user = new User(123);
    }

    @RepeatedTest(2)
    @DisplayName("Total scan time for 5 sequential scans.")
    public void fiveSequentialScansTest() throws InterruptedException {
        user.triggerScanRequests(5);
        assertEquals(50, user.getTotalDurationInMillis());
    }

    @RepeatedTest(2)
    @DisplayName("Total scan time for 3 sequential scans.")
    public void threeSequentialScansTest() throws InterruptedException {
        user.triggerScanRequests(3);
        assertEquals(15, user.getTotalDurationInMillis());
    }

}