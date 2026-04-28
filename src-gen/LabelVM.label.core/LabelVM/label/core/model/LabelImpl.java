package LabelVM.label.core.model;

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


@Entity(name="label_impl")
@Table(name="label_impl")
public class LabelImpl extends LabelComponent {

	public LabelImpl(int idLabel, String name, String description) {
		this.idLabel = idLabel;
		this.name = name;
		this.description = description;
	}

	public LabelImpl(String name, String description) {
		Random r = new Random();
		this.idLabel = Math.abs(r.nextInt());
		this.name = name;
		this.description = description;
	}

	public LabelImpl() { }

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

	
	public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> labelMap = new HashMap<String,Object>();
		labelMap.put("idLabel",getIdLabel());
		labelMap.put("name",getName());
		labelMap.put("description",getDescription());

        return labelMap;
    }

}
