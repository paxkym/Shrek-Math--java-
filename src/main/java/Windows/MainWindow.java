package src.main.java.Windows;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.text.JTextComponent;

import src.main.java.Tabs.CustomFunction;
import src.main.java.Tabs.CustomWave;
import src.main.java.Tabs.Tab;
import src.main.java.Shrek_Math;
import src.main.java.Misc.Processor;
import src.main.java.Windows.SettingsWindow;



public class MainWindow {
boolean list1IsSelected = true;
boolean h = false;
public int selection = 0;
ArrayList<Tab> tabs = new ArrayList<Tab>(0);
public int renderIndex = 0;
SettingsWindow settings = new SettingsWindow();
Processor proc = new Processor();
public ArrayList views = new ArrayList<Tab>();



DefaultListModel model = new DefaultListModel();
public JPanel panel = new JPanel();
public JPanel menuBarTop;
JList list = new JList(model);
// public JPanel spanel = new JPanel();
                      
public void CreateView(int index){
System.out.println(tabs.get(index).value.size());
ViewWindow view = new ViewWindow();
views.add(view);
proc.views = views;
view.in1 = tabs.get(index).input1;
view.in2 = tabs.get(index).input2;
view.out = tabs.get(index);
}
public float double2float(double d){
float f = (float)d;
return f;
}
public void goToTab(int index){
    Tab tab = tabs.get(index);
    if(tab.type == "Custom Wave"){
    String opt[] = {"Square Wave", "Triangle Wave", "Sine Wave", "Rising Edge Sawtooth Wave", "Falling Edge Sawtooth Wave", "Straight Line", "Noise (Random)", "Bell Curve"};
    JComboBox menu = new JComboBox(opt); 
    JSpinner leng = new JSpinner();
    JPanel spanel = new JPanel();
    JSpinner freq = new JSpinner(new SpinnerNumberModel(2, 0, 10, 0.1));
    JSpinner max = new JSpinner(new SpinnerNumberModel(1, -1000000000, 100000000, 0.1));
    JSpinner min = new JSpinner(new SpinnerNumberModel(0, -1000000000, 100000000, 0.1));
    
    spanel.setLayout(new GridLayout(5, 1));
    freq.setValue((double)(tab).freq);
    leng.setValue((int)(tab).length);
    max.setValue((double)(tab).max);
    min.setValue((double)(tab).min);
    
    spanel.add(new JLabel("Type:"));
    spanel.add(menu);
    spanel.add(new JLabel("Frequency:"));
    spanel.add(freq);
    spanel.add(new JLabel("Length:"));
    spanel.add(leng);
    spanel.add(new JLabel("Maximum Value:"));
    spanel.add(max);
    spanel.add(new JLabel("Minimum Value:"));
    spanel.add(min);

     panel.removeAll();
      panel.repaint();
      panel.revalidate();
    panel.add(spanel, BorderLayout.CENTER);
    panel.add(new JScrollPane(list), BorderLayout.WEST);
    panel.add(menuBarTop, BorderLayout.NORTH);
      panel.repaint();
      panel.revalidate();
    
    menu.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
        tab.subtype = menu.getSelectedIndex();
        proc.process(tabs);
      }
      
    });
    freq.addChangeListener((ChangeListener) new ChangeListener(){

            @Override
            public void stateChanged(ChangeEvent e) {
              if(double2float((double)freq.getValue()) < 0){
                freq.setValue(1);
              }else if(double2float((double)freq.getValue()) > proc.resolution){
                freq.setValue(proc.resolution);
              }else{
                (tab).freq = double2float((double)freq.getValue());
              }
                      proc.process(tabs);
            }
    });
    leng.addChangeListener((ChangeListener) new ChangeListener(){

            @Override
            public void stateChanged(ChangeEvent e) {

                (tab).length = (int)leng.getValue();
              
                      proc.process(tabs);
            }
    });
    max.addChangeListener((ChangeListener) new ChangeListener(){

            @Override
            public void stateChanged(ChangeEvent e) {
              if((double)(max.getValue()) <= (double)(min.getValue())){
                max.setValue((double)max.getValue()+1);
              }else{
                (tab).max = double2float((double)max.getValue());
              }
                      proc.process(tabs);
            }
    });
    min.addChangeListener((ChangeListener) new ChangeListener(){

            @Override
            public void stateChanged(ChangeEvent e) {
              if((double)min.getValue() >= (double)max.getValue()){
                min.setValue((double)min.getValue()-1);
              }else{
                (tab).min = double2float((double)min.getValue());
              }
                      proc.process(tabs);
            }
    });
  }else if(tab.type == "Custom Function"){
    JPanel spanel = new JPanel();
    JTextArea texta = new JTextArea(tab.text);
    spanel.setLayout(new GridLayout(3, 1));
    
    spanel.add(new JLabel("Type function below:"));
    spanel.add(texta);
    spanel.add(new JLabel("Result:\n\n"+tab.result));


     panel.removeAll();
      panel.repaint();
      panel.revalidate();
    panel.add(spanel, BorderLayout.CENTER);
    panel.add(new JScrollPane(list), BorderLayout.WEST);
    panel.add(menuBarTop, BorderLayout.NORTH);
      panel.repaint();
      panel.revalidate();

       texta.addKeyListener(new KeyListener() {

        @Override
        public void keyTyped(KeyEvent e) {}

        @Override
        public void keyPressed(KeyEvent e) {}

        @Override
        public void keyReleased(KeyEvent e) {
        tab.ptext = tab.text;
        tab.text = texta.getText();
        }
        
       });
  }
  return;
}
public Tab createNewTab(String name, String type, int subtype){
Tab tab = new Tab();
if(type == "Custom Wave"){
tab = new CustomWave();
}else if(type == "Custom Function"){
tab = new CustomFunction();
}

tab.name = name;
tab.type = type;
tab.subtype = subtype;
tab.realLength = (settings.maximum-settings.minimum)*settings.resolution;
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
     panel.removeAll();
      panel.repaint();
      panel.revalidate();
    panel.add(spanel, BorderLayout.CENTER);
    panel.add(new JScrollPane(list), BorderLayout.WEST);
    panel.add(menuBarTop, BorderLayout.NORTH);
      panel.repaint();
      panel.revalidate();
    button.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
              System.out.println("Tab added");
              tabs.add(createNewTab(textarea.getText(), (String)menu.getSelectedItem(), 0));
              model.addElement(textarea.getText());
              selection = tabs.size()-1;
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
    JButton ViewButton = new JButton("New View");
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
              CreateView(selection);
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

model.addElement("Jane Doe");

list = new JList(model);

        panel.add(new JScrollPane(list), BorderLayout.WEST);
        buildTopPanel();
        panel.add(menuBarTop, BorderLayout.NORTH);

        list.addListSelectionListener(new ListSelectionListener() {  
            public void actionPerformed(ActionEvent e) {   

            }

            @Override
            public void valueChanged(ListSelectionEvent e) {
                list1IsSelected = !list1IsSelected;
                if(list1IsSelected){
                    if(list.getSelectedValue() == "Jane Doe"){

                        // list.setSelectedIndex(selection);
                    }else{
                        selection = list.getSelectedIndex();
                        goToTab(list.getSelectedIndex()-1);
                        System.out.println("S");
                    };
                }
            }
        });
            

        panel.repaint();
        panel.revalidate();
    }
}
