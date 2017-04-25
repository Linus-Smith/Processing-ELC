package DanielShiffman.a1;

import processing.core.PApplet;

public class RandomCount  extends PApplet{
	
	int[] randomCounts;
	
	@Override
	public void settings() {
		super.settings();
		size(640, 240);
	}
	
	@Override
	public void setup() {
		super.setup();
		randomCounts = new int[20];
	}
	
	@Override
	public void draw() {
		background(255);
		int index = (int)random(randomCounts.length);
		randomCounts[index]++;
		float i = random(1);
		System.out.println(i);
		stroke(0);
		fill(127);
		int w = width / randomCounts.length;
	
		for(int x = 0; x < randomCounts.length; x++) {
			rect(x * w , height - randomCounts[x], w - 1, randomCounts[x]);
		}
	}
			
	public static void main(String[] argc) {
		PApplet.main("DanielShiffman.RandomCount");
	}

}
