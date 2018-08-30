package test.vishal;

import java.util.List;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

public class DelegatingExecutorService extends AbstractExecutorService {
	
	private ExecutorService executor;
	
	public DelegatingExecutorService(ExecutorService executor) {
		this.executor = executor;
	}

	@Override
	public boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException {
		return executor.awaitTermination(timeout, unit);
	}

	@Override
	public boolean isShutdown() {
		return executor.isShutdown();
	}

	@Override
	public boolean isTerminated() {
		return executor.isTerminated();
	}

	@Override
	public void shutdown() {
		executor.shutdown();
	}

	@Override
	public List<Runnable> shutdownNow() {
		return executor.shutdownNow();
	}

	@Override
	public void execute(Runnable command) {
		executor.execute(new DelegatingThread(command));
	}

}
