package io.github.vkb24312.gameAttempt.Executables;

import com.thoughtworks.xstream.XStream;
import io.github.vkb24312.gameAttempt.Information.Information;
import io.github.vkb24312.gameAttempt.Information.User;

import javax.swing.*;
import java.awt.*;

public class Login {
    static private boolean aBoolean = false;

    static void toggleBoolean(){
        aBoolean = !aBoolean;
    }

    public static void main(Information info){
        JFrame frame = new JFrame("Log into the Game");
        frame.setPreferredSize(new Dimension(300, 300));
        frame.setVisible(true);

        JPanel panel = new JPanel(new GridBagLayout());

        JButton register = new JButton("New Player");
        JButton login = new JButton("Old Player");

        register.addActionListener(e ->{
            frame.dispose();
            User user = register(info);
        });

        login.addActionListener(e -> {
            frame.dispose();
            User user = login(info);
        });

        panel.add(register);
        panel.add(login);
        frame.add(panel);
    }

    static User login(Information info) {
        JFrame frame = new JFrame("Login");
        JPanel mainPanel = new JPanel(new CardLayout());
        JPanel panel = new JPanel(new GridBagLayout());
        JPanel back = new JPanel(new GridBagLayout());
        JScrollPane scrollPane = new JScrollPane();

        scrollPane.add(panel);
        mainPanel.add(scrollPane);
        mainPanel.add(back);
        mainPanel.add(frame);

        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> main(info));

        JTextArea username = new JTextArea("Username");
        JTextArea password = new JTextArea("Password (Low security)");

        username.setLineWrap(true);
        password.setLineWrap(true);

        JButton submit = new JButton("Submit");
        submit.addActionListener(e -> {
            toggleBoolean();
        });

        while(aBoolean){}

        User user = new User();
        user.password = password.toString();
        user.username = username.toString();

        return user;
    }
    static User register(Information info){

        return info.user;
    }
}
