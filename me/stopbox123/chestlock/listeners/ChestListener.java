package me.stopbox123.chestlock.listeners;

import me.stopbox123.chestlock.commands.LockChest;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class ChestListener implements Listener {
	
	LockChest lockedcheck = new LockChest();
	@EventHandler
	public void isLocked(PlayerInteractEvent e) {
		if (e.getClickedBlock().getType() == Material.CHEST) {
                if (lockedcheck.locked.containsKey(e.getPlayer())) {
                	
                } else {
                	e.setCancelled(true);
                	e.getPlayer().sendMessage(ChatColor.GRAY + "[" + ChatColor.GOLD + "ChestLock" + ChatColor.GRAY + "] " + ChatColor.AQUA + "You may not open that chest owned by " + lockedcheck.locked.get(e.getClickedBlock().getLocation()));
                }
		}
	}

}
