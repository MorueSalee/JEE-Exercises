package fr.formation.task.bo;

import java.time.LocalDateTime;

public class Task {
	private Integer idTask;
	private String label;
	private LocalDateTime start;
	private LocalDateTime end;
	private Integer priority;
	private Boolean isDone=false;

	public Task() {
	}

	public Task(String label, LocalDateTime start, LocalDateTime end, Integer priority, Boolean isDone) {
		super();
		this.label = label;
		this.start = start;
		this.end = end;
		this.priority = priority;
		this.isDone = isDone;
	}

	public Integer getIdTask() {
		return idTask;
	}

	public void setIdTask(Integer idTask) {
		this.idTask = idTask;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public LocalDateTime getStart() {
		return start;
	}

	public void setStart(LocalDateTime start) {
		this.start = start;
	}

	public LocalDateTime getEnd() {
		return end;
	}

	public void setEnd(LocalDateTime end) {
		this.end = end;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public Boolean getIsDone() {
		return isDone;
	}

	public void setIsDone(Boolean isDone) {
		this.isDone = isDone;
	}

	@Override
	public String toString() {
		return "Task [idTask=" + idTask + ", label=" + label + ", start=" + start + ", end=" + end + ", priority="
				+ priority + ", isDone=" + isDone + "]";
	}

}
