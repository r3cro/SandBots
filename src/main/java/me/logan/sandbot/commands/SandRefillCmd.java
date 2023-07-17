package me.logan.sandbot.commands;

import me.logan.sandbot.utils.SandMap;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class SandRefillCmd implements CommandExecutor {

    SandMap sandMap = SandMap.getInstance();

    private void check(Player player, int CHECK_RADIUS) {
        for (int x = -CHECK_RADIUS; x <= CHECK_RADIUS; x++) {
            for (int y = -CHECK_RADIUS; y <= CHECK_RADIUS; y++) {
                for (int z = -CHECK_RADIUS; z <= CHECK_RADIUS; z++) {
                    Block block = player.getWorld().getBlockAt(player.getLocation().add(x, y, z));
                    if (block.getType().equals(Material.SEA_LANTERN)) {
                        sandMap.add(block.getLocation().toCenterLocation());
                    }
                }
            }
        }
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {

        Player player = (Player) commandSender;

        check(player, 15);

        return true;
    }
}
