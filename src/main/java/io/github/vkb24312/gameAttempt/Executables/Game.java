package io.github.vkb24312.gameAttempt.Executables;

import io.github.vkb24312.gameAttempt.Information.Information;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;

public class Game extends JPanel {
    private static Information info;

    public void testRoom(Information info) {
        Game.info = info;
        info.gameFrame.setVisible(true);
        info.gameFrame.add(this);
        info.gameFrame.setSize(300, 300);

        Game.info.user.x = 150;
        Game.info.user.y = 150;

        repaint();

        //<editor-fold desc="Keybinding">
        getInputMap().put(KeyStroke.getKeyStroke("UP"), "upArrowPress");
        getInputMap().put(KeyStroke.getKeyStroke("DOWN"), "downArrowPress");
        getInputMap().put(KeyStroke.getKeyStroke("RIGHT"), "rightArrowPress");
        getInputMap().put(KeyStroke.getKeyStroke("LEFT"), "leftArrowPress");

        getActionMap().put("upArrowPress", new Action() {
            @Override
            public Object getValue(String key) {
                return null;
            }

            @Override
            public void putValue(String key, Object value) {

            }

            @Override
            public void setEnabled(boolean b) {

            }

            @Override
            public boolean isEnabled() {
                return true;
            }

            @Override
            public void addPropertyChangeListener(PropertyChangeListener listener) {

            }

            @Override
            public void removePropertyChangeListener(PropertyChangeListener listener) {

            }

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("up");
                Game.info.user.moveUp();
                repaint();
            }
        });

        getActionMap().put("downArrowPress", new Action() {
            @Override
            public Object getValue(String key) {
                return null;
            }

            @Override
            public void putValue(String key, Object value) {

            }

            @Override
            public void setEnabled(boolean b) {

            }

            @Override
            public boolean isEnabled() {
                return true;
            }

            @Override
            public void addPropertyChangeListener(PropertyChangeListener listener) {

            }

            @Override
            public void removePropertyChangeListener(PropertyChangeListener listener) {

            }

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("down");
                Game.info.user.moveDown();
                repaint();
            }
        });

        getActionMap().put("rightArrowPress", new Action() {
            @Override
            public Object getValue(String key) {
                return null;
            }

            @Override
            public void putValue(String key, Object value) {

            }

            @Override
            public void setEnabled(boolean b) {

            }

            @Override
            public boolean isEnabled() {
                return true;
            }

            @Override
            public void addPropertyChangeListener(PropertyChangeListener listener) {

            }

            @Override
            public void removePropertyChangeListener(PropertyChangeListener listener) {

            }

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("right");
                Game.info.user.moveRight();
                repaint();
            }
        });

        getActionMap().put("leftArrowPress", new Action() {
            @Override
            public Object getValue(String key) {
                return null;
            }

            @Override
            public void putValue(String key, Object value) {

            }

            @Override
            public void setEnabled(boolean b) {

            }

            @Override
            public boolean isEnabled() {
                return true;
            }

            @Override
            public void addPropertyChangeListener(PropertyChangeListener listener) {

            }

            @Override
            public void removePropertyChangeListener(PropertyChangeListener listener) {

            }

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("left");
                Game.info.user.moveLeft();
                repaint();
            }
        });
        //</editor-fold>
    }

    @Override
    public void paint(Graphics g) {
        System.out.println("paint");
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        if (info.user.currentSprite != null) {
            g2d.drawImage(info.user.currentSprite, info.user.x, info.user.y, null);
        }
    }
}
