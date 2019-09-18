/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacman;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author desenv
 */
public class Pac extends PieceMove{
    public int score;
    public int lives;
    private int d = 1;
    public int dir = 30;
    public int dir1 = 300;
    public Color OlhoCor = new Color(85,0,231);
    public boolean olho = true;
    public boolean pacx = false, pacy = false;
    public long timeBoost;
    
    public Pac(){
        height = 25;
        width = 25;
        color = new Color(245, 225, 50);
        x = 385;
        y = 305;
        this.velx = 0;
        this.vely = 0;
        this.lives = 3;
        this.sprite = 3;
    }
    
    public void eat(Food food){
    }
    public void eat(Ghost ghost){
    }
    public void eat(Boost boost){
    }
    public void draw(Graphics g){
        if ((System.currentTimeMillis() - timeBoost)>10000) {
            timeBoost = 0;
        }
        if (timeBoost > 0) { // Animação do Pac Matador
            if (sprite == 1) {
                OlhoCor = Color.BLACK;
                this.color = Color.RED;
            }
            else if (sprite == 2) {
                OlhoCor = Color.RED;
                this.color = Color.DARK_GRAY;
            }
            else if (sprite == 3) {
                OlhoCor = Color.BLACK;
                this.color = Color.RED;
            }
            else{
                OlhoCor = Color.CYAN;
                this.color = Color.DARK_GRAY;
            }
        }
        else{
        this.color = new Color(245, 225, 50);
        OlhoCor = new Color(85,0,231);
        }
        if (velx == 0 && vely == 0) {
            g.setColor(this.color);
            g.fillArc(x, y, width, height, dir, dir1);
            if (olho == true) {
            g.setColor(this.OlhoCor);
            g.fillOval(x+((height/2)-height/30), y+((width/6)-width/30), width/5, width/5);    
            }
            else{
            g.setColor(this.OlhoCor);
            g.fillOval(x+((width/6)-width/30), y+((height/2)-height/30), width/5, width/5);
            }
        }
        else if (velx > 0) {    // Movimentação para a Direita
            if (this.sprite == 1) {// 1º Sprite
            // Pac boca aberta
            g.setColor(this.color);
            g.fillArc(x, y, width, height, 30, 300);
            //Olho
            g.setColor(this.OlhoCor);
            g.fillOval(x+((height/2)-height/30), y+((width/6)-width/30), width/5, width/5);
            }
            else if (this.sprite == 2) { // 2º Sprite
            // Pac boca semi fechada
            g.setColor(this.color);
            g.fillArc(x, y, width, height, 20, 310);    
            //Olho
            g.setColor(this.OlhoCor);
            g.fillOval(x+((height/2)-height/30), y+((width/6)-width/30), width/5, width/5);
            }
            else {// 3º Sprite
            // Pac boca fechada
            g.setColor(this.color);
            g.fillArc(x, y, width, height, 0, 360);    
            //Olho
            g.setColor(this.OlhoCor);
            g.fillOval(x+((height/2)-height/30), y+((width/6)-width/30), width/5, width/5);
            }
        }
        else if (velx < 0) {    // Movimentação para a Esquerda
            if (this.sprite == 1) {// 1º Sprite
            // Pac boca aberta
            g.setColor(this.color);
            g.fillArc(x, y, width, height, 210, 300);
            //Olho
            g.setColor(this.OlhoCor);
            g.fillOval(x+((height/2)-height/30), y+((width/6)-width/30), width/5, width/5);
            }
            else if (this.sprite == 2) { // 2º Sprite
            // Pac boca semi fechada
            g.setColor(this.color);
            g.fillArc(x, y, width, height, 200, 310);    
            //Olho
            g.setColor(this.OlhoCor);
            g.fillOval(x+((height/2)-height/30), y+((width/6)-width/30), width/5, width/5);
            }
            else {// 3º Sprite
            // Pac boca fechada
            g.setColor(this.color);
            g.fillArc(x, y, width, height, 0, 360);    
            //Olho
            g.setColor(this.OlhoCor);
            g.fillOval(x+((height/2)-height/30), y+((width/6)-width/30), width/5, width/5);
            }
        }
        else if (vely > 0) {    // Movimentação para Baixo
            if (this.sprite == 1) {// 1º Sprite
            // Pac boca aberta
            g.setColor(this.color);
            g.fillArc(x, y, width, height, 305, 295);
            //Olho
            g.setColor(this.OlhoCor);
            g.fillOval(x+((width/6)-width/30), y+((height/2)-height/30), width/5, width/5);
            }
            else if (this.sprite == 2) { // 2º Sprite
            // Pac boca semi fechada
            g.setColor(this.color);
            g.fillArc(x, y, width, height, 295, 305);    
            //Olho
            g.setColor(this.OlhoCor);
            g.fillOval(x+((width/6)-width/30), y+((height/2)-height/30), width/5, width/5);
            }
            else {// 3º Sprite
            // Pac boca fechada
            g.setColor(this.color);
            g.fillArc(x, y, width, height, 0, 360);    
            //Olho
            g.setColor(this.OlhoCor);
            g.fillOval(x+((width/6)-width/30), y+((height/2)-height/30), width/5, width/5);
            }
        }
        else if (vely < 0) {    // Movimentação para Cima
            if (this.sprite == 1) {// 1º Sprite
            // Pac boca aberta
            g.setColor(this.color);
            g.fillArc(x, y, width, height, 120,300);
            //Olho
            g.setColor(this.OlhoCor);
            g.fillOval(x+((width/6)-width/30), y+((height/2)-height/30), width/5, width/5);
            }
            else if (this.sprite == 2) { // 2º Sprite
            // Pac boca semi fechada
            g.setColor(this.color);
            g.fillArc(x, y, width, height, 110, 320);    
            //Olho
            g.setColor(this.OlhoCor);
            g.fillOval(x+((width/6)-width/30), y+((height/2)-height/30), width/5, width/5);
            }
            else {// 3º Sprite
            // Pac boca fechada
            g.setColor(this.color);
            g.fillArc(x, y, width, height, 0, 360);    
            //Olho
            g.setColor(this.OlhoCor);
            g.fillOval(x+((width/6)-width/30), y+((height/2)-height/30), width/5, width/5);
            }
        }
            this.d++;
            if (d > 1) { // Cria efeito de animação trocando os sprites
                if (this.sprite == 1) {
                    this.sprite = 2;
                }else if (this.sprite == 2) {
                    this.sprite = 3;
                }else if (this.sprite == 3){
                    this.sprite = 1;
                }
                d = 0;
            }
        }
    
