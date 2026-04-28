package ProjectVM.project.core.service;
import java.util.*;
import java.lang.*;

import id.ac.ui.cs.prices.winvmj.hibernate.RepositoryUtil;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import ProjectVM.project.core.model.Project;
//add other required packages

public abstract class ProjectServiceComponent implements ProjectService{
	protected RepositoryUtil<Project> Repository;

    public ProjectServiceComponent(){
        this.Repository = new RepositoryUtil<Project>(ProjectVM.project.core.model.ProjectComponent.class);
    }	

    public abstract Project createProject(Map<String, Object> requestBody);
	public abstract Project createProject(Map<String, Object> requestBody, int id);
	public abstract HashMap<String, Object> updateProject(Map<String, Object> requestBody);
    public abstract HashMap<String, Object> getProject(String idStr);
    public abstract List<HashMap<String,Object>> getAllProject();
    public abstract List<HashMap<String,Object>> transformListToHashMap(List<Project> List);
    public abstract List<HashMap<String,Object>> deleteProject(Map<String, Object> requestBody);
	public abstract HashMap<String, Object> getProjectById(int id);

}
