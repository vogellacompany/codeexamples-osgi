package com.vogella.osgi.taskconsumer;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.vogella.tasks.model.TaskService;

@Component
public class TaskConsumer {

	private TaskService taskService; 

	public TaskConsumer() {
		System.out.println("Created");
	}
	@Reference
	private void bindTaskService(TaskService taskService) {
		this.taskService = taskService;
		System.out.println("Injected " + taskService);
	}
	@SuppressWarnings("unused")
	private void unbindTaskService(TaskService taskService) {
		System.out.println("Removed " + taskService);
		taskService = null;
	}
	
	@Activate
	public void activate() {
		System.out.println("Activate called");
		System.out.println("Number of tasks: " + taskService.getAll().size());
	}
}
