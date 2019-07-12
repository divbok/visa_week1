package threads;

public class Numbers extends Thread {
	private int start;
	private int end;

	public Numbers(int start, int end) {
		this.start = start;
		this.end = end;
	}

	@Override
	public void run() {
		printNos();
	}

	private void printNos() {
		Thread t =Thread.currentThread();
		for (int i = start; i <= end; i++) {
			System.out.println(t.getName() + " : " + i);
		}
	}

}
