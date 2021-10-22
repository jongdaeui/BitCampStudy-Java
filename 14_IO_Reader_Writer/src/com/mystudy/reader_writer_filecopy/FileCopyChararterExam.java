package com.mystudy.reader_writer_filecopy;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileCopyChararterExam {

	public static void main(String[] args) {
		// FileReader, FileWriter 사용해서 파일 복사
		// 원본파일 : file/test_char.txt
		// 대상파일 : file/test_char_copy.txt
		// 처리 : 원본파일을 읽어서 대상파일에 쓰기/저장 (문자단위)
		// -------------------------------------------------
		// 0. 사용할 파일 객체 생성
//		File file = new File("file/test_char.txt");
//
//		// 1. 파일로부터 읽어들이고, 쓸 객체를 저장할 변수 선언
//		FileInputStream fis = null;
//		FileOutputStream fos = null;
//
//		// 2. 읽기 위한 객체 생성, 쓰기 위한 객체 생성
//		try {
//			fis = new FileInputStream(file);
//			fos = new FileOutputStream("file/test_char_copy.txt");
//
//			// 3. 읽고, 쓰기 반복 (원본파일의 끝이 나올때까지)
//			int readValue;
//			while ((readValue = fis.read()) != -1) {
//				fos.write(readValue);
//			}
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				// 4. 사용객체 close();
//				fis.close();
//				fos.close();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
		File file = new File("file/test_char.txt");
		
		FileReader fr = null;
		FileWriter fw = null;
		
		try {
			fr = new FileReader(file);
			fw = new FileWriter("file/test_char_copy2");
			
			int readValue;
			while ((readValue = fr.read()) != -1) {
				fw.write(readValue);
			}
			fw.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fr.close();
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
