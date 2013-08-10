package us.kpvpdev.easysounds.utils;

import java.util.HashMap;

import org.bukkit.Sound;

import com.google.common.collect.Maps;

public class Lists {

	private static HashMap<String, Sound> SOUNDS = Maps.newHashMap();
	
	public static HashMap<String, Sound> getSounds(){
		return SOUNDS;
	}
	
	public Lists() {
		SOUNDS.clear();
		
		for(Sound sound : Sound.values()) {
			SOUNDS.put(sound.name().toLowerCase().replaceAll("_", ""), sound);
		}
	}
	
}
