package ProjectVM.project.core.service;
import java.util.*;
import java.lang.*;

import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import ProjectVM.project.core.model.Project;

public abstract class ProjectServiceDecorator extends ProjectServiceComponent{
	protected ProjectServiceComponent record;

    public ProjectServiceDecorator(ProjectServiceComponent record) {
        this.record = record;
    }

	public Project createProject(Map<String, Object> requestBody){
		return record.createProject(requestBody);
	}
	
	public Project createProject(Map<String, Object> requestBody, int id){
		return record.createProject(requestBody, id);
	}

	public HashMap<String, Object> getProject(String idStr){
		return record.getProject(idStr);
	}

	public List<HashMap<String,Object>> getAllProject(){
		return record.getAllProject();
	}

    public HashMap<String, Object> updateProject(Map<String, Object> requestBody){
		return record.updateProject(requestBody);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<Project> List){
		return record.transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> deleteProject(Map<String, Object> requestBody){
		return record.deleteProject(requestBody);
	}

	public HashMap<String, Object> getProjectById(int id){
        return record.getProjectById(id);
    }

}
