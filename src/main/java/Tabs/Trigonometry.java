package src.main.java.Tabs;

import java.util.LinkedList;

public class Trigonometry extends Tab{
public String type = "Trigonometry";

public void process(){
LinkedList<Float> input = input1.value;
value = new LinkedList<Float>();
if(subtype == 0){
for(int i = 0;i<input.size();i++) value.add((float)Math.sin((float)input.get(i)));
if(isInverse){
for(int i = 0;i<input.size();i++) value.add((float)Math.asin((float)input.get(i)));
}
}
if(subtype == 1){
for(int i = 0;i<input.size();i++) value.add((float)Math.cos((float)input.get(i)));
if(isInverse){
for(int i = 0;i<input.size();i++) value.add((float)Math.acos((float)input.get(i)));
}
}
if(subtype == 2){
for(int i = 0;i<input.size();i++) value.add((float)Math.tan((float)input.get(i)));
if(isInverse){
for(int i = 0;i<input.size();i++) value.add((float)Math.atan((float)input.get(i)));
}
}
if(subtype == 3){
for(int i = 0;i<input.size();i++) value.add((float)(Math.sin((float)input.get(i))/(i/10)));
}
if(subtype == 4){
for(int i = 0;i<input.size();i++) value.add((float)Math.sinh((float)input.get(i)));
}
if(subtype == 5){
for(int i = 0;i<input.size();i++) value.add((float)Math.cosh((float)input.get(i)));
}
if(subtype == 6){
for(int i = 0;i<input.size();i++) value.add((float)Math.tanh((float)input.get(i)));
}

}
}
