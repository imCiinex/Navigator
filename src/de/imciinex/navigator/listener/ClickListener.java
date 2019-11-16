package de.imciinex.navigator.listener;

import de.imciinex.navigator.utils.LocationAPI;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class ClickListener implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent inventoryClickEvent) {
        Player player = (Player) inventoryClickEvent.getWhoClicked();

        if (inventoryClickEvent.getInventory().getName().equalsIgnoreCase("§2§lTELEPORTER")) {
            if (inventoryClickEvent.getCurrentItem().getType() != null) {
                if (inventoryClickEvent.getCurrentItem().getType().equals(Material.MAGMA_CREAM)) {
                    inventoryClickEvent.setCancelled(true);
                    player.closeInventory();

                    try {
                        player.teleport(LocationAPI.getLocation("spawn"));

                        player.sendMessage("§eDu wurdest zum §aSpawn §eTeleportiert.");
                    }catch (Exception expetion) {
                        expetion.printStackTrace();
                        player.sendMessage("§cDie Location wurde nicht Gesetzt.");
                    }
                }else if (inventoryClickEvent.getCurrentItem().getType().equals(Material.BED)) {
                    inventoryClickEvent.setCancelled(true);
                    player.closeInventory();

                    try {
                        player.teleport(LocationAPI.getLocation("bedwars"));

                        player.sendMessage("§eDu wurdest zu §aBedWars §eTeleportiert.");
                    }catch (Exception expetion) {
                        expetion.printStackTrace();
                        player.sendMessage("§cDie Location wurde nicht Gesetzt.");
                    }
                }else if (inventoryClickEvent.getCurrentItem().getType().equals(Material.GRASS)) {
                    inventoryClickEvent.setCancelled(true);
                    player.closeInventory();

                    try {
                        player.teleport(LocationAPI.getLocation("skywars"));

                        player.sendMessage("§eDu wurdest zu §aSkyWars §eTeleportiert.");
                    }catch (Exception expetion) {
                        expetion.printStackTrace();
                        player.sendMessage("§cDie Location wurde nicht Gesetzt.");
                    }
                }
            }
        }
    }
}
