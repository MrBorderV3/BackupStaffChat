package me.border.backupstaffchat.listeners;

import me.border.backupstaffchat.BackupStaffChat;
import me.border.backupstaffchat.commands.BackupStaffChatCommand;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.UUID;

import static me.border.backupstaffchat.utils.Utils.chat;

public class PlayerHandler implements Listener {

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e){
        if (!BackupStaffChat.toggle) return;
        Player p = e.getPlayer();
        UUID uuid = p.getUniqueId();
        if (BackupStaffChatCommand.staffChat.contains(uuid)){
            e.setCancelled(true);
            String message = e.getMessage();
            String kicker = chat("&4[&eSTAFF&4]&5<&a" + p.getName() + "&5>&6 ");
            for (Player all : Bukkit.getOnlinePlayers()) {
                if (all.hasPermission("backupstaffchat.use")) {
                    all.sendMessage(kicker + message);
                }
            }
        }
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e){
        UUID uuid = e.getPlayer().getUniqueId();
        BackupStaffChatCommand.staffChat.remove(uuid);
    }
}
