package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

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
        assertTrue(168 == prime.getCount());
    }

    @Test
    @DisplayName("Tests firstNumber boundary with negative value -1")
    void testInvalidInputFirstNumberNegative() {
        new Prime(-1, 1000);
        String expectedResponse = "Hoppsan, fel intervall angivet!";
        assertEquals(expectedResponse, outputStreamCaptor.toString().trim());
    }

    @Test
    @DisplayName("Tests lastNumber boundary with value over 1000")
    void testInvalidInputLastNumberOutsideRange() {
        new Prime(0, 1001);
        String expectedResponse = "Hoppsan, fel intervall angivet!";
        assertEquals(expectedResponse, outputStreamCaptor.toString().trim());
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
    @DisplayName("Tests the output from printCount Method with valid input.")
    void testOutputprintSum() {
        prime = new Prime(0, 1000);
        prime.printSum();
        String expectedResponse = "Och den totala summan av dessa primtal är 76127";
        assertEquals(expectedResponse, outputStreamCaptor.toString().trim());
    }

    @Test
    @DisplayName("Testing getCount getter functionality")
    void testGetCount(){
        prime = new Prime(0, 1000);
        assertTrue(168 == prime.getCount());
    }

    @Test
    @DisplayName("Testing getSum getter functionality")
    void testGetSumOfPrimes(){
        prime = new Prime(0, 1000);
        assertTrue(76127 == prime.getSumOfPrimes());
    }

}