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

        //TODO Add exception for when sender inserts '0' as a number
        //TODO Add modifiers for powerful players or cheating ones
        //TODO Add way to re-roll your throw with user prompt

        try {

            if (args.length == 1) {
                diceSides = Integer.parseInt(args[0]);
                diceAmount = DEFAULT_DICE_AMOUNT;
            } else if (args.length >= 2) {
                diceSides = Integer.parseInt(args[0]);
                diceAmount = Integer.parseInt(args[1]);
            } else {
                diceSides = DEFAULT_DICE_SIDES;
                diceAmount = DEFAULT_DICE_AMOUNT;
            }

            StringBuilder sb = new StringBuilder();

            sb.append("You throw a ").append(diceSides).append(" sided dice");
            sb.append(diceAmount == 1 ? " once ":(diceAmount+" times ") );
            sb.append("and rolled a ").append(RoleplayUtils.rollDice(diceSides,diceAmount));

            sender.sendMessage(ChatColor.GOLD + sb.toString());

            return true;

        }catch (NumberFormatException e){
            sender.sendMessage(ChatColor.RED + "Please insert a valid number!");
            return false;
        }



    }
}
