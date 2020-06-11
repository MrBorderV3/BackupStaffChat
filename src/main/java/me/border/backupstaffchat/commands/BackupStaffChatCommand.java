package me.border.backupstaffchat.commands;

import me.border.backupstaffchat.BackupStaffChat;
import static me.border.backupstaffchat.utils.Utils.*;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class BackupStaffChatCommand implements CommandExecutor {

    public static List<UUID> staffChat = new ArrayList<>();

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!playerCheck(sender)) return true;
        if (!permCheck(sender, "backupstaffchat.use")) return true;
        if (!BackupStaffChat.toggle) {
            sender.sendMessage(chat("&cBackup Staff Chat is toggled off!"));
            return true;
        }
        Player p = (Player) sender;
        UUID uuid = p.getUniqueId();
        if (args.length == 0 && staffChat.contains(uuid)) {
            staffChat.remove(uuid);
            p.sendMessage(chat("&6[&7&lSC&6] &7You have left staff chat."));
        } else if (args.length == 0 && !staffChat.contains(uuid)) {
            staffChat.add(uuid);
            p.sendMessage(chat("&6[&7&lSC&6] &7You have entered staff chat."));
        } else {
            StringBuilder message = new StringBuilder(chat("&4[&eSTAFF&4]&5<&a" + p.getName() + "&5>&6 "));
            for (String s : args) {
                message.append(s).append(" ");
            }
            for (Player all : Bukkit.getOnlinePlayers()) {
                if (all.hasPermission("backupstaffchat.use")) {
                    all.sendMessage(chat(message.toString()));
                }
            }
        }

        return false;
    }
}
