package TaskManagementVM.taskmanagement.core.model;

import java.util.*;
import java.lang.*;
import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="taskmanagement_comp")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class TaskManagementComponent implements TaskManagement{
	@Id
	protected int idTask; 
	protected String title;
	protected String description;
	protected String status;
	protected String objectName = TaskManagementComponent.class.getName();

	public TaskManagementComponent() {

	} 

	public TaskManagementComponent(
        int idTask, String title, String description, String status
    ) {
        this.idTask = idTask;
        this.title = title;
        this.description = description;
        this.status = status;
    }

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
 

	@Override
    public String toString() {
        return "{" +
            " idTask='" + getIdTask() + "'" +
            " title='" + getTitle() + "'" +
            " description='" + getDescription() + "'" +
            " status='" + getStatus() + "'" +
            "}";
    }
	
}
