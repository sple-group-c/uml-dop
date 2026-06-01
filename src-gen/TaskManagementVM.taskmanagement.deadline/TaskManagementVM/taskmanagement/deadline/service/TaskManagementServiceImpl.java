package TaskManagementVM.taskmanagement.deadline.service;

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
		String deadline = (String) requestBody.get("deadline");
		String idTaskStr = (String) requestBody.get("idTask");
		int idTask = Integer.parseInt(idTaskStr);
		String title = (String) requestBody.get("title");
		String description = (String) requestBody.get("description");
		String status = (String) requestBody.get("status");
		TaskManagement taskmanagementdeadline = record.createTaskManagement(requestBody);
		TaskManagement taskmanagementdeadlinedeco = TaskManagementFactory.createTaskManagement("TaskManagementVM.taskmanagement.deadline", taskmanagementdeadline, idTask, title, description, status, deadline);
		Repository.saveObject(taskmanagementdeadlinedeco);
		return taskmanagementdeadlinedeco;
	}

	public TaskManagement createTaskManagement(Map<String, Object> requestBody, int id){
		TaskManagement savedTaskManagement = Repository.getObject(id);
		String deadline = (String) requestBody.get("deadline");
		String idTaskStr = (String) requestBody.get("idTask");
		int idTask = Integer.parseInt(idTaskStr);
		String title = (String) requestBody.get("title");
		String description = (String) requestBody.get("description");
		String status = (String) requestBody.get("status");
		UUID recordTaskManagementIdTask = ((TaskManagementDecorator) savedTaskManagement).getIdTask();
		TaskManagement TaskManagement = record.createTaskManagement(requestBody, recordTaskManagementIdTask);
		TaskManagement taskmanagementdeadline = TaskManagementFactory.createTaskManagement("TaskManagementVM.taskmanagement.deadline.model.TaskManagementImpl", TaskManagement, idTask, title, description, status, deadline);
		return taskmanagementdeadline;
	}

    public HashMap<String, Object> updateTaskManagement(Map<String, Object> requestBody){
		String idStr = (String) requestBody.get("idTask");
		
		TaskManagement taskmanagementdeadline = Repository.getObject(id);
		taskmanagementdeadline = createTaskManagement(requestBody, id);
		
		Repository.updateObject(taskmanagementdeadline);
		taskmanagementdeadline = Repository.getObject(id);
		
		//to do: fix association attributes
		
		return taskmanagementdeadline.toHashMap();
	}

	public HashMap<String, Object> getTaskManagement(String idStr){
		int id = Integer.parseInt(idStr);
		TaskManagement taskmanagementdeadline = Repository.getObject(id);
		return taskmanagementdeadline.toHashMap();
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
		List<TaskManagement> List = Repository.getAllObject("taskmanagement_deadline");
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
