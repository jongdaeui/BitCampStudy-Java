package exam2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Exam2 {

	public static void main(String[] args) {
		List<StudentVO> list = new ArrayList<StudentVO>();
		try {
			// File객체를 생성해서 Reader에 전달하는 것과 Reader에서 파일을 직접 불러오는 것의
			// 차이, 확인 필요
			FileReader fr = new FileReader("file/data.txt");

			// BufferedReader를 사용하는 것 외의 파일의 내용을 읽어오는 방법들, 확인 필요
			BufferedReader br = new BufferedReader(fr);
			StudentVO stu = null;
			String str = "";
			while (true) {
				str = br.readLine();
				if (str == null)
					break;
				String[] strArr = str.split(",");
				// 메소드 처리 가능 확인
				stu = new StudentVO();
				stu.setId(Integer.parseInt(strArr[0]));
				stu.setName(strArr[1]);
				stu.setKor(Integer.parseInt(strArr[2]));
				stu.setEng(Integer.parseInt(strArr[3]));
				stu.setMath(Integer.parseInt(strArr[4]));
				list.add(stu);
			}
			br.close();
			// Reader와 마찬가지로 File 객체 생성 필요 여부 확인
			FileWriter fw = new FileWriter("file/result.txt");
			for (StudentVO s : list) {
				// 메소드로 처리가능 확인
				fw.write(s.getId() + "," + s.getName() + "," + s.getKor() + "," + s.getEng() + "," + s.getMath() + ","
						+ s.getTot() + "," + s.getAvg() + "\n");
				fw.flush();
			}
			fw.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
