package org.example;

import java.util.List;

public class SavedCode {
    private List<Integer> primes;


    /**
     * When the primes list is empty or the smallest prime in the list is greater than the square root of the number being checked, the method falls back to the basic divisibility check (iterating from 2 to the square root of the number).
     * Once the primes list has enough elements (i.e., it contains primes smaller than or equal to the square root of the number being checked), the method uses the list for the divisibility check.
     * @param number
     * @return
     */
    private boolean numIsPrime(int number) {
        if (number <= 1) return false;
        if (number == 2) return true; // Handle the first prime number

        // Use basic divisibility check if primes list is not yet useful
        if (primes.isEmpty() || primes.get(0) > Math.sqrt(number)) {
            for (int i = 2; i <= Math.sqrt(number); i++) {
                if (number % i == 0) return false;
            }
            return true;
        }

        // Use primes list for divisibility check
        for (int prime : primes) {
            if (prime * prime > number) break;
            if (number % prime == 0) return false;
        }
        return true;
    }
}
