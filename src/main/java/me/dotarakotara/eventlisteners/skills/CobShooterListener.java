package me.dotarakotara.eventlisteners.skills;

import me.dotarakotara.eventlisteners.FunnyManhunt;
import me.dotarakotara.eventlisteners.players.PlayerPlus;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Map;
import java.util.UUID;

public class CobShooterListener implements Listener {

    protected FunnyManhunt plugin;
    protected Map<UUID, PlayerPlus> uuidToPP;

    public CobShooterListener(FunnyManhunt vplugin, Map<UUID, PlayerPlus> vuuidToPP) {
        plugin = vplugin;
        uuidToPP = vuuidToPP;
    }

    @EventHandler
    public void onHit(EntityDamageByEntityEvent e) {
        if (!(e.getDamager() instanceof Player)) {
            return;
        }
        Player player = (Player) e.getDamager();
        if (!uuidToPP.containsKey(player.getUniqueId())) {
            return;
        }
        PlayerPlus pp = uuidToPP.get(player.getUniqueId());
        ItemStack item = player.getInventory().getItemInMainHand();
        if (pp.hasSkill("Spider Power") && item.getItemMeta() != null && item.getItemMeta().getDisplayName().equals("Cob Shooter")
        && pp.getSpiderPowerCD().isUnlocked()) {
            pp.getSpiderPowerCD().lock();
            e.setCancelled(true);
            // change later, maybe
            Location upLoc = e.getEntity().getLocation();
            upLoc.setY(upLoc.getY()+1);
            Block up = upLoc.getBlock();

            Location downLoc = e.getEntity().getLocation();
            Block down = downLoc.getBlock();

            up.setType(Material.COBWEB);
            down.setType(Material.COBWEB);
            pp.getSpiderPowerCD().unlockAfter(30, ChatColor.RED + "Cob Shooter can be used again!");
        }
    }

}
