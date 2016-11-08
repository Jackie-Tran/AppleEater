/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.jm.gameState;

import ca.jm.main.Game;
import ca.jm.main.Screen;
import java.awt.Graphics2D;

/**
 *
 * @author Jack Jack Attack
 */
public abstract class GameState {
    
    
    public GameState(GameStateManager gsm) {
        
    }
    
    protected abstract void init();
    protected abstract void tick();
    
    protected abstract void render(Graphics2D g, Screen screen);
    
}
