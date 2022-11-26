package me.dotarakotara.eventlisteners.players;

import me.dotarakotara.eventlisteners.FunnyManhunt;
import me.dotarakotara.eventlisteners.cooldown.Cooldown;
import me.dotarakotara.eventlisteners.itens.CustomItem;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.*;

public class PlayerPlus {
    protected final int INF = 9999999;
    protected Player player;
    protected UUID uuid;
    protected Set<String> skills;
    protected FunnyManhunt plugin;

    protected Map<UUID, PlayerPlus> uuidToPP;

    protected Cooldown pigpowerCD;
    protected Cooldown sheeppowerCD;
    protected Cooldown skeletonPowerCD;
    protected Cooldown creeperPowerCD;

    public PlayerPlus(FunnyManhunt vplugin, Player vplayer, Map<UUID, PlayerPlus> vuuidToPP) {
        plugin = vplugin;
        player = vplayer;
        uuid = vplayer.getUniqueId();
        skills = new HashSet<String>();
        uuidToPP = vuuidToPP;

        pigpowerCD = new Cooldown(vplugin, this);
        sheeppowerCD = new Cooldown(vplugin, this);
        skeletonPowerCD = new Cooldown(vplugin, this);
        creeperPowerCD = new Cooldown(vplugin, this);
    }

    public Player getPlayer() {
        return player;
    }

    public Set<String> getSkills() {
        return skills;
    }

    public Cooldown getPigPowerCD() {
        return pigpowerCD;
    }

    public Cooldown getSheepPowerCD() {
        return sheeppowerCD;
    }

    public Cooldown getSkeletonPowerCD() {
        return skeletonPowerCD;
    }

    public Cooldown getCreeperPowerCD() {
        return creeperPowerCD;
    }

    private void addSkill(String skill) {
        skills.add(skill);
    }

    public boolean hasSkill(String skill) {
        return skills.contains(skill);
    }

    public void gainChickenPower() {
        if (skills.contains("Chicken Power")) {
            return;
        }
        player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_FALLING, INF, 0));
        addSkill("Chicken Power");
    }

    public void gainPigPower() {
        if (skills.contains("Pig Power")) {
            return;
        }
        ItemStack pigShooter = CustomItem.pigShooter();
        Location loc = player.getLocation();
        loc.setY(loc.getY()+0.5);
        player.getWorld().dropItemNaturally(loc, pigShooter);
        addSkill("Pig Power");
    }

    public void gainSheepPower() {
        if (skills.contains("Sheep Power")) {
            return;
        }
        addSkill("Sheep Power");
    }

    public void gainCowPower() {
        if (skills.contains("Cow Power")) {
            return;
        }
        addSkill("Cow Power");
    }

    public void gainFishPower() {
        if (skills.contains("Fish Power")) {
            return;
        }
        player.addPotionEffect(new PotionEffect(PotionEffectType.CONDUIT_POWER, INF, 0));
        addSkill("Fish Power");
    }

    public void gainBatPower() {
        if (skills.contains("Bat Power")) {
            return;
        }
        player.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, INF, 0));
        addSkill("Bat Power");
    }

    public void gainSkeletonPower() {
        if (skills.contains("Bat Power")) {
            return;
        }
        addSkill("Skeleton Power");
    }

    public void gainZombiePower() {
        if (skills.contains("Zombie Power")) {
            return;
        }
        player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, INF, 0));
        addSkill("Zombie Power");
    }

    public void gainCreeperPower() {
        if (skills.contains("Creeper Power")) {
            return;
        }

        ItemStack explosiveDust = CustomItem.explosiveDust();
        Location loc = player.getLocation();
        loc.setY(loc.getY()+0.5);
        player.getWorld().dropItemNaturally(loc, explosiveDust);
        addSkill("Creeper Power");
    }

    public void gainSpiderPower() {
        if (skills.contains("Spider Power")) {
            return;
        }
        ItemStack cobShooter = CustomItem.cobShooter();
        Location loc = player.getLocation();
        loc.setY(loc.getY()+0.5);
        player.getWorld().dropItemNaturally(loc, cobShooter);
        addSkill("Spider Power");
    }
}
