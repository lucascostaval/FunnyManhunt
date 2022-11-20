package me.dotarakotara.eventlisteners.commands;

import me.dotarakotara.eventlisteners.FunnyManhunt;
import me.dotarakotara.eventlisteners.Interface;
import me.dotarakotara.eventlisteners.players.PlayerPlus;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Map;
import java.util.UUID;

public class ChooseCommand implements CommandExecutor {

    protected Interface interface1;
    protected Map<UUID, PlayerPlus> uuidToPP;
    protected FunnyManhunt plugin;

    public ChooseCommand(FunnyManhunt vplugin, Map<UUID, PlayerPlus> vuuidToPP) {
        interface1 = new Interface();
        plugin = vplugin;
        uuidToPP = vuuidToPP;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player)sender;
            PlayerPlus playerplus = new PlayerPlus(plugin, p);
            uuidToPP.put(p.getUniqueId(), playerplus);
            if (args[0].equalsIgnoreCase("hunter")) {
                p.sendMessage(ChatColor.RED+"You are now a Hunter");
                // Need to get compass pointing do speedrunner

            } else if (args[0].equalsIgnoreCase("speedrunner")) {
                p.sendMessage(ChatColor.BLUE+"You are now a speedrunner");

            }
        }
        return true;
    }
}
