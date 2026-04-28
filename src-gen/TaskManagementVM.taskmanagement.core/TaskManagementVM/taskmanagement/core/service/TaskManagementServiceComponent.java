package TaskManagementVM.taskmanagement.core.service;
import java.util.*;
import java.lang.*;

import id.ac.ui.cs.prices.winvmj.hibernate.RepositoryUtil;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import TaskManagementVM.taskmanagement.core.model.TaskManagement;
//add other required packages

public abstract class TaskManagementServiceComponent implements TaskManagementService{
	protected RepositoryUtil<TaskManagement> Repository;

    public TaskManagementServiceComponent(){
        this.Repository = new RepositoryUtil<TaskManagement>(TaskManagementVM.taskmanagement.core.model.TaskManagementComponent.class);
    }	

    public abstract TaskManagement createTaskManagement(Map<String, Object> requestBody);
	public abstract TaskManagement createTaskManagement(Map<String, Object> requestBody, int id);
	public abstract HashMap<String, Object> updateTaskManagement(Map<String, Object> requestBody);
    public abstract HashMap<String, Object> getTaskManagement(String idStr);
    public abstract List<HashMap<String,Object>> getAllTaskManagement();
    public abstract List<HashMap<String,Object>> transformListToHashMap(List<TaskManagement> List);
    public abstract List<HashMap<String,Object>> deleteTaskManagement(Map<String, Object> requestBody);
	public abstract HashMap<String, Object> getTaskManagementById(int id);

}
