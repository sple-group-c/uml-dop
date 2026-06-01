package ProjectVM.project.programmingproject.model;

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

@Entity(name="project_programmingproject")
@Table(name="project_programmingproject")
public class ProjectImpl extends ProjectDecorator {

	protected String onlineRepository;
	protected String defaultBranch;
	protected String repositoryLink;
	public ProjectImpl() {
        super();
		Random r = new Random();
		this. = Math.abs(r.nextInt());
        this.objectName = ProjectImpl.class.getName();
    }

	public ProjectImpl(ProjectComponent record, String onlineRepository, String defaultBranch, String repositoryLink) {
		super(record, ProjectImpl.class.getName());
		this.onlineRepository = onlineRepository;
		this.defaultBranch = defaultBranch;
		this.repositoryLink = repositoryLink;
		this.objectName = ProjectImpl.class.getName();
	}

	public String getOnlineRepository() {
		return this.onlineRepository;
	}

	public void setOnlineRepository(String onlineRepository) {
		this.onlineRepository = onlineRepository;
	}
	public String getDefaultBranch() {
		return this.defaultBranch;
	}

	public void setDefaultBranch(String defaultBranch) {
		this.defaultBranch = defaultBranch;
	}
	public String getRepositoryLink() {
		return this.repositoryLink;
	}

	public void setRepositoryLink(String repositoryLink) {
		this.repositoryLink = repositoryLink;
	}


	public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> map = record.toHashMap();
        map.put("idProject", idProject);
		map.put("onlineRepository", getOnlineRepository());
		map.put("defaultBranch", getDefaultBranch());
		map.put("repositoryLink", getRepositoryLink());

        return map;
    }

}
