package TaskManagementVM.taskmanagement.coba.service;

import java.util.*;
import java.lang.*;

import id.ac.ui.cs.prices.winvmj.core.VMJExchange;

import TaskManagementVM.taskmanagement.core.service.TaskManagementServiceDecorator;
import TaskManagementVM.taskmanagement.core.model.TaskManagementImpl;
import TaskManagementVM.taskmanagement.core.service.TaskManagementServiceComponent;
import TaskManagementVM.taskmanagement.core.model.TaskManagement;
import TaskManagementVM.taskmanagement.core.model.TaskManagementDecorator;
import TaskManagementVM.taskmanagement.TaskManagementFactory;

public class TaskManagementServiceImpl extends TaskManagementServiceDecorator {
    public TaskManagementServiceImpl (TaskManagementServiceComponent record) {
        super(record);
    }

 	public TaskManagement createTaskManagement(Map<String, Object> requestBody){
		String Deadline = (String) requestBody.get("Deadline");
		String idTaskStr = (String) requestBody.get("idTask");
		int idTask = Integer.parseInt(idTaskStr);
		String title = (String) requestBody.get("title");
		String description = (String) requestBody.get("description");
		String status = (String) requestBody.get("status");
		TaskManagement taskmanagementcoba = record.createTaskManagement(requestBody);
		TaskManagement taskmanagementcobadeco = TaskManagementFactory.createTaskManagement("TaskManagementVM.taskmanagement.coba", taskmanagementcoba, idTask, title, description, status, Deadline);
		Repository.saveObject(taskmanagementcobadeco);
		return taskmanagementcobadeco;
	}

	public TaskManagement createTaskManagement(Map<String, Object> requestBody, int id){
		TaskManagement savedTaskManagement = Repository.getObject(id);
		String Deadline = (String) requestBody.get("Deadline");
		String idTaskStr = (String) requestBody.get("idTask");
		int idTask = Integer.parseInt(idTaskStr);
		String title = (String) requestBody.get("title");
		String description = (String) requestBody.get("description");
		String status = (String) requestBody.get("status");
		UUID recordTaskManagementIdTask = ((TaskManagementDecorator) savedTaskManagement).getIdTask();
		TaskManagement TaskManagement = record.createTaskManagement(requestBody, recordTaskManagementIdTask);
		TaskManagement taskmanagementcoba = TaskManagementFactory.createTaskManagement("TaskManagementVM.taskmanagement.coba.model.TaskManagementImpl", TaskManagement, idTask, title, description, status, Deadline);
		return taskmanagementcoba;
	}

    public HashMap<String, Object> updateTaskManagement(Map<String, Object> requestBody){
		String idStr = (String) requestBody.get("idTask");
		
		TaskManagement taskmanagementcoba = Repository.getObject(id);
		taskmanagementcoba = createTaskManagement(requestBody, id);
		
		Repository.updateObject(taskmanagementcoba);
		taskmanagementcoba = Repository.getObject(id);
		
		//to do: fix association attributes
		
		return taskmanagementcoba.toHashMap();
	}

	public HashMap<String, Object> getTaskManagement(String idStr){
		int id = Integer.parseInt(idStr);
		TaskManagement taskmanagementcoba = Repository.getObject(id);
		return taskmanagementcoba.toHashMap();
	}

	public HashMap<String, Object> getTaskManagementById(int id){
		List<HashMap<String, Object>> taskmanagementList = getAllTaskManagement();
		for (HashMap<String, Object> taskmanagement : taskmanagementList){
			int taskmanagement_id = ((Double) taskmanagement.get("idtask")).intValue();
			if (taskmanagement_id == id){
				return taskmanagement;
			}
		}
		return null;
	}

    public List<HashMap<String,Object>> getAllTaskManagement(){
		List<TaskManagement> List = Repository.getAllObject("taskmanagement_coba");
		return transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<TaskManagement> List){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < List.size(); i++) {
            resultList.add(List.get(i).toHashMap());
        }

        return resultList;
	}

    public List<HashMap<String,Object>> deleteTaskManagement(Map<String, Object> requestBody){
		String idStr = ((String) requestBody.get("idTask"));
		int id = Integer.parseInt(idStr);
		Repository.deleteObject(id);
		return getAllTaskManagement();
	}

	
}
