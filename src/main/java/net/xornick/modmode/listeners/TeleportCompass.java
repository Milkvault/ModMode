package net.xornick.modmode.listeners;

import net.xornick.modmode.ModMode;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Random;

public class TeleportCompass implements Listener {

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        ItemStack item = event.getItem();

        if (ModMode.getUsers().contains(player.getUniqueId())) {
            if (item.getType() == Material.COMPASS) {
                if (!player.hasPermission("modmode.use")) return;
                Random random = new Random();
                ArrayList<Player> players = new ArrayList<>();
                for (Player online : ModMode.getInstance().getServer().getOnlinePlayers()) {
                    if (online == player) {
                        return;
                    }
                    players.add(online);
                }
                int index = random.nextInt(players.size());
                Player target = (Player) players.get(index);
                player.teleport(target);
                player.sendMessage(ChatColor.GREEN + "You have teleported to " + target.getName());
            }
        }
    }
}
