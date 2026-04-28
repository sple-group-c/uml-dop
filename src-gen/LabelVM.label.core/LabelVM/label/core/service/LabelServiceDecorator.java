package LabelVM.label.core.service;
import java.util.*;
import java.lang.*;

import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import LabelVM.label.core.model.Label;

public abstract class LabelServiceDecorator extends LabelServiceComponent{
	protected LabelServiceComponent record;

    public LabelServiceDecorator(LabelServiceComponent record) {
        this.record = record;
    }

	public Label createLabel(Map<String, Object> requestBody){
		return record.createLabel(requestBody);
	}
	
	public Label createLabel(Map<String, Object> requestBody, int id){
		return record.createLabel(requestBody, id);
	}

	public HashMap<String, Object> getLabel(String idStr){
		return record.getLabel(idStr);
	}

	public List<HashMap<String,Object>> getAllLabel(){
		return record.getAllLabel();
	}

    public HashMap<String, Object> updateLabel(Map<String, Object> requestBody){
		return record.updateLabel(requestBody);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<Label> List){
		return record.transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> deleteLabel(Map<String, Object> requestBody){
		return record.deleteLabel(requestBody);
	}

	public HashMap<String, Object> getLabelById(int id){
        return record.getLabelById(id);
    }

}
