

import java.awt.Button;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

public class GUI {
	static class MyGUI extends JFrame {
		MyGUI() {
			JFrame f = new JFrame();
			setLayout(new GridLayout(4, 1, 10, 10));
			// GridLayout g = new GridLayout(4,1,10,10);
			JPanel p = new JPanel(new GridLayout(4, 1, 10, 10));
			// this.setLayout(g);

			JPanel p1 = new JPanel();
			JPanel p2 = new JPanel();
			JPanel p3 = new JPanel();
			JPanel p4 = new JPanel();
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			f.setTitle("Average");
			setSize(800, 600);

			Button btn1 = new Button("이름");
			JTextField jtf1 = new JTextField(10);
			JButton jbtn1 = new JButton("추가");
			this.add(p1);

			Button btn2 = new Button("국어");
			JTextField jtf2 = new JTextField(10);
			JButton jbtn2 = new JButton("제거");
			this.add(p2);

			Button btn3 = new Button("수학");
			JTextField jtf3 = new JTextField(10);
			JButton jbtn3 = new JButton("수정");
			this.add(p3);

			Button btn4 = new Button("영어");
			JTextField jtf4 = new JTextField(10);
			JButton jbtn4 = new JButton("*****");
			this.add(p4);

			p1.add(btn1);
			p1.add(jtf1);
			p1.add(jbtn1);

			p2.add(btn2);
			p2.add(jtf2);
			p2.add(jbtn2);

			p3.add(btn3);
			p3.add(jtf3);
			p3.add(jbtn3);

			p4.add(btn4);
			p4.add(jtf4);
			p4.add(jbtn4);
			
			JTable jtb = new JTable();
			//JScrol jsc= new JScrol();

			//f.setLayout();
			//f.add(p);
			f.pack();
			setVisible(true);

		}
	}

	public static void main(String[] args) {
		MyGUI mygui = new MyGUI();
	}

}