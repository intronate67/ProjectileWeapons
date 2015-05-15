package main.java.net.huntersharpe.pw;

import org.bukkit.ChatColor;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityShootBowEvent;
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
        if(!e.getBow().getItemMeta().getDisplayName().equals(ChatColor.RED + "TNT Bow")) return;
        Vector v = new Vector(e.getProjectile().getVelocity().getX(),
                e.getProjectile().getVelocity().getY(),
                e.getProjectile().getVelocity().getZ()
        );
        e.setProjectile(p.getWorld().spawnEntity(p.getLocation(), EntityType.PRIMED_TNT));
        e.getProjectile().setVelocity(v);
    }

}
