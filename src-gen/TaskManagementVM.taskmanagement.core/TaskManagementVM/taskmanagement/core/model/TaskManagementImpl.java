package TaskManagementVM.taskmanagement.core.model;

import java.lang.*;
import java.util.*;
import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity(name="taskmanagement_impl")
@Table(name="taskmanagement_impl")
public class TaskManagementImpl extends TaskManagementComponent {

	public TaskManagementImpl(int idTask, String title, String description, String status) {
		this.idTask = idTask;
		this.title = title;
		this.description = description;
		this.status = status;
	}

	public TaskManagementImpl(String title, String description, String status) {
		Random r = new Random();
		this.idTask = Math.abs(r.nextInt());
		this.title = title;
		this.description = description;
		this.status = status;
	}

	public TaskManagementImpl() { }

	public int getIdTask() {
		return this.idTask;
	}

	public void setIdTask(int idTask) {
		this.idTask = idTask;
	}
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
	public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> taskmanagementMap = new HashMap<String,Object>();
		taskmanagementMap.put("idTask",getIdTask());
		taskmanagementMap.put("title",getTitle());
		taskmanagementMap.put("description",getDescription());
		taskmanagementMap.put("status",getStatus());

        return taskmanagementMap;
    }

}
