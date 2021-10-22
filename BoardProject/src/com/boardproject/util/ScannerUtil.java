package com.boardproject.util;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ScannerUtil {
	private Scanner scanner;

	public ScannerUtil() {
		scanner = new Scanner(System.in);
	}

	public void printMessage(String message) {
		System.out.println(message);
		System.out.print("> ");
	}

	public String nextLine(String message) {
		String temp = "";
		printMessage(message);
		temp = scanner.nextLine();
		while (temp.isBlank()) {
			System.out.println("입력된 정보가 존재하지 않습니다.");
			return nextLine(message);
		}
		return temp;
	}

	public String nextLineNN(String message) {
		String temp = "";
		printMessage(message);
		temp = scanner.nextLine();
		while (temp.isBlank()) {
			System.out.println("필수 입력항목입니다. 정보를 입력해주세요.");
			printMessage(message);
			temp = scanner.nextLine();
		}
		return temp;
	}

	public int nextInt(String message) {
		while (true) {
			try {
				printMessage(message);
				return scanner.nextInt();
			} catch (InputMismatchException e) {
				scanner.nextLine();
				System.out.println("잘못된 입력입니다.");
			}
		}

	}

	public int nextInt(String message, int min, int max) {
		while (true) {
			try {
				int temp = nextInt(message);
				while (!(temp >= min && temp <= max)) {
					System.out.println("잘못된 입력입니다.");
					temp = nextInt(message);
				}
				return temp;
			} catch (InputMismatchException e) {
				System.out.println("잘못된 입력입니다.");
			}
		}
	}

	public int nextInt(String message, int min) {
		while (true) {
			try {
				int temp = nextInt(message);
				while (!(temp >= min)) {
					System.out.println("잘못된 입력입니다.");
					temp = nextInt(message);
				}
				return temp;
			} catch (InputMismatchException e) {
				System.out.println("잘못된 입력입니다.");
			}
		}
	}

	public double nextDouble(String message) {
		printMessage(message);
		return scanner.nextDouble();
	}

	public double nextDouble(String message, double min, double max) {
		double temp = nextDouble(message);

		while (!(temp >= min && temp <= max)) {
			System.out.println("잘못된 입력입니다.");
			temp = nextDouble(message);
		}
		return temp;
	}

}
