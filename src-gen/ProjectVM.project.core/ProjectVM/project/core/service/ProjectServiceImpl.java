package ProjectVM.project.core.service;
import java.util.*;
import java.lang.*;
import com.google.gson.Gson;
import java.util.*;
import java.util.logging.Logger;
import java.io.File;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import id.ac.ui.cs.prices.winvmj.core.exceptions.*;
import ProjectVM.project.ProjectFactory;
import ProjectVM.project.core.model.Project;
import id.ac.ui.cs.prices.winvmj.auth.annotations.Restricted;
//add other required packages

public class ProjectServiceImpl extends ProjectServiceComponent{

    public Project createProject(Map<String, Object> requestBody){
		String name = (String) requestBody.get("name");
		String description = (String) requestBody.get("description");
		
		//to do: fix association attributes
		
		Project project = ProjectFactory.createProject("ProjectVM.project.core.model.ProjectImpl", name, description);
		Repository.saveObject(project);
		return project;
	}

	public Project createProject(Map<String, Object> requestBody, int id){
		int idProject = id;
		String name = (String) requestBody.get("name");
		String description = (String) requestBody.get("description");
		
		//to do: fix association attributes
		Project project = ProjectFactory.createProject("ProjectVM.project.core.model.ProjectImpl",idProject, name, description);
		Repository.saveObject(project);
		return project;
	}

    public HashMap<String, Object> updateProject(Map<String, Object> requestBody){
		String idStr = (String) requestBody.get("idProject");
		int id = Integer.parseInt(idStr);
		Project project = Repository.getObject(id);
		
		project.setName((String) requestBody.get("name"));
		project.setDescription((String) requestBody.get("description"));
		
		Repository.updateObject(project);
		
		//to do: fix association attributes
		
		return project.toHashMap();
		
	}

    public HashMap<String, Object> getProject(String idStr){
		int id = Integer.parseInt(idStr);
		Project project = Repository.getObject(id);
		return project.toHashMap();
	}

	public HashMap<String, Object> getProjectById(int id){
		List<HashMap<String, Object>> projectList = getAllProject();
		for (HashMap<String, Object> project : projectList){
			int record_id = ((Double) project.get("idProject")).intValue();
			if (record_id == id){
				return project;
			}
		}
		return null;
	}

    public List<HashMap<String,Object>> getAllProject(){
		List<Project> List = Repository.getAllObject("project_impl");
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
