package com.learning.concurrency.ThreadLocal;

import java.util.concurrent.Callable;

public class ServiceRequestResponse implements Callable<Long> {


	private Context<Long> context = new Context<>();
	private long requestParam ;

	public ServiceRequestResponse(long requestParam) {
		this.requestParam = requestParam;
	}

	 

	@Override
	public Long call() throws Exception {
		context.set(requestParam);
		//System.out.println(" ServiceRequestResponse calll context value " + context.get());
		return context.get();
	}

}
