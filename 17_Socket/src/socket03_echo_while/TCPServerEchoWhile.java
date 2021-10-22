package socket03_echo_while;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServerEchoWhile {
	public static void main(String[] args) {
		// 클라이언트에서 보내는 메세지를 받고 다시 보내기 반복 처리
		// 수신(input) 메세지 화면 출력후 클라이언트로 전송 (output)
		//
		// 서버 소켓 저장 변수 선언
		ServerSocket server = null;

		// 데이터를 읽기위한 객체를 저장할 변수 선언
		InputStream is = null;
		InputStreamReader isr = null;
		BufferedReader br = null;

		// 데이터를 전송하기 위한 객체를 저장할 변수 선언
		OutputStream os = null;
		PrintWriter pw = null;

		try {
			// 클라이언트와 연결할 포트를 저장할 변수 선언
			System.out.println(">>> 서버시작");
			server = new ServerSocket(10000);

			// 클라이언트로 부터 메세지를 받을 소켓 변수 선언
			System.out.println(">>> 대기중....");
			Socket socket = server.accept();

			// 데이터 받기
			while (true) {
				is = socket.getInputStream();
				isr = new InputStreamReader(is);
				br = new BufferedReader(isr);
	
				// 메세지 출력
				System.out.println(">>> 메세지 읽기");
				String msg = br.readLine();
				System.out.println("[클라이언트]에서 보냄 : " + msg);
	
				// 받은 메세지를 다시 서버로 전송
				pw = new PrintWriter(socket.getOutputStream());
	
				pw.println(msg);
				pw.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (pw != null)
				pw.close();
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		pw.println(">>> 서버 종료");
	}
}
