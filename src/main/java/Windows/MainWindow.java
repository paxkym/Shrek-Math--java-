package src.main.java.Windows;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.text.JTextComponent;
import src.main.java.Tabs.Tab;
import src.main.java.Shrek_Math;
import src.main.java.Windows.SettingsWindow;



public class MainWindow {
boolean list1IsSelected = true;
boolean h = false;
public int selection = 0;
ArrayList<Tab> tabs = new ArrayList<Tab>(0);
public int renderIndex = 0;
SettingsWindow settings = new SettingsWindow();




DefaultListModel model = new DefaultListModel();
public JPanel panel = new JPanel();
public JPanel menuBarTop;
JList list = new JList(model);
// public JPanel spanel = new JPanel();
JScrollPane scroll = new JScrollPane(list, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
ExecutorService thread = Executors.newSingleThreadExecutor();    

public void goToTab(int index){
    // Tab tab = tabs.get(index);//tab.type == "Custom Wave"
    if(true){
    String opt[] = {"Square Wave", "Triangle Wave", "Sine Wave", "Falling Edge Sawtooth Wave", "Rising Edge Sawtooth Wave", "Straight Line", "Noise (Random)", "Bell Curve"};
    JComboBox menu = new JComboBox(opt); 
    JButton button = new JButton("Done");
    JPanel spanel = new JPanel();
    spanel.setLayout(new FlowLayout());
    spanel.add(menu);
    spanel.add(button);
     panel.removeAll();
      panel.repaint();
      panel.revalidate();
    panel.add(spanel, BorderLayout.CENTER);
    panel.add(new JScrollPane(list), BorderLayout.WEST);
    System.out.println("goToTab");
    
    
    button.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
              System.out.println("Tab added");
            }
    });
  }

  return;
}
public Tab createNewTab(String name, String type, int subtype){
Tab tab = new Tab();
tab.name = name;
tab.type = type;
tab.subtype = subtype;
tab.value = new float[(settings.maximum-settings.minimum)*settings.resolution];
return tab;
} 
public void requestRendering(int type){
    renderIndex = type;
   }
   public void CreateNewTabPanel(){
    
        // Build new interface every time button is pressed
    String opt[] = {"Custom Wave", "Custom Function", "Constant", "Arithmetic", "Trigonometry", "Calculus", "Boolean", "Transform", "Statistics", "Miscellaneous", "Complex Numbers"};
    TextArea textarea = new TextArea("Tab");
    JComboBox menu = new JComboBox(opt); 
    JButton button = new JButton("Create");
    JPanel spanel = new JPanel();
    spanel.setLayout(new FlowLayout());
    spanel.add(textarea);
    spanel.add(menu);
    spanel.add(button);
    System.out.println("Hi");
    panel.add(spanel, BorderLayout.CENTER);
      panel.repaint();
      panel.revalidate();
    button.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
              System.out.println("Tab added");
              tabs.add(createNewTab(textarea.getText(), "Custom Wave", 0));
              model.addElement(textarea.getText());
              requestRendering(2);
            }
    });
  
    return;
   }
   public void buildTopPanel(){
    menuBarTop = new JPanel();
    menuBarTop.setLayout(new FlowLayout());
    JButton AddTabButton = new JButton("Add Tab");
    JButton DeleteTabButton = new JButton("Delete Tab");
    JButton ViewButton = new JButton("Open View");
    JButton SettingsButton = new JButton("Settings");
    menuBarTop.add(AddTabButton);
    menuBarTop.add(DeleteTabButton);
    menuBarTop.add(ViewButton);
    menuBarTop.add(SettingsButton);
    AddTabButton.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
              System.out.println("Tab added");
              CreateNewTabPanel();
            }
    });
    DeleteTabButton.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
              System.out.println("Tab deleted");
              requestRendering(2);
            }
    });
    ViewButton.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
              System.out.println("View added");
            }
    });
    SettingsButton.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
              System.out.println("Settings opened");
            }
    });

   }
   public void CreateWindow(){
        panel.setLayout(new BorderLayout());
        list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        list.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        list.setVisibleRowCount(-1);
        scroll.setSize(new Dimension(150, 150));

model.addElement("Jane Doe");

list = new JList(model);


        panel.add(new JScrollPane(list), BorderLayout.WEST);
        buildTopPanel();
        panel.add(menuBarTop, BorderLayout.NORTH);

        list.addListSelectionListener(new ListSelectionListener() {  
            public void actionPerformed(ActionEvent e) {   
                CreateNewTabPanel();
            }

            @Override
            public void valueChanged(ListSelectionEvent e) {
                list1IsSelected = !list1IsSelected;
                if(list1IsSelected){
                    if(list.getSelectedValue() == "Jane Doe"){

                        // list.setSelectedIndex(selection);
                    }else{
                        selection = list.getSelectedIndex();

                    };
                }
            }
        });
            

        panel.repaint();
        panel.revalidate();
    }
}
