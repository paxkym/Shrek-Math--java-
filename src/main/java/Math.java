package src.main.java;
import java.awt.BorderLayout;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.JPanel;

import src.main.Windows.*;
import src.main.Tabs.*;

public class Math implements ActionListener {
    MainWindow MainWindow = new MainWindow();
    public int TabQuantity = 0;
    public ArrayList<Tab> Tabs = new ArrayList<Tab>();
    public ArrayList<JPanel> Panels = new ArrayList<JPanel>();


    public void addTab(String name, String type){
        MainWindow.model.addElement(name);

        Tab NewTab = new Tab();


        if(type == "CustomWave"){
            NewTab = new CustomWave();
        }

        Tabs.add(NewTab);

        Panels.add(NewTab.buildTab());


    }

    // Variables

    
    // App method
    public Math() {
        // Setup

        addTab("Tab1", "CustomWave");
        MouseListener TabListener = new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {

                int Selection = MainWindow.TabList.locationToIndex(e.getPoint());
                String type = Tabs.get(Selection).type;

                MainWindow.setPanel(Panels.get(Selection));
                System.out.println(MainWindow.centerPanel);


             }
        };
        MainWindow.TabList.addMouseListener(TabListener);


    }

    // Main method
    public static void main(String args[]) {
        Math app = new Math();

    }


    @Override
    public void actionPerformed(ActionEvent e) {

     }
    }