package io.github.vkb24312.gameAttempt.Executables;

import io.github.vkb24312.gameAttempt.Information.Information;
import javax.swing.*;
public class Main {
    public static void main(String[] args){
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (Exception ignore){}
        Information info = new Information();
        Login.main(info);
        System.out.println("Finished execution");
    }
}
