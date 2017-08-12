package net.xornick.modmode;

import net.xornick.modmode.commands.ModModeCommand;
import net.xornick.modmode.listeners.IceFreeze;
import net.xornick.modmode.listeners.TeleportCompass;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public final class ModMode extends JavaPlugin {

    private static ModMode instance;
    private static List<UUID> users = new ArrayList<>();
    private static HashMap<Player, ItemStack[]> playerInventory = new HashMap<>();
    private static HashMap<Player, ItemStack[]> playerArmorContents = new HashMap<>();

    @Override
    public void onEnable() {
        instance = this;
        load();
    }

    private void load() {
        playerArmorContents.clear();
        playerInventory.clear();
        getServer().getPluginManager().registerEvents(new TeleportCompass(), this);
        getServer().getPluginManager().registerEvents(new IceFreeze(), this);
        getCommand("mod").setExecutor(new ModModeCommand());
    }

    public static ModMode getInstance() {
        return instance;
    }

    public static List<UUID> getUsers() {
        return users;
    }

    public static HashMap<Player, ItemStack[]> getPlayerInventory() {
        return playerInventory;
    }

    public static HashMap<Player, ItemStack[]> getPlayerArmorContents() {
        return playerArmorContents;
    }
}
