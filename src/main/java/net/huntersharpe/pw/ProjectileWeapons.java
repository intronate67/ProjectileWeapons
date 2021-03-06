package main.java.net.huntersharpe.pw;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hunter Sharpe on 5/13/15.
 */
public class ProjectileWeapons extends JavaPlugin {

    public FileConfiguration config = getConfig();

    public void onEnable(){
        if(!getDataFolder().exists()){
            getDataFolder().mkdir();
            saveDefaultConfig();
            saveConfig();
        }

        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new BowListener(), this);
        addRecipes();

    }

    public void onDisable(){

    }

    private void addRecipes(){
        ShapedRecipe tntBow = new ShapedRecipe(tntBow());
        tntBow.shape("TGT");
        tntBow.setIngredient('T', Material.TNT);
        tntBow.setIngredient('G', Material.SULPHUR);
        tntBow.shape(new String[]{"TGT"});
        getServer().addRecipe(tntBow);

        ShapedRecipe tntAmmo = new ShapedRecipe(tntAmmo());
        tntAmmo.shape("TFT");
        tntAmmo.setIngredient('T', Material.TNT);
        tntAmmo.setIngredient('F', Material.FIREBALL);
        tntAmmo.shape(new String[]{"TFT"});
        getServer().addRecipe(tntAmmo);
    }

    public ItemStack tntBow(){
        ItemStack tntBow = new ItemStack(Material.BOW, (byte) 4);
        ItemMeta tntMeta = tntBow.getItemMeta();
        tntMeta.setDisplayName(ChatColor.RED + "TNT Bow");
        List<String> s = new ArrayList<String>();
        s.add(ChatColor.AQUA + "Shoots TNT");
        tntMeta.setLore(s);
        tntBow.setItemMeta(tntMeta);
        return tntBow;
    }

    public ItemStack tntAmmo() {
        ItemStack tntAmmo = new ItemStack(Material.ARROW, (byte) 4);
        ItemMeta tntMeta = tntAmmo.getItemMeta();
        tntMeta.setDisplayName(ChatColor.GREEN + "TNT Bow Ammo");
        List<String> s = new ArrayList<String>();
        s.add(ChatColor.LIGHT_PURPLE + "Used for TNT Bow");
        tntMeta.setLore(s);
        tntAmmo.setItemMeta(tntMeta);
        return tntAmmo;
    }
}
