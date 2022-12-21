package me.dotarakotara.eventlisteners;

import me.dotarakotara.eventlisteners.commands.ChooseCommand;
import me.dotarakotara.eventlisteners.commands.ModifyCommand;
import me.dotarakotara.eventlisteners.commands.SkillsCommand;
import me.dotarakotara.eventlisteners.listeners.*;
import me.dotarakotara.eventlisteners.skills.*;
import me.dotarakotara.eventlisteners.players.PlayerPlus;
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
        WaterInNether waterInNetherListener = new WaterInNether(this, uuidToPP);
        ExplodeListener explodeListener = new ExplodeListener(this, uuidToPP);
        CompassListener compassListener = new CompassListener(this, uuidToPP);
        CobShooterListener cobShooter = new CobShooterListener(this, uuidToPP);

        ChooseCommand chooseCommand = new ChooseCommand(this, uuidToPP);
        SkillsCommand skillsCommand = new SkillsCommand(this, uuidToPP);
        ModifyCommand modifyCommand = new ModifyCommand(this, uuidToPP);

        interface1.showMessage("Starting the server!");
        getServer().getPluginManager().registerEvents(milkingListener, this);
        getServer().getPluginManager().registerEvents(drinkingListener, this);
        getServer().getPluginManager().registerEvents(pigShootListener, this);
        getServer().getPluginManager().registerEvents(grassEatListener, this);
        getServer().getPluginManager().registerEvents(plusEatingListener, this);
        getServer().getPluginManager().registerEvents(shootArrowListener, this);
        getServer().getPluginManager().registerEvents(waterInNetherListener, this);
        getServer().getPluginManager().registerEvents(explodeListener, this);
        getServer().getPluginManager().registerEvents(compassListener, this);
        getServer().getPluginManager().registerEvents(cobShooter, this);

        getCommand("choose").setExecutor(chooseCommand);
        getCommand("skills").setExecutor(skillsCommand);
        getCommand("modify").setExecutor(modifyCommand);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
