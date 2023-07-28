package fr.formation.task.bll;

import java.time.LocalDateTime;

import fr.formation.task.bo.Task;

public class TaskManagerTest {
	private static TaskManager manager = TaskManagerSing.getInstance();

	public static void main(String[] args) throws TaskException {
		manager.addTask(new Task("Try",LocalDateTime.now().plusDays(1),LocalDateTime.now().plusDays(2),5,true));
		manager.getAllTasksToDo().forEach(System.out::println);
		System.out.println();
		
		// add a non edded task
		manager.addTask(new Task("Try",LocalDateTime.now().plusDays(1),LocalDateTime.now().plusDays(2),5,false));
		manager.getAllTasksToDo().forEach(System.out::println);
		System.out.println();
		
		// add a up side down task
		try {
			manager.addTask(new Task("Try",LocalDateTime.now().plusDays(2),LocalDateTime.now().plusDays(1),5,false));
		} catch (TaskException e) {
			System.out.println("Erreur : "+e.getMessage());
		}
		
		// add a task started before now
		try {
			manager.addTask(new Task("Try",LocalDateTime.now().minusDays(1),LocalDateTime.now().plusDays(1),5,false));
		} catch (TaskException e) {
			System.out.println("Erreur : "+e.getMessage());
		}
		
		// add a task ended before now
		try {
			manager.addTask(new Task("Try",LocalDateTime.now().minusDays(2),LocalDateTime.now().minusDays(2),5,false));
		} catch (TaskException e) {
			System.out.println("Erreur : "+e.getMessage());
		}
		
		// add a tast with low priority (test of the sort)
		manager.addTask(new Task("Try2",LocalDateTime.now().plusDays(1),LocalDateTime.now().plusDays(2),1,true));
		manager.addTask(new Task("Try3",LocalDateTime.now().plusDays(1),LocalDateTime.now().plusDays(2),2,true));	
		manager.getAllTasksToDo().forEach(System.out::println);
		System.out.println();
		
		
	}

}
