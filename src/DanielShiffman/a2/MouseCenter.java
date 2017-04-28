package DanielShiffman.a2;

import processing.core.PApplet;
import processing.core.PVector;

public class MouseCenter extends PApplet{

	@Override
	public void settings() {
		super.settings();
		size(500, 500);
	}
	
	@Override
	public void draw() {
		background(255);
		PVector mouse = new PVector(mouseX, mouseY);
		PVector center = new PVector(width / 2 , height / 2);
		
		mouse.sub(center);
		mouse.normalize();
		mouse.mult(150);
		translate(width / 2, height / 2);
		line(0, 0, mouse.x, mouse.y);
	}
	
	public static void main(String[] argc) {
		PApplet.main("DanielShiffman.a2.MouseCenter");
		for(int i = -3; i <= 3; ++i) {
			System.out.println(i);
		}
	}
}
