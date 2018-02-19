package io.github.pedrokase;


public class RoleplayUtils {

    //TODO Either add exception here or on player's method to deny '0' sided dice or dice numbers
    public static int rollDice(int diceSides, int diceNumber){
        return (int) ( (Math.random()*diceSides) + 1 )*diceNumber;
    }


}
