package io.github.pedrokase;

import java.util.List;
import java.util.Random;


public class RoleplayUtils {

    private final int DEFAULT_DICE_SIDES = 6,
                      DEFAULT_DICE_NUMBER = 1;


    public int rollDice(){
        return rollDice(DEFAULT_DICE_SIDES, DEFAULT_DICE_NUMBER);
    }

    public int rollDice(int diceSides){
        return rollDice(diceSides, DEFAULT_DICE_NUMBER);
    }

    //TODO Either add exception here or on player's method to deny '0' sided dice or dice numbers
    public static int rollDice(int diceSides, int diceNumber){
        return (int) ( (Math.random()*diceSides) + 1 )*diceNumber;
    }


}
