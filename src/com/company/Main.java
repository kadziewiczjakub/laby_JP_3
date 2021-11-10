package com.company;

import javax.swing.*;
//import static javax.swing.SwingUtilities.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
        //DB.loadFromFile();
        SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                try{
                    MainWindow window=new MainWindow("Login Window");
                    window.setVisible(true);
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        });
    }

}
