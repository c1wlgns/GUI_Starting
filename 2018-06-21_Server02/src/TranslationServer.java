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
		System.out.println("영어 번역 서버가 실행중입니다.");
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
				out.println("안녕하세요? 클라이언트 번호는 " + myId + "입니다.");
				out.println("단어를 입력하세요");
				while (true) {
					String input = in.readLine();
					if(input == null) {
						break;
					}
					if(input.equals("java") == true)
						out.println("java->자바");
					else
						out.println("조금 쉬운 단어를 보내주세요.");
				}
				
			}catch (IOException e) {
				System.out.println("클라이언트 번호: " + myId + "처리실패" + e);
			}finally {
				try {
					socket.close();
				}catch (IOException e) {
					System.out.println("소켓 종료 오류" + e);
				}
				System.out.println("클라이언트 번호: " + myId + "처리 처리 종료");
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
		setTitle("클라이언트");
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
