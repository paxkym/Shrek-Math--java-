package src.main.Windows;

import java.awt.*;
import javax.swing.*;

public class MainWindow {
    
    public DefaultListModel<String> model = new DefaultListModel<>();  
    public JList TabList = new JList<String>(model);
    public JPanel MainPanel = new JPanel();
    public JFrame MainWindow = new JFrame();
    public JPanel centerPanel = new JPanel();

    public void setPanel(JPanel panel){
        MainPanel.add(panel, BorderLayout.CENTER);
    }

    public MainWindow(){
        // JFrame
        {
            
            MainWindow.add(MainPanel);
            MainWindow.setTitle("Shrek Math Software");
            MainWindow.setVisible(true);
            MainWindow.pack();
            MainWindow.setSize(570, 400);
            MainWindow.setResizable(false);
            if (System.getProperty("os.name") != "Mac OS X") {
                MainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            } else {
                MainWindow.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            }

        }

        // Formatting
        {
        TabList.setFixedCellWidth(100);
        TabList.setVisibleRowCount(6);
        TabList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        TabList.setMaximumSize(new Dimension(100, 100));
        

        }

        // JPanel
        {
        MainPanel.setLayout(new BorderLayout());
        MainPanel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        MainPanel.add(new JScrollPane(TabList), BorderLayout.WEST);
        
        }

        
    }
}