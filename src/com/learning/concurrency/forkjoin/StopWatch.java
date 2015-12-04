package com.learning.concurrency.forkjoin;

import java.util.concurrent.atomic.AtomicLong;

public class StopWatch {

	private AtomicLong startTimer = new AtomicLong();
	private AtomicLong stopTimer = new AtomicLong();
	
	public StopWatch() {
		
	}
	
	public void start() {
		startTimer = new AtomicLong(System.currentTimeMillis());
	}
	
	public void stop() {
		stopTimer = new AtomicLong(System.currentTimeMillis()); 
	}
	
	public long getElapsedTime() {
		return stopTimer.get() - startTimer.get();
	}
}
