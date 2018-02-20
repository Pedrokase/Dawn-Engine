package io.github.pedrokase.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Countdown implements CommandExecutor {

    private final JavaPlugin plugin;

    public Countdown(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        int count;

        try {
            if(strings.length >= 1){
                //TODO Add exception for numbers bellow 1
                count = Integer.parseInt(strings[0]);
            }else count = 10;

            //TODO Send to those around once a custom chat plugin is enabled
            commandSender.sendMessage(ChatColor.RED + commandSender.getName() + " has started a countdown from " + count + "!");

            new BukkitRunnable() {
                //TODO Disallow players from creating multiple countdowns while theirs is still going
                int descendingCountdown = count;
                @Override
                public void run() {
                    if(descendingCountdown>=0){
                        commandSender.sendMessage(ChatColor.GOLD+"COUNTDOWN: " + descendingCountdown--);
                    }else this.cancel();
                }
            }.runTaskTimer(plugin, 0, 20);

            return true;

        }catch (NumberFormatException e){
            commandSender.sendMessage(ChatColor.RED + "Please insert a valid number!");
            return false;
        }
    }
}
