package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PrimeTest {
    Prime prime;
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    @DisplayName("Tests the input with valid maximum range.")
    void testValidRange() {
        prime = new Prime(0, 1000);
        int expectedValue = 168;
        assertTrue(expectedValue == prime.getCount());
    }

    @Test
    @DisplayName("Tests boundary with firstNumber -1")
    void testInvalidInputFirstNumberNegative() {
        new Prime(-1, 1000);
        String expectedResponse = "Hoppsan, fel intervall angivet!";
        assertEquals(expectedResponse, outputStreamCaptor.toString().trim());
    }

    @Test
    @DisplayName("Tests boundary with lastNumber 1001")
    void testInvalidInputLastNumberOutsideRange() {
        new Prime(0, 1001);
        String expectedResponse = "Hoppsan, fel intervall angivet!";
        assertEquals(expectedResponse, outputStreamCaptor.toString().trim());
    }

    @Test
    @DisplayName("Tests input with firstNumber larger than lastNumber")
    void testInvalidInputFirstNumberLargerThanLastNumber() {
        new Prime(100, 10);
        String expectedResponse = "Hoppsan, fel intervall angivet!";
        assertEquals(expectedResponse, outputStreamCaptor.toString().trim());
    }

    @Test
    @DisplayName("Tests correct primes in full range")
    void testCorrectPrimesInFullInterval() {
        Prime prime = new Prime(0, 1000);
        List<Integer> expectedPrimes = List.of(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179, 181, 191, 193, 197, 199, 211, 223, 227, 229, 233, 239, 241, 251, 257, 263, 269, 271, 277, 281, 283, 293, 307, 311, 313, 317, 331, 337, 347, 349, 353, 359, 367, 373, 379, 383, 389, 397, 401, 409, 419, 421, 431, 433, 439, 443, 449, 457, 461, 463, 467, 479, 487, 491, 499, 503, 509, 521, 523, 541, 547, 557, 563, 569, 571, 577, 587, 593, 599, 601, 607, 613, 617, 619, 631, 641, 643, 647, 653, 659, 661, 673, 677, 683, 691, 701, 709, 719, 727, 733, 739, 743, 751, 757, 761, 769, 773, 787, 797, 809, 811, 821, 823, 827, 829, 839, 853, 857, 859, 863, 877, 881, 883, 887, 907, 911, 919, 929, 937, 941, 947, 953, 967, 971, 977, 983, 991, 997);
        assertEquals(expectedPrimes, prime.getPrimes());
    }

    @Test
    @DisplayName("Tests correct primes in a small interval within range")
    void testCorrectPrimesInLimitedInterval() {
        Prime prime = new Prime(10, 20);
        List<Integer> expectedPrimes = List.of(11, 13, 17, 19);
        assertEquals(expectedPrimes, prime.getPrimes());
    }

    @Test
    @DisplayName("Tests the output from printCount Method with valid input.")
    void testOutputPrintCount() {
        prime = new Prime(0, 1000);
        prime.printCount();
        String expectedResponse = "Hej, det finns 168 primtal mellan 0 och 1000";
        assertEquals(expectedResponse, outputStreamCaptor.toString().trim());
    }


    @Test
    @DisplayName("Tests the output from printSum Method with valid input.")
    void testOutputprintSum() {
        prime = new Prime(0, 1000);
        prime.printSum();
        String expectedResponse = "Och den totala summan av dessa primtal är 76127";
        assertEquals(expectedResponse, outputStreamCaptor.toString().trim());
    }

    @Test
    @DisplayName("Testing getCount getter functionality")
    void testGetCount() {
        prime = new Prime(0, 1000);
        int expectedValue = 168;
        assertTrue(expectedValue == prime.getCount());
    }

    @Test
    @DisplayName("Testing getSum getter functionality")
    void testGetSumOfPrimes() {
        prime = new Prime(0, 1000);
        int expectedValue = 76127;
        assertTrue(expectedValue == prime.getSumOfPrimes());
    }

}