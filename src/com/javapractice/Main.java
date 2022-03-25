package com.javapractice;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int principal = (int) readNumber("Principal ($1K - $1M): ", 1000, 1000000);
        float annualInterest = (float) readNumber("Annual Interest Rate: ", 0, 30);
        byte period = (byte) readNumber("Period (Years): ", 1, 30);

        //Mortgage Formula
       double mortgagePayments = calculateMortgage(principal, annualInterest, period);

        NumberFormat monthlyPayment = NumberFormat.getCurrencyInstance();
        String monthlyPayments = monthlyPayment.format(mortgagePayments);

        System.out.println("Monthly Payments: " + monthlyPayments);
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
        final byte MONTHS_IN_YEARS = 12;
        final byte PERCENT = 100;

        float monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEARS;
        short numberOfPayments = (short)(period * MONTHS_IN_YEARS);

        double interest = Math.pow( ( 1 + monthlyInterest ), numberOfPayments );
        double mortgagePayments = (principal * ( ( monthlyInterest * interest ) / ( interest - 1 ) ));

        return  mortgagePayments;
    }
}
