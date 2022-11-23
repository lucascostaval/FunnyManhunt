package me.dotarakotara.eventlisteners.itens;

import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;


public class CustomItem {
    private CustomItem() {}

    private static ItemStack createItem(String displayName, String description, Material material) {
        ItemStack item = new ItemStack(material, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(displayName);
        List<String> lore = new ArrayList<String>();
        lore.add(description);
        meta.setLore(lore);
        item.setItemMeta(meta);

        return item;

    }
    public static ItemStack chickenMilk() {

        String name = "Chicken Milk";
        String description = "Milking chickens, now that is new";
        Material material = Material.MILK_BUCKET;

        return CustomItem.createItem(name, description, material);
    }

    public static ItemStack pigMilk() {

        String name = "Pig Milk";
        String description = "Tasty Milking, tasty life";
        Material material = Material.MILK_BUCKET;

        return CustomItem.createItem(name, description , material);
    }

    public static ItemStack sheepMilk() {

        String name = "Sheep Milk";
        String description = "Sheeping Milks";
        Material material = Material.MILK_BUCKET;

        return CustomItem.createItem(name, description, material);
    }

    public static ItemStack cowMilk() {

        String name = "Cow Milk";
        String description = "Kinda ok I guess";
        Material material = Material.MILK_BUCKET;

        return CustomItem.createItem(name, description, material);
    }

    public static ItemStack fishMilk() {

        String name = "Fish Milk";
        String description = "Fishy business";
        Material material = Material.MILK_BUCKET;

        return CustomItem.createItem(name, description, material);
    }

    public static ItemStack batMilk() {

        String name = "Bat Milk";
        String description = "Bat milking is op!";
        Material material = Material.MILK_BUCKET;

        return CustomItem.createItem(name, description, material);
    }

    public static ItemStack skeletonMilk() {

        String name = "Skeleton Milk";
        String description = "Milk is good for bones... and bone is good for milk";
        Material material = Material.MILK_BUCKET;

        return CustomItem.createItem(name, description, material);
    }

    public static ItemStack zombieMilk() {

        String name = "Zombie Milk";
        String description = "??";
        Material material = Material.MILK_BUCKET;

        return CustomItem.createItem(name, description, material);
    }

    public static ItemStack creeperMilk() {

        String name = "Creeper Milk";
        String description = "EXPLOSION!";
        Material material = Material.MILK_BUCKET;

        return CustomItem.createItem(name, description, material);
    }

    public static ItemStack spiderMilk() {

        String name = "Spider Milk";
        String description = "String Milk";
        Material material = Material.MILK_BUCKET;

        return CustomItem.createItem(name, description, material);

    }

    public static ItemStack pigShooter() {

        String name = "Pig Shooter";
        String description = "Shoots pigs because you can!";
        Material material = Material.STICK;

        return CustomItem.createItem(name, description, material);
    }

    public static ItemStack explosiveDust() {

        String name = "Explosive Dust";
        String description = "Explode on click";
        Material material = Material.GUNPOWDER;

        return CustomItem.createItem(name, description, material);
    }

    public static ItemStack runnerTracker() {

        String name = "Runner Tracker";
        String description = "Good luck";
        Material material = Material.COMPASS;

        return CustomItem.createItem(name, description, material);
    }
}

