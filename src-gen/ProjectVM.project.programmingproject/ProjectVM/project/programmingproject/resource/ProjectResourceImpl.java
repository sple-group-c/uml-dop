package ProjectVM.project.programmingproject.resource;
import java.util.*;
import java.lang.*;

import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import id.ac.ui.cs.prices.winvmj.core.exceptions.*;

import ProjectVM.project.core.resource.ProjectResourceDecorator;
import ProjectVM.project.core.resource.ProjectResourceComponent;
import ProjectVM.project.core.model.Project;
import ProjectVM.project.core.model.ProjectImpl;
import ProjectVM.project.core.service.ProjectServiceComponent;
import ProjectVM.project.programmingproject.service.ProjectServiceImpl;

public class ProjectResourceImpl extends ProjectResourceDecorator {
	protected ProjectServiceComponent recordComponent;
	private ProjectServiceImpl projectprogrammingprojectServiceImpl = new ProjectServiceImpl(recordComponent);

    public ProjectResourceImpl (ProjectResourceComponent record) {
        super(record);
    }

    
    @Route(url="call/programmingproject/save")
    public List<HashMap<String,Object>> saveProject(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		Project projectprogrammingproject = createProject(vmjExchange);
		return getAllProject(vmjExchange);
	}

    public Project createProject(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			Project result = projectprogrammingprojectServiceImpl.createProject(requestBody);
			return result;
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

    public Project createProject(VMJExchange vmjExchange, UUID id){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			Project result = projectprogrammingprojectServiceImpl.createProject(requestBody, id);
			return result;
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

	
    @Route(url="call/programmingproject/update")
    public HashMap<String, Object> updateProject(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")){
			return null;
		}
		return projectprogrammingprojectServiceImpl.updateProject(requestBody);
	}

	
    @Route(url="call/programmingproject/detail")
    public HashMap<String, Object> getProject(VMJExchange vmjExchange){
		return record.getProject(vmjExchange);
	}

	
    @Route(url="call/programmingproject/list")
    public List<HashMap<String,Object>> getAllProject(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload();
		return projectprogrammingprojectServiceImpl.getAllProject();
	}

    public List<HashMap<String,Object>> transformProjectListToHashMap(List<Project> ProjectProgrammingProjectList){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < ProjectProgrammingProjectList.size(); i++) {
            resultList.add(ProjectProgrammingProjectList.get(i).toHashMap());
        }

        return resultList;
	}

	
    @Route(url="call/programmingproject/delete")
    public List<HashMap<String,Object>> deleteProject(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		return projectprogrammingprojectServiceImpl.deleteProject(requestBody);
	}

	
}
