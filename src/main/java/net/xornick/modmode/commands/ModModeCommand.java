package net.xornick.modmode.commands;

import net.xornick.modmode.ModMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;

public class ModModeCommand implements CommandExecutor {

    private HashMap<Player, ItemStack[]> playerInventory = new HashMap<>();
    private HashMap<Player, ItemStack[]> playerArmorContents = new HashMap<>();


    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            return false;
        }
        return false;
    }

    public ModModeCommand() {
        this.playerArmorContents = ModMode.getPlayerArmorContents();
        this.playerInventory = ModMode.getPlayerInventory();
    }
}
