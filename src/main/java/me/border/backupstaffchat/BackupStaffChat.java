package me.border.backupstaffchat;

import me.border.backupstaffchat.commands.BackupStaffChatCommand;
import me.border.backupstaffchat.commands.ToggleStaffChatCommand;
import me.border.backupstaffchat.listeners.PlayerHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class BackupStaffChat extends JavaPlugin {

    public static boolean toggle = false;

    private static BackupStaffChat instance;

    public static BackupStaffChat getInstance(){
        return instance;
    }

    @Override
    public void onEnable() {
        instance = this;
        getCommand("backupstaffchat").setExecutor(new BackupStaffChatCommand());
        getCommand("togglestaffchat").setExecutor(new ToggleStaffChatCommand());
        registerHandler(new PlayerHandler());
    }

    public void registerHandler(Listener listener){
        getServer().getPluginManager().registerEvents(listener, this);
    }
}
