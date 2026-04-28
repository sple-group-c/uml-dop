package ProjectVM.project.core.model;

import java.lang.*;
import java.util.*;
import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity(name="project_impl")
@Table(name="project_impl")
public class ProjectImpl extends ProjectComponent {

	public ProjectImpl(int idProject, String name, String description) {
		this.idProject = idProject;
		this.name = name;
		this.description = description;
	}

	public ProjectImpl(String name, String description) {
		Random r = new Random();
		this.idProject = Math.abs(r.nextInt());
		this.name = name;
		this.description = description;
	}

	public ProjectImpl() { }

	public int getIdProject() {
		return this.idProject;
	}

	public void setIdProject(int idProject) {
		this.idProject = idProject;
	}
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
	public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> projectMap = new HashMap<String,Object>();
		projectMap.put("idProject",getIdProject());
		projectMap.put("name",getName());
		projectMap.put("description",getDescription());

        return projectMap;
    }

}
