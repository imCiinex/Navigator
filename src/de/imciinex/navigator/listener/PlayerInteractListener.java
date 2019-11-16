package de.imciinex.navigator.listener;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class PlayerInteractListener implements Listener {

    @EventHandler
    public void onInteract(PlayerInteractEvent playerInteractEvent) {
        Player player = playerInteractEvent.getPlayer();

        if (playerInteractEvent.getAction().equals(Action.RIGHT_CLICK_AIR) || playerInteractEvent.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
            if (playerInteractEvent.getMaterial() != null) {
                if (playerInteractEvent.getMaterial().equals(Material.COMPASS)) {
                    Inventory inventory = Bukkit.createInventory(null, 9, "§2§lTELEPORTER");

                    ItemStack spawn = new ItemStack(Material.MAGMA_CREAM);
                    ItemMeta spawnMeta = spawn.getItemMeta();
                    spawnMeta.setDisplayName("§aSpawn");
                    spawn.setItemMeta(spawnMeta);

                    ItemStack bed = new ItemStack(Material.BED);
                    ItemMeta bedMeta = bed.getItemMeta();
                    bedMeta.setDisplayName("§4BedWars");
                    bed.setItemMeta(bedMeta);

                    ItemStack sky = new ItemStack(Material.GRASS);
                    ItemMeta skyMeta = sky.getItemMeta();
                    skyMeta.setDisplayName("§2SkyWars");
                    sky.setItemMeta(skyMeta);

                    inventory.setItem(2, bed);
                    inventory.setItem(4, spawn);
                    inventory.setItem(6, sky);

                    if (player.getOpenInventory() != null) player.openInventory(inventory);
                }
            }
        }
    }
}
