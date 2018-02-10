package io.github.vkb24312.gameAttempt.Information;

import io.github.vkb24312.gameAttempt.Executables.Game;
import io.github.vkb24312.gameAttempt.Information.Characters.User;

import javax.swing.*;
import java.io.IOException;

public class Information {
    public Information(){
        try {
            user = new User();
        } catch (IOException e){
            e.printStackTrace();
            System.exit(1);
        }
    }
    public User user;

    public void load(){
        if(user.room==-1) new Game().testRoom(this);
    }

    public JFrame gameFrame = new JFrame("Game");
}
