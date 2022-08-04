package com.intech.animation;

import javax.swing.*;
import java.awt.*;


import static java.lang.Thread.*;

/**
 * User : Tanvir Ahmed
 * Date: 08/04/2022.
 */


public class Animation extends JComponent {

    private int x=0;
    private int y=100;
    private int width=100;
    private int height=50;
    private  int moveStepSize=10;

     int max_x,max_y;



    public Animation(int w,int h){
        this.max_x=w;
        this.max_y=h;
    }

    @Override
    public void paint(Graphics gr){
        super.paint(gr);

        gr.setColor(Color.BLACK);
        gr.drawRect(x,y,width,height);


    }

    public void animate() {
        if(x+width>max_x || x< 0){
            moveStepSize =- moveStepSize;
        }
        x= x+moveStepSize;

        try {
            sleep(40);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        repaint();
    }
}
