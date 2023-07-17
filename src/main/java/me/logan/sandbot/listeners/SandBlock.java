package me.logan.sandbot.listeners;

import me.logan.sandbot.utils.SandMap;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

import java.util.List;

public class SandBlock implements Listener {

    SandMap sandMap = SandMap.getInstance();
    List<Location> sandMapLocations = sandMap.getSandMapLocations();

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        Block block = event.getBlock();
        if(!block.getType().equals(Material.SEA_LANTERN)) return;
        sandMapLocations.add(block.getLocation().toCenterLocation());
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        Block block = event.getBlock();

        if(!block.getType().equals(Material.SEA_LANTERN)) return;
        if(!sandMapLocations.contains(block.getLocation().toCenterLocation())) return;

        sandMapLocations.remove(block.getLocation().toCenterLocation());
    }
}
