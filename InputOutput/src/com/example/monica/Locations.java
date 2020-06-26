package com.example.monica;

import java.io.*;
import java.util.*;

public class Locations implements Map<Integer, Location> {
    private static Map<Integer, Location> locations = new LinkedHashMap<Integer, Location>();

    public static void main(String[] args) throws IOException{
        // try with resources
//        try (BufferedWriter locFile = new BufferedWriter(new FileWriter("location.txt"));
//             BufferedWriter dirFile = new BufferedWriter(new FileWriter("directions.txt"))) {
//            for (Location location : locations.values()) {
//                locFile.write(location.getLocationID() + "," + location.getDescription()
//                + "\n");
//                for (String direction : location.getExits().keySet()) {
//                    if(!direction.equalsIgnoreCase("Q")) {
//                        dirFile.write(location.getLocationID() + "," + direction + "," +
//                                location.getExits().get(direction) + "\n");
//                    }
//                }
//            }
//        }

        try (DataOutputStream locFile = new DataOutputStream(new BufferedOutputStream(
                new FileOutputStream("locations.dat")))){;
            for (Location location : locations.values()) {
                locFile.writeInt(location.getLocationID());
                locFile.writeUTF(location.getDescription());

                System.out.println("Writing location: " + location.getLocationID() + " : " + location.getDescription());
                System.out.println("Writing " + (location.getExits().size()-1) + " exits.");
                locFile.writeInt(location.getExits().size()-1);

                for(String direction : location.getExits().keySet()) {
                    if(!direction.equalsIgnoreCase("Q")) {
                        System.out.println("\t\t" + direction + ", " + location.getExits().get(direction));
                        locFile.writeUTF(direction);
                        locFile.writeInt(location.getExits().get(direction));
                    }
                }
            }
        }
    }

    // only one instance will be created - moved from main
    static {

        try (BufferedReader reader = new BufferedReader(new FileReader("locations_big.txt"))){
            String input;
            while ((input = reader.readLine()) != null) {
//                int loc = scanner.nextInt();
//                scanner.skip(scanner.delimiter());
//                String description = scanner.nextLine();
                String[] data = input.split(",");
                int loc = Integer.parseInt(data[0]);
                String description = data[1];
                System.out.println("Imported loc: " + loc + " : " + description);

                Map<String, Integer> tempExit = new LinkedHashMap<>();
                locations.put(loc, new Location(loc, description, tempExit));
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        // Now read exits
        try (BufferedReader reader = new BufferedReader(new FileReader("directions_big.txt"))){

            String input;
            while((input= reader.readLine()) != null) {
                String[] data = input.split(",");
                int loc = Integer.parseInt(data[0].trim());
                String direction = data[1];
                int dest = Integer.parseInt(data[2].trim());
                System.out.println(loc + " : " + direction + " : " + dest);
                Location location = locations.get(loc);
                location.addExit(direction, dest);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int size() {
        return locations.size();
    }

    @Override
    public boolean isEmpty() {
        return locations.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return locations.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return locations.containsValue(value);
    }

    @Override
    public Location get(Object key) {
        return locations.get(key);
    }

    @Override
    public Location put(Integer key, Location value) {
        return locations.put(key, value);
    }

    @Override
    public Location remove(Object key) {
        return locations.remove(key);
    }

    @Override
    public void putAll(Map<? extends Integer, ? extends Location> m) {

    }

    @Override
    public void clear() {
        locations.clear();
    }

    @Override
    public Set<Integer> keySet() {
        return locations.keySet();
    }

    @Override
    public Collection<Location> values() {
        return locations.values();
    }

    @Override
    public Set<Entry<Integer, Location>> entrySet() {
        return locations.entrySet();
    }
}
