package TaskManagementVM.taskmanagement.core.service;
import java.util.*;
import java.lang.*;
import com.google.gson.Gson;
import java.util.*;
import java.util.logging.Logger;
import java.io.File;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import id.ac.ui.cs.prices.winvmj.core.exceptions.*;
import TaskManagementVM.taskmanagement.TaskManagementFactory;
import TaskManagementVM.taskmanagement.core.model.TaskManagement;
import id.ac.ui.cs.prices.winvmj.auth.annotations.Restricted;
//add other required packages

public class TaskManagementServiceImpl extends TaskManagementServiceComponent{

    public TaskManagement createTaskManagement(Map<String, Object> requestBody){
		String title = (String) requestBody.get("title");
		String description = (String) requestBody.get("description");
		String status = (String) requestBody.get("status");
		
		//to do: fix association attributes
		
		TaskManagement taskmanagement = TaskManagementFactory.createTaskManagement("TaskManagementVM.taskmanagement.core.model.TaskManagementImpl", title, description, status);
		Repository.saveObject(taskmanagement);
		return taskmanagement;
	}

	public TaskManagement createTaskManagement(Map<String, Object> requestBody, int id){
		int idTask = id;
		String title = (String) requestBody.get("title");
		String description = (String) requestBody.get("description");
		String status = (String) requestBody.get("status");
		
		//to do: fix association attributes
		TaskManagement taskmanagement = TaskManagementFactory.createTaskManagement("TaskManagementVM.taskmanagement.core.model.TaskManagementImpl",idTask, title, description, status);
		Repository.saveObject(taskmanagement);
		return taskmanagement;
	}

    public HashMap<String, Object> updateTaskManagement(Map<String, Object> requestBody){
		String idStr = (String) requestBody.get("idTask");
		int id = Integer.parseInt(idStr);
		TaskManagement taskmanagement = Repository.getObject(id);
		
		taskmanagement.setTitle((String) requestBody.get("title"));
		taskmanagement.setDescription((String) requestBody.get("description"));
		taskmanagement.setStatus((String) requestBody.get("status"));
		
		Repository.updateObject(taskmanagement);
		
		//to do: fix association attributes
		
		return taskmanagement.toHashMap();
		
	}

    public HashMap<String, Object> getTaskManagement(String idStr){
		int id = Integer.parseInt(idStr);
		TaskManagement taskmanagement = Repository.getObject(id);
		return taskmanagement.toHashMap();
	}

	public HashMap<String, Object> getTaskManagementById(int id){
		List<HashMap<String, Object>> taskmanagementList = getAllTaskManagement();
		for (HashMap<String, Object> taskmanagement : taskmanagementList){
			int record_id = ((Double) taskmanagement.get("idTask")).intValue();
			if (record_id == id){
				return taskmanagement;
			}
		}
		return null;
	}

    public List<HashMap<String,Object>> getAllTaskManagement(){
		List<TaskManagement> List = Repository.getAllObject("taskmanagement_impl");
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
