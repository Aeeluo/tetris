package main;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

import static java.lang.System.nanoTime;

public class GameLoop extends JPanel implements Runnable {


    // SCREEN SETTINGS
    private final int originalTileSize = 32; // 16x16
    private final double scalar = 1.5;
    private final int tileSize = (int) (originalTileSize * scalar);

    private int maxScreenCol = 40;
    private int maxScreenRow = 22;

    private int screenWidth = tileSize * maxScreenCol; // 1920;
    private int screenHeight = tileSize * maxScreenRow; // 1080;

    // FPS
    private int targetFPS = 144;

    // SYSTEM
    private Thread thread;

    // INTERFACE AND OBJECTS
    public  GameInterface gameInterface = new GameInterface();

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
        long lastIterationTime = nanoTime();
        double drawInterval = 1000000000 / this.targetFPS;
        long now;
        double delta = 0;

        int timer = 0;
        int drawCount = 0;

        while(this.thread != null) {
            now = nanoTime();

            delta += (now - lastIterationTime) / drawInterval;
            timer += (now - lastIterationTime);
            lastIterationTime = now;

            if(delta >= 1) {
                update();
                repaint();
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
        // TODO
    }

    public void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        this.gameInterface.draw(g2);
    }
}
