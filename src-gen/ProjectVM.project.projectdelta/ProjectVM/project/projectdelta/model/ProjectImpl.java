package ProjectVM.project.projectdelta.model;

import java.util.*;
import java.lang.*;
import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;

import ProjectVM.project.core.model.ProjectDecorator;
import ProjectVM.project.core.model.Project;
import ProjectVM.project.core.model.ProjectComponent;

@Entity(name="project_projectdelta")
@Table(name="project_projectdelta")
public class ProjectImpl extends ProjectDecorator {

	public ProjectImpl() {
        super();
		Random r = new Random();
		this. = Math.abs(r.nextInt());
        this.objectName = ProjectImpl.class.getName();
    }

	public ProjectImpl(ProjectComponent record) {
		super(record, ProjectImpl.class.getName());
		this.objectName = ProjectImpl.class.getName();
	}



	public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> map = record.toHashMap();
        map.put("idProject", idProject);

        return map;
    }

}
