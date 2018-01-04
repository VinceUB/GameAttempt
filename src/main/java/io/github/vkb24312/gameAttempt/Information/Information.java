package io.github.vkb24312.gameAttempt.Information;

import javax.swing.*;
import java.awt.*;

public class Information {
    public Information(Dimension frameSize){
        //<editor-fold desc="JFrame setup">
        frame = new JFrame();
        frame.setSize(frameSize);
        frame.setVisible(true);
        panel = new JPanel();

        JPanel mainPanel = new JPanel(new CardLayout());

        frame.add(mainPanel);

        mainPanel.add(panel);

        if(backButtonVisible){
            panel.setPreferredSize(new Dimension(frame.getWidth(), frame.getHeight()-20));
            JPanel backPanel = new JPanel();
            mainPanel.add(backPanel);
            backPanel.add(new JButton("Back"));
            backPanel.getComponent(0).setBounds(backPanel.getComponent(0).getX(), backPanel.getComponent(0).getY(), backPanel.getComponent(0).getWidth(), 20);
        } else {
            panel.setPreferredSize(new Dimension(frame.getWidth(), frame.getHeight()));
        }
        //</editor-fold>

        user = new User();
    }
    public JFrame frame;
    public User user;
    public JPanel panel;

    public boolean backButtonVisible = true;
}
