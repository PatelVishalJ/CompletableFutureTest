package test.vishal;

public class MyThread implements Runnable {

	@Override
	public void run() {
		System.out.println("This is My Thread throwing exception : " + Thread.currentThread().getName());
		throw new RuntimeException("Runtime exception from MyThread");
	}

}
