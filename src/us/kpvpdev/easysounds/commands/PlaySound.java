package us.kpvpdev.easysounds.commands;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import us.kpvpdev.easysounds.EasySounds;
import us.kpvpdev.easysounds.utils.Lists;

public class PlaySound implements CommandExecutor {

	public PlaySound() {
		EasySounds.instance().getCommand("playsound").setExecutor(this);
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String tag, String[] args) {
		if(sender.hasPermission("easysounds.playsound") || sender.isOp()) {
			if(args.length <= 2) {
				sender.sendMessage("§3Usage:§f /" + tag + " <sound> <volume> <pitch> [player/all]");
				sender.sendMessage("§3To view available sounds, use:§f /sounds");
			} else if(args.length == 3) {
				if(sender instanceof Player) {
					try {
						Player player = (Player)sender;
						
						Sound sound = Lists.getSounds().get(args[0]);
						float volume = Float.parseFloat(args[1]);
						float pitch = Float.parseFloat(args[2]);
						
						player.playSound(player.getEyeLocation(), sound, volume, pitch);
						sender.sendMessage("§3Played sound, " + sound.name() + ",§f " + sender.getName() + "!");
					} catch(Exception e) {
						sender.sendMessage("§3§lSound not recognised!");
						sender.sendMessage("§3Usage:§f /" + tag + " <sound> <volume> <pitch> [player/all]");
					}
				} else {
					sender.sendMessage("§3Please specify a player!");
				}
			} else if(args.length >= 4) {
				if(args[3].equalsIgnoreCase("all")) {
					try {
						Sound sound = Lists.getSounds().get(args[0]);
						float volume = Float.parseFloat(args[1]);
						float pitch = Float.parseFloat(args[2]);
						
						for(Player player : Bukkit.getOnlinePlayers()) {
							player.playSound(player.getEyeLocation(), sound, volume, pitch);
						}
						
						sender.sendMessage("§3Played sound, " + sound.name() + ",§f to all players!");
					} catch(Exception e) {
						sender.sendMessage("§3§lSound not recognised!");
						sender.sendMessage("§3Usage:§f /" + tag + " <sound> <volume> <pitch> [player/all]");
					}
				} else {
					Player target = Bukkit.getPlayer(args[3]);
					
					if(target != null && target.isOnline()) {
						try {
							Sound sound = Lists.getSounds().get(args[0]);
							float volume = Float.parseFloat(args[1]);
							float pitch = Float.parseFloat(args[2]);
							
							target.playSound(target.getEyeLocation(), sound, volume, pitch);
							sender.sendMessage("§3Played sound, " + sound.name() + ",§f to §3" + target.getName() + "§f!");
						} catch(Exception e) {
							sender.sendMessage("§3§lSound not recognised!");
							sender.sendMessage("§3Usage:§f /" + tag + " <sound> <volume> <pitch> [player/all]");
						}
					} else {
						sender.sendMessage("§3Player not found!");
					}
				}
			}
			
		} else {
			sender.sendMessage("§3You don't have permission to use this,§f " + sender.getName() + "!");
			return true;
		}
		
		return false;
	}
	
}
