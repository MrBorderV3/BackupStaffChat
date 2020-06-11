package me.border.backupstaffchat.utils;

import me.border.backupstaffchat.BackupStaffChat;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Utils {
    private static BackupStaffChat plugin = BackupStaffChat.getInstance();

    public static String chat(String s) {
        return ChatColor.translateAlternateColorCodes('&', s);
    }

    public static boolean playerCheck(CommandSender sender){
        if (sender instanceof Player){
            return true;
        }
        sender.sendMessage(Utils.chat("&cYou may not execute this command"));
        return false;
    }

    public static boolean permCheck(CommandSender sender, String perm){
        if (sender.hasPermission(perm)){
            return true;
        }
        sender.sendMessage(Utils.chat("&cYou do not have permission to execute this command!"));
        return false;
    }
}
