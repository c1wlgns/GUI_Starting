
import java.awt.Button;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class GUI {
	static class MyGUI extends JFrame {
		public MyGUI() {
			Button btn1 = new Button("�̸�");
			JTextField jtf = new JTextField();
			Button btn2 = new Button("����");
			JTextField jtf2 = new JTextField();
			Button btn3 = new Button("����");
			JTextField jtf3 = new JTextField();
			Button btn4 = new Button("����");
			JTextField jtf4 = new JTextField();
			Button btn5 = new Button("JAVA");
			JTextField jtf5 = new JTextField(10);
			Button btn6 = new Button("�׷���");
			JTextField jtf6 = new JTextField(10);
			JButton jbtn1 = new JButton("�߰�");
			JButton jbtn2 = new JButton("����");
			JButton jbtn3 = new JButton("����");
			JButton jbtn4 = new JButton("Ŭ��");
			JButton jbtn5 = new JButton("����");

			GridLayout layout = new GridLayout(1,2,10,10);
			GridLayout p1 = new GridLayout(6,3);
			
			JFrame f = new JFrame();
			JPanel panel = new JPanel();
			
			f.setTitle("Average");
			f.setSize(800, 600);
			f.setLayout(layout);
			f.add(panel);
			
			panel.setLayout(p1);
			panel.add(btn1);
			panel.add(jtf);
			panel.add(jbtn1);
			panel.add(btn2);
			panel.add(jtf2);
			panel.add(jbtn2);
			panel.add(btn3);
			panel.add(jtf3);
			panel.add(jbtn3);
			panel.add(btn4);
			panel.add(jtf4);
			panel.add(jbtn4);
			panel.add(btn5);
			panel.add(jtf5);
			panel.add(jbtn5);
			panel.add(btn6);
			panel.add(jtf6);
			
			
			String title [] = {"�̸�","����","����","����","JAVA","�׷���","����","���"};
	 		String contents[][]= {};
	 		JTable table = new JTable(contents, title);
	 		JScrollPane sp = new JScrollPane(table);
	 		f.add(sp);

	 		f.setVisible(true);
	 		
		}
	}

	public static void main(String[] args) {
		MyGUI mygui = new MyGUI();
	}

}