import java.awt.Button;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class GUI {
	static class MyGUI extends JFrame {
		public MyGUI() {
			DAO dao = new DAO();
			DTO scodto = new DTO();
			
			Button btn1 = new Button("이름");
			JTextField jtf = new JTextField();
			Button btn2 = new Button("국어");
			JTextField jtf2 = new JTextField();
			Button btn3 = new Button("수학");
			JTextField jtf3 = new JTextField();
			Button btn4 = new Button("영어");
			JTextField jtf4 = new JTextField();
			JButton jbtn1 = new JButton("추가");
			JButton jbtn2 = new JButton("제거");
			JButton jbtn3 = new JButton("수정");

			GridLayout layout = new GridLayout(1, 2, 10, 10);
			GridLayout p1 = new GridLayout(4, 1);

			JFrame f = new JFrame();
			JPanel panel = new JPanel();

			f.setTitle("Average");
			f.setSize(800, 300);
			f.setLocation(500, 300);
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

			Vector title = new Vector();
			title.add("이름");
			title.add("국어");
			title.add("수학");
			title.add("영어");
			title.add("총점");
			title.add("평균");
			
			Vector contents = dao.getScore();

			DefaultTableModel model = new DefaultTableModel(contents, title);

			JTable table = new JTable(model);
			JScrollPane sp = new JScrollPane(table);
			f.add(sp);

			f.setVisible(true);

			jbtn1.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					String name = jtf.getText();
					int kor = Integer.parseInt(jtf2.getText());
					int math = Integer.parseInt(jtf3.getText());
					int eng = Integer.parseInt(jtf4.getText());

					int total = kor + math + eng;
					int average = total / 3;

					scodto.setName(name);
					scodto.setKor(kor);
					scodto.setMat(math);
					scodto.setEng(eng);
					scodto.setTot(total);
					scodto.setAve(average);
					
					dao.insertScore(scodto);

					//Vector contents = dao.getScore();
					
					// TODO
					Vector<String> row = new Vector<String>();

					row.add(name);
					row.add(Integer.toString(kor));
					row.add(Integer.toString(math));
					row.add(Integer.toString(eng));
					row.add(Integer.toString(total));
					row.add(Integer.toString(average));

					model.addRow(row);
					
					jtf.setText("");
					jtf2.setText("");
					jtf3.setText("");
					jtf4.setText("");

					String retMsg = String.format("추가완료");

					JOptionPane.showMessageDialog(table, retMsg, "추가", JOptionPane.INFORMATION_MESSAGE);
				}
			});

			jbtn2.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					int selection = table.getSelectedRow();
					
					Object name = table.getValueAt(selection, 0);
										
					System.out.println(name);
				
					scodto.setName(name.toString());
					dao.deleteScore(scodto);
					
					// TODO
					model.removeRow(selection);
					
					String retMsg = String.format("삭제완료");

					JOptionPane.showMessageDialog(table, retMsg, "삭제", JOptionPane.INFORMATION_MESSAGE);
				}

			});

			jbtn3.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					String name = jtf.getText();
					int kor = Integer.parseInt(jtf2.getText());
					int math = Integer.parseInt(jtf3.getText());
					int eng = Integer.parseInt(jtf4.getText());

					int total = kor + math + eng;
					int average = total / 3;

					scodto.setKor(kor);
					scodto.setEng(eng);
					scodto.setMat(math);
					scodto.setTot(total);
					scodto.setAve(average);
					scodto.setName(name);
					
					dao.updateScore(scodto);

					// TODO
					int selection = table.getSelectedRow();

					model.setValueAt(name, selection, 0);
					model.setValueAt(kor, selection, 1);
					model.setValueAt(math, selection, 2);
					model.setValueAt(eng, selection, 3);
					model.setValueAt(total, selection, 4);
					model.setValueAt(average, selection, 5);
					
					jtf.setText("");
					jtf2.setText("");
					jtf3.setText("");
					jtf4.setText("");

					String retMsg = String.format("수정완료");

					JOptionPane.showMessageDialog(table, retMsg, "수정", JOptionPane.INFORMATION_MESSAGE);

				}
			});

			table.addMouseListener(new MouseListener() {

				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub

				}
			});
		}
	}

	public static void main(String[] args) {

		MyGUI mygui = new MyGUI();
	}

}