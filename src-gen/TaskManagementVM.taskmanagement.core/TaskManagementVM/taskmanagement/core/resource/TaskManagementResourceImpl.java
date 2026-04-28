package TaskManagementVM.taskmanagement.core.resource;
import java.util.*;

import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import id.ac.ui.cs.prices.winvmj.core.exceptions.*;
import TaskManagementVM.taskmanagement.TaskManagementFactory;
import id.ac.ui.cs.prices.winvmj.auth.annotations.Restricted;
import TaskManagementVM.taskmanagement.core.model.TaskManagement;
import TaskManagementVM.taskmanagement.core.service.TaskManagementServiceImpl;
//add other required packages


public class TaskManagementResourceImpl extends TaskManagementResourceComponent{
	
	private TaskManagementServiceImpl taskmanagementServiceImpl = new TaskManagementServiceImpl();

	
    @Route(url="call/taskmanagement/save")
    public List<HashMap<String,Object>> saveTaskManagement(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		TaskManagement taskmanagement = createTaskManagement(vmjExchange);
		return taskmanagementServiceImpl.getAllTaskManagement();
	}

    public TaskManagement createTaskManagement(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			TaskManagement result = taskmanagementServiceImpl.createTaskManagement(requestBody);
			return result;
		}
		throw new NotFoundException("Route tidak ditemukan");
	}
	
	public TaskManagement createTaskManagement(VMJExchange vmjExchange, int id){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			TaskManagement result = taskmanagementServiceImpl.createTaskManagement(requestBody, id);
			return result;
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

	
    @Route(url="call/taskmanagement/update")
    public HashMap<String, Object> updateTaskManagement(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")){
			return null;
		}
		return taskmanagementServiceImpl.updateTaskManagement(requestBody);
		
	}

	
    @Route(url="call/taskmanagement/detail")
    public HashMap<String, Object> getTaskManagement(VMJExchange vmjExchange){
		String idStr = vmjExchange.getGETParam("idTask");
		return taskmanagementServiceImpl.getTaskManagement(idStr);
	}

	
    @Route(url="call/taskmanagement/list")
    public List<HashMap<String,Object>> getAllTaskManagement(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		return taskmanagementServiceImpl.getAllTaskManagement();
	}

	
    @Route(url="call/taskmanagement/delete")
    public List<HashMap<String,Object>> deleteTaskManagement(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		return taskmanagementServiceImpl.deleteTaskManagement(requestBody);
	}


}
