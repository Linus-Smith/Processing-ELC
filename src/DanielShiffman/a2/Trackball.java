
package DanielShiffman.a2;

import java.applet.Applet;

import processing.core.PApplet;
import processing.core.PVector;

public class Trackball extends PApplet{
	
	
	Mover mover;
	
	@Override
	public void settings() {
		// TODO Auto-generated method stub
		super.settings();
		size(1500, 1500);
	}
	
	@Override
	public void setup() {
		// TODO Auto-generated method stub
		super.setup();
		smooth();
		mover = new Mover();
		background(255);
	}
	
	@Override
	public void draw() {
	 // background(255);
	  mover.update();
	  mover.checkEdes();
	  mover.display();
	}
	
	class Mover{
		PVector localtion;
		PVector velocity;
		PVector acceleration;
		
		public Mover() {
			localtion = new PVector(random(width), random(height));
			velocity = new PVector(0, 0);
			acceleration = new PVector(-0.001f, 0.01f);
		}
		
		void update() {
			PVector mouse = new PVector(mouseX, mouseY);
			PVector dir = PVector.sub(mouse, localtion);
			dir.normalize();
		    acceleration =	dir.mult(0.5f);
		    velocity.add(acceleration);
			velocity.limit(10);
			localtion.add(velocity);
		}
		
		void display() {
			stroke(random(255),random(255), random(255));
			fill(random(255),random(255), random(255));
			ellipse(localtion.x, localtion.y, 96, 96);
		}
		
		void checkEdes() {
			if(localtion.x > width) {
				localtion.x = 0;
			} else if(localtion.x < 0) {
				localtion.x = width;
			}
			
			if(localtion.y > height) {
				localtion.y = 0;
			} else if(localtion.y < 0) {
				localtion.y = height;
			}
		}
		
	}
	
	
	
	public static void main (String[] argc) {
		PApplet.main("DanielShiffman.a2.Trackball");
	}
}