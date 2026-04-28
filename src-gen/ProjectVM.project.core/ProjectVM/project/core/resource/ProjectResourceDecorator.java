package ProjectVM.project.core.resource;
import java.util.*;

import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import ProjectVM.project.core.model.Project;

public abstract class ProjectResourceDecorator extends ProjectResourceComponent{
	protected ProjectResourceComponent record;

    public ProjectResourceDecorator(ProjectResourceComponent record) {
        this.record = record;
    }

    public List<HashMap<String,Object>> saveProject(VMJExchange vmjExchange){
		return record.saveProject(vmjExchange);
	}

    public Project createProject(VMJExchange vmjExchange){
		return record.createProject(vmjExchange);
	}
	
	public Project createProject(VMJExchange vmjExchange, int id){
		return record.createProject(vmjExchange, id);
	}

    public HashMap<String, Object> updateProject(VMJExchange vmjExchange){
		return record.updateProject(vmjExchange);
	}

    public HashMap<String, Object> getProject(VMJExchange vmjExchange){
		return record.getProject(vmjExchange);
	}

    public List<HashMap<String,Object>> getAllProject(VMJExchange vmjExchange){
		return record.getAllProject(vmjExchange);
	}

    public List<HashMap<String,Object>> deleteProject(VMJExchange vmjExchange){
		return record.deleteProject(vmjExchange);
	}

}
