package me.erisos.erisostrash.command;

import me.erisos.erisostrash.ErisosTrash;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.eclipse.aether.util.listener.ChainedTransferListener;
import org.jetbrains.annotations.NotNull;

public class trashCommand implements CommandExecutor {

    private final ErisosTrash trashConfig;

    public trashCommand(ErisosTrash trashConfig) {
        this.trashConfig = trashConfig;
    }


    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {

        if(commandSender instanceof Player) {

            Player player = (Player) commandSender;

            if(player.hasPermission("trash.use")) {

                // --CONFIG--
                String prefix = ChatColor.translateAlternateColorCodes('&', trashConfig.getConfig().getString("prefix"));
                String open_message = ChatColor.translateAlternateColorCodes('&' , trashConfig.getConfig().getString("open_message"));
                String menu_name = ChatColor.translateAlternateColorCodes('&', trashConfig.getConfig().getString("menu_name"));

                int menu_size = trashConfig.getConfig().getInt("menu_size");
                // --CONFIG--

                Inventory trashMenu = Bukkit.createInventory(player, menu_size, menu_name);

                player.sendMessage(prefix + open_message);
                player.openInventory(trashMenu);
            }
            else {
                String perm_message = ChatColor.translateAlternateColorCodes('&', trashConfig.getConfig().getString("perm_message"));
                player.sendMessage(perm_message);
            }

        }

        return true;
    }
}