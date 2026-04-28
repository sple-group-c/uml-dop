package TaskManagementVM.taskmanagement.core.resource;
import java.util.*;

import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import TaskManagementVM.taskmanagement.core.model.TaskManagement;

public abstract class TaskManagementResourceDecorator extends TaskManagementResourceComponent{
	protected TaskManagementResourceComponent record;

    public TaskManagementResourceDecorator(TaskManagementResourceComponent record) {
        this.record = record;
    }

    public List<HashMap<String,Object>> saveTaskManagement(VMJExchange vmjExchange){
		return record.saveTaskManagement(vmjExchange);
	}

    public TaskManagement createTaskManagement(VMJExchange vmjExchange){
		return record.createTaskManagement(vmjExchange);
	}
	
	public TaskManagement createTaskManagement(VMJExchange vmjExchange, int id){
		return record.createTaskManagement(vmjExchange, id);
	}

    public HashMap<String, Object> updateTaskManagement(VMJExchange vmjExchange){
		return record.updateTaskManagement(vmjExchange);
	}

    public HashMap<String, Object> getTaskManagement(VMJExchange vmjExchange){
		return record.getTaskManagement(vmjExchange);
	}

    public List<HashMap<String,Object>> getAllTaskManagement(VMJExchange vmjExchange){
		return record.getAllTaskManagement(vmjExchange);
	}

    public List<HashMap<String,Object>> deleteTaskManagement(VMJExchange vmjExchange){
		return record.deleteTaskManagement(vmjExchange);
	}

}
