package me.dotarakotara.eventlisteners.skills;

import me.dotarakotara.eventlisteners.FunnyManhunt;
import me.dotarakotara.eventlisteners.Helper;
import me.dotarakotara.eventlisteners.players.PlayerPlus;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Pig;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.util.Vector;

import java.util.Collection;
import java.util.Map;
import java.util.UUID;

public class PigShootListener implements Listener {

    protected FunnyManhunt plugin;
    protected Map<UUID, PlayerPlus> uuidToPP;

    protected int CDTime = 20*(int)Helper.getDebug(0);
    public PigShootListener(FunnyManhunt vplugin, Map<UUID, PlayerPlus> vuuidToPP) {
        plugin = vplugin;
        uuidToPP = vuuidToPP;
    }

    // Checks if the player can shoot the pig (has the stick, cooldown available, etc)
    @EventHandler
    public void onShoot(PlayerInteractEvent e) {
        Player player = e.getPlayer();
        UUID uuid = player.getUniqueId();
        if (!uuidToPP.containsKey(uuid)) {
            return;
        }
        PlayerPlus pp = uuidToPP.get(uuid);
        ItemStack item = player.getInventory().getItemInMainHand();
        if ((e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) && item.
                getItemMeta() != null && item.getItemMeta().getDisplayName().equalsIgnoreCase("Pig Shooter")
                && pp.getSkills().contains("Pig Power") && pp.getPigPowerCD().isUnlocked()) {
            shootPig(pp);
            pp.getPigPowerCD().lock();
        }
    }

    // Actual does the shooting
    private void shootPig(PlayerPlus pp) {
        Player player = pp.getPlayer();
        World world = player.getWorld();
        Location location = player.getLocation();
        location.setY(location.getY()+1);

        Pig pig = (Pig)world.spawnEntity(location, EntityType.PIG);
        Vector direction = player.getEyeLocation().getDirection().normalize();
        pig.setVelocity(direction.multiply(1.5));

        BukkitScheduler scheduler = Bukkit.getScheduler();
        scheduler.runTaskLater(plugin, () -> {
            Collection<Entity> entities = world.getNearbyEntities(pig.getLocation(), 3, 3, 3);
            Helper.applyToAll(entities, PotionEffectType.SLOW, 4, 3);
            int numberOfPigs = 6;
            for (int i = 0; i < numberOfPigs; i++) {
                Pig otherpig = (Pig)world.spawnEntity(pig.getLocation(), EntityType.PIG);
                double delX = Math.sin(2*Math.PI*i/numberOfPigs);
                double delZ = Math.cos(2*Math.PI*i/numberOfPigs);
                otherpig.setVelocity(new Vector(delX*0.75, 0.75, delZ*0.75));
            }
        }, 30L);

        pp.getPigPowerCD().unlockAfter(CDTime, ChatColor.RED + "Pig Shooter can be used again!");
    }
}
