package threads;

public class ProducerConsumerClient {

	public static void main(String[] args) {
		ProducerConsumer prod = new ProducerConsumer(1);
		ProducerConsumerThread p1 = new ProducerConsumerThread(prod, "produce");
		ProducerConsumerThread p2 = new ProducerConsumerThread(prod, "consume");
		ProducerConsumerThread p3 = new ProducerConsumerThread(prod, "produce");
		
		p1.start();

		p2.start();
		p3.start();
		
		try {
			p1.join();
			p2.join();
			p3.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Final items:" + prod.getNoofitems());
		
	}

}
