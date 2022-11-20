package me.dotarakotara.eventlisteners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class Interface {
    public Interface() {}

    public void showMessage(String message) {
        System.out.println(message);
    }

    public void messageAllPlayers(String message) {
        for (Player p : Bukkit.getOnlinePlayers()) {
            p.sendMessage(message);
        }
    }
}
