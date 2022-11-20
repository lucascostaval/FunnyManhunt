package me.dotarakotara.eventlisteners;

import me.dotarakotara.eventlisteners.commands.ChooseCommand;
import me.dotarakotara.eventlisteners.commands.SkillsCommand;
import me.dotarakotara.eventlisteners.listeners.DrinkingListener;
import me.dotarakotara.eventlisteners.listeners.MilkingListener;
import me.dotarakotara.eventlisteners.skills.GrassEatListener;
import me.dotarakotara.eventlisteners.skills.PigShootListener;
import me.dotarakotara.eventlisteners.players.PlayerPlus;
import me.dotarakotara.eventlisteners.skills.PlusEatingListener;
import me.dotarakotara.eventlisteners.listeners.ShootArrowListener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public final class FunnyManhunt extends JavaPlugin {

    protected Interface interface1;
    protected Map<UUID, PlayerPlus> uuidToPP;

    @Override
    public void onEnable() {
        // Plugin startup logic
        interface1 = new Interface();
        uuidToPP = new HashMap<UUID, PlayerPlus>();
        MilkingListener milkingListener = new MilkingListener(this, uuidToPP);
        DrinkingListener drinkingListener = new DrinkingListener(this, uuidToPP);
        PigShootListener pigShootListener = new PigShootListener(this, uuidToPP);
        GrassEatListener grassEatListener = new GrassEatListener(this, uuidToPP);
        PlusEatingListener plusEatingListener = new PlusEatingListener(this, uuidToPP);
        ShootArrowListener shootArrowListener = new ShootArrowListener(this, uuidToPP);

        ChooseCommand chooseCommand = new ChooseCommand(this, uuidToPP);
        SkillsCommand skillsCommand = new SkillsCommand(this, uuidToPP);

        interface1.showMessage("Starting the server!");
        getServer().getPluginManager().registerEvents(milkingListener, this);
        getServer().getPluginManager().registerEvents(drinkingListener, this);
        getServer().getPluginManager().registerEvents(pigShootListener, this);
        getServer().getPluginManager().registerEvents(grassEatListener, this);
        getServer().getPluginManager().registerEvents(plusEatingListener, this);
        getServer().getPluginManager().registerEvents(shootArrowListener, this);


        getCommand("choose").setExecutor(chooseCommand);
        getCommand("skills").setExecutor(skillsCommand);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
