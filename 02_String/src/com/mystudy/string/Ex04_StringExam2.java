package com.mystudy.string;

public class Ex04_StringExam2 {

	public static void main(String[] args) {
		/* String 사용 실습
		문자열 : "홍길동","이순신","이순신","을지문덕","김유신","연개소문","Tom","TOM"
		1. 위의 문자열 값을 저장할 수 있는 문자열 배열(names) 변수를 선언하고 입력
		2. 배열에 있는 값을 구분자 콤마(,)로 구분하여 한 라인에 출력
		   출력 예) 홍길동,이순신,이순신,을지문덕....
		3. 배열에 있는 데이터의 첫 글자만 출력-구분자 콤마(,) 사용 한 라인에 출력
		   출력 예) 홍,이,이,을,김,연,T,T...
		4. 이름의 글자수가 4글자 이상인 이름을 검색해서 "인덱스번호:이름" 형태로 출력
		   예) 3:을지문덕
		5. 이름이 같은 데이터를 "인덱스번호:이름=인덱스번호:이름" 형태로 출력
		   예) 1:이순신=2:이순신
		(기타) 이름 비교시에는 대소문자 구분 없이 비교처리(Tom, TOM 은 같다)
		========================================================= */
		//"홍길동","이순신","이순신","을지문덕","김유신","연개소문","Tom","TOM"
		//1. 위의 문자열 값을 저장할 수 있는 문자열 배열(names) 변수를 선언하고 입력
		String[] names = {"홍길동","이순신","이순신","을지문덕",
				"김유신","연개소문","Tom","TOM"};
		System.out.println("names 데이터 갯수 : " + names.length);
		
		//2. 배열에 있는 값을 구분자 콤마(,)로 구분하여 한 라인에 출력
		// 홍길동,이순신,이순신,을지문덕,김유신,연개소문,Tom,TOM
		System.out.println("--- 2번 ---");
		for (int i = 0; i < names.length; i++) {
			if (i == 0) {
				System.out.print(names[i]);
			} else {
				System.out.print("," + names[i]);
			}
		}
		System.out.println();
		
		System.out.println("--------------");
		if (names.length > 0) {
			System.out.print(names[0]);
		}
		for (int i = 1; i < names.length; i++) {
			System.out.print("," + names[i]);
		}
		System.out.println();
		
		System.out.println("---- 3번 ----");
		if (names.length > 0) {
			System.out.print(names[0].charAt(0));
		}
		for (int i = 1; i < names.length; i++) {
			System.out.print("," + names[i].charAt(0));
		}
		
		System.out.println("\n------ 4번 --------");
		//4. 이름의 글자수가 4글자 이상인 이름을 검색해서 "인덱스번호:이름" 형태로 출력
		for (int i = 0; i < names.length; i++) {
			if (names[i].length() >= 4) {
				System.out.println(i + ":" + names[i]);
			}
		}
		
		System.out.println("---- 5번 -----");
		//5. 이름이 같은 데이터를 "인덱스번호:이름=인덱스번호:이름" 형태로 출력
		//(기타) 이름 비교시에는 대소문자 구분 없이 비교처리(Tom, TOM 은 같다)
		// 0      1       2       3       4      5        6      7
		//"홍길동","이순신","이순신","을지문덕","김유신","연개소문","Tom","TOM"
		//---------------------
		
		//기준인덱스 : 0 일때
//		if (names[0].equalsIgnoreCase(names[1])) {
//			System.out.println(0 + ":" + names[0] + "=" + 1 + ":" + names[1]);
//		}
//		if (names[0].equalsIgnoreCase(names[2])) {
//			System.out.println(0 + ":" + names[0] + "=" + 2 + ":" + names[2]);
//		}
//		if (names[0].equalsIgnoreCase(names[3])) {
//			System.out.println(0 + ":" + names[0] + "=" + 3 + ":" + names[3]);
//		}
//		//.....
//		if (names[0].equalsIgnoreCase(names[names.length-1])) {
//			System.out.println(0 + ":" + names[0] + "=" + (names.length-1) + ":" + names[names.length-1]);
//		}
		
		//=================================================
		//기준 인덱스 : 0
		for (int i = 1; i < names.length; i++) {
			if (names[0].equalsIgnoreCase(names[i])) {
				System.out.println(0 + ":" + names[0] + "=" + i + ":" + names[i]);
			}
		}
		
		//기준 인덱스 : 1
		for (int i = 2; i < names.length; i++) {
			if (names[1].equalsIgnoreCase(names[i])) {
				System.out.println(1 + ":" + names[1] + "=" + i + ":" + names[i]);
			}
		}
		
		//기준 인덱스 : 2
		for (int i = 3; i < names.length; i++) {
			if (names[2].equalsIgnoreCase(names[i])) {
				System.out.println(2 + ":" + names[2] + "=" + i + ":" + names[i]);
			}
		}
		
		//.....
		//기준 마지막 인덱스 : names.length - 2
		//비교 대상 마지막 인덱스 : names.length - 1
		for (int i = names.length - 1; i < names.length; i++) {
			if (names[names.length - 2].equalsIgnoreCase(names[i])) {
				System.out.println((names.length - 2) + ":" + names[names.length - 2] + "=" + i + ":" + names[i]);
			}
		}
		
		//=======================================
		
		//이중 반복문으로 만들기
		System.out.println("===== 이중반복문(최종) ====");
		for (int gijun = 0; gijun < names.length - 1; gijun++) {
			for (int i = gijun + 1; i < names.length; i++) {
				if (names[gijun].equalsIgnoreCase(names[i])) {
					System.out.println(gijun + ":" + names[gijun] + "=" + i + ":" + names[i]);
				}
			}
		}
		
	}

}







