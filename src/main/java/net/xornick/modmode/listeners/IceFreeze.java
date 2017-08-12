package net.xornick.modmode.listeners;

import net.xornick.modmode.ModMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.ItemStack;

public class IceFreeze implements Listener {

    @EventHandler
    public void onPlayerInteractEntity(PlayerInteractEntityEvent event) {
        Player player = event.getPlayer();
        ItemStack item = player.getItemInHand();

        if (ModMode.getUsers().contains(player.getUniqueId())) {
            if (item.getType() == Material.COMPASS) {
                Player target = (Player) event.getRightClicked();
                player.performCommand("freeze " + target.getName());
            }
        }
    }
}
