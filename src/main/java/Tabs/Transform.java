package src.main.java.Tabs;

import java.util.ArrayList;
import java.util.LinkedList;

public class Transform extends Tab{

public void process(){
int length = 2000;
float avg = 0;
ArrayList<Float> input = new ArrayList<Float>();
value = new LinkedList<Float>();
for(float i : input1.value) input.add(i);

for(int i2 = 0;i2<length;i2++){
for(int i = 0;i<100;i++){
avg += input.get(i)*Math.sin(((((float)i2)/10f)*(((float)i)/10f))*6.28318d);
// avg += Math.sin(i*0.4*3.14159)+Math.cos(((((float)i2)/10f)*(((float)i)/10f))*6.28318d);
}

avg /= input.size();
value.add(avg);
avg = 0;
}
}
}
