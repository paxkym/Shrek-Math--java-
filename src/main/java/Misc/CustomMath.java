package src.main.java.Misc;

public class CustomMath {


public double[] complexRoot(double index, double x, double y){
double output[] = new double[2];
// Stolen from wikipedia
output[0] = Math.pow(((x*x)+(y*y)),((index)/2))*Math.cos((index)*Math.atan2(y,x));
output[1] =Math.pow(((x*x)+(y*y)),((index)/2))*Math.sin((index)*Math.atan2(y,x));
return output;
}
// TODO: create complex sine function, use this for e to the power of function
public double[] eToThePowerOf(double x, double y){
double output[] = new double[2];

return complexRoot(2, x, y);
}

public CustomMath(){

}
public void start(){
eToThePowerOf(4d, 1d);
// System.out.print(eToThePowerOf(4d, 0d)[0]);
// System.out.print(", ");
// System.out.println(eToThePowerOf(4d, 0d)[1]);
}
}
