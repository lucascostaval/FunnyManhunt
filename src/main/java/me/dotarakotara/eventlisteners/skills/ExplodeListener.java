package me.dotarakotara.eventlisteners.skills;

import me.dotarakotara.eventlisteners.FunnyManhunt;
import me.dotarakotara.eventlisteners.Helper;
import me.dotarakotara.eventlisteners.players.PlayerPlus;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public class ExplodeListener implements Listener {
    protected FunnyManhunt plugin;
    protected Map<UUID, PlayerPlus> uuidToPP;

    protected int CDTime = 20;
    public ExplodeListener(FunnyManhunt vplugin, Map<UUID, PlayerPlus> vuuidToPP) {
        plugin = vplugin;
        uuidToPP = vuuidToPP;
    }

    @EventHandler
    public void onUse(PlayerInteractEvent e) {
        Player player = e.getPlayer();
        UUID uuid = player.getUniqueId();
        if (!uuidToPP.containsKey(uuid)) {
            return;
        }
        PlayerPlus pp = uuidToPP.get(uuid);
        ItemStack item = player.getInventory().getItemInMainHand();
        if ((e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) && item.
                getItemMeta() != null && item.getItemMeta().getDisplayName().equalsIgnoreCase("Explosive Dust")
                && pp.hasSkill("Creeper Power") && pp.getCreeperPowerCD().isUnlocked()) {
            explode(pp);
            pp.getCreeperPowerCD().lock();
        }
    }

    public void explode(PlayerPlus pp) {

        Player player = pp.getPlayer();
        player.getWorld().createExplosion(player.getLocation(), 0F);
        Location loc = player.getLocation();
        loc.setY(loc.getY()-1);
        List<Entity> entitiesAffected = player.getNearbyEntities(5, 5, 5);
        for (Entity affected : entitiesAffected) {
            Vector v1 = loc.toVector();
            Vector v2 = affected.getLocation().toVector();
            double distance = v1.distance(v2);
            Vector direction = v2.subtract(v1).normalize();
            double force = getForce(distance);
            /*
            player.sendMessage("V1 loc");
            player.sendMessage("X: " + v1.getX() + " |Y: " + v1.getY() + " |Z : " + v1.getZ());
            player.sendMessage("V2 entity loc");
            player.sendMessage("X: " + v2.getX() + " |Y: " + v2.getY() + " |Z : " + v2.getZ());
            player.sendMessage("mob: " + affected.getName());
            player.sendMessage("distance: " + distance);
            player.sendMessage("force: " + String.valueOf(force));
             */
            affected.setVelocity(direction.multiply(force));
        }

        pp.getCreeperPowerCD().unlockAfter(CDTime, ChatColor.GREEN + "Explosive Dust can be used again!");
    }

    private double getForce(double distance) {
        if (distance <= 0.5) {
            return 3;
        }
        return Math.pow(distance, -1)* 3.5;
    }
}
