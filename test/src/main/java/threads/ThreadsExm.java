package threads;

public class ThreadsExm extends Thread {
	public static void main(String[] args) {

		System.out.println(Thread.currentThread().getName());
		Thread.currentThread().setName("sekhar");
		System.out.println(Thread.currentThread().getName());
		
		ThreadsExm threadsExm = new ThreadsExm();
		System.out.println(threadsExm.getPriority());
		threadsExm.setPriority(MIN_PRIORITY);
		System.out.println(threadsExm.getPriority());
	}

}
