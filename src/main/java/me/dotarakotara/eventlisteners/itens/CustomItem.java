package me.dotarakotara.eventlisteners.itens;

import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;


public class CustomItem {
    public CustomItem() {}
    public static ItemStack ChickenMilk() {

        ItemStack item = new ItemStack(Material.MILK_BUCKET, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("Chicken Milk");
        List<String> lore = new ArrayList<String>();
        lore.add("Milking chickens, now that is new");
        meta.setLore(lore);
        item.setItemMeta(meta);

        return item;
    }

    public static ItemStack pigMilk() {

        ItemStack item = new ItemStack(Material.MILK_BUCKET, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("Pig Milk");
        List<String> lore = new ArrayList<String>();
        lore.add("Tasty Milking, tasty life");
        meta.setLore(lore);
        item.setItemMeta(meta);

        return item;
    }

    public static ItemStack sheepMilk() {

        ItemStack item = new ItemStack(Material.MILK_BUCKET, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("Sheep Milk");
        List<String> lore = new ArrayList<String>();
        lore.add("Sheeping Milks");
        meta.setLore(lore);
        item.setItemMeta(meta);

        return item;
    }

    public static ItemStack cowMilk() {
        ItemStack item = new ItemStack(Material.MILK_BUCKET, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("Cow Milk");
        List<String> lore = new ArrayList<String>();
        lore.add("Kinda ok I guess");
        meta.setLore(lore);
        item.setItemMeta(meta);

        return item;
    }

    public static ItemStack fishMilk() {
        ItemStack item = new ItemStack(Material.MILK_BUCKET, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("Fish Milk");
        List<String> lore = new ArrayList<String>();
        lore.add("Fishy business");
        meta.setLore(lore);
        item.setItemMeta(meta);

        return item;
    }

    public static ItemStack batMilk() {

        ItemStack item = new ItemStack(Material.MILK_BUCKET, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("Bat Milk");
        List<String> lore = new ArrayList<String>();
        lore.add("Bat milking is op");
        meta.setLore(lore);
        item.setItemMeta(meta);

        return item;
    }

    public static ItemStack skeletonMilk() {
        ItemStack item = new ItemStack(Material.MILK_BUCKET, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("Skeleton Milk");
        List<String> lore = new ArrayList<String>();
        lore.add("Milk is good for bones... and bone is good for milk");
        meta.setLore(lore);
        item.setItemMeta(meta);

        return item;
    }

    public static ItemStack zombieMilk() {
        ItemStack item = new ItemStack(Material.MILK_BUCKET, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("Zombie Milk");
        List<String> lore = new ArrayList<String>();
        lore.add("??");
        meta.setLore(lore);
        item.setItemMeta(meta);

        return item;
    }

    public static ItemStack creeperMilk() {
        ItemStack item = new ItemStack(Material.MILK_BUCKET, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("Creeper Milk");
        List<String> lore = new ArrayList<String>();
        lore.add("EXPLOSION!");
        meta.setLore(lore);
        item.setItemMeta(meta);

        return item;
    }

    public static ItemStack pigShooter() {

        ItemStack item = new ItemStack(Material.STICK, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("Pig Shooter");
        List<String> lore = new ArrayList<String>();
        lore.add("Shoots pigs because you can!");
        meta.setLore(lore);
        item.setItemMeta(meta);

        return item;
    }
}

