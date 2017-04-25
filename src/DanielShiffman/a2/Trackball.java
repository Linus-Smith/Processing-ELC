
package DanielShiffman.a2;

import java.applet.Applet;

import processing.core.PApplet;

public class Trackball extends PApplet{
	
	float x = 100;  //小球的位置和速度变量
	float y = 100;   
	
	float xspeed = 1;
	float yspeed = 3.3f;
	
	@Override
	public void settings() {
		// TODO Auto-generated method stub
		super.settings();
		size(200, 200);
	}
	
	@Override
	public void setup() {
		// TODO Auto-generated method stub
		super.setup();
		smooth();
		background(255);
	}
	
	
	
	public static void main (String[] argc) {
		PApplet.main("DanielShiffman.a2.Trackball");
	}
}