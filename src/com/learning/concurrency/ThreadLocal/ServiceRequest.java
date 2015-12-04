package com.learning.concurrency.ThreadLocal;

public class ServiceRequest implements Runnable {

	private Context<Long> context = new Context<>();
	private long requestParam ;

	public ServiceRequest(long requestParam) {
		this.requestParam = requestParam;
	}

	@Override
	public void run() { 
		 
		context.set(requestParam);
		//System.out.println(" context value RUn... " + context.get());
	}

}
