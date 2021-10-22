package thread04_error2;

class Bank {
	int money = 0;
}

class ATM extends Thread {
	Bank bank;
	String name;
	ATM(Bank bank, String name)	 {
		super(name);
		this.bank = bank;
		this.name = name;
	}
	
	// 입금
	synchronized void add(int money)	 {
		bank.money += money;
		System.out.println(Thread.currentThread() + "입금 : " +
				money + ", 잔액 : " + bank.money);
	}
	
	// 출금
	synchronized void out(int money)	 {
		bank.money -= money;
		System.out.println(Thread.currentThread() + "출금 : " +
				money + ", 잔액 : " + bank.money);
	}
	
	void bankSleep(int millisecond) {
		try {
			Thread.currentThread().sleep(millisecond);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void run() {
		add(1000);
		bankSleep(1000);
		out(500);
		bankSleep(1000);
		out(300);
		bankSleep(1000);
		out(200);
		
	}
}














public class ATM_ThreadError2 {

	public static void main(String[] args) {
		System.out.println(" ---- main() 시작 ---- ");
		
		Bank bank = new Bank();
		System.out.println("은행잔고 : " + bank.money);
		
		ATM atm1 = new ATM(bank, "ATM-1");
		atm1.start();
		
		ATM atm2 = new ATM(bank, "AMT-2");
		atm2.start();

				
		System.out.println(" ---- main() 끝 ----");		
	}

}
