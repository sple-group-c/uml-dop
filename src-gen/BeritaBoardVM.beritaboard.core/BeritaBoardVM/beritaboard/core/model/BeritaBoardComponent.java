package BeritaBoardVM.beritaboard.core.model;

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
@Table(name="beritaboard_comp")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class BeritaBoardComponent implements BeritaBoard{
	@Id
	protected int beritaid; 
	protected String content;
	protected String objectName = BeritaBoardComponent.class.getName();

	public BeritaBoardComponent() {

	} 

	public BeritaBoardComponent(
        int beritaid, String content
    ) {
        this.beritaid = beritaid;
        this.content = content;
    }

	public int getBeritaid() {
		return this.beritaid;
	}

	public void setBeritaid(int beritaid) {
		this.beritaid = beritaid;
	}
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}
 

	@Override
    public String toString() {
        return "{" +
            " beritaid='" + getBeritaid() + "'" +
            " content='" + getContent() + "'" +
            "}";
    }
	
}
