/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.jm.gameState;

import ca.jm.main.Game;
import java.awt.Graphics2D;

/**
 *
 * @author Jack Jack Attack
 */
public class GameStateManager {

    public Game game;
    private int currentState;
    private GameState gameStates[];

    private final int NUM_STATES = 3;
    //Gamestate ID's
    public final int TEST_STATE = 0;

    public GameStateManager(Game game) {
        this.game = game;
        gameStates = new GameState[NUM_STATES];
        currentState = TEST_STATE;
        setState(currentState);
    }

    public void loadState(int state) { // Loads the state
        if (state == TEST_STATE) {
            gameStates[state] = new TestState(this);
        }
    }

    public void unloadState(int state) {
        gameStates[state] = null;
    }

    public void setState(int state) {
        /*
         int previousState = currentState;
         loadState(state);
         currentState = state;
         unloadState(previousState);
         gameStates[currentState].init();*/
        unloadState(currentState);
        currentState = state;
        loadState(currentState);
        gameStates[currentState].init();
    }

    public void tick() {
        gameStates[currentState].tick();
    }

    public void render(Graphics2D g) {
        gameStates[currentState].render(g, game.screen);
    }

}
