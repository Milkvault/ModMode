package net.xornick.modmode.commands;

import net.xornick.modmode.ModMode;
import net.xornick.modmode.util.CreateItemStacks;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class ModModeCommand implements CommandExecutor {

    private static CreateItemStacks createItemStacks;
    private List<UUID> users = new ArrayList<>();
    private HashMap<Player, ItemStack[]> playerInventory = new HashMap<>();
    private HashMap<Player, ItemStack[]> playerArmorContents = new HashMap<>();


    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            return false;
        }
        Player player = (Player) sender;
        if (!player.hasPermission("modmode.use")) {
            player.sendMessage(ChatColor.RED + "You do not have permission to perform this command.");
            return true;
        }
        if (users.contains(player.getUniqueId())) {
            users.remove(player.getUniqueId());
            player.getInventory().clear();
            player.sendMessage("Exited staff mode!");
            player.setGameMode(GameMode.SURVIVAL);
            player.getInventory().setContents(playerInventory.get(player));
            player.getInventory().setArmorContents(playerArmorContents.get(player));
        } else {
            // Player toggling mod mode
            users.add(player.getUniqueId());
            playerInventory.put(player, player.getInventory().getContents());
            playerArmorContents.put(player, player.getInventory().getArmorContents());
            player.setGameMode(GameMode.CREATIVE);
            player.getInventory().clear();

            player.getInventory().setItem(4, createItemStacks.createCarpet());
            player.getInventory().setItem(0, createItemStacks.createCompass());
            player.getInventory().setItem(1, createItemStacks.createPackedIce());
        }
        return false;
    }

    public ModModeCommand() {
        this.playerArmorContents = ModMode.getPlayerArmorContents();
        this.playerInventory = ModMode.getPlayerInventory();
        this.users = ModMode.getUsers();
    }
}
