package me.stopbox123.chestlock.listeners;

import me.stopbox123.chestlock.commands.LockChest;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class ChestListener implements Listener {
	
	LockChest lockedcheck;
	
	public ChestListener(LockChest lockedcheck)
	{
		this.lockedcheck = lockedcheck;
	}
	
	@EventHandler
	public void isLocked(PlayerInteractEvent e) {
		if(e.getAction() != Action.RIGHT_CLICK_BLOCK)
		{
			// There is no Block that we are interacting with
			return;
		}
		if (e.getClickedBlock().getType() == Material.CHEST) 
		{
			String owner = lockedcheck.locked.get(e.getClickedBlock().getLocation());
			// Check if the block does not have an owner
			// or if the interacting player isn't the owner
	            	if (owner == null || !owner.equals(e.getPlayer().getName()))
	            	{
	                	e.setCancelled(true);
                		 e.getPlayer().sendMessage(ChatColor.GRAY + "[" + ChatColor.GOLD + "ChestLock" + ChatColor.GRAY + "] " + ChatColor.AQUA + "You may not open that chest owned by " + lockedcheck.locked.get(e.getClickedBlock().getLocation()));   
	            	}
		}
	}
}
