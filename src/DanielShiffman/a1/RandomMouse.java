package DanielShiffman.a1;

import processing.core.PApplet;

public class RandomMouse extends PApplet {

	
	class Waller{
		int x;
		int y;
		
		public Waller() {
			x = width / 2;
			y = height /2;
		}
		
		public void displayer() {
			float num = random(1);
			if(num < 0.5) {
				x = mouseX;
				y = mouseY;
			}
			
			stroke(0);
			point(x, y);
		}
	}
	
	Waller w;
	
	@Override
	public void settings() {
		super.settings();
		size(640, 360);
	}
	
	@Override
	public void setup() {
		super.setup();
		w = new Waller();
		background(255);
	}
	
	@Override
	public void draw() {
	//	super.draw();
		w.displayer();
	}
	
	
	
	public static void main(String[] argc) {
		PApplet.main("DanielShiffman.RandomMouse");
	}
}
