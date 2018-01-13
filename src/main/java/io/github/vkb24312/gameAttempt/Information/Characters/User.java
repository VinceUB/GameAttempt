package io.github.vkb24312.gameAttempt.Information.Characters;

import io.github.vkb24312.gameAttempt.Information.Character;
import io.github.vkb24312.gameAttempt.Information.Item;
import io.github.vkb24312.gameAttempt.Information.Sprite;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class User implements Character {
    public User() throws IOException{
        //<editor-fold desc="Sprite init">
        System.out.println(getClass().getClassLoader().getResource("Sprites/user/user_walk_bac.png").getFile());
        BufferedImage upSpriteMove = ImageIO.read(new File(getClass().getClassLoader().getResource("Sprites/user/user_walk_bac.png").getFile()));
        BufferedImage downSpriteMove = ImageIO.read(new File(getClass().getClassLoader().getResource("Sprites/user/user_walk_for.png").getFile()));
        BufferedImage rightSpriteMove = ImageIO.read(new File(getClass().getClassLoader().getResource("Sprites/user/user_walk_rig.png").getFile()));
        BufferedImage leftSpriteMove = ImageIO.read(new File(getClass().getClassLoader().getResource("Sprites/user/user_walk_lef.png").getFile()));

        for (int i = 0; i < 4; i++) {
            int x;
            int y;
            if(i%2==0){
                x=32;
            } else {
                x=0;
            }
            if(i-2>=0){
                y=32;
            } else {
                y=0;
            }
            sprite.spr_walk_up[i] = upSpriteMove.getSubimage(x, y, 32, 32);
            sprite.spr_walk_down[i] = downSpriteMove.getSubimage(x, y, 32, 32);
            sprite.spr_walk_left[i] = leftSpriteMove.getSubimage(x, y, 32, 32);
            sprite.spr_walk_right[i] = rightSpriteMove.getSubimage(x, y, 32, 32);
        }

        sprite.spr_still_up = new ImageIcon(getClass().getClassLoader().getResource("Sprites/user/user_still_bac.png").getFile()).getImage();
        sprite.spr_still_down = new ImageIcon(getClass().getClassLoader().getResource("Sprites/user/user_still_for.png").getFile()).getImage();
        sprite.spr_still_left = new ImageIcon(getClass().getClassLoader().getResource("Sprites/user/user_still_lef.png").getFile()).getImage();
        sprite.spr_still_right = new ImageIcon(getClass().getClassLoader().getResource("Sprites/user/user_still_rig.png").getFile()).getImage();

        sprite.icon = sprite.spr_still_down;
        //</editor-fold>
    }

    //<editor-fold desc="Login info">
    public String username;
    public String password;
    public String passwordHint;
    //</editor-fold>

    //<editor-fold desc="Names">
    public String name_personal;
    public String name_formal;
    public String name_full;
    public String name_stranger;

    public String getName(int nameType){
        if(nameType==0){
            return name_personal;
        } else if(nameType==1){
            return name_formal;
        } else if (nameType==2) {
            return name_full;
        } else if(nameType==3){
            return name_stranger;
        } else {
            throw new IllegalArgumentException("nameType cannot be less than 0 or more than 2");
        }
    }

    public static final int NAMETYPE_PERSONAL = 0;
    public static final int NAMETYPE_FORMAL = 1;
    public static final int NAMETYPE_FULL = 2;
    public static final int NAMETYPE_NONPERSONAL = 3;
    //</editor-fold>

    //<editor-fold desc="Inventory">
    private ArrayList<Item> inventory = new ArrayList<>();

    int getItemNumber(Item item){
        int i = 0;
        while(i>=inventory.toArray().length){
            if(item==inventory.get(i)){
                return i;
            } else {
                i++;
            }
        }
        return -1;
    }

    Item getItem(int index){
        if(0 <= index && index < inventory.toArray().length) {
            return inventory.get(index);
        } else {
            return null;
        }
    }

    void addItem(Item item){
        inventory.add(inventory.toArray().length, item);
    }
    //</editor-fold>

    static Sprite sprite = new Sprite();

    //<editor-fold desc="Sprite Animation">
    int x = 0;
    int y = 0;
    public Image currentSprite;

    public void moveDown(){
        for (int i = 0; i < 4; i++) {
            y--;
            currentSprite = sprite.spr_walk_down[i];
        }
    }

    public void moveUp(){
        for (int i = 0; i < 4; i++) {
            y++;
            currentSprite = sprite.spr_walk_up[i];
        }
    }

    public void moveLeft(){
        for (int i = 0; i < 4; i++) {
            x--;
            currentSprite = sprite.spr_walk_left[i];
        }
    }

    public void moveRight(){
        for (int i = 0; i < 4; i++) {
            x++;
            currentSprite = sprite.spr_walk_right[i];
        }
    }
    //</editor-fold>
}