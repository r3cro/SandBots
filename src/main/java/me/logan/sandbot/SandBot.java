package me.logan.sandbot;


import me.logan.sandbot.commands.SandRefillCmd;
import me.logan.sandbot.listeners.SandBlock;
import me.logan.sandbot.utils.SandSchedule;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class SandBot extends JavaPlugin {

    private int taskId;

    @Override
    public void onEnable() {
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new SandBlock(), this);

        getCommand("sandrefill").setExecutor(new SandRefillCmd());

        SandSchedule sandSchedule = new SandSchedule();
        taskId = sandSchedule.runTaskTimer(this, 0, 5).getTaskId();

    }

    @Override
    public void onDisable() {
        canceltask();
    }

    private void canceltask() {
        if(taskId != -1) {
            getServer().getScheduler().cancelTask(taskId);
            taskId = -1;
        }
    }

}