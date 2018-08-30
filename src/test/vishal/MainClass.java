package test.vishal;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MainClass {

	public static void main(String[] arg) {
		
		way1();
	}
	
	public static void way1() {
		ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors()+1);
		
		System.out.println("This is main class : " + Thread.currentThread().getName());
		DelegatingExecutorService executorService = new DelegatingExecutorService(executor);
		
		CompletableFuture.runAsync(new MyThread(), executorService)
		.whenCompleteAsync((res, ex) -> {
			if (ex != null) {
				System.out.println("whenComplete - exception  : " + Thread.currentThread().getName());
			} else {
				System.out.println("whenComplete - success  : " + Thread.currentThread().getName());
			}
		}, executor);
		;
		
//		executor.execute(new DelegatingThread(new MyThread()));
		
		
//		Future<?> f = executor.submit(new DelegatingThread(new MyThread()));
//		
//		try {
//			f.get();
//		} catch (Exception e) {
//			System.out.println("Main class - exception caught : " + Thread.currentThread().getName());
//		}
		
//		Thread myThread = new Thread(new DelegatingThread(new MyThread()));
//		myThread.start();
		executor.shutdown();
		System.out.println("main class completed : " + Thread.currentThread().getName());
	}
	
	
	public static void way2() {
		ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors()+1);
		
		System.out.println("This is main class : " + Thread.currentThread().getName());
		DelegatingExecutorService executorService = new DelegatingExecutorService(executor);
		
		
		executorService.execute(new MyThread());
		
		
//		Future<?> f = executor.submit(new DelegatingThread(new MyThread()));
//		
//		try {
//			f.get();
//		} catch (Exception e) {
//			System.out.println("Main class - exception caught : " + Thread.currentThread().getName());
//		}
		
//		Thread myThread = new Thread(new DelegatingThread(new MyThread()));
//		myThread.start();
		
		System.out.println("main class completed : " + Thread.currentThread().getName());
	}
	
	
}
