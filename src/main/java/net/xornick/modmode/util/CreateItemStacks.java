package net.xornick.modmode.util;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class CreateItemStacks {

    public ItemStack createPackedIce() {
        ItemStack packedIce = new ItemStack(Material.PACKED_ICE, 1);
        ItemMeta iceMeta = packedIce.getItemMeta();
        iceMeta.setDisplayName(ChatColor.BLUE + "Freeze Player");
        packedIce.setItemMeta(iceMeta);
        return packedIce;
    }

    public ItemStack createCompass() {
        ItemStack compass = new ItemStack(Material.COMPASS, 1);
        ItemMeta compassMeta = compass.getItemMeta();
        compassMeta.setDisplayName(ChatColor.RED + "Random Teleport");
        compass.setItemMeta(compassMeta);
        return compass;
    }

    public ItemStack createCarpet() {
        ItemStack carpet = new ItemStack(Material.CARPET, 1);
        ItemMeta carpetMeta = carpet.getItemMeta();
        carpetMeta.setDisplayName(ChatColor.BLUE + "Carpet");
        return carpet;
    }
}
