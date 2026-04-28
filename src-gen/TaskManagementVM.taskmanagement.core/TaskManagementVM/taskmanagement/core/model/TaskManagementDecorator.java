package TaskManagementVM.taskmanagement.core.model;

import java.util.*;
import java.lang.*;
import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;

import javax.persistence.OneToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.CascadeType;
//add other required packages

@MappedSuperclass
public abstract class TaskManagementDecorator extends TaskManagementComponent{
    @OneToOne(cascade=CascadeType.ALL)
	protected TaskManagementComponent record;

	public TaskManagementDecorator () {
		super();
		Random r = new Random();
		this.idTask = Math.abs(r.nextInt());
	}

	public TaskManagementDecorator (int idTask, TaskManagementComponent record) {
		this.idTask =  idTask;
		this.record = record;
	}
	
	public TaskManagementDecorator (TaskManagementComponent record, String objectName) {
		Random r = new Random();
		this.idTask = Math.abs(r.nextInt());
		this.record = record;
		this.objectName=objectName;
	}


	public int getIdTask() {
		return record.getIdTask();
	}
	public void setIdTask(int idTask) {
		record.setIdTask(idTask);
	}
	public String getTitle() {
		return record.getTitle();
	}
	public void setTitle(String title) {
		record.setTitle(title);
	}
	public String getDescription() {
		return record.getDescription();
	}
	public void setDescription(String description) {
		record.setDescription(description);
	}
	public String getStatus() {
		return record.getStatus();
	}
	public void setStatus(String status) {
		record.setStatus(status);
	}


	public HashMap<String, Object> toHashMap() {
        return this.record.toHashMap();
    }

}
