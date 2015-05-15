package main.java.net.huntersharpe.pw;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

/**
 * Created by Hunter Sharpe on 5/13/15.
 */
public class BowListener implements Listener{


    @EventHandler
    public void onBowShoot(EntityShootBowEvent e){
        if(!(e.getEntity() instanceof Player)) return;
        Player p = (Player) e.getEntity();
        if(!p.hasPermission("pw.shoot")) return;
        if(!e.getBow().getData().equals((byte) 4)) return;
        if(p.getGameMode().equals(GameMode.CREATIVE)){
            Vector v = new Vector(e.getProjectile().getVelocity().getX(),
                    e.getProjectile().getVelocity().getY(),
                    e.getProjectile().getVelocity().getZ()
            );
            e.setProjectile(p.getWorld().spawnEntity(p.getLocation(), EntityType.PRIMED_TNT));
            e.getProjectile().setVelocity(v);
        }else if(!p.getInventory().contains(Material.ARROW, (byte) 4)){
            e.setCancelled(true);
            return;
        }
        else{
            Vector v = new Vector(e.getProjectile().getVelocity().getX(),
                    e.getProjectile().getVelocity().getY(),
                    e.getProjectile().getVelocity().getZ()
            );
            e.setProjectile(p.getWorld().spawnEntity(p.getLocation(), EntityType.PRIMED_TNT));
            e.getProjectile().setVelocity(v);
            p.getInventory().remove(new ItemStack(Material.ARROW, (byte) 4));
            return;
        }


    }

}
