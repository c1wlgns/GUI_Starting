import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame{
	public MyFrame(){
		setSize(300,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("MyFrame");
		setVisible(true);
		
		setLayout(new FlowLayout());
		JButton button = new JButton("��ư");
		this.add(button);
		setVisible(true);
		
	}
}
	class MyFrameTest{
		public static void main(String[] args) {
			MyFrame f = new MyFrame();
		}
	}
