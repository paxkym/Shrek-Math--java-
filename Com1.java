import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
public class Com1 {
ArrayList<Float> input = new ArrayList<Float>();
ArrayList<Float> output = new ArrayList<Float>();

public static void run(){

}
public static void main(String args[]){
try{run();}catch(Exception e){
FileWriter writer;
try {
    writer = new FileWriter("Com2.txt");
    writer.write(e.getMessage());
    writer.close();
} catch (IOException e1) {}
}
File com2 = new File("Com2.txt");
}}