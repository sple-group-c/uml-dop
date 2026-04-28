package ProjectVM.project.core.resource;
import java.util.*;

import ProjectVM.project.core.model.Project;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;

public interface ProjectResource {
    List<HashMap<String,Object>> saveProject(VMJExchange vmjExchange);
    HashMap<String, Object> updateProject(VMJExchange vmjExchange);
    HashMap<String, Object> getProject(VMJExchange vmjExchange);
    List<HashMap<String,Object>> getAllProject(VMJExchange vmjExchange);
    List<HashMap<String,Object>> deleteProject(VMJExchange vmjExchange);
}
