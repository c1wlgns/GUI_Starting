import java.awt.*;
import javax.swing.*;

public class MyFrame extends JFrame {
	public MyFrame() {
		setSize(600, 150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Average");
		
		JPanel panel;
		panel = new JPanel();
		panel.setLayout(new FlowLayout());
		panel.add(new Button("�̸�"));
		panel.add(new JTextField(10));
		panel.add(new JButton("�߰�"));
		

		/*Button btn2 = new Button("����");
		JTextField field2 = new JTextField(10);
		JPanel panel2 = new JPanel();
		JButton jbtn2 = new JButton("����");
		panel2.add(jbtn2);

		Button btn3 = new Button("����");
		JTextField field3 = new JTextField(10);
		JPanel panel3 = new JPanel();
		JButton jbtn3 = new JButton("����");
		panel3.add(jbtn3);

		Button btn4 = new Button("����");
		JTextField field4 = new JTextField(10);
		
		
		setVisible(true);*/

	} 

}
