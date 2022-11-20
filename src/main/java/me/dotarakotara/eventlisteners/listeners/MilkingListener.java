package me.dotarakotara.eventlisteners.listeners;

import me.dotarakotara.eventlisteners.itens.CustomItem;
import me.dotarakotara.eventlisteners.FunnyManhunt;
import me.dotarakotara.eventlisteners.Interface;
import me.dotarakotara.eventlisteners.players.PlayerPlus;
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

    @EventHandler
    public void milkChicken(PlayerInteractEntityEvent e) {
        Player player = e.getPlayer();
        if (player.getInventory().getItemInMainHand().getType() != Material.BUCKET) {
            return;
        }
        if (e.getRightClicked().getType() == EntityType.CHICKEN) {
            ItemStack chickenMilk = CustomItem.ChickenMilk();
            player.getInventory().setItemInMainHand(chickenMilk);
            player.sendMessage(ChatColor.WHITE + "You just milked a chicken. Weird");
        }
    }

    @EventHandler
    public void milkPig(PlayerInteractEntityEvent e) {
        Player player = e.getPlayer();
        if (player.getInventory().getItemInMainHand().getType() != Material.BUCKET) {
            return;
        }
        if (e.getRightClicked().getType() == EntityType.PIG) {
            ItemStack pigMilk = CustomItem.pigMilk();
            player.getInventory().setItemInMainHand(pigMilk);
            player.sendMessage(ChatColor.LIGHT_PURPLE + "You just milked a pig. Pog I guess");
        }
    }

    @EventHandler
    public void milkSheep(PlayerInteractEntityEvent e) {
        Player player = e.getPlayer();
        if (player.getInventory().getItemInMainHand().getType() != Material.BUCKET) {
            return;
        }
        if (e.getRightClicked().getType() == EntityType.SHEEP) {
            ItemStack sheepMilk = CustomItem.sheepMilk();
            player.getInventory().setItemInMainHand(sheepMilk);
            player.sendMessage(ChatColor.GRAY + "Sheep MILKING???");
        }
    }

    @EventHandler
    public void milkCow(PlayerInteractEntityEvent e) {
        Player player = e.getPlayer();
        if (player.getInventory().getItemInMainHand().getType() != Material.BUCKET) {
            return;
        }
        if (e.getRightClicked().getType() == EntityType.COW) {
            ItemStack cowMilk = CustomItem.cowMilk();
            player.getInventory().setItemInMainHand(cowMilk);
            player.sendMessage("Normal milking, like the old days");
        }
    }

    @EventHandler
    public void milkFish(PlayerInteractEntityEvent e) {
        Player player = e.getPlayer();
        if (player.getInventory().getItemInMainHand().getType() != Material.BUCKET) {
            return;
        }
        Entity entity = e.getRightClicked();
        if (entity.getType() == EntityType.COD || entity.getType() == EntityType.SALMON ||
        entity.getType() == EntityType.TROPICAL_FISH || entity.getType() == EntityType.PUFFERFISH) {
            ItemStack fishMilk = CustomItem.fishMilk();
            player.getInventory().setItemInMainHand(fishMilk);
            player.sendMessage(ChatColor.AQUA + "Nice Fish Milk");
        }
    }

    @EventHandler
    public void milkBat(PlayerInteractEntityEvent e) {
        Player player = e.getPlayer();
        if (player.getInventory().getItemInMainHand().getType() != Material.BUCKET) {
            return;
        }
        if (e.getRightClicked().getType() == EntityType.BAT) {
            ItemStack batMilk = CustomItem.batMilk();
            player.getInventory().setItemInMainHand(batMilk);
            player.sendMessage("Bat Milking");
        }
    }

    @EventHandler
    public void milkSkeleton(PlayerInteractEntityEvent e) {
        Player player = e.getPlayer();
        if (player.getInventory().getItemInMainHand().getType() != Material.BUCKET) {
            return;
        }
        if (e.getRightClicked().getType() == EntityType.SKELETON) {
            ItemStack skeletonMilk = CustomItem.skeletonMilk();
            player.getInventory().setItemInMainHand(skeletonMilk);
            player.sendMessage(ChatColor.WHITE + "Milk for your bones");
        }
    }

    @EventHandler
    public void milkZombie(PlayerInteractEntityEvent e) {
        Player player = e.getPlayer();
        if (player.getInventory().getItemInMainHand().getType() != Material.BUCKET) {
            return;
        }
        if (e.getRightClicked().getType() == EntityType.ZOMBIE) {
            ItemStack zombieMilk = CustomItem.zombieMilk();
            player.getInventory().setItemInMainHand(zombieMilk);
            player.sendMessage("Very Strange Milking");
        }
    }

    @EventHandler
    public void milkCreeper(PlayerInteractEntityEvent e) {
        Player player = e.getPlayer();
        if (player.getInventory().getItemInMainHand().getType() != Material.BUCKET) {
            return;
        }
        if (e.getRightClicked().getType() == EntityType.CREEPER) {
            ItemStack creeperMilk = CustomItem.creeperMilk();
            player.getInventory().setItemInMainHand(creeperMilk);
            player.sendMessage("This MILK may EXPLODE");
        }
    }

    @EventHandler
    public void milkPlayer(PlayerInteractEntityEvent e) {
        if (e.getPlayer().getInventory().getItemInMainHand().getType() != Material.BUCKET) {
            return;
        }
        Player player = e.getPlayer();
        Entity milked = e.getRightClicked();
        if (milked.getType() == EntityType.PLAYER) {
            player.getInventory().getItemInMainHand().setType(Material.MILK_BUCKET);
            player.sendMessage("You just milked " + milked.getName() + "!");
        }
    }

}
