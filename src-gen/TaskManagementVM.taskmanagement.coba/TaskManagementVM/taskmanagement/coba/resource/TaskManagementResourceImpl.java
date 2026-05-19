package TaskManagementVM.taskmanagement.coba.resource;
import java.util.*;
import java.lang.*;

import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import id.ac.ui.cs.prices.winvmj.core.exceptions.*;

import TaskManagementVM.taskmanagement.core.resource.TaskManagementResourceDecorator;
import TaskManagementVM.taskmanagement.core.resource.TaskManagementResourceComponent;
import TaskManagementVM.taskmanagement.core.model.TaskManagement;
import TaskManagementVM.taskmanagement.core.model.TaskManagementImpl;
import TaskManagementVM.taskmanagement.core.service.TaskManagementServiceComponent;
import TaskManagementVM.taskmanagement.coba.service.TaskManagementServiceImpl;

public class TaskManagementResourceImpl extends TaskManagementResourceDecorator {
	protected TaskManagementServiceComponent recordComponent;
	private TaskManagementServiceImpl taskmanagementcobaServiceImpl = new TaskManagementServiceImpl(recordComponent);

    public TaskManagementResourceImpl (TaskManagementResourceComponent record) {
        super(record);
    }

    
    @Route(url="call/coba/save")
    public List<HashMap<String,Object>> saveTaskManagement(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		TaskManagement taskmanagementcoba = createTaskManagement(vmjExchange);
		return getAllTaskManagement(vmjExchange);
	}

    public TaskManagement createTaskManagement(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			TaskManagement result = taskmanagementcobaServiceImpl.createTaskManagement(requestBody);
			return result;
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

    public TaskManagement createTaskManagement(VMJExchange vmjExchange, UUID id){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			TaskManagement result = taskmanagementcobaServiceImpl.createTaskManagement(requestBody, id);
			return result;
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

	
    @Route(url="call/coba/update")
    public HashMap<String, Object> updateTaskManagement(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")){
			return null;
		}
		return taskmanagementcobaServiceImpl.updateTaskManagement(requestBody);
	}

	
    @Route(url="call/coba/detail")
    public HashMap<String, Object> getTaskManagement(VMJExchange vmjExchange){
		return record.getTaskManagement(vmjExchange);
	}

	
    @Route(url="call/coba/list")
    public List<HashMap<String,Object>> getAllTaskManagement(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload();
		return taskmanagementcobaServiceImpl.getAllTaskManagement();
	}

    public List<HashMap<String,Object>> transformTaskManagementListToHashMap(List<TaskManagement> TaskManagementCobaList){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < TaskManagementCobaList.size(); i++) {
            resultList.add(TaskManagementCobaList.get(i).toHashMap());
        }

        return resultList;
	}

	
    @Route(url="call/coba/delete")
    public List<HashMap<String,Object>> deleteTaskManagement(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		return taskmanagementcobaServiceImpl.deleteTaskManagement(requestBody);
	}

	
}
