package scissors;

import java.util.Random;
import java.util.Scanner;

import util.ScannerUtil;

public class ScissorsGame {
	private Random random;
	private Scanner scanner;
	private final String ROCK = "바위";
	private final String SCISSORS = "가위";
	private final String PAPERS = "보";
	private final String WIN = "사용자가 이겼습니다.";
	private final String LOSE = "컴퓨터가 이겼습니다.";
	private final String DRAW = "비겼습니다.";
	private boolean game = true;

	public void startGame() {

		System.out.println(">>> 가위, 바위, 보 게임을 시작합니다.");
		while (game) {
			int computerRandom = computerRandom();
			String computerChoice = computerChoice(computerRandom);
			System.out.println("컴퓨터의 선택 : " + computerChoice);
			String userChoice = userChoice();
			System.out.println("사용자의 선택 : " + userChoice);

			String result = compareChoice(computerChoice, userChoice);
			System.out.println(result);
			game = moreGame();
		}
	}

	public int computerRandom() {
		random = new Random();
		int computerRandom = random.nextInt(3) + 1;
		return computerRandom;
	}

	public String computerChoice(int computerRandom) {
		String result;
		if (computerRandom == 1) {
			result = ROCK;
		} else if (computerRandom == 2) {
			result = SCISSORS;
		} else {
			result = PAPERS;
		}
		System.out.println("컴퓨터 랜덤 선택 완료");
		return result;
	}

	public String userChoice() {
		scanner = new Scanner(System.in);
		String result;
		String message = ("1. 가위 2. 바위 3. 보");
		int userChoice = ScannerUtil.nextInt(scanner, message, 1, 3);
		if (userChoice == 1) {
			result = SCISSORS;
		} else if (userChoice == 2) {
			result = ROCK;
		} else {
			result = PAPERS;
		}
		return result;
	}

	public String compareChoice(String computerChoice, String userChoice) {
		String result = "";
		if (computerChoice.equals(userChoice)) {
			result = DRAW;
		} else {
			if (ROCK.equals(computerChoice)) {
				if (SCISSORS.equals(userChoice)) {
					result = LOSE;
				} else if (PAPERS.equals(userChoice)) {
					result = WIN;
				}
			} else if (SCISSORS.equals(computerChoice)) {
				if (ROCK.equals(userChoice)) {
					result = WIN;
				} else if (PAPERS.equals(userChoice)) {
					result = LOSE;
				}
			} else if (PAPERS.equals(computerChoice)) {
				if (ROCK.equals(userChoice)) {
					result = LOSE;
				} else if (SCISSORS.equals(userChoice)) {
					result = WIN;
				}
			}
		}

		return result;
	}

	public boolean moreGame() {
		String message = new String("게임을 한번 더 진행하시겠습니까? y/n");
		String yesNo = ScannerUtil.nextLine(scanner, message);
		while (!yesNo.equalsIgnoreCase("n")) {
			if (!yesNo.equalsIgnoreCase("y")) {
				System.out.println("잘못된 입력입니다.");
				yesNo = ScannerUtil.nextLine(scanner, message);
			} else {
				return true;
			}
		}
		System.out.println("이용해주셔서 감사합니다.");
		return false;
	}
}
