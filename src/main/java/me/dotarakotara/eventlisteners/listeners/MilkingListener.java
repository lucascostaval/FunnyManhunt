package me.dotarakotara.eventlisteners.listeners;

import me.dotarakotara.eventlisteners.itens.CustomItem;
import me.dotarakotara.eventlisteners.FunnyManhunt;
import me.dotarakotara.eventlisteners.Interface;
import me.dotarakotara.eventlisteners.players.PlayerPlus;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Map;
import java.util.UUID;

public class MilkingListener implements Listener {

    protected Interface interface1;
    protected Map<UUID, PlayerPlus> uuidToPP;
    public MilkingListener(FunnyManhunt vplugin, Map<UUID, PlayerPlus> vuuidToPP) {
        interface1 = new Interface();
        FunnyManhunt plugin = vplugin;
        uuidToPP = vuuidToPP;
    }

    private boolean isMilking(Player player) {
        return player.getInventory().getItemInMainHand().getType() == Material.BUCKET;
    }

    @EventHandler
    public void milkChicken(PlayerInteractEntityEvent e) {
        Player player = e.getPlayer();
        EntityType mobClicked = e.getRightClicked().getType();
        if (isMilking(player) && mobClicked == EntityType.CHICKEN) {
            ItemStack chickenMilk = CustomItem.chickenMilk();
            player.getInventory().setItemInMainHand(chickenMilk);
            player.sendMessage(ChatColor.WHITE + "You just milked a chicken. Weird");
        }
    }

    @EventHandler
    public void milkPig(PlayerInteractEntityEvent e) {
        Player player = e.getPlayer();
        EntityType mobClicked = e.getRightClicked().getType();
        if (isMilking(player) && mobClicked == EntityType.PIG) {
            ItemStack pigMilk = CustomItem.pigMilk();
            player.getInventory().setItemInMainHand(pigMilk);
            player.sendMessage(ChatColor.LIGHT_PURPLE + "You just milked a pig. Pog I guess");
        }
    }

    @EventHandler
    public void milkSheep(PlayerInteractEntityEvent e) {
        Player player = e.getPlayer();
        EntityType mobClicked = e.getRightClicked().getType();
        if (isMilking(player) && mobClicked == EntityType.SHEEP) {
            ItemStack sheepMilk = CustomItem.sheepMilk();
            player.getInventory().setItemInMainHand(sheepMilk);
            player.sendMessage(ChatColor.GRAY + "Sheep MILKING???");
        }
    }

    @EventHandler
    public void milkCow(PlayerInteractEntityEvent e) {
        Player player = e.getPlayer();
        EntityType mobClicked = e.getRightClicked().getType();
        if (isMilking(player) && mobClicked == EntityType.COW) {
            ItemStack cowMilk = CustomItem.cowMilk();
            player.getInventory().setItemInMainHand(cowMilk);
            player.sendMessage("Normal milking, like the old days");
        }
    }

    @EventHandler
    public void milkFish(PlayerInteractEntityEvent e) {
        Player player = e.getPlayer();
        EntityType mobClicked = e.getRightClicked().getType();
        if (mobClicked == EntityType.COD || mobClicked == EntityType.SALMON
                || mobClicked == EntityType.TROPICAL_FISH || mobClicked == EntityType.PUFFERFISH) {
            ItemStack fishMilk = CustomItem.fishMilk();
            player.getInventory().setItemInMainHand(fishMilk);
            player.sendMessage(ChatColor.AQUA + "Nice Fish Milk");
        }
    }

    @EventHandler
    public void milkBat(PlayerInteractEntityEvent e) {
        Player player = e.getPlayer();
        EntityType mobClicked = e.getRightClicked().getType();
        if (isMilking(player) && mobClicked == EntityType.BAT) {
            ItemStack batMilk = CustomItem.batMilk();
            player.getInventory().setItemInMainHand(batMilk);
            player.sendMessage("Bat Milking");
        }
    }

    @EventHandler
    public void milkSkeleton(PlayerInteractEntityEvent e) {
        Player player = e.getPlayer();
        EntityType mobClicked = e.getRightClicked().getType();
        if (isMilking(player) && mobClicked == EntityType.SKELETON) {
            ItemStack skeletonMilk = CustomItem.skeletonMilk();
            player.getInventory().setItemInMainHand(skeletonMilk);
            player.sendMessage(ChatColor.WHITE + "Milk for your bones");
        }
    }

    @EventHandler
    public void milkZombie(PlayerInteractEntityEvent e) {
        Player player = e.getPlayer();
        EntityType mobClicked = e.getRightClicked().getType();
        if (isMilking(player) && mobClicked == EntityType.ZOMBIE) {
            ItemStack zombieMilk = CustomItem.zombieMilk();
            player.getInventory().setItemInMainHand(zombieMilk);
            player.sendMessage("Very Strange Milking");
        }
    }

    @EventHandler
    public void milkCreeper(PlayerInteractEntityEvent e) {
        Player player = e.getPlayer();
        EntityType mobClicked = e.getRightClicked().getType();
        if (isMilking(player) && mobClicked == EntityType.CREEPER) {
            ItemStack creeperMilk = CustomItem.creeperMilk();
            player.getInventory().setItemInMainHand(creeperMilk);
            player.sendMessage("This MILK may EXPLODE");
        }
    }

    @EventHandler
    public void milkSpider(PlayerInteractEntityEvent e) {
        Player player = e.getPlayer();
        EntityType mobClicked = e.getRightClicked().getType();
        if (isMilking(player) && (mobClicked == EntityType.SPIDER || mobClicked == EntityType.CAVE_SPIDER)) {
            ItemStack spiderMilk = CustomItem.spiderMilk();
            player.getInventory().setItemInMainHand(spiderMilk);
            player.sendMessage("Milking spiders, watch out for the strings!");
        }
    }

    @EventHandler
    public void milkPlayer(PlayerInteractEntityEvent e) {
        Player player = e.getPlayer();
        EntityType milked = e.getRightClicked().getType();
        if (isMilking(player) && milked == EntityType.PLAYER) {
            player.getInventory().getItemInMainHand().setType(Material.MILK_BUCKET);
            Bukkit.broadcastMessage(ChatColor.LIGHT_PURPLE + player.getName() + ChatColor.WHITE + " just milked "
                    + ChatColor.AQUA + e.getRightClicked().getName() + "!");
        }
    }

}
