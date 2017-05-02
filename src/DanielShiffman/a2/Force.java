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
		PVector location;  //�����λ��
		PVector velocity; //�ٶ�
		PVector acceleration; //���ٶ�
		float mass;   //��һ��float��������
		
		public Mover() {
			location = new PVector(0, 0);
			velocity = new PVector(0.5f, 0.5f);
			acceleration = new PVector();
		}
		
		void applyForce(PVector force) {
			//acceleration = force;  //ţ�ٵڶ����ɼ�ʵ�ַ�ʽ��F / 1 = F    A = F��
			acceleration.add(force);  //ţ�ٵڶ����ɺ������ۼӣ����Ƿֱ�ÿ���������ڼ��ٶ���
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
