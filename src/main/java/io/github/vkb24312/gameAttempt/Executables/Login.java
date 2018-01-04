package io.github.vkb24312.gameAttempt.Executables;

import io.github.vkb24312.gameAttempt.Information.Information;
import io.github.vkb24312.gameAttempt.Information.User;

import javax.swing.*;
import java.awt.*;

public class Login {
    public static void main(Information info){
        JPanel panel = (JPanel) info.frame.getComponent(0).getComponentAt(0,0);

        JButton register = new JButton("Register");
        register.setPreferredSize(new Dimension(panel.getWidth(), panel.getHeight()/2));

        JButton login = new JButton("Log in");
        login.setPreferredSize(new Dimension(panel.getWidth(), panel.getHeight()/2));

        panel.add(register);
        panel.add(login);

        register.addActionListener(e -> {
            info.user = register(info);
        });

        login.addActionListener(e -> {
            info.user = register(info);
        });

        info.frame.remove(0);
        info.frame.add(panel, 0);
    }

    static User login(Information info) {
        info.backButtonVisible = true;
        JPanel backPanel = (JPanel) info.frame.getComponent(1);
    }
    static User register(Information info){

    }
}
