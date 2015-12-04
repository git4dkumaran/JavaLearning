package com.learning.concurrency.forkjoin;

public class SillyWorker {

	public static void main(String[] args) throws Exception {

		

		/**
		 * 
Computing Fib number: 10
Computed Result: 55
Elapsed Time: 1448345259240
 
Computing Fib number: 30
Computed Result: 832040
Elapsed Time: 1448403053963
Thread: main calculates 30
  
Computing Normal  Fib number: 30
Computed Normal Result: 832040
Elapsed Normal  Time: 1448403053964 
 
		 */ 
		
		int n = 40;
		
		long result = 0;
		FibonacciProblem bigProblem = new FibonacciProblem(n);
		 
		StopWatch stopWatch1 = new StopWatch();  
		result = bigProblem.solveNormal();
		stopWatch1.stop();

		System.out.println("Computing Normal  Fib number: " + n);
		System.out.println("Computed Normal Result: " + result);
		System.out.println("Elapsed Normal  Time: " + stopWatch1.getElapsedTime());


		StopWatch stopWatch = new StopWatch();
		

		result = bigProblem.solve();
		stopWatch.stop();

		System.out.println("Computing Fib number: " + n);
		System.out.println("Computed Result: " + result);
		System.out.println("Elapsed Time: " + stopWatch.getElapsedTime());

		
		
	}

}