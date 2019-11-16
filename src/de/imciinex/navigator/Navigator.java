package de.imciinex.navigator;

import de.imciinex.navigator.commands.LocationCommand;
import de.imciinex.navigator.listener.ClickListener;
import de.imciinex.navigator.listener.PlayerInteractListener;
import de.imciinex.navigator.listener.PlayerJoinListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Navigator extends JavaPlugin {

    private static Navigator navigator;

    public static Navigator getNavigator() {
        return navigator;
    }

    @Override
    public void onEnable() {
        this.navigator = this;
        Bukkit.getConsoleSender().sendMessage("§aDas Plugin wurde Geladen!");
        this.registerUtil();
    }
    private void registerUtil() {
        this.getCommand("setloc").setExecutor(new LocationCommand());

        this.getServer().getPluginManager().registerEvents(new PlayerInteractListener(),this);
        this.getServer().getPluginManager().registerEvents(new PlayerJoinListener(),this);
        this.getServer().getPluginManager().registerEvents(new ClickListener(),this);
    }
}
