package src.main.java.Tabs;

import java.util.LinkedList;

public class CustomWave extends Tab{
public String type = "Custom Wave";
public CustomWave(){
value = new LinkedList<Float>();
for(int i = 0;i<realLength;i++)value.add(0f);
}
public void process(){
LinkedList<Float> output = new LinkedList<Float>();
        double peak = max;
        float freqc = 10f/(float)freq;
        if(subtype == 0){
          int i = 0;
          boolean up = false;
          while(i<length){
          up = (i%(int)freqc*2)==0?!up:up;
          if(up){
          output.add((float)min);
         }else{
          output.add((float)peak);
          }
          i++;
        }
      }
        if(subtype == 1){
          int i = 0;
          float i2 = 0;
          boolean up = true;
          freqc /= 10;
          while(i<length){
        if(i2>peak){
          up = false;
        }else if(i2<0){
          up = true;
        }
        if(up){
          i2 += (float)peak/((float)freqc*(float)resolution);
        }else if(!up){
          i2 -= (float)peak/((float)freqc*(float)resolution);
          }
          output.add((float)i2);
          i++;
        }
        }
        if(subtype == 3){
          int i = 0;
          double i2 = min;
          boolean up = true;
          freqc /= 10;
          while(i<length){
        if(i2>peak){
          up = false;
        }else if(i2 <= min){
          up = true;
        }
        if(up){
          i2 += ((float)peak/((float)freqc*(float)resolution))/2f;
        }else if(!up){
          i2 = min;
          }
          output.add((float)i2);
          i++;
        }
        }
        if(subtype == 4){
          int i = 0;
          double i2 = peak;
          freqc /= 10;
          while(i<length){
        if(i2 >= min){
          i2 -= ((float)peak/((float)freqc*(float)resolution))/2f;
        }else if(i2 <= min){
          i2 = peak;
          }
          output.add((float)i2);
          i++;
        }
        }
        if(subtype == 2){
          int i = 0;
          float i2 = 0;
          while(i<length){
            output.add((float)(Math.sin(Math.PI * i2)*peak));
            i++;
            i2 += 1f/(float)freqc;  
          }  
          System.out.println((float)Math.sin(Math.PI * (1f/(float)freqc)*20)*peak);
        }
        if(subtype == 5){
          float i = 0;
          float i2 = min;
          while(i<length){
            output.add((float)i2);
            i++;
            i2 += 1f/freq;
          }
        System.out.println(1f/freq);
        }
        if(subtype == 6){
          int i = 0;
          int i2 = 0;
          double randint = (((Math.random()-min)/(max-min))*max);
          while(i<length){
            if(i2 == 10/freq){
              randint = (((Math.random()-min)/(max-min))*max);
            i2 = 0;
            }
            output.add((float)randint);
            i++;
            i2++;
          }
        }

value = new LinkedList<Float>();
for(int i = 0;i<realLength;i++)value.add(0f);
for(int i = 0;i<value.size()&&i<output.size();i++)value.set(i, output.get(i));
System.out.print("Value length: ");
System.out.println(value.size());
}
}
