package DanielShiffman.a1;

import java.util.Random;

import processing.core.PApplet;

public class RandomGaussian extends PApplet {

	Random generator;
	
	@Override
	public void settings() {
		// TODO Auto-generated method stub
		super.settings();
		size(640, 360);
	}
	
	@Override
	public void setup() {
		// TODO Auto-generated method stub
		super.setup();
		generator = new Random();
	}
	
	@Override
   public void draw() {
		float num  = (float)generator.nextGaussian();
		System.out.println(num+"=======");
		float sd = 60;
		float mean = 320;
		float x = sd * num + mean; //乘以标准差，再加上平均值
		
		noStroke();
		fill(255, 10);
		ellipse(x, 180, 160, 160);
	}
	
	public static void main(String[] argc) {
		PApplet.main("DanielShiffman.a1.RandomGaussian");
	}
}
