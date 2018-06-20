import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

public class DownloadImage {
	public static void main(String[] args) throws Exception {
		String website = 
				"http://www.oracle.com/us/hp07-bg121314-openworld-2x-2280475.jpg";
		System.out.println(""+ website + "����Ʈ���� �̹����� �ٿ�ε��մϴ�.");
		URL url = new URL(website);
		byte[] bufer = new byte[2048];
		try (InputStream in = url.openStream();
				OutputStream out = new FileOutputStream("test.jpg");){
				int length = 0;
				while ((length = in.read(bufer)) != -1){
					System.out.println(""+ length + "����Ʈ ��ŭ �о���!");
					out.write(bufer, 0, length);
				}
				in.close();
				out.close();
		}catch (Exception e) {
			System.out.println("����: " + e.getMessage());
		}
	}

}
