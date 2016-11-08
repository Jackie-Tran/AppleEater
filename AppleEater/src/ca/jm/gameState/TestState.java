/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.jm.gameState;

import ca.jm.gameObject.Handler;
import ca.jm.gameObject.ObjectId;
import ca.jm.gameObject.Player;
import ca.jm.main.Screen;
import java.awt.Color;
import java.awt.Graphics2D;

/**
 *
 * @author Jack Jack Attack
 */
public class TestState extends GameState{

    private Handler handler;
    
    public TestState(GameStateManager gsm) {
        super(gsm);
        handler = new Handler();
        handler.addObject(new Player(100, 100, gsm.game.key, ObjectId.player));
    }

    protected void init() {
    }

    protected void tick() {
        handler.tick();
    }

    protected void render(Graphics2D g, Screen screen) {
        handler.render(g);
    }
    
}
