package io.github.pedrokase;


public class Dice {

    private int sides, number;

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
        return (int) ( (Math.random()*getSides()) + 1 )*getNumber();
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
