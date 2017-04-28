package DanielShiffman.a1;

import processing.core.PApplet;

public class RandomColorBoard extends PApplet {

	
	
   @Override
  public void settings() {
	super.settings();
	size(720, 720);
   }
   
   @Override
	public void setup() {
		super.setup();
	}
   
   
   @Override
	public void draw() {
		fill(random(255), random(255), random(255), random(255));
		float num = randomGaussian();
		
		float sd = 140;
		float meadX = width / 2;
		float meadY =  100;
		
		float s = 4;
		float w = 20;
		
		float r =  s * num + w;
		noStroke();
		float x = sd * num + meadX;
		float y = sd * num + meadY;
		ellipse(x, y, r, r);
	}
   
	
	public static void main(String[] args) {
		PApplet.main("DanielShiffman.a1.RandomColorBoard");
	}
}
