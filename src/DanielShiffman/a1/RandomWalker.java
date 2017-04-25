package DanielShiffman.a1;

import java.applet.Applet;

import processing.core.PApplet;

public class RandomWalker extends PApplet {

	class Waller {
		int x;
		int y;
		
		public Waller() {
		 x = width / 2;
		 y = height / 2;
		}
		
		void display() {
			stroke(0);
			point(x, y);
		}
		
		void step() {
			int choice = (int) random(4); //随机游走，四种情况
			if(choice == 0) {
				x++;
			} else if(choice == 1 ) {
				x--;
			}  else if(choice == 2) {
				y++;
			}else {
				y--;
			}
		}
	}
	
	
	Waller w;
	
	@Override
	public void settings() {
		super.settings();
		size(640, 360);
	}
	
	@Override
	public void setup() {
		super.setup();
		w = new Waller();
		background(255);
	}
	
	@Override
	public void draw() {
	//	super.draw();
		w.step();
		w.display();
	}
	
	
	
	public static void main(String[] argc) {
		PApplet.main("DanielShiffman.RandomWalker");
	}
	
}
