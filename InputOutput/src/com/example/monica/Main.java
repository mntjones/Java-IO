package com.example.monica;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static Locations locations = new Locations();



    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int loc = 64;

        while(true) {
            System.out.println(locations.get(loc).getDescription());
            // Won't work - updated the constructor - fully immutable, now

            if (loc == 0) {
                break;
            }

            Map<String, Integer> exits = locations.get(loc).getExits();
            System.out.println("Available exits are: ");
            for (String exit: exits.keySet()) {
                System.out.print(exit + ", ");
            }
            System.out.println();


            String direction = scanner.nextLine().toUpperCase();

            String[] directionArray = direction.split(" ");

            for (String s : directionArray) {
                String word = s.toUpperCase();

                switch (word) {
                    case "W": case "WEST":
                        direction = "W";
                        break;
                    case "E": case "EAST":
                        direction = "E";
                        break;
                    case "N": case "NORTH":
                        direction = "N";
                        break;
                    case "S": case "SOUTH":
                        direction = "S";
                        break;
                    case "Q": case "QUIT":
                        direction = "Q";
                        break;
                }
            }

            if (exits.containsKey(direction)) {
                loc = exits.get(direction);
            }
            else {
                System.out.println("You cannot go in that direction");
            }
        }
    }
}
