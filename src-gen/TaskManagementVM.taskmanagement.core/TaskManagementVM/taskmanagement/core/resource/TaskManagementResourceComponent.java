package TaskManagementVM.taskmanagement.core.resource;
import java.util.*;

import id.ac.ui.cs.prices.winvmj.hibernate.RepositoryUtil;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import TaskManagementVM.taskmanagement.core.model.TaskManagement;
//add other required packages

public abstract class TaskManagementResourceComponent implements TaskManagementResource{
	
	public TaskManagementResourceComponent() { }
 
    public abstract List<HashMap<String,Object>> saveTaskManagement(VMJExchange vmjExchange);
    public abstract TaskManagement createTaskManagement(VMJExchange vmjExchange);
	public abstract TaskManagement createTaskManagement(VMJExchange vmjExchange, int id);
	public abstract HashMap<String, Object> updateTaskManagement(VMJExchange vmjExchange);
    public abstract HashMap<String, Object> getTaskManagement(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> getAllTaskManagement(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> deleteTaskManagement(VMJExchange vmjExchange);

}
