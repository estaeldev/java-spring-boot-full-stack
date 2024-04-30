package com.in28minutes.learnspringframework;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.in28minutes.learnspringframework.game.GameRunner;
import com.in28minutes.learnspringframework.game.GamingConsole;
import com.in28minutes.learnspringframework.game.PacManGama;

@Configuration
public class GamingConfiguration {

    @Bean
    GamingConsole game() {
        return new PacManGama();
    }

    @Bean
    GameRunner gameRunner(GamingConsole game) {
        return new GameRunner(game);
    }

    

    
}
