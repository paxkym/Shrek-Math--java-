package src.main.Windows;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;
import src.main.Tabs.*;

public class MainWindow {
    public int TabQuantitiy = 0;
    public Tab Tabs[];
    private String[] TabNames = {"Tab1", "Tab2"};

    DefaultListModel<String> model = new DefaultListModel<>();  
    JList TabList = new JList<String>(model);
    JPanel MainPanel = new JPanel();
    JFrame MainWindow = new JFrame();

    // public void addTab(String name){
    //     {
    //     Tab Placeholder[] = Tabs;
    //     Tab New[] = new Tab[Tabs.length+1];
    //     int i = 0;
    //     while(i<Tabs.length){
    //         New[i] = Placeholder[i];
    //         i++;
    //     }

    //     Tabs = New;
    // }   

    //     {
    //     String Placeholder[] = TabNames;
    //     String New[] = new String[TabNames.length+1];
    //     int i = 0;
    //     while(i<TabNames.length){
    //         New[i] = Placeholder[i];
    //         i++;
    //     }

    //     New[TabNames.length+1] = name; 

    //     TabNames = New;

    // }
    // model.addElement(name);
    // }

    public MainWindow(){
        model.addElement("Hi");
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
        
        TabList.setVisibleRowCount(6);
        TabList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        TabList.setBounds(100,100, 75,75);  
        }

        // JPanel
        {
        MainPanel.setLayout(new BorderLayout());
        MainPanel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        MainPanel.add(TabList, BorderLayout.WEST);
        }

        
    }
}
