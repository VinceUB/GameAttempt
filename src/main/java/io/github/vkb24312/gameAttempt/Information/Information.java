package io.github.vkb24312.gameAttempt.Information;

import io.github.vkb24312.gameAttempt.Information.Characters.User;

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

    static public void load(){

    }
}
