package com.gh.professorsam.azmc;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class AzureMCPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        saveDefaultConfig();
        saveConfig();
        reloadConfig();
        int checkInMinutes = getConfig().getInt("check-in-minutes");
        if(checkInMinutes <= 0) {
            checkInMinutes = 5;
        }
        Bukkit.getServer().getScheduler().runTaskTimer(this, () -> {
            if(!Bukkit.getServer().getOnlinePlayers().isEmpty()){
                return;
            }
            Bukkit.getServer().shutdown();
        }, 20L *60*checkInMinutes, 20L *60*checkInMinutes);
        getLogger().info("Loaded with " + checkInMinutes + " minutes interval!");
    }
}
