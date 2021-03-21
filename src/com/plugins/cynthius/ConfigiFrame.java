package com.plugins.cynthius;

import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.entity.LivingEntity;
import org.bukkit.plugin.java.JavaPlugin;


/**
 * Plugin to enable configuration of noDamageTicks
 * 
 * @author Cosmo De Bonis-Campbell
 *
 */
public class ConfigiFrame extends JavaPlugin {
	
	@Override	
	public void onDisable() {
		getLogger().info("[ConfigiFrame shut down]");
		super.onDisable();
	}

	@Override
	public void onEnable() {
		getLogger().info("[ConfigiFrame launched]");
		super.onEnable();
	}
	
	public void noDamageTicks() {
		List<LivingEntity> list = Bukkit.getServer().getWorld("world").getLivingEntities();
		for(LivingEntity e : list) {
			e.setNoDamageTicks(0);
		}
	}
}
