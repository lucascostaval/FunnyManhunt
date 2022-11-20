package me.dotarakotara.eventlisteners.listeners;

import me.dotarakotara.eventlisteners.FunnyManhunt;
import me.dotarakotara.eventlisteners.Interface;
import me.dotarakotara.eventlisteners.players.PlayerPlus;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Map;
import java.util.UUID;

public class DrinkingListener implements Listener {
    protected Interface interface1;
    protected FunnyManhunt plugin;
    protected Map<UUID, PlayerPlus> uuidToPP;

    public DrinkingListener (FunnyManhunt vplugin, Map<UUID, PlayerPlus> vuuidToPP) {
        interface1 = new Interface();
        plugin = vplugin;
        uuidToPP = vuuidToPP;
    }

    @EventHandler
    public void onDrinkChickenMilk(PlayerItemConsumeEvent e) {
        ItemStack milk = e.getItem();
        Player player = e.getPlayer();

        if (!uuidToPP.containsKey(player.getUniqueId())) {
            return;
        }
        if (milk.getItemMeta().getDisplayName().equals("Chicken Milk")) {
            e.setCancelled(true);
            player.getInventory().setItemInMainHand(new ItemStack(Material.BUCKET, 1));
            PlayerPlus pp = uuidToPP.get(player.getUniqueId());
            pp.gainChickenPower();
        }
    }

    @EventHandler
    public void onDrinkPigMilk(PlayerItemConsumeEvent e) {
        ItemStack milk = e.getItem();
        Player player = e.getPlayer();

        if (!uuidToPP.containsKey(player.getUniqueId())) {
            return;
        }
        if (milk.getItemMeta().getDisplayName().equalsIgnoreCase("Pig Milk")) {
            e.setCancelled(true);
            player.getInventory().setItemInMainHand(new ItemStack(Material.BUCKET, 1));
            PlayerPlus pp = uuidToPP.get(player.getUniqueId());
            pp.gainPigPower();
        }
    }

    @EventHandler
    public void onDrinkSheepMilk(PlayerItemConsumeEvent e) {
        ItemStack milk = e.getItem();
        Player player = e.getPlayer();

        if (!uuidToPP.containsKey(player.getUniqueId())) {
            return;
        }
        if (milk.getItemMeta().getDisplayName().equalsIgnoreCase("Sheep Milk")) {
            e.setCancelled(true);
            player.getInventory().setItemInMainHand(new ItemStack(Material.BUCKET, 1));
            PlayerPlus pp = uuidToPP.get(player.getUniqueId());
            pp.gainSheepPower();
        }
    }

    @EventHandler
    public void onDrinkCowMilk(PlayerItemConsumeEvent e) {
        ItemStack milk = e.getItem();
        Player player = e.getPlayer();

        if (!uuidToPP.containsKey(player.getUniqueId())) {
            return;
        }
        if (milk.getItemMeta().getDisplayName().equalsIgnoreCase("Cow Milk")) {
            e.setCancelled(true);
            player.getInventory().setItemInMainHand(new ItemStack(Material.BUCKET, 1));
            PlayerPlus pp = uuidToPP.get(player.getUniqueId());
            pp.gainCowPower();
        }
    }

    @EventHandler
    public void onDrinkFishMilk(PlayerItemConsumeEvent e) {
        ItemStack milk = e.getItem();
        Player player = e.getPlayer();

        if (!uuidToPP.containsKey(player.getUniqueId())) {
            return;
        }
        if (milk.getItemMeta().getDisplayName().equalsIgnoreCase("Fish Milk")) {
            e.setCancelled(true);
            player.getInventory().setItemInMainHand(new ItemStack(Material.BUCKET, 1));
            PlayerPlus pp = uuidToPP.get(player.getUniqueId());
            pp.gainFishPower();
        }
    }

    @EventHandler
    public void onDrinkBatMilk(PlayerItemConsumeEvent e) {
        ItemStack milk = e.getItem();
        Player player = e.getPlayer();

        if (!uuidToPP.containsKey(player.getUniqueId())) {
            return;
        }
        if (milk.getItemMeta().getDisplayName().equalsIgnoreCase("Bat Milk")) {
            e.setCancelled(true);
            player.getInventory().setItemInMainHand(new ItemStack(Material.BUCKET, 1));
            PlayerPlus pp = uuidToPP.get(player.getUniqueId());
            pp.gainBatPower();
        }
    }

    @EventHandler
    public void onDrinkSkeletonMilk(PlayerItemConsumeEvent e) {
        ItemStack milk = e.getItem();
        Player player = e.getPlayer();

        if (!uuidToPP.containsKey(player.getUniqueId())) {
            return;
        }
        if (milk.getItemMeta().getDisplayName().equalsIgnoreCase("Skeleton Milk")) {
            e.setCancelled(true);
            player.getInventory().setItemInMainHand(new ItemStack(Material.BUCKET, 1));
            PlayerPlus pp = uuidToPP.get(player.getUniqueId());
            pp.gainSkeletonPower();
        }
    }

    @EventHandler
    public void onDrinkZombieMilk(PlayerItemConsumeEvent e) {
        ItemStack milk = e.getItem();
        Player player = e.getPlayer();

        if (!uuidToPP.containsKey(player.getUniqueId())) {
            return;
        }
        if (milk.getItemMeta().getDisplayName().equalsIgnoreCase("Zombie Milk")) {
            e.setCancelled(true);
            player.getInventory().setItemInMainHand(new ItemStack(Material.BUCKET, 1));
            PlayerPlus pp = uuidToPP.get(player.getUniqueId());
            pp.gainZombiePower();
        }
    }

    @EventHandler
    public void onDrinkCreeperMilk(PlayerItemConsumeEvent e) {
        ItemStack milk = e.getItem();
        Player player = e.getPlayer();

        if (!uuidToPP.containsKey(player.getUniqueId())) {
            return;
        }
        if (milk.getItemMeta().getDisplayName().equalsIgnoreCase("Creeper Milk")) {
            e.setCancelled(true);
            player.getInventory().setItemInMainHand(new ItemStack(Material.BUCKET, 1));
            PlayerPlus pp = uuidToPP.get(player.getUniqueId());
            pp.gainCreeperPower();
        }
    }
}
