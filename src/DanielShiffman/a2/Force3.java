package DanielShiffman.a2;

import processing.core.PApplet;
import processing.core.PVector;

/**
 *  练习摩擦力，
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
	 * 模拟一个地面
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
		
		PVector calculateFriction(PVector velocity) { //计算摩擦力
			PVector friction = velocity.copy();
			friction.normalize(); //得到标准向量
			friction.mult(-1); //反向运动
			friction.mult(fn);
			return friction;
			
		}
		
		void display() {
			line(x, y, w, h);
		}
		
	}
	
	class Circle {
		PVector location; //自身位置
		PVector velocity; // 速度
		PVector acceleration; //加速度
		float mass; //密度
		
	     Circle(float mass, float x, float y) {
	    	 this.mass = mass;
	    	 location = new PVector(x, y);
	    	 velocity = new PVector(0.1f, 0);
	    	 acceleration = new PVector();
		}
	     
	    void applyFroce(PVector force) {//牛顿第二定律  F = M * A    A = F \ M 
	    	PVector f = PVector.div(force, mass);//将力除以质量，得到加速度
	    	acceleration.add(f);
	    }
		
	}
	
	public static void main(String[] args) {
		PApplet.main("DanielShiffman.a2.Force3");
	}
}
