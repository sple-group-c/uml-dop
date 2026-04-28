package BeritaBoardVM.beritaboard.core.service;
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
import BeritaBoardVM.beritaboard.BeritaBoardFactory;
import BeritaBoardVM.beritaboard.core.model.BeritaBoard;
import id.ac.ui.cs.prices.winvmj.auth.annotations.Restricted;
//add other required packages

public class BeritaBoardServiceImpl extends BeritaBoardServiceComponent{

    public BeritaBoard createBeritaBoard(Map<String, Object> requestBody){
		String content = (String) requestBody.get("content");
		
		//to do: fix association attributes
		
		BeritaBoard beritaboard = BeritaBoardFactory.createBeritaBoard("BeritaBoardVM.beritaboard.core.model.BeritaBoardImpl", content);
		Repository.saveObject(beritaboard);
		return beritaboard;
	}

	public BeritaBoard createBeritaBoard(Map<String, Object> requestBody, int id){
		int beritaid = id;
		String content = (String) requestBody.get("content");
		
		//to do: fix association attributes
		BeritaBoard beritaboard = BeritaBoardFactory.createBeritaBoard("BeritaBoardVM.beritaboard.core.model.BeritaBoardImpl",beritaid, content);
		Repository.saveObject(beritaboard);
		return beritaboard;
	}

    public HashMap<String, Object> updateBeritaBoard(Map<String, Object> requestBody){
		String idStr = (String) requestBody.get("beritaid");
		int id = Integer.parseInt(idStr);
		BeritaBoard beritaboard = Repository.getObject(id);
		
		beritaboard.setContent((String) requestBody.get("content"));
		
		Repository.updateObject(beritaboard);
		
		//to do: fix association attributes
		
		return beritaboard.toHashMap();
		
	}

    public HashMap<String, Object> getBeritaBoard(String idStr){
		int id = Integer.parseInt(idStr);
		BeritaBoard beritaboard = Repository.getObject(id);
		return beritaboard.toHashMap();
	}

	public HashMap<String, Object> getBeritaBoardById(int id){
		List<HashMap<String, Object>> beritaboardList = getAllBeritaBoard();
		for (HashMap<String, Object> beritaboard : beritaboardList){
			int record_id = ((Double) beritaboard.get("beritaid")).intValue();
			if (record_id == id){
				return beritaboard;
			}
		}
		return null;
	}

    public List<HashMap<String,Object>> getAllBeritaBoard(){
		List<BeritaBoard> List = Repository.getAllObject("beritaboard_impl");
		return transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<BeritaBoard> List){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < List.size(); i++) {
            resultList.add(List.get(i).toHashMap());
        }

        return resultList;
	}

    public List<HashMap<String,Object>> deleteBeritaBoard(Map<String, Object> requestBody){
		String idStr = ((String) requestBody.get("beritaid"));
		int id = Integer.parseInt(idStr);
		Repository.deleteObject(id);
		return getAllBeritaBoard();
	}

}
