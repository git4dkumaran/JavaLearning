package com.learning.concurrency.forkjoin.simple;

import java.util.concurrent.ForkJoinPool;

public class MainTask {

	public static void main(String[] args) {
		ForkJoinPool forkJoinPool = new ForkJoinPool(4);
		
		MyRecursiveTask myRecursiveTask = new MyRecursiveTask(128);

		long result = forkJoinPool.invoke(myRecursiveTask);
		
		System.out.println( " Task result "+ result);


	}

}
