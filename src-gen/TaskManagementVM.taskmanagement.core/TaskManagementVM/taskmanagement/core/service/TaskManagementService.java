package TaskManagementVM.taskmanagement.core.service;
import java.util.*;

import TaskManagementVM.taskmanagement.core.model.TaskManagement;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;

public interface TaskManagementService {
	TaskManagement createTaskManagement(Map<String, Object> requestBody);
	HashMap<String, Object> getTaskManagement(String idStr);
    HashMap<String, Object> updateTaskManagement(Map<String, Object> requestBody);
    List<HashMap<String,Object>> getAllTaskManagement();
    List<HashMap<String,Object>> deleteTaskManagement(Map<String, Object> requestBody);
	List<HashMap<String, Object>> transformListToHashMap(List<TaskManagement> List);
}
