package com.plugins.cynthius;

import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.entity.LivingEntity;
import org.bukkit.plugin.java.JavaPlugin;


public class HelloWorldPlugin extends JavaPlugin {
	
	@Override
	public void onDisable() {
		getLogger().info("[Plugin stopped]");
		super.onDisable();
	}

	@Override
	public void onEnable() {
		getLogger().info("Hello World");
		super.onEnable();
	}
	
	public void noDamageTicks() {
		List<LivingEntity> list = Bukkit.getServer().getWorld("world").getLivingEntities();
		for(LivingEntity e : list) {
			e.setNoDamageTicks(0);
		}
	}
}
