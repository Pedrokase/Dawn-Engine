package io.github.pedrokase.Commands;

import io.github.pedrokase.Dice;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class RollDice implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String alias, String[] args) {

        Dice dice;

        //TODO Add modifiers for powerful players or cheating ones
        //TODO Add way to re-roll your throw with user prompt

        try {

            if (args.length == 1) {
                dice = new Dice(Integer.parseInt(args[0]));
            } else if (args.length >= 2) {
                dice = new Dice(
                        Integer.parseInt(args[0]),
                        Integer.parseInt(args[1])
                );
            } else {
                dice = new Dice();
            }

            StringBuilder sb = new StringBuilder();

            sb
                    .append("You throw a ").append(dice.getSides()).append(" sided dice")
                    .append(dice.getNumber() == 1 ? " once ":(dice.getNumber()+" times ") )
                    .append("and rolled a ").append(dice.roll() );

            sender.sendMessage(ChatColor.GOLD + sb.toString());

            return true;

        }catch (NumberFormatException e){
            sender.sendMessage(ChatColor.RED + "Please insert a valid number!");
            return false;
        }



    }
}
