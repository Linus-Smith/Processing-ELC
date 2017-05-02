package DanielShiffman.a2;

import processing.core.PApplet;
import processing.core.PVector;

public class Force2 extends PApplet {

	Mover[] movers = new Mover[100];
	
	@Override
	public void settings() {
		// TODO Auto-generated method stub
		super.settings();
		size(900, 900);
	}
	
	@Override
	public void setup() {
		// TODO Auto-generated method stub
		super.setup();
		for(int i = 0; i < movers.length; i++) {
	    	movers[i] = new Mover(random(0.1f, 5f), 0, 0);
		}
	}
	
	
	@Override
	public void draw() {
		background(255);
		PVector wind = new PVector(0.01f, 0f);
		PVector graviry = new PVector(0f, 0.1f);
		
		for(int i = 0; i < movers.length; i++) {
			float c =0.11f;  //摩擦力
			PVector friction = movers[i].velocity.get();
			friction.mult(-1f);
			friction.normalize();
			friction.mult(c);
			movers[i].applyForce(friction);
			movers[i].applyForce(wind);
			movers[i].applyForce(graviry);
			
			movers[i].update();
			movers[i].display();
			movers[i].checkEdges();
		}
	}
	
	
	class Mover {
		PVector location;
		PVector velocity;
		PVector acceleration;
		float mass;
		
		Mover(float m, float x, float y) {
			mass = m;  //质量为m
			location = new PVector(x, y);
			velocity = new PVector(0, 0);
			acceleration = new PVector(0, 0);
		}
		
		void applyForce(PVector force) { //牛顿第二定律  F = M * A    A = F \ M 
			  PVector f = PVector.div(force, mass);  //将力除以质量，再加上加速度
			  acceleration.add(f);
		}
		
		void update() {
			velocity.add(acceleration);
			location.add(velocity);
			acceleration.mult(0);  //牛顿第一定律 当力不在出现时，物体保持匀速运动，去掉加速度
		}
		
		void display() {
			stroke(0);
			fill(175);
//			stroke(random(255),random(255), random(255));
//			fill(random(255),random(255), random(255));
			ellipse(location.x, location.y, mass * 16, mass * 16); //根据质量改变对象的显示大小
		}
		
		
		void checkEdges (){ //一旦对象触及到窗口边缘，我们就反弹
			if(location.x > width) {
				location.x = width;
				velocity.x *= -1;
			} else if(location.x < 0) {
				velocity.x *= - 1;
				location.x = 0;
			}
			
			if(location.y > height) {
				velocity.y *= -1;
				location.y = height;
			}else if(location.y < 0) {
				velocity.y *= - 1;
				location.y = 0;
			}
		}
	}
	
	
	public static void main(String[] argc) {
		PApplet.main("DanielShiffman.a2.Force2");
	}
}
