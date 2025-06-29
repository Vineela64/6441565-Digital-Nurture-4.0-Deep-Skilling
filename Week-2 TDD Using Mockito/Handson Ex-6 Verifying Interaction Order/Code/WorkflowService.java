package com.example;

public class WorkflowService {
	private TaskManager manager;

    public WorkflowService(TaskManager manager) {
        this.manager = manager;
    }

    public void runWorkflow() {
        manager.start();
        manager.execute();
        manager.finish();
    }

}
