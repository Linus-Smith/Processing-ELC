package DanielShiffman.a2;

import DanielShiffman.a2.Trackball.Mover;
import processing.core.PApplet;
import processing.core.PVector;

public class Force extends PApplet {
	
	Mover mover;
	
	@Override
	public void settings() {
	  size(1000, 1000);	
	}
	
	@Override
	public void setup() {
		smooth();
		mover = new Mover();
		background(255);
	}
	
	@Override
	public void draw() {
	if(mousePressed) {
	 PVector wind = new PVector(0.1f, 0.1f);
	 mover.applyForce(wind);
	
	}
	 mover.update();
	 mover.display();
	}
	
	
	class Mover {
		PVector location;  //自身的位置
		PVector velocity; //速度
		PVector acceleration; //加速度
		float mass;   //用一个float代表质量
		
		public Mover() {
			location = new PVector(0, 0);
			velocity = new PVector(0.5f, 0.5f);
			acceleration = new PVector();
		}
		
		void applyForce(PVector force) {
			//acceleration = force;  //牛顿第二定律简单实现方式；F / 1 = F    A = F　
			acceleration.add(force);  //牛顿第二定律和力的累加，我们分别将每个力作用在加速度上
		}
		
		void  update() {
			velocity.add(acceleration);
			location.add(velocity);
			acceleration.mult(0);
		}
		
		void display() {
			stroke(random(255),random(255), random(255));
			fill(random(255),random(255), random(255));
			ellipse(location.x, location.y, 96, 96);
		}
	}
	
	
	public static void main(String[] argc) {
		PApplet.main("DanielShiffman.a2.Force");
	}
}
