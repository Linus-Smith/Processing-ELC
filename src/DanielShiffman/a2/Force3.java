package DanielShiffman.a2;

import processing.core.PApplet;
import processing.core.PVector;

/**
 *  ��ϰĦ������
 * @author Linus
 *
 */
public class Force3 extends PApplet {

	Terrain mTerrain;
	
	@Override
	public void settings() {
		size(900, 900);
	}
	
	@Override
	public void setup() {
		mTerrain = new Terrain(0, height / 2, width, height / 2, 0.2f);
	}
	
	@Override
	public void draw() {
		mTerrain.display();
	}
	
	/**
	 * @author Linus
	 * ģ��һ������
	 */
	class Terrain {
		float x; float y; float w; float h;
		float fn; // f = UFN;
		
		Terrain(float x, float y, float w, float h, float fn) {
			this.x = x;
			this.y = y;
			this.w = w;
			this.h = h;
			this.fn = fn;
		}
		
		PVector calculateFriction(PVector velocity) { //����Ħ����
			PVector friction = velocity.copy();
			friction.normalize(); //�õ���׼����
			friction.mult(-1); //�����˶�
			friction.mult(fn);
			return friction;
			
		}
		
		void display() {
			line(x, y, w, h);
		}
		
	}
	
	class Circle {
		PVector location; //����λ��
		PVector velocity; // �ٶ�
		PVector acceleration; //���ٶ�
		float mass; //�ܶ�
		
	     Circle(float mass, float x, float y) {
	    	 this.mass = mass;
	    	 location = new PVector(x, y);
	    	 velocity = new PVector(0.1f, 0);
	    	 acceleration = new PVector();
		}
	     
	    void applyFroce(PVector force) {//ţ�ٵڶ�����  F = M * A    A = F \ M 
	    	PVector f = PVector.div(force, mass);//���������������õ����ٶ�
	    	acceleration.add(f);
	    }
		
	}
	
	public static void main(String[] args) {
		PApplet.main("DanielShiffman.a2.Force3");
	}
}
