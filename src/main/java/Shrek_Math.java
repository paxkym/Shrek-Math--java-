package src.main.java;
import src.main.java.Windows.MainWindow;
import src.main.java.Tabs.Tab;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.math.*;

// Christ is king! ☦☦☦
public class Shrek_Math implements ActionListener {
    // Variables
    JFrame MainWindow = new JFrame();
    JPanel Panel = new JPanel();
    JMenuBar MenuBar = new JMenuBar();
    MainWindow MainPanel = new MainWindow();

    // Elements
    JButton newButton = new JButton("New Tab");

    
    // App method
    public Shrek_Math() throws InterruptedException {
        // Setup

        // JPanel
        MainPanel.CreateWindow();
        Panel = MainPanel.panel;
        // JFrame
        {
            MainWindow.add(Panel);
            MainWindow.setTitle("Shrek Math Software");
            MainWindow.setVisible(true);
            MainWindow.pack();
            MainWindow.setSize(570, 400);
            MainWindow.setResizable(false);
            MainWindow.setJMenuBar(MenuBar);
            if (System.getProperty("os.name") != "Mac OS X") {
                MainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            } else {
                MainWindow.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            }

        }

        while(true){
        if(MainPanel.renderIndex == 1){
            MainPanel.CreateNewTabPanel();
            MainPanel.renderIndex = 0;
        }else if(MainPanel.renderIndex == 2){
            MainPanel.goToTab(MainPanel.selection);
            MainPanel.renderIndex = 0;
        }else if(MainPanel.renderIndex == 3){
            MainPanel.CreateWindow();
            MainPanel.renderIndex = 0;
        }

        Thread.sleep(100);
    }

    }

    // Main method
    public static void main(String args[]) throws InterruptedException {
        Shrek_Math app = new Shrek_Math();

    }


    @Override
    public void actionPerformed(ActionEvent e) {

     }
    }