package me.stopbox123.chestlock;

import me.stopbox123.chestlock.commands.LockChest;
import me.stopbox123.chestlock.listeners.ChestListener;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class main extends JavaPlugin {
	
	public void onEnable() {
		PluginManager pm = Bukkit.getPluginManager();
		LockChest lockchest = new LockChest();
                pm.registerEvents(new ChestListener(lockchest), this);
        	getCommand("lock").setExecutor(lockchest);
	}

}
