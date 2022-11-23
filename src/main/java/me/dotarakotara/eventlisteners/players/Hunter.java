package me.dotarakotara.eventlisteners.players;

import me.dotarakotara.eventlisteners.FunnyManhunt;
import me.dotarakotara.eventlisteners.itens.CustomItem;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.CompassMeta;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Hunter extends PlayerPlus {
    protected ItemStack compass;
    public Hunter(FunnyManhunt plugin, Player player, Map<UUID, PlayerPlus> vuuidToPP) {
        super(plugin, player, vuuidToPP);
        compass = getCompass();
    }

    public ItemStack getCompass() {
        compass = CustomItem.runnerTracker();
        updateCompass();

        Location locToGet = player.getLocation();
        locToGet.setY(locToGet.getY()+1);
        player.getWorld().dropItemNaturally(locToGet, compass);

        return compass;
    }

    public void updateCompass() {
        CompassMeta meta = (CompassMeta)compass.getItemMeta();
        Location loc = new Location(player.getWorld(), 0, 0, 0);
        for (Player p : Bukkit.getOnlinePlayers()) {
            UUID uuid = p.getUniqueId();
            if (uuidToPP.containsKey(uuid)) {
                PlayerPlus pp = uuidToPP.get(uuid);
                if (pp instanceof SpeedRunner) {
                    loc = p.getLocation();
                }
            }
        }
        meta.setLodestoneTracked(false);
        meta.setLodestone(loc);
        compass.setItemMeta(meta);
    }
}
