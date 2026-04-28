package TaskManagementVM.taskmanagement.taskdelta.resource;
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
import TaskManagementVM.taskmanagement.taskdelta.service.TaskManagementServiceImpl;

public class TaskManagementResourceImpl extends TaskManagementResourceDecorator {
	protected TaskManagementServiceComponent recordComponent;
	private TaskManagementServiceImpl taskmanagementtaskdeltaServiceImpl = new TaskManagementServiceImpl(recordComponent);

    public TaskManagementResourceImpl (TaskManagementResourceComponent record) {
        super(record);
    }

    
    @Route(url="call/taskdelta/save")
    public List<HashMap<String,Object>> saveTaskManagement(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		TaskManagement taskmanagementtaskdelta = createTaskManagement(vmjExchange);
		return getAllTaskManagement(vmjExchange);
	}

    public TaskManagement createTaskManagement(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			TaskManagement result = taskmanagementtaskdeltaServiceImpl.createTaskManagement(requestBody);
			return result;
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

    public TaskManagement createTaskManagement(VMJExchange vmjExchange, UUID id){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			TaskManagement result = taskmanagementtaskdeltaServiceImpl.createTaskManagement(requestBody, id);
			return result;
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

	
    @Route(url="call/taskdelta/update")
    public HashMap<String, Object> updateTaskManagement(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")){
			return null;
		}
		return taskmanagementtaskdeltaServiceImpl.updateTaskManagement(requestBody);
	}

	
    @Route(url="call/taskdelta/detail")
    public HashMap<String, Object> getTaskManagement(VMJExchange vmjExchange){
		return record.getTaskManagement(vmjExchange);
	}

	
    @Route(url="call/taskdelta/list")
    public List<HashMap<String,Object>> getAllTaskManagement(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload();
		return taskmanagementtaskdeltaServiceImpl.getAllTaskManagement();
	}

    public List<HashMap<String,Object>> transformTaskManagementListToHashMap(List<TaskManagement> TaskManagementTaskDeltaList){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < TaskManagementTaskDeltaList.size(); i++) {
            resultList.add(TaskManagementTaskDeltaList.get(i).toHashMap());
        }

        return resultList;
	}

	
    @Route(url="call/taskdelta/delete")
    public List<HashMap<String,Object>> deleteTaskManagement(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		return taskmanagementtaskdeltaServiceImpl.deleteTaskManagement(requestBody);
	}

	
}
