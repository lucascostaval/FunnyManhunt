package me.dotarakotara.eventlisteners.skills;

import me.dotarakotara.eventlisteners.FunnyManhunt;
import me.dotarakotara.eventlisteners.players.PlayerPlus;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.Map;
import java.util.UUID;

public class GrassEatListener implements Listener {
    protected FunnyManhunt plugin;
    protected Map<UUID, PlayerPlus> uuidToPP;

    protected int CDTime = 3;
    public GrassEatListener(FunnyManhunt vplugin, Map<UUID, PlayerPlus> vuuidToPP) {
        plugin = vplugin;
        uuidToPP = vuuidToPP;
    }

    @EventHandler
    public void onEat(PlayerInteractEvent e) {
        Player player = e.getPlayer();
        UUID uuid = player.getUniqueId();
        if (!uuidToPP.containsKey(uuid)) {
            return;
        }
        PlayerPlus pp = uuidToPP.get(uuid);
        Block block = e.getClickedBlock();
        if (block != null && block.getType() == Material.GRASS_BLOCK && pp.getSkills().contains("Sheep Power") &&
        pp.getSheepPowerCD().isUnlocked()) {
            eat(pp, block);
            pp.getSheepPowerCD().lock();
        }
    }

    private void eat(PlayerPlus pp, Block block) {
        Player player = pp.getPlayer();
        block.setType(Material.DIRT);
        int foodPoints = 1;
        if (pp.getSkills().contains("Cow Power")) {
            foodPoints++;
        }
        int newFoodLevel = Math.min(player.getFoodLevel()+foodPoints, 20);
        player.setFoodLevel(newFoodLevel);
        pp.getSheepPowerCD().unlockAfter(CDTime, "");
        player.getWorld().playSound(block.getLocation(), Sound.BLOCK_GRASS_BREAK, 3, 2);
    }
}
