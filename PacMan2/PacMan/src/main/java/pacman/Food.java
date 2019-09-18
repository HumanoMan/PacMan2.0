/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacman;

import java.awt.Color;
import java.awt.Graphics;
/**
 *
 * @author desenv
 */
public class Food extends Piece{
    public boolean eatend =  false;
    public void eaten(){
        eatend = true;
    }
    public Food(){
        color = new Color(255, 200, 200);
        width = 15;
        height = 10;
    }
    public void draw(Graphics g){
        if (!eatend) {
        g.setColor(this.color);
        g.fillRect(x, y, width, height);    
        }
    }
}
