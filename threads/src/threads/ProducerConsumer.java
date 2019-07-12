package threads;

import java.util.ArrayList;
import java.util.List;

public class ProducerConsumer {
	private int noofitems;
	private boolean b = false;

	public ProducerConsumer(int noofitems) {
		this.noofitems = noofitems;
	}

	public int getNoofitems() {
		return noofitems;
	}

	public void setNoofitems(int noofitems) {
		this.noofitems = noofitems;
	}

	public synchronized void produce(int d) {
		System.out.println("trying to produceeeeeeee");
		while( b== true) {
			System.out.println("not possible to produce ");
			try {
				wait(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		b=true;
		System.out.println("producing");
		setNoofitems(getNoofitems()+1);
		System.out.println("final " + getNoofitems());
		notifyAll();
		
	}
	public synchronized void consumer(int d) {
		System.out.println("trying to consume");
		while( b == false) {
			System.out.println("not possible");
			try {
				wait(4000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		b=false;
		System.out.println("consuming");
		setNoofitems(getNoofitems()-1);
		System.out.println("items left" +getNoofitems() );
		notifyAll();
	}
	
	

}
