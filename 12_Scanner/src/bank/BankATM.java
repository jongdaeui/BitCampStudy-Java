package bank;

import java.util.Scanner;

//[실습] 은행의 ATM 기계 만들기
// 1.입금  2.출금  3.통장확인  0.종료
//-----------------------------------
// 계좌를 하나 만들고 입금/출금/통장확인 작업을 처리
public class BankATM {
	private int money = 10000; // 통장 계좌(금액)
	private Scanner scan = new Scanner(System.in);
	private String menu = "1. 입금 2. 출금 3. 잔액확인 0. 종료\n번호를 선택해주세요 >";

	public void startBank() {
		System.out.println(">> ATM 기계를 사용합니다");

		System.out.println(menu);
		int userChoice = scan.nextInt();
		while (true) {
			if (userChoice == 1) {
				deposit();
				checkAccount();
				System.out.println();
			} else if (userChoice == 2) {
				withdraw();
				checkAccount();
				System.out.println();
			} else if (userChoice == 3) {
				checkAccount();
				System.out.println();
			} else if (userChoice == 0) {
				System.out.println("프로그램을 종료합니다.\n이용해주셔서 감사합니다.");
				break;
			} else {
				System.out.println("잘못된 입력입니다.");
				System.out.println(menu);
				userChoice = scan.nextInt();
			}
			System.out.println(menu);
			userChoice = scan.nextInt();
		}
	}

	// 입금 처리 메소드
	public void deposit() {
		System.out.println("입금하실 금액을 입력해주세요.");
		System.out.println(">> ");
		int userInput = scan.nextInt();
		money += userInput;
		System.out.println("::: 입금 금액 : " + userInput + "원");
	}

	// 출금 처리 메소드
	public void withdraw() {
		while (true) {
			if (money > 0) {
				System.out.println("출금하실 금액을 입력해주세요.");
				checkAccount();
				System.out.println(">> ");
				int userInput = scan.nextInt();
				if (money < userInput) {
					System.out.println("출금 가능한 잔액이 부족합니다.");
					checkAccount();
					System.out.println();
				} else {
					money -= userInput;
					System.out.println("::: 출금 금액 : " + userInput + "원");
					break;
				}
			} else {
				System.out.println("출금 가능한 잔액이 부족합니다.");
				break;
			}
		}
	}

	// 계좌 확인 메소드
	public void checkAccount() {
		System.out.println("::: 현재 잔액 : " + money + "원");
	}
}
