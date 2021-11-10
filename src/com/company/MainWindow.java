package com.company;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;

public class MainWindow extends JFrame {
    public MainWindow()throws HeadlessException{
        this("undefined");
    }
    public MainWindow(String title)throws HeadlessException{
        super(title);
        buildFrame();
    }

    protected void buildFrame(){
        setBounds(0,0,400,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel contentPanel=new JPanel();
        contentPanel.setBorder(new EmptyBorder(2,2,2,2));
        setContentPane(contentPanel);
        contentPanel.setLayout(null);
        contentPanel.setBounds(0,0,400,300);

        JMenuBar menuBar=new JMenuBar();
        setJMenuBar(menuBar);

        JMenu menu=new JMenu("File");
        contentPanel.add(menu);

        JMenuItem load_users=new JMenuItem("Load Users");
        load_users.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DB.loadFromFile();
            }
        });
        load_users.setMnemonic(KeyEvent.VK_O);
        load_users.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L,InputEvent.CTRL_DOWN_MASK));
        menu.add(load_users);
        menuBar.add(menu);


        JPanel userIdContainer = new JPanel();
        userIdContainer.setLayout(null);
        userIdContainer.setBounds(45,50,250,25);
        JLabel userIdTextLabel=new JLabel("User ID");
        userIdTextLabel.setBounds(0,0,75,25);
        userIdContainer.add(userIdTextLabel);
        JTextField userIdTextField=new JTextField();
        //userIdTextField.setColumns(15);
        userIdTextField.setBounds(75,0,175,25);
        userIdContainer.add(userIdTextField);
        contentPanel.add(userIdContainer);

        JPanel passwordContainer = new JPanel();
        passwordContainer.setLayout(null);
        passwordContainer.setBounds(45,100,250,25);
        JLabel passwordTextLabel=new JLabel("Password");
        passwordTextLabel.setBounds(0,0,75,25);
        passwordContainer.add(passwordTextLabel);
        JPasswordField passwordTextField=new JPasswordField();
        //passwordTextField.setColumns(15);
        passwordTextField.setBounds(75,0,175,25);
        passwordContainer.add(passwordTextField);
        contentPanel.add(passwordContainer);

        JButton loginButton=new JButton("Login");
        loginButton.setBounds(260, 200, 75, 25);
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loginButtonClicked(userIdTextField.getText(),new String(passwordTextField.getPassword()),contentPanel);
            }
        });
        contentPanel.add(loginButton);

        JButton cancelButton=new JButton("Cancel");
        cancelButton.setBounds(160, 200, 75, 25);
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cancelButtonClicked();
            }
        });
        contentPanel.add(cancelButton);

        JMenuItem loginFromMenu=new JMenuItem("Login");
        loginFromMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loginButtonClicked(userIdTextField.getText(),new String(passwordTextField.getPassword()),contentPanel);
            }
        });
        loginFromMenu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T,InputEvent.CTRL_DOWN_MASK));
        menu.add(loginFromMenu);

    }

    private void loginButtonClicked(String uid,String password,JPanel panel)
    {
        if(DB.checkCredentials(uid,password))
        {
            panel.setBackground(Color.GREEN);
        }
        else {
            panel.setBackground(Color.RED);
        }
    }

    private void cancelButtonClicked()
    {
        dispatchEvent(new WindowEvent(this,WindowEvent.WINDOW_CLOSING));
    }
}
