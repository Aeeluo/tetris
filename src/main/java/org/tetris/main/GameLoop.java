package org.tetris.main;

import javax.swing.*;
import java.awt.*;

public class GameLoop extends JPanel implements Runnable {


    // SCREEN SETTINGS
    private int screenWidth = 1920;
    private int screenHeight = 1080;

    // FPS
    private int targetFPS = 144;

    // SYSTEM
    private Thread thread;
    public GameLoop() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.setFocusable(true);
    }

    public void setupGame(){
        // TODO
    }

    public void startThread(){
        this.thread = new Thread(this);
        this.thread.start();
    }

    @Override
    public void run() {
        long lastIterationTime = System.nanoTime();
        long drawInterval = 1000000000 / this.targetFPS;
        long now;
        long delta = 0;

        int timer = 0;
        int drawCount = 0;

        while(this.thread != null) {
            now = System.nanoTime();

            delta += (now - lastIterationTime) / drawInterval;
            timer += (now - lastIterationTime);
            lastIterationTime = now;

            if(delta >= 1) {
                update();
                draw();
                drawCount ++;
                delta --;
                if(timer >= 1000000000){
                    drawCount = 0;
                    timer = 0;
                }
            }

        }
    }

    public void update(){
        System.out.println("Update!");
    }

    public void draw(){
        System.out.println("Draw!");
    }
}
