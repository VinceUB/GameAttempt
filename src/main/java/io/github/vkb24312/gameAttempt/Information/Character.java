package io.github.vkb24312.gameAttempt.Information;

import java.io.*;
import javax.swing.*;
import java.awt.*;

public interface Character {
    String name = "Unnamed Character";
    Sprite sprite = new Sprite().setAll(new ImageIcon("Sprites/Unnamed_spr.png").getImage());

    int x = 0;
    int y = 0;

    void moveUp();
    void moveDown();
    void moveLeft();
    void moveRight();

    Image currentSprite = sprite.spr_still_down;
}
