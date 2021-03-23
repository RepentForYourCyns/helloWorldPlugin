package com.plugins.cynthius;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.plugin.java.JavaPlugin;


/**
 * Plugin to enable configuration of noDamageTicks
 * 
 * @author Cosmo De Bonis-Campbell
 */
public class ConfigiFrame extends JavaPlugin implements Listener {
	
	int maxNoDamageTicks;
	
	@EventHandler
	public void onEntitySpawn(EntitySpawnEvent event) {
		Entity e = event.getEntity();
		if(event instanceof LivingEntity) {
			LivingEntity l = ((LivingEntity) e);
			set(maxNoDamageTicks, l);
		}
	}
	
	@Override
	public void onLoad() {
		this.saveDefaultConfig();
		super.onLoad();
	}

	@Override	
	public void onDisable() {
		getLogger().info("[ConfigiFrame shut down]");
		super.onDisable();
	}

	@Override
	public void onEnable() {
		getServer().getPluginManager().registerEvents(this, this);
		maxNoDamageTicks = getConfig().getInt("maximum-no-damage-ticks");
		set(maxNoDamageTicks);
		getLogger().info("[ConfigiFrame launched]");
		super.onEnable();
	}
	
	public static void set(int ticks) {
		List<World> worlds = Bukkit.getServer().getWorlds();
		for(World w : worlds) {
			String name = w.getName();
			List<LivingEntity> livingEntities = Bukkit.getServer().getWorld(name).getLivingEntities();
			for(LivingEntity e : livingEntities) {
				e.setMaximumNoDamageTicks(ticks);
			}
		}
	}
	
	public static void set(int ticks, LivingEntity e) {
				e.setMaximumNoDamageTicks(ticks);
	}
}		