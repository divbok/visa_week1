package threads;

import java.util.concurrent.Callable;

public class Sumer implements Callable<Integer> {
	int start;
	int end;
	
	public Sumer(int start, int end) {
		super();
		this.start = start;
		this.end = end;
	}

	@Override
	public Integer call() throws Exception {
		int sum=0;
		for (int i = start; i <=end ; i++) {
			sum+=i;
		}
		return sum;
	}

}
