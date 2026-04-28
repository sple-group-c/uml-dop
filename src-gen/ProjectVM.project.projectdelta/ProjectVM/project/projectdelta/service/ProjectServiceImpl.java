package ProjectVM.project.projectdelta.service;

import java.util.*;
import java.lang.*;

import id.ac.ui.cs.prices.winvmj.core.VMJExchange;

import ProjectVM.project.core.service.ProjectServiceDecorator;
import ProjectVM.project.core.model.ProjectImpl;
import ProjectVM.project.core.service.ProjectServiceComponent;
import ProjectVM.project.core.model.Project;
import ProjectVM.project.core.model.ProjectDecorator;
import ProjectVM.project.ProjectFactory;

public class ProjectServiceImpl extends ProjectServiceDecorator {
    public ProjectServiceImpl (ProjectServiceComponent record) {
        super(record);
    }

 	public Project createProject(Map<String, Object> requestBody){
		String idProjectStr = (String) requestBody.get("idProject");
		int idProject = Integer.parseInt(idProjectStr);
		String name = (String) requestBody.get("name");
		String description = (String) requestBody.get("description");
		Project projectprojectdelta = record.createProject(requestBody);
		Project projectprojectdeltadeco = ProjectFactory.createProject("ProjectVM.project.projectdelta", projectprojectdelta, idProject, name, description);
		Repository.saveObject(projectprojectdeltadeco);
		return projectprojectdeltadeco;
	}

	public Project createProject(Map<String, Object> requestBody, int id){
		Project savedProject = Repository.getObject(id);
		String idProjectStr = (String) requestBody.get("idProject");
		int idProject = Integer.parseInt(idProjectStr);
		String name = (String) requestBody.get("name");
		String description = (String) requestBody.get("description");
		UUID recordProjectIdProject = ((ProjectDecorator) savedProject).getIdProject();
		Project Project = record.createProject(requestBody, recordProjectIdProject);
		Project projectprojectdelta = ProjectFactory.createProject("ProjectVM.project.projectdelta.model.ProjectImpl", Project, idProject, name, description);
		return projectprojectdelta;
	}

    public HashMap<String, Object> updateProject(Map<String, Object> requestBody){
		String idStr = (String) requestBody.get("idProject");
		
		Project projectprojectdelta = Repository.getObject(id);
		projectprojectdelta = createProject(requestBody, id);
		
		Repository.updateObject(projectprojectdelta);
		projectprojectdelta = Repository.getObject(id);
		
		//to do: fix association attributes
		
		return projectprojectdelta.toHashMap();
	}

	public HashMap<String, Object> getProject(String idStr){
		int id = Integer.parseInt(idStr);
		Project projectprojectdelta = Repository.getObject(id);
		return projectprojectdelta.toHashMap();
	}

	public HashMap<String, Object> getProjectById(int id){
		List<HashMap<String, Object>> projectList = getAllProject();
		for (HashMap<String, Object> project : projectList){
			int project_id = ((Double) project.get("idproject")).intValue();
			if (project_id == id){
				return project;
			}
		}
		return null;
	}

    public List<HashMap<String,Object>> getAllProject(){
		List<Project> List = Repository.getAllObject("project_projectdelta");
		return transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<Project> List){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < List.size(); i++) {
            resultList.add(List.get(i).toHashMap());
        }

        return resultList;
	}

    public List<HashMap<String,Object>> deleteProject(Map<String, Object> requestBody){
		String idStr = ((String) requestBody.get("idProject"));
		int id = Integer.parseInt(idStr);
		Repository.deleteObject(id);
		return getAllProject();
	}

	
}
