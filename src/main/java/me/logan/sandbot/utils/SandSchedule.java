package me.logan.sandbot.utils;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.FallingBlock;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import java.util.List;

public class SandSchedule extends BukkitRunnable {

    SandMap sandMap = SandMap.getInstance();
    List<Location> sandMapLocations = sandMap.getSandMapLocations();


    @Override
    public void run() {
        for(Location location : sandMapLocations) {

            FallingBlock fallingBlock = location.getWorld().spawnFallingBlock(location, Material.SAND.createBlockData());

            Vector velocity = new Vector(0, -0.5, 0);
            fallingBlock.setVelocity(velocity);

            fallingBlock.setDropItem(false);
            fallingBlock.setHurtEntities(false);

        }
    }
}
