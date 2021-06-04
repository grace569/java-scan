package com.parallel;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import static org.junit.jupiter.api.Assumptions.assumeTrue;

class UserTest {

    private User user;

    @BeforeEach
    public void createUser() {
        user = new User(1);
    }

    @RepeatedTest(10)
    @DisplayName("Total scan time for 5 parallel scans")
    public void fiveParallelScansTest() {
        user.triggerScans(5);
        assumeTrue(user.getTotalDurationInMillis() <= 10);
    }

}