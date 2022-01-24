package com.blz.day30;

import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InvoiceServiceTest {
    InvoiceGenerator invoiceGenerator = new InvoiceGenerator();

    @Before
    public void setUp() {
        invoiceGenerator = new InvoiceGenerator();
    }

    // testCase to write Total fare
    @Test
    public void givenDistanceAndTime_ShouldReturnTotalFare() {
        invoiceGenerator = new InvoiceGenerator();
        double distance = 2.0;
        int time = 5;
        double fare = invoiceGenerator.calculateFare(distance, time);
        Assertions.assertEquals(25, fare, 0.0);
    }

    //testCase to calculate the Minimum Charges
    @Test
    public void givenLessDistanceAndTime_ShouldReturnMinFare() {
        invoiceGenerator = new InvoiceGenerator();
        double distance = 0.1;
        int time = 1;
        double fare = invoiceGenerator.calculateFare(distance, time);
        Assertions.assertEquals(5, fare, 0.0);
    }

    //invoice generator for multiple rides
    @Test
    public void givenMultipleRides_ShouldReturnInvoiceSummary() {
        invoiceGenerator = new InvoiceGenerator();
        Ride[] rides = {new Ride(25.0, 30), new Ride(12.0, 20)};
        InvoiceSummary summary = invoiceGenerator.calculateFare(rides);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 420);
        Assertions.assertEquals(expectedInvoiceSummary, summary);
    }

    //testCase to return Invoice summary using userID
    @Test
    public void givenUserId_shouldReturnInvoiceSummary() {
        invoiceGenerator = new InvoiceGenerator();
        String userId = "sandipankande@gmail.com";
        Ride[] rides = {new Ride(2.0, 5),
                new Ride(0.1, 1)};
        invoiceGenerator.addRides(userId, rides);
        InvoiceSummary summary = invoiceGenerator.calculateFare(rides, "normal");
        InvoiceSummary invoiceSummary = invoiceGenerator.getInvoiceSummary(userId);
        Assertions.assertEquals(invoiceSummary, summary);

    }
}
