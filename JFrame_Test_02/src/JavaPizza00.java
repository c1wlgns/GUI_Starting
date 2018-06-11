import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class JavaPizza00 extends JFrame {

	public JavaPizza00() {
		setSize(600, 150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("JavaPizza HomePage");

		JPanel panel = new JPanel();
		JPanel panelA = new JPanel();
		JPanel panelB = new JPanel();

		JLabel label1 = new JLabel("자바 피자에 오신 것을 환영합니다. 피자의 종류를 선택하십시오.");
		panelA.add(label1);

		JButton button1 = new JButton("Combo");
		JButton button2 = new JButton("Pott");
		JButton button3 = new JButton("Bullgogi");
		panelB.add(button1);
		panelB.add(button2);
		panelB.add(button3);

		JLabel label2 = new JLabel("Count");
		JTextField field1 = new JTextField(10);
		panelB.add(label2);
		panelB.add(field1);

		panel.add(panelA);
		panel.add(panelB);
		add(panel);
		setVisible(true); 
	}

}


