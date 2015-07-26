	package org.branko29.guards;

		import java.util.ArrayList;
		import java.util.logging.Logger;
		import org.bukkit.Bukkit;
		import org.bukkit.ChatColor;
		import org.bukkit.Material;
		import org.bukkit.command.Command;
		import org.bukkit.command.CommandSender;
		import org.bukkit.enchantments.Enchantment;
		import org.bukkit.entity.Player;
		import org.bukkit.inventory.ItemStack;
		import org.bukkit.inventory.PlayerInventory;
		import org.bukkit.inventory.meta.ItemMeta;
		import org.bukkit.plugin.PluginManager;
		import org.bukkit.plugin.java.JavaPlugin;
		import org.bukkit.event.EventHandler;
		import org.bukkit.event.player.*;
		
		public class KGBguards
		extends JavaPlugin
		{
			
		private static final Logger log = Logger.getLogger("Minecraft");
		private final KGBguardsListener Tree = new KGBguardsListener(this);
 
		public KGBguards() {}
   
			public void onEnable() { log.info("&4KGBguards has been enabled!");
				PluginManager pm = Bukkit.getPluginManager();
				pm.registerEvents(this.Tree, this);
			}
   
			public void onDisable() { log.info("&4KGBguard has been disabled!");
			}
		
			public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
				if ((cmd.getName().equalsIgnoreCase("KGBguard")) && (((Player)sender).hasPermission("kgbguards.kit"))) {
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
					
					lore.add(ChatColor.GRAY + "Isprskajte svoju metu! (Ne koristiti za PVP)");
					lore2.add(ChatColor.GRAY + "Protresite svoju metu! (Ne koristiti za PVP)");
					lore3.add(ChatColor.GRAY + "Odbacite svoju metu! (Ne koristiti za PVP)");
					lore4.add(ChatColor.GRAY + "Oduzmite nedozvoljene iteme! (Ne koristiti za PVP)");
					
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
					Lisice.addUnsafeEnchantment(Enchantment.WATER_WORKER, 1);

					if ((!((Player)sender).getInventory().contains(Sprej)) || (!((Player)sender).getInventory().contains(Tejzer)) || (!((Player)sender).getInventory().contains(Tejzer)))
					{
					int count = 0;
					PlayerInventory contents = ((Player)sender).getInventory();
						for (int i = 0; i < contents.getSize(); i++) {
							if (contents.getItem(i) != null)
								count++;
							if (contents.getItem(count) == null) {
								contents.setItem(count, Sprej);
								count++;
							if (contents.getItem(count) == null) {
								contents.setItem(count, Tejzer);
								count++;
							if (contents.getItem(count) == null) {
								contents.setItem(count, Palica);
								count++;
							if (contents.getItem(count) == null) {
								contents.setItem(count, Lisice);
								break;
							}
							}
							}
							}
							}
							}								
								
						 	else {
								sender.sendMessage(ChatColor.RED + "Usvom inventaru vec posedujes sve guard iteme!!");
							}
						}
								
							else {
								sender.sendMessage(ChatColor.RED + "Nemas dozvolu za ovu komandu");
							}
						
					
				
				return false;
			}
		
		}
		
					
			
				 

			
			
