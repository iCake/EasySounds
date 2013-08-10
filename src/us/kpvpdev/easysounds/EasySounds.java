package us.kpvpdev.easysounds;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import us.kpvpdev.easysounds.commands.PlaySound;
import us.kpvpdev.easysounds.commands.Sounds;
import us.kpvpdev.easysounds.utils.Lists;

public class EasySounds extends JavaPlugin {
	
	public static EasySounds instance() {
		return (EasySounds) Bukkit.getPluginManager().getPlugin("EasySounds");
	}
	
	public void onEnable() {
		new PlaySound();
		new Sounds();
		
		new Lists();
	}

}