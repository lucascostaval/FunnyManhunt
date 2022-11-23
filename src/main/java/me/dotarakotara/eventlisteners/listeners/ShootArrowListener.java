package me.dotarakotara.eventlisteners.listeners;

import me.dotarakotara.eventlisteners.FunnyManhunt;
import me.dotarakotara.eventlisteners.Helper;
import me.dotarakotara.eventlisteners.players.PlayerPlus;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.util.Vector;

import java.util.Map;
import java.util.UUID;

public class ShootArrowListener implements Listener {
    protected FunnyManhunt plugin;
    protected Map<UUID, PlayerPlus> uuidToPP;

    protected int CDTime = 10;

    public ShootArrowListener(FunnyManhunt vplugin, Map<UUID, PlayerPlus> vuuidToPP) {
        plugin = vplugin;
        uuidToPP = vuuidToPP;
    }

    @EventHandler
    public void onShoot(EntityShootBowEvent e) {
        if (!(e.getEntity() instanceof Player)) {
            return;
        }
        Player shooter = (Player)e.getEntity();
        UUID uuid = shooter.getUniqueId();
        if (uuidToPP.containsKey(uuid)) {
            PlayerPlus pp = uuidToPP.get(uuid);
            if (!pp.hasSkill("Skeleton Power")) {
                Projectile projectile = (Projectile) e.getProjectile();
                Vector direction = projectile.getVelocity();
                double velocity = Helper.getMagnitude(direction);
                int randX = Helper.dice(-100, 100);
                int randY = Helper.dice(-100, 100);
                int randZ = Helper.dice(-100, 100);
                Vector newDirection = new Vector(randX, randY, randZ).normalize();
                newDirection.multiply((int)velocity);
                projectile.setVelocity(newDirection);
                shooter.sendMessage(ChatColor.AQUA + "Woah, you suck at shooting arrows!");
                shooter.sendMessage(ChatColor.WHITE + "Maybe try to acquire the SKELETON POWER!");
            }
        }
    }

    @EventHandler
    public void bonusShot(PlayerInteractEvent e) {
        Player player = e.getPlayer();
        UUID uuid = player.getUniqueId();
        ItemStack item = player.getInventory().getItemInMainHand();

        if (!uuidToPP.containsKey(uuid)) {
            return;
        }
        PlayerPlus pp = uuidToPP.get(uuid);
        if (item.getType() == Material.BOW && pp.hasSkill("Skeleton Power") && ((e.getAction() == Action.LEFT_CLICK_AIR)
            || (e.getAction() == Action.LEFT_CLICK_BLOCK)) && pp.getSkeletonPowerCD().isUnlocked()) {
            Vector direction = player.getEyeLocation().getDirection().normalize();

            Arrow arrow = player.getWorld().spawnArrow(player.getEyeLocation(), direction, 3, 1);

            if (pp.hasSkill("Creeper Power")) {
                BukkitScheduler scheduler = Bukkit.getScheduler();
                scheduler.runTaskLater(plugin, () -> {
                    player.getWorld().createExplosion(arrow.getLocation(), 2F);
                }, 20);
            }

            pp.getSkeletonPowerCD().lock();
            pp.getSkeletonPowerCD().unlockAfter(CDTime, ChatColor.WHITE + "BonusShot can be used again!");
        }
    }

}