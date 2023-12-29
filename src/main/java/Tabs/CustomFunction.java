package src.main.java.Tabs;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.JOptionPane;

public class CustomFunction extends Tab{

// public CustomFunction(){

// }

public void process(){
// Runs script
File com2 = new File("Com2.txt");
String c1Name = "";
// c1Name = com2.getAbsolutePath();
// int count = 0;
// int count2 = 0;
// for(int i = c1Name.length()-1;i>0;i--){
// if(c1Name.charAt(i) == '/'){
// count++;
// }
// if(count == 0){
// count2 = i;
// break;
// }
// }
// c1Name = "";
// for(int i = 0;i<count2;i++) c1Name += (com2.getAbsolutePath().charAt(i));
// System.out.println(c1Name);
File com1 = new File("Com1.java");
    //Write Java program to file
      try {
        FileWriter myWriter = new FileWriter("Com1.java");
        myWriter.write("import java.io.File;\n" + //
                "import java.io.FileWriter;\n" + //
                "import java.io.IOException;\n" + //
                "import java.util.ArrayList;\n" + //
                "public class Com1 {\n" + //
                "ArrayList<Float> input = new ArrayList<Float>();\n" + //
                "ArrayList<Float> output = new ArrayList<Float>();\n" + //
                "\n" + //
                "public static void run(){\n" + //
                "\n" + //
                text +
                "}\n" + //
                "public static void main(String args[]){\n" + //
                "try{run();}catch(Exception e){\n" + //
                "FileWriter writer;\n" + //
                "try {\n" + //
                "    writer = new FileWriter(\"Com2.txt\");\n" + //
                "    writer.write(e.getMessage());\n" + //
                "    writer.close();\n" + //
                "} catch (IOException e1) {}\n" + //
                "}\n" + //
                "File com2 = new File(\"Com2.txt\");\n" + //
                "}}");
        myWriter.close();
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }

    
    //Run program
    ProcessBuilder p =
    new ProcessBuilder("java", com1.getAbsolutePath());
    try {
        p.start();
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
Scanner fr;
LinkedList<String> str = new LinkedList<String>();
    try {
        fr = new Scanner(com2);
        while (fr.hasNextLine()) {
        str.add(fr.nextLine());
      }
      fr.close();
    } catch (FileNotFoundException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
String out = "";
for(int i = 0;i<str.size();i++) out += str.get(i);
if(out.charAt(0) != '{') result = out; else result = "";
ptext = text;
}
}
