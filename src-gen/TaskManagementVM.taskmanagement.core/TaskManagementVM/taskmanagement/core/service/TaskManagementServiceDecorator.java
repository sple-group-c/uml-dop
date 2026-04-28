package TaskManagementVM.taskmanagement.core.service;
import java.util.*;
import java.lang.*;

import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import TaskManagementVM.taskmanagement.core.model.TaskManagement;

public abstract class TaskManagementServiceDecorator extends TaskManagementServiceComponent{
	protected TaskManagementServiceComponent record;

    public TaskManagementServiceDecorator(TaskManagementServiceComponent record) {
        this.record = record;
    }

	public TaskManagement createTaskManagement(Map<String, Object> requestBody){
		return record.createTaskManagement(requestBody);
	}
	
	public TaskManagement createTaskManagement(Map<String, Object> requestBody, int id){
		return record.createTaskManagement(requestBody, id);
	}

	public HashMap<String, Object> getTaskManagement(String idStr){
		return record.getTaskManagement(idStr);
	}

	public List<HashMap<String,Object>> getAllTaskManagement(){
		return record.getAllTaskManagement();
	}

    public HashMap<String, Object> updateTaskManagement(Map<String, Object> requestBody){
		return record.updateTaskManagement(requestBody);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<TaskManagement> List){
		return record.transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> deleteTaskManagement(Map<String, Object> requestBody){
		return record.deleteTaskManagement(requestBody);
	}

	public HashMap<String, Object> getTaskManagementById(int id){
        return record.getTaskManagementById(id);
    }

}
