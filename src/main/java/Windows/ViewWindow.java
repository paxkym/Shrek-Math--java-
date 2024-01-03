package src.main.java.Windows;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import src.main.java.Tabs.Tab;

public class ViewWindow {
boolean isParametric = false;
JFrame window = new JFrame("View");
DefaultListModel model = new DefaultListModel();
public JPanel panel = new JPanel();
public JPanel centerPanel = new JPanel();
public JPanel menuBarTop;
public Graph inGraph = new Graph();
public Graph outGraph = new Graph();
public float minimumIn = 0, minimumOut = 0, maximumIn = 500, maximumOut = 500;
JList list = new JList(model);
// public JPanel spanel = new JPanel();
JScrollPane scroll = new JScrollPane(list, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
int selection = 0;
boolean list1IsSelected = false;
public ArrayList tabs;
public Tab in1;
public Tab in2;
public Tab out;
public int resolution = 10;
public BufferedImage mainimg = new BufferedImage(496, 163, BufferedImage.TYPE_4BYTE_ABGR);
public BufferedImage userimg = new BufferedImage(496, 163, BufferedImage.TYPE_4BYTE_ABGR);
public boolean isDrawingShower = false;
public int ux = 0;
public boolean mouseDown = false;
private Color clearWhite = new Color(255, 255, 255, 1);
public int begin = 0;

public void buildTopPanel(){
    menuBarTop = new JPanel();
    menuBarTop.setLayout(new FlowLayout());
    JButton AddTabButton = new JButton("Parametric");
    JButton DeleteTabButton = new JButton("Save View");
    menuBarTop.add(AddTabButton);
    menuBarTop.add(DeleteTabButton);
    AddTabButton.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
            isParametric = !isParametric;
              if(isParametric){
                AddTabButton.setText("Normal");
              }else{
                AddTabButton.setText("Parametric");
              }
              
            }
    });
    DeleteTabButton.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
              System.out.println("Tab deleted");
              
            }
    });
   }

public ViewWindow(){

   //JPanel
    {
      GridLayout l = new GridLayout(2, 1);
      l.setVgap(0);
      centerPanel.setLayout(l);
      centerPanel.add(inGraph);
      centerPanel.add(outGraph);
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
        panel.add(centerPanel, BorderLayout.CENTER);

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
                        System.out.println("S");
                    };
                }
            }
        });
        outGraph.addMouseListener(new MouseListener() {

          @Override
          public void mouseClicked(MouseEvent e) {
          mouseDown = !mouseDown;
          }

          @Override
          public void mousePressed(MouseEvent e) {
           mouseDown = true;
          }

          @Override
          public void mouseReleased(MouseEvent e) {
            mouseDown = false;
          }

          @Override
          public void mouseEntered(MouseEvent e) {}

          @Override
          public void mouseExited(MouseEvent e) {
          mouseDown = false;
          }
          
        });
        outGraph.addMouseMotionListener(new MouseMotionListener() {

          @Override
          public void mouseDragged(MouseEvent e) {

          }

          @Override
          public void mouseMoved(MouseEvent e) {
            if(true){
            ux = e.getX();
            isDrawingShower = true;
            outGraph.paint(outGraph.getGraphics());
            isDrawingShower = false;
            panel.repaint();
            panel.revalidate();
            }
          }
          
        });

        panel.repaint();
        panel.revalidate();
    }
    //JFrame
    {
    window.add(panel);
    window.setTitle("View");
    window.setVisible(true);
    window.pack();
    window.setSize(570, 400);
    window.setResizable(false);
    window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
}
}

class Graph extends Canvas {    

        public Graph() {    
        setBackground (Color.GRAY);    
        setSize(496, 163);    
     }    
  
  public void paint(Graphics g1){    
    if(!isDrawingShower){
    Graphics g = mainimg.getGraphics();
    // Draw graph
    g.setColor(Color.WHITE);
    g.fillRect(0, 0, 496, 163);
    g.setColor(Color.black);
    g.drawLine(0,0, 496,0);
    if(!isParametric){
    float i = minimumOut;
    int ind = 20;
    LinkedList l = out.value;
    float maximum = 0;
    float minimum = 0;
    //find maximum
    for(int in = 0;in<l.size();in++){
    if((float)l.get(in)>maximum&&Float.isFinite((float)l.get(in))&&!Float.isNaN((float)l.get(in))){
    maximum = (float)l.get(in);
    }
    }

    for(int in = 0;in<l.size();in++){
    if((float)l.get(in)<minimum&&Float.isFinite((float)l.get(in))&&!Float.isNaN((float)l.get(in))){
    minimum = (float)l.get(in+begin);
    }
    }
    while(ind+1<out.value.size()){

      g.drawLine(ind, 163-(int)(((out.value.get(ind)-minimum)/(maximum-minimum))*163f), ind, 163-(int)(((out.value.get(ind+1)-minimum)/(maximum-minimum))*163f)); 
      i += 1.0/resolution;
      ind++;
    }
    System.out.println((((1-minimum)/(maximum-minimum))));
    }
    // Draw scale
    g.setColor(Color.BLACK);
    g.setFont(new Font("Serif", 0, 9));
    g.drawString(String.valueOf(minimumOut), 0, 163);
    g.drawString(String.valueOf(maximumOut), 0,12);
  }else if(ux <= 496){
    userimg = new BufferedImage(496, 163, BufferedImage.TYPE_4BYTE_ABGR);
  Graphics g = userimg.getGraphics();
  // g.setColor(clearWhite);
  // g.fillRect(0, 0, 496, 163);
  g.setColor(Color.black);

  g.drawLine(0,0, 496,0);
  g.drawLine(ux, 0, ux, 163);
  g.drawString("y: "+String.valueOf(out.value.get(ux+begin)), ux, 106);
  g.drawString("x: "+String.valueOf(((float)(ux+begin))/10), ux, 57);
}

  g1.drawImage(mainimg, 0, 0, null); 

  if(isDrawingShower){
  g1.drawImage(userimg, 0, 0, null);
  }

  }   
}       

public void render(){
inGraph.paint(inGraph.getGraphics());
outGraph.paint(outGraph.getGraphics());
panel.repaint();
panel.revalidate();
}
}
