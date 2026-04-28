package ProjectVM.project.core.model;

import java.util.*;
import java.lang.*;
import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="project_comp")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class ProjectComponent implements Project{
	@Id
	protected int idProject; 
	protected String name;
	protected String description;
	protected String objectName = ProjectComponent.class.getName();

	public ProjectComponent() {

	} 

	public ProjectComponent(
        int idProject, String name, String description
    ) {
        this.idProject = idProject;
        this.name = name;
        this.description = description;
    }

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
 

	@Override
    public String toString() {
        return "{" +
            " idProject='" + getIdProject() + "'" +
            " name='" + getName() + "'" +
            " description='" + getDescription() + "'" +
            "}";
    }
	
}
