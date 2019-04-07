package com.itzbradmc.mcquarry.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class mqCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {

        if(args.length >= 2){
            if(args[0].equalsIgnoreCase("give")){
                give(args[1]);
            }
        } else{
            commandSender.sendMessage("Invalid command");
        }

        return false;
    }

    private void give(String playerName){

        Player player = Bukkit.getPlayer(playerName);

        ItemStack item = new ItemStack(Material.IRON_BLOCK);
        ItemMeta itemMeta = item.getItemMeta();

        itemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&eQuarry"));

        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7Place this next to an area"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&bordered with redstone torches"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&and a chest"));

        itemMeta.setLore(lore);

        item.setItemMeta(itemMeta);

        player.getInventory().addItem(item);


    }


}
