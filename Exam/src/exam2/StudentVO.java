package exam2;

public class StudentVO {
	private int id;
	private String name;
	private int kor;
	private int eng;
	private int math;
	private int tot;
	private double avg;
	
	public StudentVO(int id, String name, int kor, int eng, int math) {
		this.id = id;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		computeTotAvg();
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public StudentVO() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
		computeTotAvg();
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
		computeTotAvg();
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
		computeTotAvg();
	}

	public int getTot() {
		return tot;
	}

	public double getAvg() {
		return avg;
	}

	private void computeTotAvg() {
		this.tot = kor + eng + math;
		avg = tot * 100 / 3 / 100.00;
		
	}
	
	public void printData() {
		System.out.println(id + "," + name + "," 
				+ kor + "," + eng + "," + math + ","
				+ tot + "," + avg);
	}
	
}







