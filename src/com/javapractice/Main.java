package com.javapractice;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final byte MONTHS_IN_YEARS = 12;
        final byte PERCENT = 100;

        int principal;
        float monthlyInterest;
        int numberOfPayments;

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
            float annualInterest = scanner.nextFloat();
            if (annualInterest > 0 && annualInterest <= 30) {
                monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEARS;
                break;
            }
            System.out.println("Enter a number greater than 0 and less than or equal to 30");
        }

        //Period
        while (true) {
            System.out.print("Period (Years): ");
            byte period = scanner.nextByte();
            if (period >= 1 && period <= 30) {
                numberOfPayments = period * MONTHS_IN_YEARS;
                break;
            }
            System.out.println("Enter a number between 1 and 30");
        }

        //Mortgage Formula
        double interest = Math.pow( ( 1 + monthlyInterest ), numberOfPayments );
        double mortgagePayments = (principal * ( ( monthlyInterest * interest ) / ( interest - 1 ) ));

        NumberFormat monthlyPayment = NumberFormat.getCurrencyInstance();
        String monthlyPayments = monthlyPayment.format(mortgagePayments);

        System.out.println("Monthly Payments: " + monthlyPayments);
    }
}
