package LabelVM.label.labeldelta.service;

import java.util.*;
import java.lang.*;

import id.ac.ui.cs.prices.winvmj.core.VMJExchange;

import LabelVM.label.core.service.LabelServiceDecorator;
import LabelVM.label.core.model.LabelImpl;
import LabelVM.label.core.service.LabelServiceComponent;
import LabelVM.label.core.model.Label;
import LabelVM.label.core.model.LabelDecorator;
import LabelVM.label.LabelFactory;

public class LabelServiceImpl extends LabelServiceDecorator {
    public LabelServiceImpl (LabelServiceComponent record) {
        super(record);
    }

 	public Label createLabel(Map<String, Object> requestBody){
		String idLabelStr = (String) requestBody.get("idLabel");
		int idLabel = Integer.parseInt(idLabelStr);
		String name = (String) requestBody.get("name");
		String description = (String) requestBody.get("description");
		Label labellabeldelta = record.createLabel(requestBody);
		Label labellabeldeltadeco = LabelFactory.createLabel("LabelVM.label.labeldelta", labellabeldelta, idLabel, name, description);
		Repository.saveObject(labellabeldeltadeco);
		return labellabeldeltadeco;
	}

	public Label createLabel(Map<String, Object> requestBody, int id){
		Label savedLabel = Repository.getObject(id);
		String idLabelStr = (String) requestBody.get("idLabel");
		int idLabel = Integer.parseInt(idLabelStr);
		String name = (String) requestBody.get("name");
		String description = (String) requestBody.get("description");
		UUID recordLabelIdLabel = ((LabelDecorator) savedLabel).getIdLabel();
		Label Label = record.createLabel(requestBody, recordLabelIdLabel);
		Label labellabeldelta = LabelFactory.createLabel("LabelVM.label.labeldelta.model.LabelImpl", Label, idLabel, name, description);
		return labellabeldelta;
	}

    public HashMap<String, Object> updateLabel(Map<String, Object> requestBody){
		String idStr = (String) requestBody.get("idLabel");
		
		Label labellabeldelta = Repository.getObject(id);
		labellabeldelta = createLabel(requestBody, id);
		
		Repository.updateObject(labellabeldelta);
		labellabeldelta = Repository.getObject(id);
		
		//to do: fix association attributes
		
		return labellabeldelta.toHashMap();
	}

	public HashMap<String, Object> getLabel(String idStr){
		int id = Integer.parseInt(idStr);
		Label labellabeldelta = Repository.getObject(id);
		return labellabeldelta.toHashMap();
	}

	public HashMap<String, Object> getLabelById(int id){
		List<HashMap<String, Object>> labelList = getAllLabel();
		for (HashMap<String, Object> label : labelList){
			int label_id = ((Double) label.get("idlabel")).intValue();
			if (label_id == id){
				return label;
			}
		}
		return null;
	}

    public List<HashMap<String,Object>> getAllLabel(){
		List<Label> List = Repository.getAllObject("label_labeldelta");
		return transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<Label> List){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < List.size(); i++) {
            resultList.add(List.get(i).toHashMap());
        }

        return resultList;
	}

    public List<HashMap<String,Object>> deleteLabel(Map<String, Object> requestBody){
		String idStr = ((String) requestBody.get("idLabel"));
		int id = Integer.parseInt(idStr);
		Repository.deleteObject(id);
		return getAllLabel();
	}

	
}
