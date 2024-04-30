package com.in28minutes.learnspringframework.game;

import org.springframework.stereotype.Component;

@Component
public class PacManGama implements GamingConsole {
    
    @Override
    public void up() {
        System.out.println("Up - PacMan");
    }

    @Override
    public void down() {
        System.out.println("Down - PacMan");
    }

    @Override
    public void left() {
        System.out.println("Left - PacMan");
    }

    @Override
    public void right() {
        System.out.println("Right - PacMan");
    }
    


}
