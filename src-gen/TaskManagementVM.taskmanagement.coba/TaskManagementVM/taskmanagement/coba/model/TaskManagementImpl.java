package TaskManagementVM.taskmanagement.coba.model;

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

@Entity(name="taskmanagement_coba")
@Table(name="taskmanagement_coba")
public class TaskManagementImpl extends TaskManagementDecorator {

	protected String Deadline;
	public TaskManagementImpl() {
        super();
		Random r = new Random();
		this. = Math.abs(r.nextInt());
        this.objectName = TaskManagementImpl.class.getName();
    }

	public TaskManagementImpl(TaskManagementComponent record, String Deadline) {
		super(record, TaskManagementImpl.class.getName());
		this.Deadline = Deadline;
		this.objectName = TaskManagementImpl.class.getName();
	}

	public String getDeadline() {
		return this.Deadline;
	}

	public void setDeadline(String Deadline) {
		this.Deadline = Deadline;
	}


	public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> map = record.toHashMap();
        map.put("idTask", idTask);
		map.put("Deadline", getDeadline());

        return map;
    }

}
