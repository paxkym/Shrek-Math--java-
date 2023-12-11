package src.main.java.Windows;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.text.JTextComponent;
import src.main.java.Tabs.Tab;



public class MainWindow {
boolean list1IsSelected = true;
int selection = 0;
Tab tabs[];


DefaultListModel model = new DefaultListModel();
public JPanel panel = new JPanel();
JList list = new JList(model);
public JPanel spanel = new JPanel();
JScrollPane scroll = new JScrollPane(list, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
   public void update(){
            panel.add(spanel, BorderLayout.CENTER);
   }
    public void CreateWindow(){
        panel.setLayout(new BorderLayout());
        list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        list.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        list.setVisibleRowCount(-1);
        scroll.setSize(new Dimension(150, 150));

model.addElement("+ Add Tab");
model.addElement("Jane Doe");

list = new JList(model);



        panel.add(new JScrollPane(list), BorderLayout.WEST);
                        

        list.addListSelectionListener(new ListSelectionListener() {  
            public void actionPerformed(ActionEvent e) {   

            }

            @Override
            public void valueChanged(ListSelectionEvent e) {
                list1IsSelected = !list1IsSelected;
                if(list1IsSelected){
                    if(list.getSelectedValue() == "+ Add Tab"){
                        // Build new interface every time button is pressed
                        TextArea textarea = new TextArea("Tab");
                        JPopupMenu menu = new JPopupMenu(); 
                        JButton button = new JButton("Create");

                        spanel.setLayout(new FlowLayout());
                        spanel.add(textarea);
                        menu.add(new JMenuItem("Custom Wave"));menu.add(new JMenuItem("Custom Function"));menu.add(new JMenuItem("Constant"));
                        spanel.add(menu);
                        spanel.add(button);
                        System.out.println("Hi");
                        update();
                        return;
                        
                        // list.setSelectedIndex(selection);
                    }else{
                        selection = list.getSelectedIndex();

                    };
                }
            }
        });
            


    }
}
