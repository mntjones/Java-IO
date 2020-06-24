package com.example.monica;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Example {

    public static void main(String[] args) {
        int result = divide();
        System.out.println(result);

    }

    private static int divide() {
        int x, y;


        try {
            x = getInt();
            y= getInt();
        }
        catch (NoSuchElementException e) {
            throw new ArithmeticException("No suitable input");
        }

        System.out.println("x is " + x + " and y is " + y);
        try{
            return x / y;
        }
        catch (ArithmeticException e) {
            throw new ArithmeticException("Attempt to divide by zero");
        }

    }

    private static int getInt() {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter an integer: ");
        while(true) {
            try {
                return s.nextInt();
            }
            catch(InputMismatchException e){
                // keep trying to get valid input
                s.nextLine();
                System.out.println("Please enter a valid integer: ");
            }
        }

    }
}
