package net_multi2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

// 메세지 작성 전송 독립적으로 동작하는 스레드 생성(쓰기전용)
// 메세지 수신 독립적으로 동작하는 스레드 생성(읽기전용)
public class TCPClientMultiChat {

	public static void main(String[] args) {
		// 송신, 수신 스레드 생성 실행
		System.out.println(" ---- main() 시작 ----");

		Scanner scan = new Scanner(System.in);
		System.out.println("사용할 이름(별명) 입력 : ");
		String name = scan.nextLine();

		Socket socket = null;
		try {
			socket = new Socket("192.168.0.200", 10000);

			// 메세지 보내기 스레드 생성 (스레드로 동작)
			ClientSender clientSender = new ClientSender(socket, name);
			clientSender.start();

			// 메세지 수신 받기 스레드 생성
			ClientReceiver clientReceiver = new ClientReceiver(socket);
			clientReceiver.start();
			
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println(" ---- main() 종료 ----");
	}

	// 메세지 보내기 스레드
	static class ClientSender extends Thread {
		Socket socket;
		String name;
		DataOutputStream out;

		ClientSender(Socket socket, String name) {
			this.socket = socket;
			this.name = name;

			try {
				out = new DataOutputStream(socket.getOutputStream());
			} catch (IOException e) {
//				e.printStackTrace();
				System.out.println("[예외발생] ClientSender 생성자 " + "out 객체 생성 실패!!!");
			}
		}

		@Override
		public void run() {
			// 메세지 작성하고, 작성된 메세지 서버로 전송
			if (out == null) {
				System.out.println("[예외발생] out객체가 null입니다.");
				return;
			}
			Scanner scan = new Scanner(System.in);

			try {
				out.writeUTF(name); // 첫번째 메세지 작성 : 이름
				while (true) {
					System.out.println("메세지 작성 > ");
					String msg = scan.nextLine();

					// [홍길동] 안녕하세요.
					out.writeUTF("[" + name + "]" + msg);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			scan.close();
		}
	}

	// 메세지 받기 스레드
	static class ClientReceiver extends Thread {
		Socket socket;
		DataInputStream in;

		ClientReceiver(Socket socket) {
			this.socket = socket;

			try {
				in = new DataInputStream(socket.getInputStream());

			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		@Override
		public void run() {
			// 메세지를 받아서 화면출력 (반복)
			while (true) {
				try {
					System.out.println(in.readUTF());
				} catch (IOException e) {

				}
			}
		}
	}
}
