package LabelVM.label.core.service;
import java.util.*;
import java.lang.*;

import id.ac.ui.cs.prices.winvmj.hibernate.RepositoryUtil;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import LabelVM.label.core.model.Label;
//add other required packages

public abstract class LabelServiceComponent implements LabelService{
	protected RepositoryUtil<Label> Repository;

    public LabelServiceComponent(){
        this.Repository = new RepositoryUtil<Label>(LabelVM.label.core.model.LabelComponent.class);
    }	

    public abstract Label createLabel(Map<String, Object> requestBody);
	public abstract Label createLabel(Map<String, Object> requestBody, int id);
	public abstract HashMap<String, Object> updateLabel(Map<String, Object> requestBody);
    public abstract HashMap<String, Object> getLabel(String idStr);
    public abstract List<HashMap<String,Object>> getAllLabel();
    public abstract List<HashMap<String,Object>> transformListToHashMap(List<Label> List);
    public abstract List<HashMap<String,Object>> deleteLabel(Map<String, Object> requestBody);
	public abstract HashMap<String, Object> getLabelById(int id);

}
