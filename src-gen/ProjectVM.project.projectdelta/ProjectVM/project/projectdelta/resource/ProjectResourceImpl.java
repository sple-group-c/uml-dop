package ProjectVM.project.projectdelta.resource;
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
import ProjectVM.project.projectdelta.service.ProjectServiceImpl;

public class ProjectResourceImpl extends ProjectResourceDecorator {
	protected ProjectServiceComponent recordComponent;
	private ProjectServiceImpl projectprojectdeltaServiceImpl = new ProjectServiceImpl(recordComponent);

    public ProjectResourceImpl (ProjectResourceComponent record) {
        super(record);
    }

    
    @Route(url="call/projectdelta/save")
    public List<HashMap<String,Object>> saveProject(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		Project projectprojectdelta = createProject(vmjExchange);
		return getAllProject(vmjExchange);
	}

    public Project createProject(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			Project result = projectprojectdeltaServiceImpl.createProject(requestBody);
			return result;
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

    public Project createProject(VMJExchange vmjExchange, UUID id){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			Project result = projectprojectdeltaServiceImpl.createProject(requestBody, id);
			return result;
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

	
    @Route(url="call/projectdelta/update")
    public HashMap<String, Object> updateProject(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")){
			return null;
		}
		return projectprojectdeltaServiceImpl.updateProject(requestBody);
	}

	
    @Route(url="call/projectdelta/detail")
    public HashMap<String, Object> getProject(VMJExchange vmjExchange){
		return record.getProject(vmjExchange);
	}

	
    @Route(url="call/projectdelta/list")
    public List<HashMap<String,Object>> getAllProject(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload();
		return projectprojectdeltaServiceImpl.getAllProject();
	}

    public List<HashMap<String,Object>> transformProjectListToHashMap(List<Project> ProjectProjectDeltaList){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < ProjectProjectDeltaList.size(); i++) {
            resultList.add(ProjectProjectDeltaList.get(i).toHashMap());
        }

        return resultList;
	}

	
    @Route(url="call/projectdelta/delete")
    public List<HashMap<String,Object>> deleteProject(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		return projectprojectdeltaServiceImpl.deleteProject(requestBody);
	}

	
}
