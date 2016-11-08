/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.jm.gameObject;

import ca.jm.main.KeyInput;
import ca.jm.main.Screen;
import java.awt.Color;
import java.awt.Graphics2D;

/**
 *
 * @author Jack Jack Attack
 */
public class Player extends GameObject{

    private int velX = 0, velY = 0;
    public Player(int x, int y, KeyInput key, ObjectId id) {
        super(x, y, key, id);
    }

    private void movement() {
        if (key.up) {
            velX = 0;
            velY = -5;
        }
        
        if (key.down) {
            velX = 0;
            velY = 5;
        }
        
        if (key.left) {
            velX = -5;
            velY = 0;
        }
        
        if (key.right) {
            velX = 5;
            velY = 0;
        }
        
        x+= velX;
        y+= velY;
    }
    
    public void tick() {
        movement();
        if (x < 0) {
            x = 0;
            velX = 0;
        }
        
        if (x + width > 794) {
            x = 794 - width;
            velX = 0;
        }
        if (y < 0) {
            y = 0;
            velY = 0;
        }
        
        if (y + height > 571) {
            y = 571 - height;
            velY = 0;
        }
    }

    public void render(Graphics2D g) {
        g.setColor(Color.BLUE);
        g.fillRect(x, y, width, height);
    }

    public void renderPixels(Screen screen) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
