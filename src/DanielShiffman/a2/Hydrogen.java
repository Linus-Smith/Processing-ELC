package DanielShiffman.a2;

import processing.core.PApplet;
import processing.core.PVector;

//练习向上升起的气球
public class Hydrogen extends PApplet {

	Mover mover;
	float t = 3;
	
	@Override
	public void settings() {
		size(900, 900);
	}
	
	@Override
	public void setup() {
	  mover = new Mover();
	}
	
	
	@Override
	public void draw() {
		float n = noise(t);
		float y = map(n, 0, 0.1f, 0, 0.1f);
		mover.addForce(new PVector(0, y));
		t+= 0.01;
		mover.update();
		mover.display();
	}
	
	class Mover {
		PVector location;  //最终位置
		PVector velocity; //速度
		PVector acceleration;//加速度
		
		int direction;
		static final int UP = -1;
		static final int DOMWS = 1;
		
		
		int windBan;
		static final int TO_LEFT_BAN = -2;
		static final int TO_RIGHT_BAN = 2;
		static final int NORMAL = 0;
		
	    Mover() {
	    	location = new PVector(width / 2, height -96 / 2); //从底部开始
	    	velocity = new PVector(0, 10.5f ); // 上升起
	    	acceleration = new PVector(); 
		}
	    
	    void addForce(PVector force) {
	    	acceleration.add(force);
	    }
	    
	    void update() {
	    	velocity.add(acceleration);
	    	if(location.y >= (height -96 / 2)) direction = UP;
	    	if(location.y <= (96 / 2)) direction = DOMWS; 
	    	
	    	if(location.x  < (96 / 2)) windBan = TO_LEFT_BAN;
	    	else if(location.x  > (width -96 / 2)) windBan = TO_RIGHT_BAN;
	    	else windBan = NORMAL;
	    	
	    	if(direction == UP) {
     	    	location.sub(velocity);
 	    	} else if(direction == DOMWS) {
 	    		location.add(velocity);
	    	}
	    	
	    	if(location.x  < (96 / 2)) location.x = 96 / 2;
	    	else if(location.x  > (width -96 / 2)) location.x = width - 96 / 2;
	    	else windBan = NORMAL;
	    	acceleration.mult(0);
	    }
	    
	    void display() {
	    	background(255);
	    	//stroke(random(255),random(255), random(255));
			fill(23,34, 245);
	    	ellipse(location.x, location.y, 96, 96);
	    }
	}
	
	public static void main(String[] args) {
		PApplet.main("DanielShiffman.a2.Hydrogen");
	}
}
