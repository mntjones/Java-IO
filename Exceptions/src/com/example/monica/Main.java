package com.example.monica;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
//        int x = 99;
//        int y = 0;
//
//        System.out.println(divideLBYL(x,y));
//        System.out.println(divideEAFP(x,y));
//        System.out.println(divide(x,y));

        int x = getInt();
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
}
