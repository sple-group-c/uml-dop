package LabelVM.label.labeldelta.model;

import java.util.*;
import java.lang.*;
import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;

import LabelVM.label.core.model.LabelDecorator;
import LabelVM.label.core.model.Label;
import LabelVM.label.core.model.LabelComponent;

@Entity(name="label_labeldelta")
@Table(name="label_labeldelta")
public class LabelImpl extends LabelDecorator {

	public String color;
	public LabelImpl() {
        super();
		Random r = new Random();
		this.idLabel = Math.abs(r.nextInt());
        this.objectName = LabelImpl.class.getName();
    }

	public LabelImpl(LabelComponent record, String color) {
		super(record, LabelImpl.class.getName());
		this.color = color;
		this.objectName = LabelImpl.class.getName();
	}



	public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> map = record.toHashMap();
        map.put("idLabel", idLabel);
		map.put("color", getColor());

        return map;
    }

}
