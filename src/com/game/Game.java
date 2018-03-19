package com.game;
import com.player.*;

import java.util.Scanner;

public class Game {
    Player p1, p2;
    public void start() {
        Scanner input = new Scanner(System.in);
        System.out.println("-- RoShamBo --");
        int selection = 0;
        while (selection != 4) {
        System.out.println(
              "Welcome to the challenge! Select an option: \n" +
                "  1) Player vs. Player\n" +
                "  2) Player vs. Computer\n" +
                "  3) Hall Of Fame\n" +
                "  4) Exit\n "
            );
            selection = input.nextInt();
            input.nextLine();
        switch (selection) {
            case 1:
                this.pvp();
                break;
            case 2:
                this.pvc();
                break;
            case 3:
                this.readScore();
                break;
            case 4:
                this.exit();
                break;
            default:
                System.out.println("Please try again - wisely");
                break;
        }
        }
    }

    private void exit() {
        System.out.println("Let's stop for now.\n\n");
    }

    private void pvc() {
        System.out.println("We'll need a single person to give their name.");
        setupPlayers(true);
        System.out.printf("%s and %s are our players\n\n", p1.name, p2.name);
        startGame();
    }

    private void pvp() {
        System.out.println("Two contestants enter the ring...");
        setupPlayers(false);
        System.out.printf("%s and %s are our players\n\n", p1.name, p2.name);
        startGame();
    }
    private void setupPlayers(boolean compPlayer) {
        p1 = new HumanPlayer();
        p1.setName();
        if (compPlayer) {
            p2 = new ComputerPlayer();
            p2.setName();
        } else {
            p2 = new HumanPlayer();
            p2.setName();
        }
    }
    private void startGame() {
        int option = 0;
        Scanner input = new Scanner(System.in);
        while (option !=3){
            System.out.println(
                    "Type a number to select an option: \n" +
                            "  1) Play ROSHAMBO\n" +
                            "  2) Check Score\n" +
                            "  3) Return to Menu\n "
            );
            option = input.nextInt();
            input.nextLine();
            switch (option) {
                case 1:
                    newGame();
                    break;
                case 2:
                    readScore();
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Please try again - wisely.  I mean how hard is it to choose 1, 2 or 3?");
                    break;
            }
        }
    }

    private void readScore() {
        try {
            System.out.printf("%s's score is %s with a current winning streak of %s.\n" +
                            "%s's score is %s with a current winning streak of %s.\n\n",
                    p1.name, p1.gamesWon, p1.winningStreak, p2.name, p2.gamesWon, p2.winningStreak);
        } catch (NullPointerException npe) {
            System.out.println("No players have been set.");
        }
    }

    private void newGame() {
        String p1Prompt = p1.name + " please enter (R)ock, (P)aper, or (S)cissors";
        String p2Prompt = p2.name + " please enter (R)ock, (P)aper, or (S)cissors";
        String p1Move = movePrompt(p1, p1Prompt);
        String p2Move = movePrompt(p2, p2Prompt);
        if (p1Move == p2Move){
            System.out.printf("Both Players chose %s! - THAT'S A TIE!!  NO WINNER\n\n", p1Move);
        } else if((p1Move.equals("Rock")&& p2Move.equals("Scissors"))
                ||(p1Move.equals("Scissors")&&p2Move.equals("Paper"))
                ||(p1Move.equals("Paper")&&p2Move.equals("Rock"))){
            System.out.printf("%s's %s beats %s's %s\n\n", p1.name, p1Move, p2.name, p2Move);
            p1.setWinner(true);
            p2.setWinner(false);
        } else {
            System.out.printf("%s's %s beats %s's %s\n\n", p2.name, p2Move, p1.name, p1Move);
            p1.setWinner(false);
            p2.setWinner(true);
        }
    }

    private String movePrompt(Player p, String prompt) {
        Boolean validInput = true;
        String result = "";
        while(validInput) {
            result = p.askForMove(prompt);
            result = result.substring(0,1).toUpperCase();
            if(result.equals("R") || result.equals("P") || result.equals("S")){
                validInput = false;
                System.out.printf("%s has made their move.\n\n", p.name);
            } else {
                System.out.println("Oopsie - what was that?? Well no worries, but if you cant spell Rock Paper or Scissors you can just choose R, P, or S!");
            }
        }
        switch (result) {
            case "R":
            result = "Rock";
            break;
            case "P":
            result = "Paper";
            break;
            case "S":
            result = "Scissors";
            break;
        }
        return result;
    }
}
