package TaskManagementVM.taskmanagement.deadline.model;

import java.util.*;
import java.lang.*;
import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;

import TaskManagementVM.taskmanagement.core.model.TaskManagementDecorator;
import TaskManagementVM.taskmanagement.core.model.TaskManagement;
import TaskManagementVM.taskmanagement.core.model.TaskManagementComponent;

@Entity(name="taskmanagement_deadline")
@Table(name="taskmanagement_deadline")
public class TaskManagementImpl extends TaskManagementDecorator {

	protected String deadline;
	public TaskManagementImpl() {
        super();
		Random r = new Random();
		this. = Math.abs(r.nextInt());
        this.objectName = TaskManagementImpl.class.getName();
    }

	public TaskManagementImpl(TaskManagementComponent record, String deadline) {
		super(record, TaskManagementImpl.class.getName());
		this.deadline = deadline;
		this.objectName = TaskManagementImpl.class.getName();
	}

	public String getDeadline() {
		return this.deadline;
	}

	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}


	public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> map = record.toHashMap();
        map.put("idTask", idTask);
		map.put("deadline", getDeadline());

        return map;
    }

}
