package me.dotarakotara.eventlisteners.listeners;

import me.dotarakotara.eventlisteners.FunnyManhunt;
import me.dotarakotara.eventlisteners.Interface;
import me.dotarakotara.eventlisteners.players.Hunter;
import me.dotarakotara.eventlisteners.players.PlayerPlus;
import me.dotarakotara.eventlisteners.players.SpeedRunner;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.Map;
import java.util.UUID;

public class CompassListener implements Listener {
    protected Interface interface1;
    protected FunnyManhunt plugin;
    protected Map<UUID, PlayerPlus> uuidToPP;

    public CompassListener(FunnyManhunt vplugin, Map<UUID, PlayerPlus> vuuidToPP) {
        interface1 = new Interface();
        plugin = vplugin;
        uuidToPP = vuuidToPP;
    }

    @EventHandler
    public void onMove(PlayerMoveEvent e) {
        Player player = e.getPlayer();
        UUID uuid = player.getUniqueId();
        if (!uuidToPP.containsKey(uuid) || !(uuidToPP.get(uuid) instanceof SpeedRunner)) {
            return;
        }
        for (Player p : Bukkit.getOnlinePlayers()) {
            UUID uuidP = p.getUniqueId();
            if (uuidToPP.containsKey(uuid) && uuidToPP.get(uuid) instanceof Hunter) {
                Hunter hunter = (Hunter)uuidToPP.get(uuidP);
                hunter.updateCompass();
                p.updateInventory();
            }
        }
    }
}
