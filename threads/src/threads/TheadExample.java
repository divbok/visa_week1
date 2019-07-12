package threads;

public class TheadExample {

	public static void main(String[] args) {
		Numbers t1 = new Numbers(1, 400);
		Numbers t2 = new Numbers(900, 1200);
	//	t2.setDaemon(true);
		Chars ch = new Chars();
		//Thread t3 = new Thread(); //this wont execute anything because we havent specified the target
		//to implement the class which implements runnable we need to specify the target
		Thread t3= new Thread(ch);
		t3.start();
		t1.start();
		t2.start();
		doTask();
	}

	private static void doTask() {
		Thread t = Thread.currentThread();
		System.out.println("Name: " + t.getName());
		System.out.println("Prioirity: " + t.getPriority());
		System.out.println("group: " + t.getThreadGroup().getName());
		/*
		 * JRE waits for the status for last NoDaemon thread before it terminates
		 */
		System.out.println("Daemon: " + t.isDaemon());
	}

}
