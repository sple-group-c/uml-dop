package TaskManagementVM.taskmanagement.core.resource;
import java.util.*;

import TaskManagementVM.taskmanagement.core.model.TaskManagement;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;

public interface TaskManagementResource {
    List<HashMap<String,Object>> saveTaskManagement(VMJExchange vmjExchange);
    HashMap<String, Object> updateTaskManagement(VMJExchange vmjExchange);
    HashMap<String, Object> getTaskManagement(VMJExchange vmjExchange);
    List<HashMap<String,Object>> getAllTaskManagement(VMJExchange vmjExchange);
    List<HashMap<String,Object>> deleteTaskManagement(VMJExchange vmjExchange);
}
