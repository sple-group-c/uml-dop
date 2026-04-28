package LabelVM.label.core.model;

import java.util.*;
import java.lang.*;
import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;

import javax.persistence.OneToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.CascadeType;
//add other required packages

@MappedSuperclass
public abstract class LabelDecorator extends LabelComponent{
    @OneToOne(cascade=CascadeType.ALL)
	protected LabelComponent record;

	public LabelDecorator () {
		super();
		Random r = new Random();
		this.idLabel = Math.abs(r.nextInt());
	}

	public LabelDecorator (int idLabel, LabelComponent record) {
		this.idLabel =  idLabel;
		this.record = record;
	}
	
	public LabelDecorator (LabelComponent record, String objectName) {
		Random r = new Random();
		this.idLabel = Math.abs(r.nextInt());
		this.record = record;
		this.objectName=objectName;
	}


	public int getIdLabel() {
		return record.getIdLabel();
	}
	public void setIdLabel(int idLabel) {
		record.setIdLabel(idLabel);
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
