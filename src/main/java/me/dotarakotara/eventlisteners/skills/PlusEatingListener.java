package me.dotarakotara.eventlisteners.skills;

import me.dotarakotara.eventlisteners.FunnyManhunt;
import me.dotarakotara.eventlisteners.players.PlayerPlus;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitScheduler;

import java.util.Map;
import java.util.UUID;

public class PlusEatingListener implements Listener {
    protected FunnyManhunt plugin;
    protected Map<UUID, PlayerPlus> uuidToPP;

    public PlusEatingListener(FunnyManhunt vplugin, Map<UUID, PlayerPlus> vuuidToPP) {
        plugin = vplugin;
        uuidToPP = vuuidToPP;
    }

    @EventHandler
    public void onEat(PlayerItemConsumeEvent e){
        Player player = e.getPlayer();
        UUID uuid = player.getUniqueId();
        if (!uuidToPP.containsKey(uuid)) {
            return;
        }
        PlayerPlus pp = uuidToPP.get(uuid);
        ItemStack item = e.getItem();
        if (pp.getSkills().contains("Cow Power") && item.getType().isEdible()) {
            BukkitScheduler scheduler = Bukkit.getScheduler();
            scheduler.runTaskLater(plugin, () -> {
                int newFoodLevel = Math.min(20, player.getFoodLevel()+4);
                player.setFoodLevel(newFoodLevel);
            }, 1);
        }
    }
}
