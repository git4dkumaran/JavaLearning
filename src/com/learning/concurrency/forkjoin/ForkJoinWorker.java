package com.learning.concurrency.forkjoin;

import java.util.concurrent.ForkJoinPool;

public class ForkJoinWorker {

	public static void main(String[] args) {

		// Check the number of available processors
		int processors = Runtime.getRuntime().availableProcessors();
		System.out.println("No of processors: " + processors);

		/**
		 * No of processors: 8 Computing Fib number: 10
Computed Result: 55
Elapsed Time: 1448345411396

		 */
		int n = 40;

		StopWatch stopWatch = new StopWatch();
		FibonacciProblem bigProblem = new FibonacciProblem(n);

		FibonacciTask task = new FibonacciTask(bigProblem);
		ForkJoinPool pool = new ForkJoinPool(processors);
		pool.invoke(task);

		long result = task.result;
		stopWatch.stop();
		
		System.out.println("No of processors: " + processors+ " Computing Fib number: "+ n);
		System.out.println("Computed Result: " + result);
		System.out.println("Elapsed Time: " + stopWatch.getElapsedTime());

	}

}
