package io.github.pedrokase.Commands;

import io.github.pedrokase.RoleplayUtils;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class RollDice implements CommandExecutor {

    private final int DEFAULT_DICE_SIDES = 6,
                      DEFAULT_DICE_AMOUNT = 1;

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String alias, String[] args) {

        int diceSides, diceAmount;

        if(args.length >= 1) {
            diceSides = args[0] != null ? Integer.parseInt(args[0]) : DEFAULT_DICE_SIDES;
            diceAmount = args[1] != null ? Integer.parseInt(args[1]) : DEFAULT_DICE_AMOUNT;
        }
        else {
            diceSides  = DEFAULT_DICE_SIDES;
            diceAmount = DEFAULT_DICE_AMOUNT;
        }

        sender.sendMessage(ChatColor.GOLD
                + "You throw a " + diceSides
                + " sided dice " + diceAmount
                + " times and rolled a " + RoleplayUtils.rollDice(diceSides, diceAmount));

        return true;
    }
}
