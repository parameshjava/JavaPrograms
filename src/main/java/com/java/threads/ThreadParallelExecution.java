package com.java.threads;

public class ThreadParallelExecution {
    
    /**
     * Calculates the sum of all prime numbers upto the given range
     * 
     * @param range range to calculate sum of all prime numbers
     * @return prime numbers sum
     */
    public static long sumOfPrimes(int range) {
        long primesTotal = 3; // 1 + 2
        
        // Since all the even numbers are not prime, we are skipping even numbers
        for (int currentNumber = 3; currentNumber <= range; currentNumber += 2) {
            // Initially assume current number is a prime
            boolean isPrime = true;
            for (int factor = 3; factor <= (currentNumber / 2); factor++) {
                if(currentNumber % factor == 0) {
                    // Update current number is not a prime, when it has factor
                    isPrime = false;
                    // Since it has a factor and no need to continue the loop
                    break;
                }
            }
            // Add current number to the series, when there is no factor available
            if(isPrime) {
                primesTotal += currentNumber; 
            }
        }
        return primesTotal;
    }
    
    public static void sequentialExecution() {
        long startTime = System.currentTimeMillis();
        long sum1 = sumOfPrimes(500000);
        System.out.println("Sume of primes of 500000 : " + sum1);
        
        long sum2 = sumOfPrimes(530000);
        System.out.println("Sume of primes of 530000 : " + sum2);
        
        long endTime = System.currentTimeMillis();
        System.out.println("Sequential Execution time : " + (endTime - startTime));
    }
    
    public static void parallelExecution() throws InterruptedException {
        long startTime = System.currentTimeMillis();
        Thread trd1 = new Thread("My Thread 1") {
            public void run() {
                long sum = sumOfPrimes(500000);
                System.out.println("Sume of primes of 500000 : " + sum);
            }
        };
        Thread trd2 = new Thread("My Thread 2") {
            public void run() {
                long sum = sumOfPrimes(530000);
                System.out.println("Sume of primes of 530000 : " + sum);
            }
        };
        trd1.start();
        trd2.start();
        trd1.join();
        trd2.join();
        long endTime = System.currentTimeMillis();
        System.out.println("Parellel Execution time : " + (endTime - startTime));
    }
    public static void main(String[] args) throws InterruptedException {
        sequentialExecution();
        parallelExecution();
    }
    
}
