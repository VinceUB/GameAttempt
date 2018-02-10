package io.github.vkb24312.gameAttempt.Executables;

import io.github.vkb24312.gameAttempt.Information.Information;

import javax.swing.*;
import java.awt.*;

public class Game extends JPanel{
    private static Information info;

    public void testRoom(Information info){
        Game.info = info;
        info.gameFrame.setVisible(true);
        info.gameFrame.add(new Game());
        info.gameFrame.setSize(300, 300);

        Game.info.user.x = 150;
        Game.info.user.y = 150;

        Game.info.gameFrame.setVisible(false);
        Game.info.gameFrame.setVisible(true);
        System.out.println("repaint");
    }

    @Override
    public void paint(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        while(Game.info==null){
            try{
                Thread.sleep(3);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        g2d.drawImage(info.user.currentSprite, info.user.x, info.user.y, null);
    }

    //TODO: Get the sprite to display on screen
}