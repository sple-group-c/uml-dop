package ProjectVM.project.core.resource;
import java.util.*;

import id.ac.ui.cs.prices.winvmj.hibernate.RepositoryUtil;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import ProjectVM.project.core.model.Project;
//add other required packages

public abstract class ProjectResourceComponent implements ProjectResource{
	
	public ProjectResourceComponent() { }
 
    public abstract List<HashMap<String,Object>> saveProject(VMJExchange vmjExchange);
    public abstract Project createProject(VMJExchange vmjExchange);
	public abstract Project createProject(VMJExchange vmjExchange, int id);
	public abstract HashMap<String, Object> updateProject(VMJExchange vmjExchange);
    public abstract HashMap<String, Object> getProject(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> getAllProject(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> deleteProject(VMJExchange vmjExchange);

}
