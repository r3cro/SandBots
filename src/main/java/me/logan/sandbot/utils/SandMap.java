package me.logan.sandbot.utils;

import org.bukkit.Location;

import java.util.ArrayList;
import java.util.List;

public class SandMap {

    private static SandMap instance;
    private List<Location> sandMapLocations;

    private SandMap() {
        sandMapLocations = new ArrayList<>();
    }

    public static SandMap getInstance() {
        if(instance == null) instance = new SandMap();
        return instance;
    }

    public void add(Location location) {
        sandMapLocations.add(location);
    }

    public List<Location> getSandMapLocations() {
        return sandMapLocations;
    }

}
