package io.github.pedrokase;


import java.util.Random;

public class Dice {

    private int sides, number;
    private static Random random = new Random();

    //Default dices have 6 sides and are rolled once
    public Dice() {
        sides  = 6;
        number = 1;
    }

    public Dice(int sides){
        this(sides, 1);
    }

    public Dice(int sides, int number){
        this.sides  = (sides  == 0 ? 1 : sides);
        this.number = (number == 0 ? 6 : number);
    }


    public int roll(){
        //TODO Add +modifiers
        int sides  = getSides(),
            result = 0;

        for (int idx = 1; idx <= getNumber(); idx++) {
            result += (random.nextInt(sides)+1);
        }
        return result;

    }

    //===============================================

    public int getSides() {
        return sides;
    }

    public int getNumber() {
        return number;
    }

    //===============================================
}
