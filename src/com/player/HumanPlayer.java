package com.player;

import java.util.Scanner;

public class HumanPlayer extends Player{
    public String askForMove(String prompt){
        String move;
        Scanner input = new Scanner(System.in);
        System.out.println(prompt);
        move = input.nextLine();
        if (move.length()==0){
            move = "invalid";
            System.out.println("No move entered.");
        }
        return move;
    }
}
