package ProjectVM.project.programmingproject.service;

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
		String onlineRepository = (String) requestBody.get("onlineRepository");
		String defaultBranch = (String) requestBody.get("defaultBranch");
		String repositoryLink = (String) requestBody.get("repositoryLink");
		String idProjectStr = (String) requestBody.get("idProject");
		int idProject = Integer.parseInt(idProjectStr);
		String name = (String) requestBody.get("name");
		String description = (String) requestBody.get("description");
		Project projectprogrammingproject = record.createProject(requestBody);
		Project projectprogrammingprojectdeco = ProjectFactory.createProject("ProjectVM.project.programmingproject", projectprogrammingproject, idProject, name, description, onlineRepository, defaultBranch, repositoryLink);
		Repository.saveObject(projectprogrammingprojectdeco);
		return projectprogrammingprojectdeco;
	}

	public Project createProject(Map<String, Object> requestBody, int id){
		Project savedProject = Repository.getObject(id);
		String onlineRepository = (String) requestBody.get("onlineRepository");
		String defaultBranch = (String) requestBody.get("defaultBranch");
		String repositoryLink = (String) requestBody.get("repositoryLink");
		String idProjectStr = (String) requestBody.get("idProject");
		int idProject = Integer.parseInt(idProjectStr);
		String name = (String) requestBody.get("name");
		String description = (String) requestBody.get("description");
		UUID recordProjectIdProject = ((ProjectDecorator) savedProject).getIdProject();
		Project Project = record.createProject(requestBody, recordProjectIdProject);
		Project projectprogrammingproject = ProjectFactory.createProject("ProjectVM.project.programmingproject.model.ProjectImpl", Project, idProject, name, description, onlineRepository, defaultBranch, repositoryLink);
		return projectprogrammingproject;
	}

    public HashMap<String, Object> updateProject(Map<String, Object> requestBody){
		String idStr = (String) requestBody.get("idProject");
		
		Project projectprogrammingproject = Repository.getObject(id);
		projectprogrammingproject = createProject(requestBody, id);
		
		Repository.updateObject(projectprogrammingproject);
		projectprogrammingproject = Repository.getObject(id);
		
		//to do: fix association attributes
		
		return projectprogrammingproject.toHashMap();
	}

	public HashMap<String, Object> getProject(String idStr){
		int id = Integer.parseInt(idStr);
		Project projectprogrammingproject = Repository.getObject(id);
		return projectprogrammingproject.toHashMap();
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
		List<Project> List = Repository.getAllObject("project_programmingproject");
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
