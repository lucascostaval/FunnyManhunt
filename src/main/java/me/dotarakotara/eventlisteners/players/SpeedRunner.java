package me.dotarakotara.eventlisteners.players;

import me.dotarakotara.eventlisteners.FunnyManhunt;
import org.bukkit.entity.Player;

import java.util.Map;
import java.util.UUID;

public class SpeedRunner extends PlayerPlus {
    public SpeedRunner(FunnyManhunt plugin, Player player, Map<UUID, PlayerPlus> vuuidToPP) {
        super(plugin, player, vuuidToPP);
    }
}
