package lehigh;

import processing.core.PApplet;

import java.awt.*;


import java.util.Random;



public class MovingBalls extends PApplet {
    int numberofballs = 3;
    float x[]= new float[numberofballs];
    float y[]= new float[numberofballs];
    int speedx[]= new int[numberofballs];
    int speedy[]= new int[numberofballs];

    float color[][]= new float [numberofballs][3];
    Point [] points = new Point [numberofballs];








    int radius = 20;





    public void settings(){
        size(600, 600);
        for (int i =0;i < numberofballs;i++){
            x[i] = (int) random(radius,width-radius);
            y[i] = (int) random(radius,width-radius);
            speedx[i] = (int) random(10);
            speedy[i] = (int)random(10);
            color[i] = new float[]{random(255),random(255),random(255)};


        }
    }

    public void draw() {
        background(0);


for (int i =0;i<numberofballs;i++){

    ellipse(x[i],y[i],40,40);
    x[i] = x[i]+speedx[i];
    y[i] = y[i]+speedy[i];

    if ((x[i]>width)|| (x[i]<0)){speedx[i]= - speedx[i];}
    if ((y[i]>width)|| (y[i]<0)){speedy[i]= - speedy[i];}

}

        for(int i=0;i < points.length ;i++){
            points[i] = new Point((int)x[i],(int)y[i]);
            for (int j = 0; j < points.length; j++) {
                points[j] = new Point((int)x[j],(int)y[j]);
                {
                    if(i==j){j++;}else{
                        linkPoints(points[i],points[j]);}

                }

            }

        }
        mouseClicked();

        }


    public static void main(String[] args) {


        String[] processingArgs = {"MovingBalls"};
        MovingBalls movingBalls = new MovingBalls();
        PApplet.runSketch(processingArgs, movingBalls);


    }
/*public void drawLine( float a,float b, float c,float d){
    if(dist(a,b,c,d)<200 && dist(a,b,c,d)>50 ){
        line(a,b,c,d);
        stroke(255);
        strokeWeight(350/dist(a,b,c,d));
    } else if( dist(a,b,c,d)<50 ){
        line(a,b,c,d);
        stroke(255);
        strokeWeight(8);
    }

}*/
public void linkPoints (Point a, Point b){
    if(dist(a.x,a.y,b.x,b.y)<200 && dist(a.x,a.y,b.x,b.y)>50 ){
        line(a.x,a.y,b.x,b.y);
        stroke(255);
        strokeWeight(350/dist(a.x,a.y,b.x,b.y));
    } else if( dist(a.x,a.y,b.x,b.y)<50 ){
        line(a.x,a.y,b.x,b.y);
        stroke(255);
        strokeWeight(8);
    }
}

public boolean testdist (int a, int b, Point p){
    if(a-p.x>=radius && b-p.y >= radius ){return true;
}else{return false;}}

public Point[] delete(int num, Point arr[]){
  Point[] arrNew = new Point[arr.length -1];
for (int i = num; i <arr.length-1;i++){
    arr[i]=arr[i+1];
}
System.arraycopy(arr,0,arrNew,0,arrNew.length);


    return arrNew;
}

    public void mouseClicked(){
        if(testdist(mouseX, mouseY, points[0])) {

            points = delete(0, points);

            numberofballs = numberofballs - 1;

        }
    }
// recalling
/*
int z[] = new int[]{1,2};
int[]z = new int[2];
z[0]=1;
z[1]=2;
 */
    /*
    class Pet{
    stringname;
    pet(Stringname);
    this.name = name
    }
    Pet mine = new Pet("X")
    mine.name = X
    Pet[]pets = new Pet[2];
    pets[0] = new Pet("X")
     */
    /*
    int[][] colors = new int [number of big arrays; color.length][number of colors];  {{0,0,0},{255,255,255}}
    for(int i=0;i<colors.length;i++){
    colors[i][0]=0;
    colors[i][1]=0;
    colors[i][2]=0;

    int[][] colors = new int [number of big arrays; color.length][]
    for ...
    colors[i] = new int[]{1,2,3};

     */
    //create the array with function


}
