package com.example.monica;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
//        int x = 99;
//        int y = 0;
//
//        System.out.println(divideLBYL(x,y));
//        System.out.println(divideEAFP(x,y));
//        System.out.println(divide(x,y));

        int x = getIntEAFP();
        System.out.println("x is: " + x);

    }

    private static int divideLBYL (int x, int y) {
        // Look Before You Leap - handle the exception before running operation,
        // make sure you test for exceptions
        if(y != 0) {
            return x/y;
        }
        else {
            return 0;
        }
    }

    private static int divideEAFP(int x, int y) {
        // Easier to Ask for Forgiveness than Permission
        // run the operation first, then deal with outcome
        try {
            return x/y;
        }
        catch (ArithmeticException e) {
            return 0;
        }
    }

    private static int divide(int x, int y) {
        // doesn't do any checking to make sure not dividing by zero
        return x/y;
    }

    public static int getInt() {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter an integer: ");
        // doesn't do any checking to make sure input is an integer
        return s.nextInt();
    }

    public static int getIntLBYL() {
        Scanner s = new Scanner(System.in);
        boolean isValid = true;
        System.out.println("Enter an integer: ");
        String input = s.next();
        // checks for integer
        for (int i=0; i<input.length(); i++) {
            if(!Character.isDigit(input.charAt(i))) {
                isValid = false;
                break;
            }
        }

        if (isValid) {
            return Integer.parseInt(input);
        }
        return 0;
    }

    public static int getIntEAFP() {
        Scanner s = new Scanner(System.in);
        boolean isValid = true;
        System.out.println("Enter an integer: ");
        // catches error after running operation
        try {
            return s.nextInt();
        }
        catch(InputMismatchException e) {
            return 0;
        }
    }
}

// Exception and RuntimeException are classes defined in Java.lang
// other exceptions are subclasses of one of these.

