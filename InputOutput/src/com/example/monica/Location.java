package com.example.monica;

import java.util.HashMap;
import java.util.Map;

public class Location {
    // lets everyone know, don't change these - no setters, as well
    private final int locationID;
    private final String description;
    private final Map<String, Integer> exits;

    public Location(int locationID, String description, Map<String, Integer> exits) {
        this.locationID = locationID;
        this.description = description;
        // will crash at runtime if no map provided - null
        //this.exits = new HashMap<String, Integer>(exits);

        //fix:
        if(exits != null) {
            this.exits = new HashMap<String, Integer>(exits);
        }
        else {
            this.exits = new HashMap<String, Integer>();
        }
        this.exits.put("Q", 0);
    }

//    public void addExit(String direction, int location) {
//        exits.put(direction, location);
//    }

    public int getLocationID() {
        return locationID;
    }

    public String getDescription() {
        return description;
    }

    public Map<String, Integer> getExits() {
        return new HashMap<String, Integer>(exits);
    }

    protected void addExit(String direction, int location) {
        exits.put(direction, location);
    }
}
