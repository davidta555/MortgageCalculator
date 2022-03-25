package com.javapractice;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    final static byte MONTHS_IN_YEARS = 12;
    final static byte PERCENT = 100;

    public static void main(String[] args) {
        int principal = (int) readNumber("Principal ($1K - $1M): ", 1000, 1000000);
        float annualInterest = (float) readNumber("Annual Interest Rate: ", 0, 30);
        byte period = (byte) readNumber("Period (Years): ", 1, 30);

        //Mortgage
       double mortgagePayments = calculateMortgage(principal, annualInterest, period);
        String monthlyPayments = NumberFormat.getCurrencyInstance().format(mortgagePayments);
        System.out.println();
        System.out.println("MORTGAGE");
        System.out.println("--------");
        System.out.println("Monthly Payments: " + monthlyPayments);

        //Payment Schedule
        System.out.println();
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("----------------");
        for (short month = 1; month <= period * MONTHS_IN_YEARS; month++) {
            double balance = calculateBalance(principal, annualInterest, period, month);
            System.out.println(NumberFormat.getCurrencyInstance().format(balance));
        }
    }

    public static double readNumber(String prompt, double min, double max) {
        Scanner scanner = new Scanner(System.in);
        double value;

        while (true) {
            System.out.print(prompt);
            value = scanner.nextDouble();
            if (value >= min && value <= max)
                break;
            System.out.println("Enter a value between " + min + "and " + max);
        }
        return value;
    }

    public static double calculateMortgage(
            int principal,
            float annualInterest,
            byte period) {

        float monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEARS;
        short numberOfPayments = (short)(period * MONTHS_IN_YEARS);

        double interest = Math.pow( ( 1 + monthlyInterest ), numberOfPayments );
        double mortgagePayments = (principal * ( ( monthlyInterest * interest ) / ( interest - 1 ) ));

        return  mortgagePayments;
    }

    public static double calculateBalance(
            int principal,
            float annualInterest,
            byte period,
            short numberOfPaymentsMade) {

        float monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEARS;
        short numberOfPayments = (short)(period * MONTHS_IN_YEARS);

        double balance = principal
                * (Math.pow(1 + monthlyInterest, numberOfPayments) - Math.pow(1 + monthlyInterest, numberOfPaymentsMade))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);

        return balance;
    }
}
