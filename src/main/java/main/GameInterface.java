package main;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GameInterface {

    private BufferedImage gameInterface;

    public GameInterface() {
        try {
            this.gameInterface = ImageIO.read(getClass().getResourceAsStream("/interface/background.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g) {
        g.drawImage(this.gameInterface, 0, 0, null);
    }
}
