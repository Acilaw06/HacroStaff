package fr.acilaw.hacrostaff.Punish;

import fr.acilaw.hacrostaff.ItemBuilder.GetItem;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class PunishGui extends GetItem implements CommandExecutor {

    public static String punishedPlayer;
    public static String duration;
    public static String sanctionType;
    public static String motif;

    public PunishGui(){
        punishedPlayer = "";
        duration = "";
        sanctionType = "";
        motif = "";
    }



    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if(!(commandSender instanceof Player)) {
            commandSender.sendMessage("§cSeul un joueur peut faire cette commande !");
            return true;
        }

        if(!(commandSender.hasPermission("group.moderateur"))){
            commandSender.sendMessage("§8[§eCrom§6Chat§8] §cTu n'as pas la permission de faire cette commande.");
        }

        if(args.length == 0 || Bukkit.getPlayer(args[0]) == null){
            commandSender.sendMessage("§8[§eCrom§6Chat§8] §cTu dois choisir un joueur.");
            return true;
        }

        Player player = (Player) commandSender;
        punishedPlayer = Bukkit.getPlayer(args[0]).getName();

        player.openInventory(punishGui(player));

        return true;
    }

    public Inventory punishGui(Player player){
        Inventory inv = Bukkit.createInventory(player, 54, "§cPunish Menu");

        // Duration Item
        // Cheats Sanction Item
        inv.setItem(19, getItem(new ItemStack(Material.IRON_FENCE), "§cBannissement", "§c", "§7▪ §eClique pour §achoisir la durée", "§eapproprié à la §asanction.", "§c"));
        inv.setItem(20, getItem(new ItemStack(Material.PAPER), "§cMute", "§c", "§7▪ §eClique pour §achoisir la durée", "§eapproprié à la §asanction.", "§c"));
        inv.setItem(21, getItem(new ItemStack(Material.BARRIER), "§cAvertissement", "§c", "§7▪ §eClique pour §asanctionner", "§ele joueur immédiatement", "§c"));


        inv.setItem(0,getItem(new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)14), " ", ""));
        inv.setItem(1,getItem(new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)14), " ", ""));
        inv.setItem(7,getItem(new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)14), " ", ""));
        inv.setItem(8,getItem(new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)14), " ", ""));
        inv.setItem(9,getItem(new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)14), " ", ""));
        inv.setItem(17,getItem(new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)14), " ", ""));
        inv.setItem(36,getItem(new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)14), " ", ""));
        inv.setItem(44,getItem(new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)14), " ", ""));
        inv.setItem(45,getItem(new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)14), " ", ""));
        inv.setItem(46,getItem(new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)14), " ", ""));
        inv.setItem(52,getItem(new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)14), " ", ""));
        inv.setItem(53,getItem(new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)14), " ", ""));


        return inv;
    }

    public void executeCommand(Player player){

        player.getServer().dispatchCommand(player, sanctionType + " " + punishedPlayer + " " + duration + " " + motif);
    }

}