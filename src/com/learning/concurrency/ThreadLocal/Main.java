package com.learning.concurrency.ThreadLocal;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {

	public static void main(String[] args) {
		//ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(5, 5, 4000, TimeUnit.MILLISECONDS, workQueue)

		Thread t = new Thread(new ServiceRequest(23000));
		t.start();
		
		ExecutorService executorService = //Executors.newSingleThreadExecutor();
				Executors.newFixedThreadPool(5);
//		
		Future future1 = executorService.submit(new ServiceRequest(1000)); 
		Future future2 = executorService.submit(new ServiceRequestResponse(2000));
		Future future3 = executorService.submit(new ServiceRequest(3000));
		Future future4 = executorService.submit(new ServiceRequestResponse(4000));
		
		try { 
			//while(!future1.isDone()) {
				System.out.println("future1 " +  future1.get());
			//}
			 
			//while(!future2.isDone()) {
				System.out.println("future2 " +  future2.get());
			//}
			
			//while(!future3.isDone()) {
				System.out.println("future3 " +  future3.get());
			//}
			
			//while(!future4.isDone()) {
				System.out.println("future4 " +  future4.get());
			//}
 			
			executorService.shutdown();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.getCause();
			e.printStackTrace();	 
		}
		
		

				
	} 
	
	
	 
}
