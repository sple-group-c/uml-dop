package LabelVM.label.core.service;
import java.util.*;
import java.lang.*;
import com.google.gson.Gson;
import java.util.*;
import java.util.logging.Logger;
import java.io.File;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import id.ac.ui.cs.prices.winvmj.core.exceptions.*;
import LabelVM.label.LabelFactory;
import LabelVM.label.core.model.Label;
import id.ac.ui.cs.prices.winvmj.auth.annotations.Restricted;
//add other required packages

public class LabelServiceImpl extends LabelServiceComponent{

    public Label createLabel(Map<String, Object> requestBody){
		String name = (String) requestBody.get("name");
		String description = (String) requestBody.get("description");
		
		//to do: fix association attributes
		
		Label label = LabelFactory.createLabel("LabelVM.label.core.model.LabelImpl", name, description);
		Repository.saveObject(label);
		return label;
	}

	public Label createLabel(Map<String, Object> requestBody, int id){
		int idLabel = id;
		String name = (String) requestBody.get("name");
		String description = (String) requestBody.get("description");
		
		//to do: fix association attributes
		Label label = LabelFactory.createLabel("LabelVM.label.core.model.LabelImpl",idLabel, name, description);
		Repository.saveObject(label);
		return label;
	}

    public HashMap<String, Object> updateLabel(Map<String, Object> requestBody){
		String idStr = (String) requestBody.get("idLabel");
		int id = Integer.parseInt(idStr);
		Label label = Repository.getObject(id);
		
		label.setName((String) requestBody.get("name"));
		label.setDescription((String) requestBody.get("description"));
		
		Repository.updateObject(label);
		
		//to do: fix association attributes
		
		return label.toHashMap();
		
	}

    public HashMap<String, Object> getLabel(String idStr){
		int id = Integer.parseInt(idStr);
		Label label = Repository.getObject(id);
		return label.toHashMap();
	}

	public HashMap<String, Object> getLabelById(int id){
		List<HashMap<String, Object>> labelList = getAllLabel();
		for (HashMap<String, Object> label : labelList){
			int record_id = ((Double) label.get("idLabel")).intValue();
			if (record_id == id){
				return label;
			}
		}
		return null;
	}

    public List<HashMap<String,Object>> getAllLabel(){
		List<Label> List = Repository.getAllObject("label_impl");
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
