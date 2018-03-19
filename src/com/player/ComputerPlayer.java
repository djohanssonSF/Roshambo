package com.player;

import java.util.concurrent.ThreadLocalRandom;

public class ComputerPlayer extends Player{
    public String askForMove(String prompt){
        int randomNum = ThreadLocalRandom.current().nextInt(1, 4);
        switch (randomNum) {
            case 1:
                return "R";
            case 2:
                return "P";
            default:
                return "S";
        }
    }
    public void setName(){
        name = "Computer";
    }
}
