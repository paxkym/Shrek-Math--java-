import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.math.*;

public class Shrek_Math implements ActionListener {
    // Variables
    JFrame MainWindow = new JFrame();
    JPanel Panel = new JPanel();
    JMenuBar MenuBar = new JMenuBar();

    // Elements
    JButton newButton = new JButton("New Tab");

    
    // App method
    public Shrek_Math() {
        // Setup

        // JPanel
        {
            GridBagConstraints gbc = new GridBagConstraints();
            Panel.setLayout(new GridBagLayout());
            Panel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

            gbc.gridy = 0;
            gbc.gridx = 0;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            Panel.add(newButton, gbc);



        }
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
        Shrek_Math app = new Shrek_Math();

    }


    @Override
    public void actionPerformed(ActionEvent e) {

     }
    }