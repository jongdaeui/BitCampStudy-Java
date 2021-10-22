package socket03_echo_while;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class TCPClientEchoWhile {
	public static void main(String[] args) {
		// 메세지를 작성해서 서버로 전송하고, 서버로부터 전달받은 메세지 수신 반복
		// 메세지 작성 : Scaner 객체 사용해서 콘솔에서 입력

		// 서버에 접속할때 사용할 소켓 변수 선언
		Socket socket = null;

		// 입력용 객체 저장 변수 선언
		InputStream is = null;
		InputStreamReader isr = null;
		BufferedReader br = null;

		// 출력용 객체 저장 변수 선언
		OutputStream os = null;
		PrintWriter pw = null;
		
		try {
			// 서버에 연결할 새로운 소켓 변수 생성
			System.out.println("--- 클라이언트 ---");
			socket = new Socket("localhost", 10000);
			System.out.println(">>> 서버에 접속완료");
			
			// 서버로 메세지 전송하기
			os = socket.getOutputStream();
			pw = new PrintWriter(os);
			
			Scanner scan = new Scanner(System.in);
			while (true) {
				String msg = scan.nextLine();
				pw.println(msg);
				pw.flush();
				
				System.out.println("보낸 메세지 : " + msg);
				
				// 서버로부터 되돌아온 메세지 수신
				br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				
				String returnMsg = br.readLine();
				System.out.println("[서버]에서 보내온 메세지 : " + returnMsg);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					
					e.printStackTrace();
				}
			}
			if (socket != null) {
				try {
					socket.close();
				} catch (IOException e) {
					
					e.printStackTrace();
				}
			}
		}
		
	}
}
