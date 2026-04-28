package LabelVM.label.core.model;

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
@Table(name="label_comp")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class LabelComponent implements Label{
	@Id
	protected int idLabel; 
	protected String name;
	protected String description;
	protected String objectName = LabelComponent.class.getName();

	public LabelComponent() {

	} 

	public LabelComponent(
        int idLabel, String name, String description
    ) {
        this.idLabel = idLabel;
        this.name = name;
        this.description = description;
    }

	public int getIdLabel() {
		return this.idLabel;
	}

	public void setIdLabel(int idLabel) {
		this.idLabel = idLabel;
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
            " idLabel='" + getIdLabel() + "'" +
            " name='" + getName() + "'" +
            " description='" + getDescription() + "'" +
            "}";
    }
	
}
