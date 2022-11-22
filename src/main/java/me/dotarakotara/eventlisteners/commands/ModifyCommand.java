package me.dotarakotara.eventlisteners.commands;

import me.dotarakotara.eventlisteners.FunnyManhunt;
import me.dotarakotara.eventlisteners.Helper;
import me.dotarakotara.eventlisteners.Interface;
import me.dotarakotara.eventlisteners.players.PlayerPlus;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;

import java.util.Map;
import java.util.UUID;

public class ModifyCommand implements CommandExecutor {
    protected Interface interface1;
    protected Map<UUID, PlayerPlus> uuidToPP;
    protected FunnyManhunt plugin;

    public ModifyCommand(FunnyManhunt vplugin, Map<UUID, PlayerPlus> vuuidToPP) {
        interface1 = new Interface();
        plugin = vplugin;
        uuidToPP = vuuidToPP;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player)sender;
            int index = Integer.parseInt(args[0]);
            double value = Double.parseDouble(args[1]);
            Helper.setDebug(index, value);
            player.sendMessage("Debug Parameter number [" + index + "] changed to value " + value);
            return true;
        }
        return false;
    }
}
