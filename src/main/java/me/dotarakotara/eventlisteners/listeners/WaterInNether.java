package me.dotarakotara.eventlisteners.listeners;

import me.dotarakotara.eventlisteners.FunnyManhunt;
import me.dotarakotara.eventlisteners.players.PlayerPlus;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.Map;
import java.util.UUID;

public class WaterInNether implements Listener {
    protected FunnyManhunt plugin;
    protected Map<UUID, PlayerPlus> uuidToPP;

    public WaterInNether(FunnyManhunt vplugin, Map<UUID, PlayerPlus> vuuidToPP) {
        plugin = vplugin;
        uuidToPP = vuuidToPP;
        System.out.println("here 0");
    }

    @EventHandler
    public void onRightClick(PlayerInteractEvent e) {
        Player player = e.getPlayer();
        player.sendMessage("Here 1");
        if (player.getWorld().getEnvironment() == World.Environment.NETHER && player.getInventory().getItemInMainHand().
                getType() == Material.WATER_BUCKET && e.getAction() == Action.RIGHT_CLICK_BLOCK) {
            e.setCancelled(true);
            player.sendMessage("Here 2");
            Location loc = e.getClickedBlock().getLocation();
            loc.setY(loc.getY()+1);
            loc.getBlock().setType(Material.WATER);
        }
    }
}
