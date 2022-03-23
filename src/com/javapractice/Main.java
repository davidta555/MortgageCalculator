package com.javapractice;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final byte MONTHS_IN_YEARS = 12;
        final byte PERCENT = 100;

        Scanner scanner = new Scanner(System.in);

        //Principal
        System.out.print("Principal: ");
        int principal = scanner.nextInt();

        //Annual Interest Rate
        System.out.print("Annual Interest Rate: ");
        float annualInterest = scanner.nextFloat();
        float monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEARS;

        //Period
        System.out.print("Period (Years): ");
        byte period = scanner.nextByte();
        int numberOfPayments = period * MONTHS_IN_YEARS;

        //Mortgage Formula
        double interest = Math.pow( ( 1 + monthlyInterest ), numberOfPayments );
        double mortgagePayments = (principal * ( ( monthlyInterest * interest ) / ( interest - 1 ) ));

        NumberFormat monthlyPayment = NumberFormat.getCurrencyInstance();
        String monthlyPayments = monthlyPayment.format(mortgagePayments);

        System.out.println("Monthly Payments: " + monthlyPayments);
    }
}
