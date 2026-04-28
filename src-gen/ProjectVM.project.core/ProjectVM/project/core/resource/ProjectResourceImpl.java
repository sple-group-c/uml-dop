package ProjectVM.project.core.resource;
import java.util.*;

import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import id.ac.ui.cs.prices.winvmj.core.exceptions.*;
import ProjectVM.project.ProjectFactory;
import id.ac.ui.cs.prices.winvmj.auth.annotations.Restricted;
import ProjectVM.project.core.model.Project;
import ProjectVM.project.core.service.ProjectServiceImpl;
//add other required packages


public class ProjectResourceImpl extends ProjectResourceComponent{
	
	private ProjectServiceImpl projectServiceImpl = new ProjectServiceImpl();

	
    @Route(url="call/project/save")
    public List<HashMap<String,Object>> saveProject(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		Project project = createProject(vmjExchange);
		return projectServiceImpl.getAllProject();
	}

    public Project createProject(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			Project result = projectServiceImpl.createProject(requestBody);
			return result;
		}
		throw new NotFoundException("Route tidak ditemukan");
	}
	
	public Project createProject(VMJExchange vmjExchange, int id){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			Project result = projectServiceImpl.createProject(requestBody, id);
			return result;
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

	
    @Route(url="call/project/update")
    public HashMap<String, Object> updateProject(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")){
			return null;
		}
		return projectServiceImpl.updateProject(requestBody);
		
	}

	
    @Route(url="call/project/detail")
    public HashMap<String, Object> getProject(VMJExchange vmjExchange){
		String idStr = vmjExchange.getGETParam("idProject");
		return projectServiceImpl.getProject(idStr);
	}

	
    @Route(url="call/project/list")
    public List<HashMap<String,Object>> getAllProject(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		return projectServiceImpl.getAllProject();
	}

	
    @Route(url="call/project/delete")
    public List<HashMap<String,Object>> deleteProject(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		return projectServiceImpl.deleteProject(requestBody);
	}


}
