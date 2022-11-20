package me.dotarakotara.eventlisteners.cooldown;

import me.dotarakotara.eventlisteners.FunnyManhunt;
import me.dotarakotara.eventlisteners.players.PlayerPlus;
import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitScheduler;

public class Cooldown {
    protected boolean unlocked;
    protected FunnyManhunt plugin;
    protected PlayerPlus pp;
    public Cooldown(FunnyManhunt vplugin, PlayerPlus vpp) {
        plugin = vplugin;
        pp = vpp;
        unlocked = true;
    }

    public void unlockAfter(int seconds, String message) {
        BukkitScheduler scheduler = Bukkit.getScheduler();
        scheduler.runTaskLater(plugin, () -> {
            unlock();
            if (!message.equals("")) {
                pp.getPlayer().sendMessage(message);
            }
        }, 20L *seconds);
    }

    public boolean isUnlocked() {
        return unlocked;
    }

    public void lock() {
        unlocked = false;
    }

    public void unlock() {
        unlocked = true;
    }
}
