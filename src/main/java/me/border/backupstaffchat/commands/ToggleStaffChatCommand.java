package me.border.backupstaffchat.commands;

import me.border.backupstaffchat.BackupStaffChat;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import static me.border.backupstaffchat.utils.Utils.*;

public class ToggleStaffChatCommand implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(!permCheck(sender, "backupstaffchat.toggle")) return false;
        if (BackupStaffChat.toggle){
            BackupStaffChat.toggle = false;
            BackupStaffChatCommand.staffChat.clear();
            sender.sendMessage(chat("&cBackup Staff Chat toggled off!"));
        } else {
            BackupStaffChat.toggle = true;
            sender.sendMessage(chat("&aBackup Staff Chat toggled on!"));
        }
        return false;
    }
}
