package de.imciinex.navigator.utils;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;

public class LocationAPI {

    public static File folder = new File("plugins/Navigator", "/");
    public static File file = new File("plugins/Navigator","/location.yml");
    public static YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);

    public static void saveFile()
    {
        try
        {
            cfg.save(file);
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }

    public static void setLocation(Player player, String name)
    {
        double x = player.getLocation().getBlockX() + 0.5D;
        double y = player.getLocation().getBlockY();
        double z = player.getLocation().getBlockZ() + 0.5D;
        double yaw = Math.round(player.getLocation().getYaw() * 22.5D) / 22.5D;
        double pitch = Math.round(player.getLocation().getPitch() * 22.5D) / 22.5D;
        String worldName = player.getWorld().getName();

        cfg.set("Locations." + name + ".X", Double.valueOf(x));
        cfg.set("Locations." + name + ".Y", Double.valueOf(y));
        cfg.set("Locations." + name + ".Z", Double.valueOf(z));
        cfg.set("Locations." + name + ".Yaw", Double.valueOf(yaw));
        cfg.set("Locations." + name + ".Pitch", Double.valueOf(pitch));
        cfg.set("Locations." + name + ".worldName", worldName);
        saveFile();
    }

    public static Location getLocation(String name)
    {
        if (cfg.get("Locations." + name + ".worldName") != null)
        {
            double x = cfg.getDouble("Locations." + name + ".X");
            double y = cfg.getInt("Locations." + name + ".Y");
            double z = cfg.getDouble("Locations." + name + ".Z");
            double yaw = cfg.getDouble("Locations." + name + ".Yaw");
            double pitch = cfg.getDouble("Locations." + name + ".Pitch");
            String worldName = cfg.getString("Locations." + name + ".worldName");

            return new Location(Bukkit.getWorld(worldName), x, y, z, (float)yaw, (float)pitch);
        }
        return null;
    }
}
