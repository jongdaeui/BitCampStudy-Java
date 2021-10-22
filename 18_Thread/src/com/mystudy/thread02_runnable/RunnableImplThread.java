package com.mystudy.thread02_runnable;

class ThreadParent {
	void print() {
		System.out.println("ThreadParent> 나는 Thread클래스의 Parent 클래스~~~");
	}
}

class RunnableImpl extends ThreadParent implements Runnable {

	@Override
	public void run() {
		System.out.println("RunnableImpl> run() 메소드 실행중~");
		super.print();
		for (int i = 1; i <= 10; i++) {
			System.out.println(i);
		}
	}
	
}

public class RunnableImplThread {

	public static void main(String[] args) {
		System.out.println("---- main() 시작 ----");
		Thread thMain = Thread.currentThread();
		System.out.println(thMain.toString());
		
		RunnableImpl runnableImpl = new RunnableImpl();
		//runnableImpl.run(); //단순 메소드 호출 - 쓰레드로 동작하지 않음

		Thread th = new Thread(runnableImpl);
		th.start();
		
		System.out.println("---- main() 끝 ----");
	}

}









