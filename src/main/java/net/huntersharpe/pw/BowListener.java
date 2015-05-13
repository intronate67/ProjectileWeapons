package main.java.net.huntersharpe.pw;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.inventory.meta.ItemMeta;

/**
 * Created by Hunter Sharpe on 5/13/15.
 */
public class BowListener implements Listener{

    @EventHandler
    public void onBowShoot(EntityShootBowEvent e){
        if(!(e.getEntity() instanceof Player)) return;
        Player p = (Player) e.getEntity();
        if(!p.hasPermission("pw.shoot")) return;
        if(!e.getBow().getItemMeta().getDisplayName().equals("TNT Bow")) return;
        if(!e.getBow().getItemMeta().getLore().equals("Shoots TNT")) return;
        e.setProjectile(p.getWorld().spawnEntity(p.getLocation(), EntityType.PRIMED_TNT));
    }

}
