package com.javapractice;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int principal;
        float annualInterest;
        byte period;

        Scanner scanner = new Scanner(System.in);

        //Principal
        while (true) {
            System.out.print("Principal ($1K - $1M): ");
            principal = scanner.nextInt();
            if (principal >= 1000 && principal <= 1000000)
                break;
            System.out.println("Enter an amount between $1,000 and $1,000,000");
        }

        //Annual Interest Rate
        while (true) {
            System.out.print("Annual Interest Rate: ");
            annualInterest = scanner.nextFloat();
            if (annualInterest > 0 && annualInterest <= 30)
                break;
            System.out.println("Enter a number greater than 0 and less than or equal to 30");
        }

        //Period
        while (true) {
            System.out.print("Period (Years): ");
            period = scanner.nextByte();
            if (period >= 1 && period <= 30)
                break;
            System.out.println("Enter a number between 1 and 30");
        }

        //Mortgage Formula
       double mortgagePayments = calculateMortgage(principal, annualInterest, period);

        NumberFormat monthlyPayment = NumberFormat.getCurrencyInstance();
        String monthlyPayments = monthlyPayment.format(mortgagePayments);

        System.out.println("Monthly Payments: " + monthlyPayments);
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
