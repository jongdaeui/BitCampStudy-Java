package socket03_echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class TCPClientEcho {
	public static void main(String[] args) {
		// 클라이언트 : 메세지를 서버쪽으로 보내고, 서버로부터 메세지 돌려받기
		Socket socket = null;

		// 입력용 객체 저장 변수 선언
		InputStream is = null;
		InputStreamReader isr = null;
		BufferedReader br = null;

		// 출력용 객체 저장 변수 선언
		OutputStream os = null;
		PrintWriter pw = null;

		try {
			System.out.println("---- 클라이언트 ----");
			socket = new Socket("localhost", 10000);
			System.out.println(">>> 서버에 접속 완료");

			is = socket.getInputStream();
			os = socket.getOutputStream();

			// 서버쪽으로 쓰기 (전송-Output / write)
			System.out.println(">>> 메세지 쓰기 (Client -> server)");
			pw = new PrintWriter(os);

			String msg = "안녕하세요. 반갑습니다~";
			pw.println(msg);
			pw.flush();

			System.out.println(">>> 보낸메세지 : " + msg);

			// 서버에서 보내온 메세지 받기 (수신) --------
			isr = new InputStreamReader(is);
			br = new BufferedReader(isr);

			String receiveMsg = br.readLine();
			System.out.println(">> 받은 메세지 : " + receiveMsg);

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
			if (socket != null)	{
				try {
					socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
