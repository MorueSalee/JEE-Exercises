package fr.eni.ecole.bo;

import java.time.LocalDate;
import java.time.LocalTime;

public class Task {
	private Integer idTask;
	private String label;
	private LocalDate dtStart;
	private LocalDate dtEnd;
	private LocalTime hStart;
	private LocalTime hEnd;
	private Integer priority;
	private Boolean isDone;
	
	public Task() {
		super();
	}

	public Task(String label, LocalDate dtStart, LocalDate dtEnd, LocalTime hStart, LocalTime hEnd, Integer priority,
			Boolean isDone) {
		super();
		this.label = label;
		this.dtStart = dtStart;
		this.dtEnd = dtEnd;
		this.hStart = hStart;
		this.hEnd = hEnd;
		this.priority = priority;
		this.isDone = isDone;
	}

	public Task(Integer idTask, String label, LocalDate dtStart, LocalDate dtEnd, LocalTime hStart, LocalTime hEnd,
			Integer priority, Boolean isDone) {
		super();
		this.idTask = idTask;
		this.label = label;
		this.dtStart = dtStart;
		this.dtEnd = dtEnd;
		this.hStart = hStart;
		this.hEnd = hEnd;
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

	public LocalDate getDtStart() {
		return dtStart;
	}

	public void setDtStart(LocalDate dtStart) {
		this.dtStart = dtStart;
	}

	public LocalDate getDtEnd() {
		return dtEnd;
	}

	public void setDtEnd(LocalDate dtEnd) {
		this.dtEnd = dtEnd;
	}

	public LocalTime gethStart() {
		return hStart;
	}

	public void sethStart(LocalTime hStart) {
		this.hStart = hStart;
	}

	public LocalTime gethEnd() {
		return hEnd;
	}

	public void sethEnd(LocalTime hEnd) {
		this.hEnd = hEnd;
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

	
}
