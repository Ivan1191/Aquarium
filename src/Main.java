import java.io.IOException;

import javax.swing.JFrame;

public class Main {
	public static void main(String[] args) throws IOException {
		Aquarium aq = new Aquarium();
		aq.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		aq.setSize(800, 650);
		aq.setLocation(200, 200);
		aq.setVisible(true);
	}

}
