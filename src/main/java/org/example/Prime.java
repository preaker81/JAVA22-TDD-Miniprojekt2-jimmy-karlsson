package org.example;

import java.util.ArrayList;
import java.util.List;

/**
 * This class calculates and stores prime numbers within a given range.
 */
public class Prime {

    // Fields
    private List<Integer> primes; // Stores the prime numbers found within the specified range.
    private int count = 0; // Tracks the total count of prime numbers found.
    private int sumOfPrimes = 0; // Stores the sum of all prime numbers found.

    /**
     * Constructor to initialize the Prime object.
     *
     * @param firstNumber The starting number of the range.
     * @param lastNumber  The ending number of the range.
     */
    public Prime(int firstNumber, int lastNumber) {
        primes = new ArrayList<>();
        // Check if the range is valid (0 to 1000)
        if (firstNumber < 0 || lastNumber > 1000 || firstNumber > lastNumber) {
            printInvalidRangeMsg();
        } else {
            // After calculation, primes list will contain all prime numbers found.
            calculatePrimes(firstNumber, lastNumber);
        }
    }


// This code does not use the List of
    private boolean numIsPrime(int number, int divisor) {
        // Base cases
        if (number <= 1) return false; // Numbers less than or equal to 1 are not prime
        if (divisor > Math.sqrt(number)) return true; // No divisors found, hence prime

        // If number is divisible by divisor, it's not a prime
        if (number % divisor == 0) return false;

        // Recursively check for next divisor
        return numIsPrime(number, divisor + 1);
    }

    private void calculatePrimes(int current, int stop) {

        if (current > stop) return; // End of range

        // Check if current number is prime and process accordingly
        if (numIsPrime(current, 2)) { // Starting divisor is 2
            primes.add(current);
            ++count;
            sumOfPrimes += current;
        }

        // Recursively check for the next number
        calculatePrimes(current + 1, stop);
    }


    // Print Methods
    public void printCount() {
        System.out.println("Hej, det finns " + count + " primtal mellan 0 och 1000");
    }

    public void printSum() {
        System.out.println("Och den totala summan av dessa primtal är " + sumOfPrimes);
    }

    public void printInvalidRangeMsg() {
        System.out.println("Hoppsan, fel intervall angivet!");
    }


    // Getters & Setters
    public int getCount() {
        return count;
    }

    public int getSumOfPrimes() {
        return sumOfPrimes;
    }

    public List<Integer> getPrimes(){
        return primes;
    }

//    public static void main(String[] args) {
//        Prime prime = new Prime(0, 1000);
//        prime.printCount();
//        prime.printSum();
//        System.out.println(prime.getPrimes());
//    }

}

