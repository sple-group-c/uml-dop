package BeritaBoardVM.beritaboard.subscription.service;

import java.util.*;
import java.lang.*;

import id.ac.ui.cs.prices.winvmj.core.VMJExchange;

import BeritaBoardVM.beritaboard.core.service.BeritaBoardServiceDecorator;
import BeritaBoardVM.beritaboard.core.model.BeritaBoardImpl;
import BeritaBoardVM.beritaboard.core.service.BeritaBoardServiceComponent;
import BeritaBoardVM.beritaboard.core.model.BeritaBoard;
import BeritaBoardVM.beritaboard.core.model.BeritaBoardDecorator;
import BeritaBoardVM.beritaboard.BeritaBoardFactory;

public class BeritaBoardServiceImpl extends BeritaBoardServiceDecorator {
    public BeritaBoardServiceImpl (BeritaBoardServiceComponent record) {
        super(record);
    }

 	public BeritaBoard createBeritaBoard(Map<String, Object> requestBody){
		boolean subscription = (boolean) requestBody.get("subscription");
		String beritaidStr = (String) requestBody.get("beritaid");
		int beritaid = Integer.parseInt(beritaidStr);
		String content = (String) requestBody.get("content");
		BeritaBoard beritaboardsubscription = record.createBeritaBoard(requestBody);
		BeritaBoard beritaboardsubscriptiondeco = BeritaBoardFactory.createBeritaBoard("BeritaBoardVM.beritaboard.subscription", beritaboardsubscription, beritaid, content, subscription);
		Repository.saveObject(beritaboardsubscriptiondeco);
		return beritaboardsubscriptiondeco;
	}

	public BeritaBoard createBeritaBoard(Map<String, Object> requestBody, int id){
		BeritaBoard savedBeritaBoard = Repository.getObject(id);
		boolean subscription = (boolean) requestBody.get("subscription");
		String beritaidStr = (String) requestBody.get("beritaid");
		int beritaid = Integer.parseInt(beritaidStr);
		String content = (String) requestBody.get("content");
		UUID recordBeritaBoardBeritaid = ((BeritaBoardDecorator) savedBeritaBoard).getBeritaid();
		BeritaBoard BeritaBoard = record.createBeritaBoard(requestBody, recordBeritaBoardBeritaid);
		BeritaBoard beritaboardsubscription = BeritaBoardFactory.createBeritaBoard("BeritaBoardVM.beritaboard.subscription.model.BeritaBoardImpl", BeritaBoard, beritaid, content, subscription);
		return beritaboardsubscription;
	}

    public HashMap<String, Object> updateBeritaBoard(Map<String, Object> requestBody){
		String idStr = (String) requestBody.get("beritaid");
		
		BeritaBoard beritaboardsubscription = Repository.getObject(id);
		beritaboardsubscription = createBeritaBoard(requestBody, id);
		
		Repository.updateObject(beritaboardsubscription);
		beritaboardsubscription = Repository.getObject(id);
		
		//to do: fix association attributes
		
		return beritaboardsubscription.toHashMap();
	}

	public HashMap<String, Object> getBeritaBoard(String idStr){
		int id = Integer.parseInt(idStr);
		BeritaBoard beritaboardsubscription = Repository.getObject(id);
		return beritaboardsubscription.toHashMap();
	}

	public HashMap<String, Object> getBeritaBoardById(int id){
		List<HashMap<String, Object>> beritaboardList = getAllBeritaBoard();
		for (HashMap<String, Object> beritaboard : beritaboardList){
			int beritaboard_id = ((Double) beritaboard.get("beritaid")).intValue();
			if (beritaboard_id == id){
				return beritaboard;
			}
		}
		return null;
	}

    public List<HashMap<String,Object>> getAllBeritaBoard(){
		List<BeritaBoard> List = Repository.getAllObject("beritaboard_subscription");
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
