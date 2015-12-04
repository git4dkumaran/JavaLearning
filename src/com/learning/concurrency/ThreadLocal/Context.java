package com.learning.concurrency.ThreadLocal;

public class Context<T> {

	private ThreadLocal<T> tl = new ThreadLocal<T>();

	public void set(T value) {
		//System.out.println("set "+value);
		tl.set(value);
	}

	public T get() {
		//System.out.println("get "+tl.get());
		return tl.get();
	}

}
