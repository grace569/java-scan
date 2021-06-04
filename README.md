# java-scan

This project is a hypothetical project with two versions of users submitting scan requests and their unit tests; one for sequential scans and one for parallel scans exploring the usage of thread pool. The output of the program should be the total time taken for a user A to complete N number of scans. 

# Sequential 
For the sequential version, the scans are executed in order and thus the total time taken for user A to finish all their scans should be the sum of the duration of each scan. 

The unit test is performed on the User class, where scans are initiated through the `triggerScanRequests(int numOfRequests)` method. There are two test methods and each of them is repeated twice.  The first method triggers 5 scan requests and the expected total duration is 50 milliseconds. The second method triggers 3 scan requests and the expected total duration is 15 milliseconds. 

After running the unit test, it is observed that both of the tests were failed, and after repeating the unit test several times, although there were one or two successes, most of the test results were failures. The outcomes are always greater than the original expectations, the first method’s results range from 50-58 milliseconds and the second from 15-19 milliseconds. 

# Parallel 
For the parallel version, the scans are executed concurrently by several threads, thus the total time taken for user A to finish all their scans should be the maximum time taken for one of the scans to finish.  

Similar to the sequential version, the unit test is performed on the User class with the `triggerScanRequests(int numOfRequests)` method. The scans initiated should each take a random duration between 1 - 10 milliseconds. There is only one test method and it is repeated 10 times. The method triggers 5 scan requests and the expected total duration is less than or equal to 10 milliseconds. 
