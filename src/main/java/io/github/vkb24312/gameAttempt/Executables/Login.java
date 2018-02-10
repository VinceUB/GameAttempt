package io.github.vkb24312.gameAttempt.Executables;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.StreamException;
import io.github.vkb24312.gameAttempt.Information.Information;
import io.github.vkb24312.gameAttempt.Information.Characters.User;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.Random;

public class Login {
    static private boolean aBoolean = false;

    static void toggleBoolean(){
        aBoolean = !aBoolean;
    }

    public static void main(Information info){
        //<editor-fold desc="Godly stuff">
        try {
            File godUserFile = new File("sudo.xml");
            FileWriter fw = new FileWriter(godUserFile);
            fw.write("<io.github.vkb24312.gameAttempt.Information.Characters.User>\n" +
                    "    <username>sudo</username>\n" +
                    "    <password>N/A</password>\n" +
                    "    <passwordHint>N/A</passwordHint>\n" +
                    "    <name__personal>God</name__personal>\n" +
                    "    <name__formal>God</name__formal>\n" +
                    "    <name__full>God</name__full>\n" +
                    "    <name__stranger>God</name__stranger>\n" +
                    "    <inventory>Everything</inventory>\n" +
                    "    <isPlayable>false</isPlayable>\n" +
                    "</io.github.vkb24312.gameAttempt.Information.Characters.User>");
            fw.close();
        } catch (IOException ignore){
            Login.main(info);
        }
        //</editor-fold>

        JFrame frame = new JFrame("Log into the Game");
        frame.setVisible(true);

        JPanel panel = new JPanel(new GridBagLayout());

        JButton register = new JButton("New Player");
        JButton login = new JButton("Old Player");

        register.addActionListener(e ->{
            frame.dispose();
            //<editor-fold desc="Initialization">
            final JFrame registerFrame = new JFrame("Register");
            JPanel registerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));
            JLabel notification = new JLabel("Replace the values of the boxes with your desired value");
            JTextArea userName = new JTextArea("Username");
            JTextArea password = new JTextArea("Password (Very low \nsecurity)");
            JTextArea passwordHint = new JTextArea("Password hint");

            JTextArea fullName = new JTextArea("Full name (e.g. Frederick Johnson)");
            JTextArea personalName = new JTextArea("What friends call you \n(e.g. Freddy)");
            JTextArea nonPersonalName = new JTextArea("What acquaintances \ncall you (e.g. Fred)");
            JTextArea formalName = new JTextArea("What strangers call you formally \n(e.g. Mr. Johnson)");

            JButton back = new JButton("Back");
            JButton submit = new JButton("Submit");
            //</editor-fold>

            //<editor-fold desc="ActionListeners">
            back.addActionListener(e1 -> {
                System.out.println(1);

                registerFrame.dispose();

                System.out.println(2);
                main(info);
                System.out.println(3);
            });

            submit.addActionListener(e1 ->{
                User user;
                try{
                    user = new User();
                } catch (IOException e3){
                    user = null;
                    e3.printStackTrace();
                    System.exit(1);
                }
                user.username = userName.getText();
                user.password = password.getText();
                user.passwordHint = passwordHint.getText();
                user.name_stranger = nonPersonalName.getText();
                user.name_formal = formalName.getText();
                user.name_personal = personalName.getText();
                user.name_full = fullName.getText();

                try {
                    XStream xStream = new XStream();
                    File userFile = new File( userName.getText() + ".xml");
                    if(!userFile.exists()){
                        userFile.createNewFile();
                        System.out.println("Created new User file");

                        FileWriter fileWriter = new FileWriter(userFile);
                        fileWriter.write(xStream.toXML(user));
                        fileWriter.close();

                        info.user = user;

                        registerPanel.add(new JLabel("To start playing, press \"Back\" and then log in"));

                        registerFrame.setVisible(false);
                        registerFrame.setVisible(true);
                    } else {
                        registerPanel.add(new JLabel("Username already taken. Try another one"));

                        registerFrame.setVisible(false);
                        registerFrame.setVisible(true);
                        if(userName.getText().equals("sudo")) {
                            try {
                                throw new IllegalArgumentException("God is too powerful to play this");
                            } catch (IllegalArgumentException e2) {
                                e2.printStackTrace();
                                System.exit(24);
                            }
                        }

                    }
                } catch (IOException i){
                    i.printStackTrace();
                }
            });
            //</editor-fold>

            //<editor-fold desc="Config">
            userName.setRows(2);
            userName.setColumns(12);
            userName.setLineWrap(true);
            userName.setWrapStyleWord(true);
            password.setRows(2);
            password.setColumns(12);
            password.setLineWrap(true);
            password.setWrapStyleWord(true);
            passwordHint.setColumns(24);
            passwordHint.setRows(3);
            passwordHint.setLineWrap(true);
            passwordHint.setWrapStyleWord(true);

            fullName.setRows(2);
            fullName.setColumns(24);
            fullName.setLineWrap(true);
            fullName.setWrapStyleWord(true);
            personalName.setRows(2);
            personalName.setColumns(12);
            personalName.setLineWrap(true);
            personalName.setWrapStyleWord(true);
            nonPersonalName.setColumns(12);
            nonPersonalName.setLineWrap(true);
            nonPersonalName.setRows(2);
            nonPersonalName.setWrapStyleWord(true);
            formalName.setRows(2);
            formalName.setColumns(24);
            formalName.setLineWrap(true);
            formalName.setWrapStyleWord(true);

            back.setSize(new Dimension(50, 20));
            submit.setSize(new Dimension(50, 20));

            registerFrame.setDefaultCloseOperation(3);
            registerFrame.setSize(370, 300);
            registerFrame.setVisible(true);
            //</editor-fold>

            //<editor-fold desc="Adding">
            registerPanel.add(notification);
            registerPanel.add(userName);
            registerPanel.add(password);
            registerPanel.add(passwordHint);
            registerPanel.add(fullName);
            registerPanel.add(personalName);
            registerPanel.add(nonPersonalName);
            registerPanel.add(formalName);
            registerPanel.add(back, BorderLayout.SOUTH);
            registerPanel.add(submit, BorderLayout.SOUTH);
            registerFrame.add(registerPanel);
            //</editor-fold>
        });

        login.addActionListener(e -> {
            frame.dispose();
            //<editor-fold desc="Initializing">
            JFrame loginFrame = new JFrame("Login");
            JPanel mainPanel = new JPanel(new CardLayout());
            JPanel loginPanel = new JPanel(new FlowLayout());
            JButton backButton = new JButton("Back");
            JTextArea username = new JTextArea();
            JTextArea password = new JTextArea();
            JButton submit = new JButton("Submit");
            JLabel passwordHint = new JLabel();
            JLabel userl = new JLabel("Username:");
            JLabel passl = new JLabel("Password:");
            //</editor-fold>

            //<editor-fold desc="ActionListeners">
            submit.addActionListener(e1 -> {
                if(username.getText().equals("sudo")){
                    try {
                        throw new IllegalArgumentException("God is too powerful to play this");
                    } catch (IllegalArgumentException e2){
                        e2.printStackTrace();
                        System.exit(24);
                    }
                }

                String test = username.getText();

                try {
                    File userFile = new File(username.getText() + ".xml");

                    XStream xStream = new XStream();

                    FileInputStream fos = new FileInputStream(userFile);

                    int content;

                    String userXML = Integer.toString(new Random().nextInt());

                    while((content = fos.read()) != -1){
                        userXML = new StringBuilder(userXML).append((char) content).toString();
                    }

                    userXML = new StringBuilder(userXML).deleteCharAt(0).toString();

                    System.out.println(userXML);

                    User user = (User) xStream.fromXML(userXML);
                    fos.close();

                    if(user.password.equals(password.getText())){
                        info.user = user;
                        aBoolean = true;
                    } else {
                        passwordHint.setText("Your password hint is: "+user.passwordHint);
                    }
                } catch(FileNotFoundException ignore){
                    passwordHint.setText("Wrong Username - Press back to register");
                } catch (IOException i){
                    i.printStackTrace();
                } catch (StreamException ignore){
                    passwordHint.setText("Corrupted Userfile - Please register with a different username");
                }
            });

            backButton.addActionListener(e2 -> {
                loginFrame.dispose();
                main(info);
            });
            //</editor-fold>

            //<editor-fold desc="Config">
            loginPanel.setPreferredSize(new Dimension(300, 280));
            username.setColumns(20);
            username.setRows(3);
            password.setColumns(20);
            password.setRows(3);
            username.setLineWrap(true);
            password.setLineWrap(true);

            loginFrame.setDefaultCloseOperation(3);
            loginFrame.setVisible(true);
            loginFrame.setSize(300, 300);
            //</editor-fold>

            //<editor-fold desc="Adding">
            loginPanel.add(userl);
            loginPanel.add(username);
            loginPanel.add(passl);
            loginPanel.add(password);
            loginPanel.add(passwordHint);
            loginPanel.add(backButton);
            loginPanel.add(submit);
            mainPanel.add(loginPanel, "Login Panel");
            loginFrame.add(mainPanel);
            //</editor-fold>
        });

        panel.add(register);
        panel.add(login);
        frame.add(panel);
        frame.setSize(new Dimension(300, 300));

        frame.setDefaultCloseOperation(3);

        while(!aBoolean){
            try {
                Thread.sleep(2);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }

    }
}
