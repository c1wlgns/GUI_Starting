import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class TranslationServer {
	public static void main(String[] args) throws Exception {
		System.out.println("���� ���� ������ �������Դϴ�.");
		int clientId = 0;
		ServerSocket ss = new ServerSocket(9101);
		try {
			while (true) {
				clientId++;
				Translator t = new Translator(ss.accept(), clientId);
				t.start();
			}
		} finally {
			ss.close();
		}
	}

	private static class Translator extends Thread {
		private Socket socket;
		private int myId;

		public Translator(Socket socket, int clientId) {
			this.socket = socket;
			this.myId = clientId;
		}

		public void run() {
			try {
				BufferedReader in = new BufferedReader
						(new InputStreamReader(socket.getInputStream()));
				PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
				out.println("�ȳ��ϼ���? Ŭ���̾�Ʈ ��ȣ�� " + myId + "�Դϴ�.");
				out.println("�ܾ �Է��ϼ���");
				while (true) {
					String input = in.readLine();
					if(input == null) {
						break;
					}
					if(input.equals("java") == true)
						out.println("java->�ڹ�");
					else
						out.println("���� ���� �ܾ �����ּ���.");
				}
				
			}catch (IOException e) {
				System.out.println("Ŭ���̾�Ʈ ��ȣ: " + myId + "ó������" + e);
			}finally {
				try {
					socket.close();
				}catch (IOException e) {
					System.out.println("���� ���� ����" + e);
				}
				System.out.println("Ŭ���̾�Ʈ ��ȣ: " + myId + "ó�� ó�� ����");
			}
		}
	}

}
class TranslationClient extends JFrame implements ActionListener {
	private BufferedReader in;
	private PrintWriter out;
	private JTextField field;
	private JTextArea area;
	public TranslationClient() throws Exception, IOException {
		setTitle("Ŭ���̾�Ʈ");
		setSize(500,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		field = new JTextField(50);
		field.addActionListener(this);
		area = new JTextArea(10,50);
		area.setEditable(false);
		add(field, BorderLayout.NORTH);
		add(area, BorderLayout.CENTER);
		Socket socket = new Socket("localhost", 9101);
		in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		out = new PrintWriter(socket.getOutputStream(), true);
		area.append(in.readLine() + "\n");
		area.append(in.readLine() + "\n");
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		out.println(field.getText());
		String response = null;
		try {
			response = in.readLine();
	}catch (IOException e) {
		e.printStackTrace();
	}
		area.append(response + "\n");
	}
	public static void mian(String[] args) throws Exception {
		TranslationClient client = new TranslationClient();
	}
}
