package com.player;

import java.util.Scanner;

public abstract class Player {
    public String name;
         abstract public String askForMove(String prompt);
         public int winningStreak = 0;
         public int gamesWon = 0;
         boolean winner = false;
         public void setName(){
             Scanner input = new Scanner(System.in);
             System.out.println("Enter name for player");
             name = input.nextLine();
         }
         public void setWinner(boolean result){
             winner = result;
             if (result){
                 winningStreak ++;
                 gamesWon++;
             } else {
                 winningStreak = 0;
             }
         }



}