    public void move(){ // Método de movimento e direção do Pac
        this.x= this.x+ this.velx;
        this.y= this.y+ this.vely;
    }
    
    public Collide collide(Block b){ // Método de colisão do Pac
        Collide c = new Collide();
        
        for (int i = 0; i < 2; i++) { // For da colisão do pac e do block
           int p1x, p1y, p2x, p2y, p3x, p3y, p4x, p4y;
           int b1x, b1y, b2x, b2y, b3x, b3y, b4x, b4y;
        // Pontos de colisão do Pac
            if (i == 0) { // Colisão do Pac em Relação aos Blocks
        // Pontos de colisão do Pac
        p1x = this.x;// Canto superior esquerdo
        p1y = this.y;
        
        p2x = this.x + this.width;// Canto superior direito
        p2y = this.y;
        
        p3x = this.x + this.width;// Canto inferior direito
        p3y = this.y + this.height;
        
        p4x = this.x; // Canto inferior esquerdo
        p4y = this.y + this.height;
        
        // Pontos de colisão do(s) bloco(s)
        b1x = b.x;// Canto superior esquerdo
        b1y = b.y;
        
        b2x = b.x + b.width; // canto superior direito
        b2y = b.y; 
        
        b3x = b.x + b.width;// Canto inferior direito
        b3y = b.y + b.height;
       
        b4x = b.x;// Canto inferior esquerdo
        b4y = b.y + b.height;
        
        // Calculo de distancia entre os blocos
        int d1x = p1x - b2x; // Distancia (X) do P1x até o B2x
        int d1y = p1y - b4y; // e etc... \_(º-º)_/
        int d2x = b1x - p2x;
        int d2y = p2y - b3y;
        int d3x = b4x - p3x;
        int d3y = b2y - p3y;
        int d4x = p4x - b3x;
        int d4y = b2y - p4y;
        
        // Pac ponto 1 (X,Y) Canto superior esquerdo
        if (p1x >= b1x && p1x <= b2x) {
            if (p1y >= b1y && p1y <= b4y) {
                if (velx == -5) {   // Ponto1 X
                this.x = x - d1x + 5;
                this.velx = 0;
                this.pacx = true;
                }
                 if (vely == -5) {  // Ponto1 Y
                this.y = y - d1y + 5;
                this.vely = 0;
                this.pacy = true;
                }
            }
        }
        
        // Pac ponto 2 (X,Y) Canto superior direito
        if (p2x >= b1x && p2x <= b2x) {
            if (p2y >= b1y && p2y <= b4y) {
                if (velx == 5) {    // Ponto2 X
                this.x = x + d2x - 5;
                this.velx = 0;
                this.pacx = true;
                }
                 if (vely == -5) {  // Ponto2 Y
                this.y = y - d2y + 5;
                this.vely = 0;
                this.pacy = true;
                }
            }
        }
        // Pac ponto 3 (X,Y) Canto inferior direito
         if (p3x >= b1x && p3x <= b2x) {
            if (p3y >= b1y && p3y <= b4y) {
                if (velx == 5) {    // Ponto3 X
                this.x = x + d3x - 5;
                this.velx = 0;
                this.pacx = true;
                }
                 if (vely == 5) {   // Ponto3 Y
                this.y = y + d3y - 5;
                this.vely = 0;
                this.pacy = true;
                }
            }
        }
         // Pac ponto 4 (X,Y) Canto inferior esquerdo
         if (p4x >= b1x && p4x <= b2x) {
            if (p4y >= b1y && p4y <= b4y) {
                if (velx == -5) {   // Ponto4 X
                this.x = x - d4x + 5;
                this.velx = 0;
                this.pacx = true;
                }
                 if (vely == 5) {   // Ponto4 Y
                this.y = y + d4y - 5;
                this.vely = 0;
                this.pacy = true;
                }
            }
        }
    }
            else{ // Colisão dos Blocks em relção ao Pac
            
        b1x = this.x;// Canto superior esquerdo
        b1y = this.y;
        
        b2x = this.x + this.width;// Canto superior direito
        b2y = this.y;
        
        b3x = this.x + this.width;// Canto inferior direito
        b3y = this.y + this.height;
        
        b4x = this.x; // Canto inferior esquerdo
        b4y = this.y + this.height;
        
        // Pontos de colisão do(s) bloco(s)
        p1x = b.x;// Canto superior esquerdo
        p1y = b.y;
        
        p2x = b.x + b.width; // canto superior direito
        p2y = b.y; 
        
        p3x = b.x + b.width;// Canto inferior direito
        p3y = b.y + b.height;
       
        p4x = b.x;// Canto inferior esquerdo
        p4y = b.y + b.height;
        
        // Calculo de distancia entre os blocos
        int d1x = b2x - p1x; // Distancia (X) do P1x até o B2x
        int d1y = b4y - p1y; // e etc... \_(º-º)_/
        int d2x = p2x - b1x;
        int d2y = b3y - p2y;
        int d3x = p3x - b4x;
        int d3y = p3y - b2y;
        int d4x = b3x - p4x;
        int d4y = p4y - b2y;
        
        // Block ponto 1 (X,Y) Canto superior esquerdo
        if (p1x >= b1x && p1x <= b2x) {
            if (p1y >= b1y && p1y <= b4y) {
                if (velx == 5) {   // Ponto1 X
                this.x = x - d1x + 5;
                this.velx = 0;
                this.pacx = true;
                }
                 if (vely == 5) {  // Ponto1 Y
                this.y = y - d1y + 5;
                this.vely = 0;
                this.pacy = true;
                }
                 return c;
            }
        }
        // Block ponto 2 (X,Y) Canto superior direito
        if (p2x >= b1x && p2x <= b2x) {
            if (p2y >= b1y && p2y <= b4y) {
                if (velx == -5) {    // Ponto2 X
                this.x = x + d2x - 5;
                this.velx = 0;
                this.pacx = true;
                }
                 if (vely == 5) {  // Ponto2 Y
                this.y = y - d2y + 5;
                this.vely = 0;
                this.pacy = true;
                }
                 return c;
            }
        }
        // Block ponto 3 (X,Y) Canto inferior direito
         if (p3x >= b1x && p3x <= b2x) {
            if (p3y >= b1y && p3y <= b4y) {
                if (velx == -5) {    // Ponto3 X
                this.x = x + d3x - 5;
                this.velx = 0;
                this.pacx = true;
                }
                 if (vely == -5) {   // Ponto3 Y
                this.y = y + d3y - 5;
                this.vely = 0;
                this.pacy = true;
                }
                 return c;
            }
        }
         // Block ponto 4 (X,Y) Canto inferior esquerdo
         if (p4x >= b1x && p4x <= b2x) {
            if (p4y >= b1y && p4y <= b4y) {
                if (velx == 5) {   // Ponto4 X
                this.x = x - d4x + 5;
                this.velx = 0;
                this.pacx = true;
                }
                 if (vely == -5) {   // Ponto4 Y
                this.y = y + d4y - 5;
                this.vely = 0;
                this.pacy = true;
                }
                 return c;
                }
            }
        }
    }
    return c; // Retornando os valores
    }
    
    public Collide colliedeFood(Food food){
        Collide c = new Collide();
        if (food.eatend == false) {
            Rectangle Rpac = new Rectangle(x, y, width, height);
            
            int fx = food.x;
            int fy = food.y;
            Rectangle Rfood = new Rectangle(fx, fy, food.width, food.height);
            
            if (Rpac.intersects(Rfood)) {
                food.eaten();
                c.c = true;
                return c;
            }
        }
        return c;
    }
     
    public Collide colliedeBoost(Boost Boost){
        Collide c = new Collide();
        if (Boost.eatend == false) {
            Rectangle Rpac = new Rectangle(x, y, width, height);
            
            int fx = Boost.x;
            int fy = Boost.y;
            Rectangle Rfood = new Rectangle(fx, fy, Boost.width, Boost.height);
            
            if (Rpac.intersects(Rfood)) {
                Boost.eaten();
                c.c = true;
                return c;
            }
        }
        return c;
    }
    public void superPac(){
        timeBoost = System.currentTimeMillis();
    }
}
