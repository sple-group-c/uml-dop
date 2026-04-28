package TaskManagementVM.taskmanagement.core.model;
import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import java.util.*;
import java.lang.*;

public interface TaskManagement {
	    public int getIdTask();
	    public void setIdTask(int idTask);
	    public String getTitle();
	    public void setTitle(String title);
	    public String getDescription();
	    public void setDescription(String description);
	    public String getStatus();
	    public void setStatus(String status);
	HashMap<String, Object> toHashMap();
}
