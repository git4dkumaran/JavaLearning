package com.learning.concurrency.forkjoin.simple;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveAction;

/**
 * A RecursiveAction is a task which does not return any value. It just does
 * some work, e.g. writing data to disk, and then exits.
 * 
 * A RecursiveAction may still need to break up its work into smaller chunks
 * which can be executed by independent threads or CPUs.
 *
 * 
 */
public class MyRecursiveAction extends RecursiveAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long workLoad = 0;

	public MyRecursiveAction(long workLoad) {
		this.workLoad = workLoad;
	}

	@Override
	protected void compute() {

		// if work is above threshold, break tasks up into smaller tasks
		if (this.workLoad > 16) {
			System.out.println("Splitting workLoad : " + this.workLoad);

			List<MyRecursiveAction> subtasks = new ArrayList<MyRecursiveAction>();

			subtasks.addAll(createSubtasks());

			for (RecursiveAction subtask : subtasks) {
				subtask.fork();
			}

		} else {
			System.out.println("Doing workLoad myself: " + this.workLoad);
		}
	}

	private List<MyRecursiveAction> createSubtasks() {
		List<MyRecursiveAction> subtasks = new ArrayList<MyRecursiveAction>();

		MyRecursiveAction subtask1 = new MyRecursiveAction(this.workLoad / 2);
		MyRecursiveAction subtask2 = new MyRecursiveAction(this.workLoad / 2);

		subtasks.add(subtask1);
		subtasks.add(subtask2);

		return subtasks;
	}

}
