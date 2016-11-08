/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.jm.main;

import java.util.Random;

/**
 *
 * @author Jack Jack Attack
 */
public class Screen {

    public int pixels[];
    private int tiles[] = new int[64 * 64];//64*64 tiles in the map
    public int width, height;
    private Random random = new Random();

    public Screen(int width, int height) {
        this.width = width;
        this.height = height;
        pixels = new int[width * height];
        for (int i = 0; i < 64 * 64; i++) {//goes through all the tiles and sets the colour
            tiles[i] = random.nextInt(0xffffff);
        }
    }

    public void clear() {
        for (int i = 0; i < pixels.length; i++) {
            pixels[i] = 0;
        }
    }

    public void render() {
        for (int y = 0; y < height; y++) {
            //if (y < 0 || y >= height) break;
            for (int x = 0; x < width; x++) {
                //if (x < 0 || x >= width) break;
                int tilesIndex = (x / 32) + (y / 32) * 64;
                //pixels[x + y * width] = tiles[tilesIndex];
            }
        }
    }

}
