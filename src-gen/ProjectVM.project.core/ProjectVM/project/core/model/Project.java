package ProjectVM.project.core.model;
import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import java.util.*;
import java.lang.*;

public interface Project {
	    public int getIdProject();
	    public void setIdProject(int idProject);
	    public String getName();
	    public void setName(String name);
	    public String getDescription();
	    public void setDescription(String description);
	HashMap<String, Object> toHashMap();
}
