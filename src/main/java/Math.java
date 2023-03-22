package src.main.java;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.math.*;
import src.main.Windows.MainWindow;

        // todo:
        /*
         Create scrollable tab interface in src.main.Windows.MainWindow

         
        */

public class Math implements ActionListener {
    // Variables
    JFrame MainWindow = new JFrame();
    JPanel Panel;
    JMenuBar MenuBar = new JMenuBar();

    // Elements
    JButton newButton = new JButton("New Tab");

    
    // App method
    public Math() {
        // Setup

        MainWindow MainWindowClass = new MainWindow();
        Panel = MainWindowClass.MainPanel;

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



    }

    // Main method
    public static void main(String args[]) {
        Math app = new Math();

    }


    @Override
    public void actionPerformed(ActionEvent e) {

     }
    }