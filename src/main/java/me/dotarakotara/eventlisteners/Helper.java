package me.dotarakotara.eventlisteners;

import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.inventory.Inventory;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

import java.util.Collection;
import java.util.Random;

public class Helper {

    protected static double[] debugParameters = {1, 0, 0, 0, 0};

    public static double getDebug(int i) {
        return debugParameters[i];
    }

    public static void setDebug(int i, double value) {
        debugParameters[i] = value;
    }
    public static int findFirstEmpty(Inventory inv) {
        int firstEmpty;
        for (int i = 0; i < 36; i++) {
            if (inv.getItem(i) == null) {
                firstEmpty = i;
                return firstEmpty;
            }
        }
        return -1;
    }

    public static void applyToAll(Collection<Entity> entities, PotionEffectType effect, int duration, int amplifier){
        for (Entity entity : entities) {
            if (entity instanceof LivingEntity) {
                LivingEntity livingEntity = (LivingEntity) entity;
                livingEntity.addPotionEffect(new PotionEffect(effect, duration*20, amplifier));
            }
        }
    }

    public static int dice(int min, int max) {
        return min+(int)(Math.random()*(max-min+1));
    }

    public static double getMagnitude(Vector vector) {
        return Math.sqrt(Math.pow(vector.getX(), 2)+Math.pow(vector.getY(), 2)+Math.pow(vector.getZ(), 2));
    }
}
