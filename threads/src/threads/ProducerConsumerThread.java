package threads;

public class ProducerConsumerThread extends Thread {
	private ProducerConsumer prodcon;
	private String type;
	private int items;
	
	public ProducerConsumerThread(ProducerConsumer prodcon, String type,int items) {
		this.prodcon = prodcon;
		this.type = type;
		this.items = items;
	}

	@Override
	public void run() {
		if(this.type=="produce") {
			prodcon.produce(items);
		}
		else {
			prodcon.consumer(items);
		}
	}
	
}
