package us.kpvpdev.easysounds.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import us.kpvpdev.easysounds.EasySounds;
import us.kpvpdev.easysounds.utils.Lists;

public class Sounds implements CommandExecutor {

	public Sounds() {
		EasySounds.instance().getCommand("sounds").setExecutor(this);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String tag, String[] args) {
		if(sender.hasPermission("easysounds.sounds") || sender.isOp()) {
			if(args.length >= 0) {
				String sounds = "";
				
				for(String s : Lists.getSounds().keySet()) {
					sounds += ", " + s;
				}
				
				sender.sendMessage("§3Available sounds:§f " + sounds.replaceFirst(", ", ""));
			}
		} else {
			sender.sendMessage("§3You don't have permission to use this,§f " + sender.getName() + "!");
			return true;
		}
		
		return false;
	}
	
}
