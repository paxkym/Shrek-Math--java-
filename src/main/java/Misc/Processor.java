package src.main.java.Misc;

import java.util.ArrayList;

import src.main.java.Tabs.Tab;
import src.main.java.Windows.ViewWindow;

public class Processor {
public int resolution = 10;
public ArrayList<ViewWindow> views = new ArrayList<ViewWindow>();

public void renderViews(){
for(int i = 0;i<views.size();i++)(views.get(i)).render();
}
public void process(ArrayList<Tab> in){
for(int i = 0;i<in.size();i++){in.get(i).process();};
renderViews();
return;
}
}
// import java.io.File;
// import java.io.FileWriter;
// import java.io.IOException;
// import java.util.ArrayList;

// public class Com1 {
// public static void main(String args[]){
// ArrayList<Float> input = new ArrayList<Float>();
// File com2 = new File("Com2.txt");
// try {
//     FileWriter writer = new FileWriter("Com2.txt");
//     writer.write("Hello, world!");
// } catch (IOException e) {
//     // TODO Auto-generated catch block
//     e.printStackTrace();
// }
// return;
// }
// }

// import java.io.File;\nimport java.io.FileWriter;\nimport java.io.IOException;\nimport java.util.ArrayList;\npublic class Com1 {\npublic static void main(String args[]){\nArrayList<Float> input = new ArrayList<Float>();\nFile com2 = new File("Com2.txt");\ntry {\nFileWriter writer = new FileWriter("Com2.txt");\nwriter.write("Hello, world!");\n} catch (IOException e) {\ne.printStackTrace();}}}
