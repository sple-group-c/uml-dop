package ProjectVM.project.core.service;
import java.util.*;

import ProjectVM.project.core.model.Project;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;

public interface ProjectService {
	Project createProject(Map<String, Object> requestBody);
	HashMap<String, Object> getProject(String idStr);
    HashMap<String, Object> updateProject(Map<String, Object> requestBody);
    List<HashMap<String,Object>> getAllProject();
    List<HashMap<String,Object>> deleteProject(Map<String, Object> requestBody);
	List<HashMap<String, Object>> transformListToHashMap(List<Project> List);
}
