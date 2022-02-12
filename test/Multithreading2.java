package test;

public class Multithreading2 {  
	public static void main(String[] args) {
		ThreadSleep thread1 = new ThreadSleep("Thread1"); 
		ThreadSleep thread2 = new ThreadSleep("Thread2");
		thread1.start(); //starting the thread 1
		thread2.start();  //starting the thread 2
		System.out.println("Thread names are following:");
	}
}

class ThreadSleep implements Runnable {
	Thread sleepThread;
	private String threadName;
	ThreadSleep(String name) {
		this.threadName = name;
	}
	@Override
	public void run() {
		System.out.println("Thread running:::" + threadName);
		for (int i = 0; i < 4; i++) {
			System.out.println("Countr::" + i);
			System.out.println("Thread:::" + threadName);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println("Thread has been interrupted");
			}
		}
	}
	public void start() {
		System.out.println("Thread started");
		if (sleepThread == null) {
			sleepThread = new Thread(this, threadName);
			sleepThread.start();
		}
	}
}



