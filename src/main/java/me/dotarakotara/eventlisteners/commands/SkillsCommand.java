package me.dotarakotara.eventlisteners.commands;

import me.dotarakotara.eventlisteners.FunnyManhunt;
import me.dotarakotara.eventlisteners.Interface;
import me.dotarakotara.eventlisteners.players.PlayerPlus;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Map;
import java.util.UUID;

public class SkillsCommand implements CommandExecutor {

    protected Interface interface1;
    protected Map<UUID, PlayerPlus> uuidToPP;
    protected FunnyManhunt plugin;

    public SkillsCommand(FunnyManhunt vplugin, Map<UUID, PlayerPlus> vuuidToPP) {
        interface1 = new Interface();
        plugin = vplugin;
        uuidToPP = vuuidToPP;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            UUID uuid = p.getUniqueId();
            if (!uuidToPP.containsKey(uuid)) {
                return false;
            }
            PlayerPlus pp = uuidToPP.get(uuid);
            String resultNotFixed = "";
            for (String s : pp.getSkills()) {
                resultNotFixed = resultNotFixed + s + ", ";
            }
            String result = "Skills: ";
            for (int i = 0; i < resultNotFixed.length()-2; i++) {
                result += resultNotFixed.charAt(i);
            }
            p.sendMessage(result);
            return true;
        }
        return false;
    }
}
