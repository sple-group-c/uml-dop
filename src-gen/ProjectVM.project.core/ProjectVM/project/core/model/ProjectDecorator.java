package ProjectVM.project.core.model;

import java.util.*;
import java.lang.*;
import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;

import javax.persistence.OneToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.CascadeType;
//add other required packages

@MappedSuperclass
public abstract class ProjectDecorator extends ProjectComponent{
    @OneToOne(cascade=CascadeType.ALL)
	protected ProjectComponent record;

	public ProjectDecorator () {
		super();
		Random r = new Random();
		this.idProject = Math.abs(r.nextInt());
	}

	public ProjectDecorator (int idProject, ProjectComponent record) {
		this.idProject =  idProject;
		this.record = record;
	}
	
	public ProjectDecorator (ProjectComponent record, String objectName) {
		Random r = new Random();
		this.idProject = Math.abs(r.nextInt());
		this.record = record;
		this.objectName=objectName;
	}


	public int getIdProject() {
		return record.getIdProject();
	}
	public void setIdProject(int idProject) {
		record.setIdProject(idProject);
	}
	public String getName() {
		return record.getName();
	}
	public void setName(String name) {
		record.setName(name);
	}
	public String getDescription() {
		return record.getDescription();
	}
	public void setDescription(String description) {
		record.setDescription(description);
	}


	public HashMap<String, Object> toHashMap() {
        return this.record.toHashMap();
    }

}
