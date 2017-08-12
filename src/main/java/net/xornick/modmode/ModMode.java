package net.xornick.modmode;

import net.xornick.modmode.listeners.IceFreeze;
import net.xornick.modmode.listeners.TeleportCompass;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;

public final class ModMode extends JavaPlugin {

    private static ModMode instance;
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
    }

    public static ModMode getInstance() {
        return instance;
    }

    public static HashMap<Player, ItemStack[]> getPlayerInventory() {
        return playerInventory;
    }

    public static HashMap<Player, ItemStack[]> getPlayerArmorContents() {
        return playerArmorContents;
    }
}
