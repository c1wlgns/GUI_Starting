import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;

public class IMG extends JFrame {
	public IMG() {
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		setSize(300,200);
		setLocation(screenSize.width/2, screenSize.height/2);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("IMG");
		Image img = kit.getImage("icon.gif");
		setIconImage(img);
		setLayout(new FlowLayout());
		JButton button = new JButton("Button");
		this.add(button);
		setVisible(true);
	}

}
