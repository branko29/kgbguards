 	package org.branko29.guards;
 
 		import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.bukkit.event.EventHandler;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.material.Chest;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitScheduler;

import com.earth2me.essentials.User;

 		public class KGBguardsListener implements Listener
 		{
 			public KGBguards plugin;
 			public static ArrayList<Player> Inv = new ArrayList();
 			public static ArrayList<Player> Ouch = new ArrayList();
   
 			public KGBguardsListener(KGBguards instance) { this.plugin = instance; }
 			
 		
 			@EventHandler
 			public void taze(PlayerMoveEvent event)
 			{
 				final Player p = event.getPlayer();
 				if (Ouch.contains(p)) {
 					p.teleport(p.getLocation());
 					p.getWorld().playSound(p.getLocation(), Sound.HURT_FLESH, 1.0F, 1.0F);
 					Bukkit.getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable()
 				{
 						
 				public void run() {
 					KGBguardsListener.Ouch.remove(p);
 				}
 			}, 200L);
 		}
 	}
   
 			@EventHandler
 			public void Drop(PlayerDropItemEvent event) { String a = ChatColor.RED + "Sprej"; 
 				String b = ChatColor.GOLD + "Tejzer";
 				String c = ChatColor.GREEN + "Palica";
 				String d = ChatColor.BLUE + "Lisice";
 				
 			try {
 				if ((event.getItemDrop().getItemStack().getItemMeta().getDisplayName().equals(ChatColor.BOLD + a)) || (event.getItemDrop().getItemStack().getItemMeta().getDisplayName().equals(ChatColor.BOLD + b)) || (event.getItemDrop().getItemStack().getItemMeta().getDisplayName().equals(ChatColor.BOLD + c)) || (event.getItemDrop().getItemStack().getItemMeta().getDisplayName().equals(ChatColor.BOLD + d))) {
 					event.setCancelled(true);
 			}
 		}
 			
 			catch (NullPointerException localNullPointerException) {}
 			}
	  
 			@EventHandler
 			public void Death(PlayerDeathEvent event)
 			{
 				ItemStack Sprej = new ItemStack(Material.INK_SACK);
 				ItemStack Tejzer = new ItemStack(Material.BLAZE_ROD);
 				ItemStack Palica = new ItemStack(Material.STICK);
 				ItemStack Lisice = new ItemStack(Material.SHEARS);
 				
 				ItemMeta meta = Sprej.getItemMeta();
 				ItemMeta meta2 = Tejzer.getItemMeta();
 				ItemMeta meta3 = Palica.getItemMeta();
 				ItemMeta meta4 = Lisice.getItemMeta();
 				
 				ArrayList<String> lore = new ArrayList();
 				ArrayList<String> lore2 = new ArrayList();
 				ArrayList<String> lore3 = new ArrayList();
 				ArrayList<String> lore4 = new ArrayList();
 				
 				lore.clear();
 				lore2.clear();
 				lore3.clear();
 				lore4.clear();
 				
 				lore.add(ChatColor.GRAY + "Isprskajte svoju metu!");
 				lore2.add(ChatColor.GRAY + "Protresite svoju metu!");
 				lore3.add(ChatColor.GRAY + "Odbacite svoju metu!");
 				lore4.add(ChatColor.GRAY + "Oduzmite nedozvoljene iteme!");
	  
 				meta.setLore(lore);
 				meta2.setLore(lore2);
 				meta3.setLore(lore3);
 				meta4.setLore(lore4);
 				
 				String a = ChatColor.RED + "Sprej";
 				String b = ChatColor.GOLD + "Tejzer";
 				String c = ChatColor.GREEN + "Palica";
 				String d = ChatColor.BLUE + "Lisice";
	  
 				meta.setDisplayName(ChatColor.BOLD + a);
 				meta2.setDisplayName(ChatColor.BOLD + b);
 				meta3.setDisplayName(ChatColor.BOLD + c);
 				meta4.setDisplayName(ChatColor.BOLD + d);
     
 				Sprej.setItemMeta(meta);
 				Tejzer.setItemMeta(meta2);
 				Palica.setItemMeta(meta3);
 				Palica.addUnsafeEnchantment(Enchantment.KNOCKBACK, 5);
 				Lisice.setItemMeta(meta4);
 				
 			if ((event.getEntity() instanceof Player)) {
 				if (event.getEntity().getInventory().contains(Sprej)) {
 					event.getDrops().remove(Sprej);
 				}
 				if (event.getEntity().getInventory().contains(Tejzer)) {
 					event.getDrops().remove(Tejzer);
 				}
 				if (event.getEntity().getInventory().contains(Palica)) {
 					event.getDrops().remove(Palica);
 				}
 				if (event.getEntity().getInventory().contains(Lisice)) {
 					event.getDrops().remove(Lisice);
 				}
 			}
 		}
	 
 			@EventHandler
 			public void cool(InventoryOpenEvent event) {
 				if (event.getInventory().getType().equals(InventoryType.PLAYER)) {
 					ItemStack Sprej = new ItemStack(Material.INK_SACK);
 					ItemStack Tejzer = new ItemStack(Material.BLAZE_ROD);
 					ItemStack Palica = new ItemStack(Material.STICK);
 					ItemStack Lisice = new ItemStack(Material.SHEARS);
 					
 					ItemMeta meta = Sprej.getItemMeta();
 					ItemMeta meta2 = Tejzer.getItemMeta();
 					ItemMeta meta3 = Palica.getItemMeta();
 					ItemMeta meta4 = Lisice.getItemMeta();
 					
 					ArrayList<String> lore = new ArrayList();
 					ArrayList<String> lore2 = new ArrayList();
 					ArrayList<String> lore3 = new ArrayList();
 					ArrayList<String> lore4 = new ArrayList();
 					
 					lore.clear();
 					lore2.clear();
 					lore3.clear();
 					lore4.clear();
 					
 					lore.add(ChatColor.GRAY + "Isprskajte svoju metu!");
 					lore2.add(ChatColor.GRAY + "Protresite svoju metu!");
 					lore3.add(ChatColor.GRAY + "Odbacite svoju metu!");
 					lore4.add(ChatColor.GRAY + "Oduzmite nedozvoljene iteme!");

 					meta.setLore(lore);
 					meta2.setLore(lore2);
 					meta3.setLore(lore3);
 					meta4.setLore(lore4);

 					String a = ChatColor.RED + "Sprej";
 					String b = ChatColor.GOLD + "Tejzer";
 					String c = ChatColor.GREEN + "Palica";
 					String d = ChatColor.BLUE + "Lisice";
	       
 					meta.setDisplayName(ChatColor.BOLD + a);
 					meta2.setDisplayName(ChatColor.BOLD + b);
 					meta3.setDisplayName(ChatColor.BOLD + c);
 					meta4.setDisplayName(ChatColor.BOLD + d);
	       
 					Sprej.setItemMeta(meta);
 					Tejzer.setItemMeta(meta2);
 					Palica.setItemMeta(meta3);
 					Palica.addUnsafeEnchantment(Enchantment.KNOCKBACK, 5);
 					Lisice.setItemMeta(meta3);
 					
 				if ((event.getInventory().contains(Sprej)) || (event.getInventory().contains(Tejzer)) || (event.getInventory().contains(Palica))|| (event.getInventory().contains(Lisice))) {
 					Inv.add((Player)event.getPlayer());
 				}
 			}
 		}
	  
 			@EventHandler
 			public void d(InventoryClickEvent event) {
 				if (Inv.contains(event.getViewers())) {
 					String a = ChatColor.RED + "Sprej";
 					String b = ChatColor.GOLD + "Tejzer";
 					String c = ChatColor.GREEN + "Palica";
 					String d = ChatColor.BLUE + "Lisice";
 				if ((event.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.BOLD + a)) || (event.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.BOLD + b)) || (event.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.BOLD + c))|| (event.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.BOLD + d)))
 					event.setCancelled(true);
 				}
 			}
	  
 			@EventHandler
 			public void close(InventoryCloseEvent event) {
 				if (Inv.contains(event.getPlayer()))
 					Inv.remove(event.getPlayer());
 			}
	 
 			@EventHandler
 			public void LOL(PlayerInteractEvent event) {
 				if ((event.getAction().equals(Action.RIGHT_CLICK_AIR)) || (event.getAction().equals(Action.RIGHT_CLICK_BLOCK))) {
 					ItemStack Sprej = new ItemStack(Material.INK_SACK);
 					ItemStack Tejzer = new ItemStack(Material.BLAZE_ROD);
 					ItemStack Palica = new ItemStack(Material.STICK);
 					ItemStack Lisice = new ItemStack(Material.SHEARS);

 					ItemMeta meta = Sprej.getItemMeta();
 					ItemMeta meta2 = Tejzer.getItemMeta();
 					ItemMeta meta3 = Palica.getItemMeta();
 					ItemMeta meta4 = Lisice.getItemMeta();

 					ArrayList<String> lore = new ArrayList();
 					ArrayList<String> lore2 = new ArrayList();
 					ArrayList<String> lore3 = new ArrayList();
 					ArrayList<String> lore4 = new ArrayList();

 					lore.clear();
 					lore2.clear();
 					lore3.clear();
 					lore4.clear();

 					lore.add(ChatColor.GRAY + "Isprskajte svoju metu!");
 					lore2.add(ChatColor.GRAY + "Protresite svoju metu!");
 					lore3.add(ChatColor.GRAY + "Odbacite svoju metu!");
 					lore4.add(ChatColor.GRAY + "Oduzmite nedozvoljene iteme!");
	       
 					meta.setLore(lore);
 					meta2.setLore(lore2);
 					meta3.setLore(lore3);
 					meta4.setLore(lore4);

 					String a = ChatColor.RED + "Sprej";
 					String b = ChatColor.GOLD + "Tejzer";
 					String c = ChatColor.GREEN + "Palica";
 					String d = ChatColor.BLUE + "Lisice";
	       
 					meta.setDisplayName(ChatColor.BOLD + a);
 					meta2.setDisplayName(ChatColor.BOLD + b);
 					meta3.setDisplayName(ChatColor.BOLD + c);
 					meta4.setDisplayName(ChatColor.BOLD + d);
	      
 					Sprej.setItemMeta(meta);
 					Tejzer.setItemMeta(meta2);
 					Palica.setItemMeta(meta3);
 					Palica.addUnsafeEnchantment(Enchantment.KNOCKBACK, 5);
 					Lisice.setItemMeta(meta4);
 					
 				if (event.getPlayer().getItemInHand().equals(Sprej)) {
 					event.getPlayer().getWorld().playEffect(event.getPlayer().getLocation(), Effect.SMOKE, 5);
 				}

 				if (event.getPlayer().getItemInHand().equals(Tejzer)) {
 					event.getPlayer().getWorld().playSound(event.getPlayer().getLocation(), Sound.FIZZ, 3.0F, 1.0F);
 					event.getPlayer().getWorld().playEffect(event.getPlayer().getLocation(), Effect.SMOKE, 5);
 				}
 			}
 		}
 			
 			@EventHandler
 			public void ttt(PlayerInteractEntityEvent event) {
 				String a = ChatColor.RED + "Sprej";
 				String b = ChatColor.GOLD + "Tejzer";
 				String c = ChatColor.GREEN + "Palica";
 				String d = ChatColor.BLUE + "Lisice";
				
			{
		
 			try {
 				if ((event.getPlayer().hasPermission("kgbguards.sprej")) && (event.getPlayer().getItemInHand().getItemMeta().getDisplayName().equals(ChatColor.BOLD + a))) {
 					event.getPlayer().getWorld().playSound(event.getPlayer().getLocation(), Sound.SILVERFISH_HIT, 1.0F, 1.0F);
 					event.getPlayer().getWorld().playEffect(event.getPlayer().getLocation(), Effect.SMOKE, 5);
 					if ((event.getRightClicked() instanceof Player)) {
 						Player victim = (Player)event.getRightClicked();
 						victim.sendMessage(ChatColor.BLUE + "Strazar te je poprskao suzavcem!");
 						victim.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 20, 1));
 						victim.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 20, 2));
 						victim.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 20, 5));
 					}
 				}
 				
 				if ((event.getPlayer().hasPermission("kgbguards.tejzer")) && (event.getPlayer().getItemInHand().getItemMeta().getDisplayName().equals(ChatColor.BOLD + b))) {
 					event.getPlayer().getWorld().playSound(event.getPlayer().getLocation(), Sound.WITHER_DEATH, 1.0F, 1.0F);
 					event.getPlayer().getWorld().playEffect(event.getPlayer().getLocation(), Effect.SMOKE, 5);
 					if ((event.getRightClicked() instanceof Player)) {
 						Player victim = (Player)event.getRightClicked();
 						victim.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 20, 1));
 						victim.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 20, 3));
 						victim.sendMessage(ChatColor.BLUE + "Strazar te je sokirao!");
 						victim.damage(1.0D);
 					}
 				}
 
 				if ((event.getPlayer().hasPermission("kgbguards.palica")) && (event.getPlayer().getItemInHand().getItemMeta().getDisplayName().equals(ChatColor.BOLD + c))) {
 					event.getPlayer().getWorld().playSound(event.getPlayer().getLocation(), Sound.ARROW_HIT, 1.0F, 1.0F);
 					event.getPlayer().getWorld().playEffect(event.getPlayer().getLocation(), Effect.SMOKE, 5);
 					}
 				
 				
 				if ((event.getPlayer().hasPermission("kgbguards.lisice")) && (event.getPlayer().getItemInHand().getItemMeta().getDisplayName().equals(ChatColor.BOLD + d))) {
 					event.getPlayer().getWorld().playSound(event.getPlayer().getLocation(), Sound.CLICK, 1.0F, 1.0F);
 					if ((event.getRightClicked() instanceof Player)) {
 						Player victim = (Player)event.getRightClicked();
 						victim.sendMessage(ChatColor.BLUE + "Strazar ti je stavio lisice, i oduzeo nedozvoljene iteme!");
 						victim.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 20, 1));
 						Ouch.add(victim);
 						victim.getInventory().remove(Material.DIAMOND_SWORD);

 					}
 				}
 			}
 			 

 			catch (NullPointerException localNullPointerException) {}
 			}
 		}
 	}
