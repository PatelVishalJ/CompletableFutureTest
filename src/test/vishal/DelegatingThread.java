package test.vishal;

public class DelegatingThread implements Runnable {
	
	private Runnable delegate; 
	
	public DelegatingThread(Runnable delegate) {
		this.delegate = delegate;
	}

	@Override
	public void run() {
		System.out.println("Delegating Thread start : " + Thread.currentThread().getName());
		try {
			//throw new RuntimeException("Exception from delegating thread : " + Thread.currentThread().getName());
			delegate.run();
		} catch (Exception e) {
			System.out.println("###### Delegating Thread Exception Caught : " + Thread.currentThread().getName());
			//throw new RuntimeException(e.getMessage());
		} catch (Throwable t) {
			System.out.println("!!!!!!! Delegating Thread Throwable Caught : " + Thread.currentThread().getName());
		}
		System.out.println("Delegating Thread ends : " + Thread.currentThread().getName());
	}

}
