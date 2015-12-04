package com.learning.concurrency.forkjoin;

public class FibonacciProblem {

	public int n;

	public FibonacciProblem(int n) {
		this.n = n;
	}

	public long solve() {
		return fibonacci(n);
	}

	private long fibonacci(int n) {
		System.out.println("Thread: " + Thread.currentThread().getName() + " calculates " + n);
		if (n <= 1)
			return n;
		else
			return fibonacci(n - 1) + fibonacci(n - 2);
	}
	
	public long solveNormal() {
		return fibonacciNonRecurrsive(n);
	}
	
	private long fibonacciNonRecurrsive(int n) {
		System.out.println("Thread: " + Thread.currentThread().getName() + " calculates " + n);
		
		long current = 0;
		long pPrev = 1;
		long prev = 1;
		
		if (n == 0) {
			System.out.println( " 0 ");
		} else  if (n == 1) {
			System.out.println( "0 1 ");
			prev = 0;
			current = 1; 
		} else if (n == 2 ) {
			System.out.println( "0 1 1");
			pPrev = 0;
			prev = 1;
			current = 1; 
		} else if (n > 2) {  
			for(int i = 3 ; i <= n; i++ ) {
				 current = prev + pPrev;
				 System.out.println(" " + current);
				 pPrev = prev;
				 prev = current; 
			}
		}
		return current;
	}
	

}