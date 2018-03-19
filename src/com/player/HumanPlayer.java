package com.player;

import java.util.Scanner;

public class HumanPlayer extends Player{
    public String askForMove(String prompt){
        String move;
        Scanner input = new Scanner(System.in);
        System.out.println(prompt);
        move = input.nextLine();
        return move;
    }
}
