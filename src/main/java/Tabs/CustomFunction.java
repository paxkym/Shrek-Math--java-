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
static public String readFile(File name){
Scanner fr;
LinkedList<String> str = new LinkedList<String>();
try{
    fr = new Scanner(name);
    while (fr.hasNextLine()) {
    str.add(fr.nextLine());
     }
     fr.close();
    } catch (Exception e){

    }
String out = "";
for(int i = 0;i<str.size();i++) out += str.get(i);
return out;
}
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
File com1t = new File("Com1.txt");
String fc = "";

    //Write Java program to file
      try {
        FileWriter myWriter = new FileWriter("Com1.java");
        myWriter.write(readFile(com1t).split("®")[0]+text+readFile(com1t).split("®")[1]);
        myWriter.close();
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    try {
        FileWriter myWriter = new FileWriter("Com2.txt");
        myWriter.write(("("+realLength+",")+(resolution+",")+(input1!=null?input1.value:""));
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
    } catch (Exception e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
String outi = readFile(com2);

while(outi.charAt(0) == '('){
try {
    Thread.sleep(50);
} catch (InterruptedException e) {}
outi = readFile(com2);
}

if(outi.charAt(0) != '{'){
result = "\nError: "+outi; 
}else{ 
String out = "";
for(int i = 1;i<outi.length()-1;i++) out += outi.charAt(i);
String items[] = out.split(",");

// System.out.print("Items[0]: ");
value = new LinkedList<>();

//for(int i = 0;i<500;i++)output.add(4f);
// System.out.println(items.length);
for(int i = 0;i<items.length;i++){value.add(Float.valueOf(items[i]));}
result = "";
};
result += "\nPrint:"+CustomFunction.readFile(new File("Com3.txt"));

ptext = text;
}
}
