package com.in28minutes.learnspringframework;

import com.in28minutes.learnspringframework.game.GameRunner;
import com.in28minutes.learnspringframework.game.PacManGama;

public class App01GamingBasicJava {
    

    public static void main(String[] args) {
        // MarioGame game = new MarioGame();
        // SuperContraGame game = new SuperContraGame();
        PacManGama game = new PacManGama();
        
        GameRunner gameRunner = new GameRunner(game);
        gameRunner.run();
    }


}
