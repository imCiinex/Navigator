package de.imciinex.navigator.commands;

import de.imciinex.navigator.utils.LocationAPI;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class LocationCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (!(commandSender instanceof Player)) {
            Bukkit.getConsoleSender().sendMessage("§cDu bist kein Spieler!");
            return true;
        }else{
            Player player = (Player) commandSender;
            if (command.getName().equals("setloc")) {
                if (player.hasPermission("navigator.setlocation")) {
                    if (strings.length == 1) {
                        if (strings[0].equalsIgnoreCase("spawn")) {
                            LocationAPI.setLocation(player, "spawn");

                            player.sendMessage("§eDu hast den §aSpawn §eGesetzt.");
                        }else if (strings[0].equalsIgnoreCase("bedwars")) {
                            LocationAPI.setLocation(player, "bedwars");

                            player.sendMessage("§eDu hast den Spawn für §aBedWars §eGesetzt.");
                        }else if (strings[0].equalsIgnoreCase("skywars")) {
                            LocationAPI.setLocation(player, "skywars");

                            player.sendMessage("§eDu hast den Spawn für §aSkyWars §eGesetzt.");
                        }else{
                            player.sendMessage("");
                            player.sendMessage("§7/§eSetLoc §8(§aSpawn§8)");
                            player.sendMessage("§7/§eSetLoc §8(§aBedWars§8)");
                            player.sendMessage("§7/§eSetLoc §8(§aSkyWars§8)");
                            player.sendMessage("");
                        }
                    }else{
                        player.sendMessage("");
                        player.sendMessage("§7/§eSetLoc §8(§aSpawn§8)");
                        player.sendMessage("§7/§eSetLoc §8(§aBedWars§8)");
                        player.sendMessage("§7/§eSetLoc §8(§aSkyWars§8)");
                        player.sendMessage("");
                    }
                }else{
                    player.sendMessage("§cKeine Rechte!");
                }
            }
        }
        return false;
    }
}
