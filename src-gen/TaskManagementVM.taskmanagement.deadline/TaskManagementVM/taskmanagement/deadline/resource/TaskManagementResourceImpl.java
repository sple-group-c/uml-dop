package TaskManagementVM.taskmanagement.deadline.resource;
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
import TaskManagementVM.taskmanagement.deadline.service.TaskManagementServiceImpl;

public class TaskManagementResourceImpl extends TaskManagementResourceDecorator {
	protected TaskManagementServiceComponent recordComponent;
	private TaskManagementServiceImpl taskmanagementdeadlineServiceImpl = new TaskManagementServiceImpl(recordComponent);

    public TaskManagementResourceImpl (TaskManagementResourceComponent record) {
        super(record);
    }

    
    @Route(url="call/deadline/save")
    public List<HashMap<String,Object>> saveTaskManagement(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		TaskManagement taskmanagementdeadline = createTaskManagement(vmjExchange);
		return getAllTaskManagement(vmjExchange);
	}

    public TaskManagement createTaskManagement(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			TaskManagement result = taskmanagementdeadlineServiceImpl.createTaskManagement(requestBody);
			return result;
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

    public TaskManagement createTaskManagement(VMJExchange vmjExchange, UUID id){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			TaskManagement result = taskmanagementdeadlineServiceImpl.createTaskManagement(requestBody, id);
			return result;
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

	
    @Route(url="call/deadline/update")
    public HashMap<String, Object> updateTaskManagement(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")){
			return null;
		}
		return taskmanagementdeadlineServiceImpl.updateTaskManagement(requestBody);
	}

	
    @Route(url="call/deadline/detail")
    public HashMap<String, Object> getTaskManagement(VMJExchange vmjExchange){
		return record.getTaskManagement(vmjExchange);
	}

	
    @Route(url="call/deadline/list")
    public List<HashMap<String,Object>> getAllTaskManagement(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload();
		return taskmanagementdeadlineServiceImpl.getAllTaskManagement();
	}

    public List<HashMap<String,Object>> transformTaskManagementListToHashMap(List<TaskManagement> TaskManagementDeadlineList){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < TaskManagementDeadlineList.size(); i++) {
            resultList.add(TaskManagementDeadlineList.get(i).toHashMap());
        }

        return resultList;
	}

	
    @Route(url="call/deadline/delete")
    public List<HashMap<String,Object>> deleteTaskManagement(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		return taskmanagementdeadlineServiceImpl.deleteTaskManagement(requestBody);
	}

	
}
