package DanielShiffman.a1;

import processing.core.PApplet;

public class Perline extends PApplet {

	float t = 3;
	
	@Override
	public void settings() {
		// TODO Auto-generated method stub
		super.settings();
		size(1080, 1920);
	}
	
	@Override
	public void draw() {
		float n = noise(t);
		float x = map(n , 0, 1, 0, width);
		ellipse(x, 480, 40, 40);
		t += 0.01;
	}
	
	public static void main(String[] args) {
		PApplet.main("DanielShiffman.a1.Perline");
	}

}
