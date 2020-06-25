package com.example.monica;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Locations implements Map<Integer, Location> {
    private static Map<Integer, Location> locations = new HashMap<Integer, Location>();

    public static void main(String[] args) throws IOException{
        // try with resources
        try (FileWriter locFile = new FileWriter("location.txt");
                FileWriter dirFile = new FileWriter("directions.txt")) {
            for (Location location : locations.values()) {
                locFile.write(location.getLocationID() + ", " + location.getDescription()
                + "\n");
                for (String direction : location.getExits().keySet()) {
                    dirFile.write(location.getLocationID() + ", " + direction + ", " +
                            location.getExits().get(direction) + "\n");
                }
            }
        }
    }

    // only one instance will be created - moved from main
    static {

        try (Scanner scanner = new Scanner(new FileReader("locations_big.txt"))){
            scanner.useDelimiter(",");
            while (scanner.hasNextLine()) {
                int loc = scanner.nextInt();
                scanner.skip(scanner.delimiter());
                String description = scanner.nextLine();
                System.out.println("Imported loc: " + loc + " : " + description);

                Map<String, Integer> tempExit = new HashMap<>();
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
