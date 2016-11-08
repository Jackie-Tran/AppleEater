/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.jm.gameObject;

import java.awt.Graphics2D;
import java.util.ArrayList;

/**
 *
 * @author Jack Jack Attack
 */
public class Handler {
    
    private ArrayList<GameObject> objectList = new ArrayList<>();
    
    public void tick() {
        for (int i = 0; i < objectList.size(); i++) {
            GameObject tempObject = objectList.get(i);
            tempObject.tick();
        }
    }
    
    public void render(Graphics2D g) {
        for (int i = 0; i < objectList.size(); i++) {
            GameObject tempObject = objectList.get(i);
            tempObject.render(g);
        }
    }
    
    public void addObject(GameObject object) {
        objectList.add(object);
    }
    
    public void removeObject(GameObject object) {
        objectList.remove(object);
    }
    
}
