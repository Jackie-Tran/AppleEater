/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.jm.gameObject;

import ca.jm.main.KeyInput;
import ca.jm.main.Screen;

/**
 *
 * @author Jack Jack Attack
 */
public abstract class GameObject {
    
    protected int x,y, width = 64, height = 64;
    protected ObjectId id;
    protected KeyInput key;
    
    public GameObject(int x, int y, KeyInput key, ObjectId id) {
        this.x = x;
        this.y = y;
        this.key = key;
        this.id = id;
    }
    
    public GameObject(int x, int y, ObjectId id) {
        this.x = x;
        this.y = y;
        this.id = id;
    }
    
    public abstract void tick();
    
    public abstract void render(java.awt.Graphics2D g);
    public abstract void renderPixels(Screen screen);
    
}
