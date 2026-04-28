package TaskManagementVM.taskmanagement.taskdelta.model;

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

@Entity(name="taskmanagement_taskdelta")
@Table(name="taskmanagement_taskdelta")
public class TaskManagementImpl extends TaskManagementDecorator {

	public TaskManagementImpl() {
        super();
		Random r = new Random();
		this. = Math.abs(r.nextInt());
        this.objectName = TaskManagementImpl.class.getName();
    }

	public TaskManagementImpl(TaskManagementComponent record) {
		super(record, TaskManagementImpl.class.getName());
		this.objectName = TaskManagementImpl.class.getName();
	}



	public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> map = record.toHashMap();
        map.put("idTask", idTask);

        return map;
    }

}
