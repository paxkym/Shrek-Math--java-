package src.main.Tabs;

import javax.swing.JButton;
import javax.swing.JPanel;

public class CustomWave extends Tab {
   public final String type = "CustomWave";

   public JPanel buildTab(){
      JPanel panel = new JPanel();
      
      panel.add(new JButton("HI"));

      return panel;
   }

   
}
