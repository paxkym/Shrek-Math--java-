package src.main.Windows;

import java.awt.*;

import javax.swing.*;

public class MainWindow {
    JList List = new JList();
    public JPanel MainPanel = new JPanel();

    public MainWindow(){
        MainPanel.setLayout(new BorderLayout());
        MainPanel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        MainPanel.add(List, BorderLayout.WEST);

    }
}
